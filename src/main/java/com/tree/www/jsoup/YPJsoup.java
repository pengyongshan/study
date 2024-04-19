package com.tree.www.jsoup;

import com.alibaba.fastjson.JSON;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.utils.HttpClientUtils;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.http.HttpStatus;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 黄页数据爬取
 *
 * @author crystal
 * @since 2021/11/15
 */
public class YPJsoup {
    public static final String BASE_URL = "https://www.yellowpages.com/search";

    public static void main(String[] args) throws InterruptedException {
        String locationStart ="A" ,searchTermStart="A";
        for (int i = 0, length = YellowPageConfig.GEO_LOCATION_TERMS.length; i < length; i++) {
            String location = YellowPageConfig.GEO_LOCATION_TERMS[i];
            if (location.compareTo(locationStart) < 0) continue;
            for (int j = 0; j < YellowPageConfig.SEARCH_TERMS.length; j++) {
                String searchTerm = YellowPageConfig.SEARCH_TERMS[j];
                if (location.compareTo(locationStart) == 0 && searchTerm.compareTo(searchTermStart) < 0) continue;
                String queryUrl = BASE_URL + "?geo_location_terms=" + location + "&search_terms=" + searchTerm;
                FIX_POOL.submit(() -> {
                    crawling(queryUrl, 1);
                    System.out.println(queryUrl);
                });
                while (((ThreadPoolExecutor) FIX_POOL).getQueue().size() > 20) {
                    TimeUnit.SECONDS.sleep(30);
                }
            }
        }
    }

    public static void crawling(String reqUrl, int pageNum) {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        CloseableHttpResponse response = null;
        reqUrl = reqUrl.replaceAll(" ", "+");
        try {
            while (true) {
                String realUrl = reqUrl + "&page=" + pageNum++;
                HttpUriRequest request = new HttpGet(realUrl);
                response = httpClient.execute(request);
                if (response.getStatusLine().getStatusCode() == HttpStatus.OK.value()) {
                    HttpEntity httpEntity = response.getEntity();
                    String html = EntityUtils.toString(httpEntity, "utf-8");
                    Document document = Jsoup.parse(html);
                    Element result = document.getElementsByClass("search-results organic").first();
                    if (result == null) {
                        return;
                    }
                    Elements list = result.getElementsByClass("v-card");
                    List<YPEntity> ypEntityList = new ArrayList<>();
                    for (Element item : list) {
                        //像jquery选择器一样，获取文章标题元素
                        String name = item.select(".business-name").tagName("span").text();
                        String phone_number = item.getElementsByClass("phones phone primary").text();
                        String locality = item.getElementsByClass("locality").text();
                        String categories = item.getElementsByClass("categories").text();
                        String street_address = item.getElementsByClass("street-address").text();
                        String web_site = item.getElementsByClass("track-visit-website").attr("href");
                        ypEntityList.add(new YPEntity(name, phone_number, locality, categories, street_address, web_site));
                    }
                    SINGLE_POOL.submit(() -> {
                        try {
                            writeSQl(ypEntityList);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    });
                    String pagination = document.getElementsByClass("pagination").first().selectFirst("span").text();
                    String[] strings = pagination.split(" ");
                    String num = strings[strings.length - 1];
                    if (pagination.indexOf(num) != pagination.lastIndexOf(num)) {
                        return;
                    }
                } else if (response.getStatusLine().getStatusCode() == 404) {
                    System.out.println("返回状态不是200:[" + reqUrl + "  ," + pageNum + "]");
                    System.out.println("code: " + response.getStatusLine().getStatusCode());
                    return;
                } else {
                    System.out.println("返回状态不是200:[" + reqUrl + "  ," + pageNum + "]");
                    System.out.println("code: " + response.getStatusLine().getStatusCode());
                }
            }
        } catch (IOException e) {
            System.out.println("请求错误: " + reqUrl);
//            e.printStackTrace();
        } finally {
            //6.关闭
            HttpClientUtils.closeQuietly(response);
            HttpClientUtils.closeQuietly(httpClient);
        }
    }

    private static volatile int size = 0;
    private static volatile int index = 1;
    private static volatile File file =
            new File("/Users/mac/Documents/yp_data_" + index++ + ".sql");
    private static volatile FileWriter FILE_WRITER;
    private static final String START_SQL = "INSERT IGNORE INTO `dt_block_yellow_pages` (`phone_number`, `name`, `ret_json`) VALUES\n";
    static {
        try {
            FILE_WRITER = new FileWriter(file, true);
            FILE_WRITER.write(START_SQL);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public synchronized static void writeSQl(List<YPEntity> list) throws IOException {
        if(list.size() == 0) return;
        StringBuilder sb = new StringBuilder();
        for (YPEntity entity : list) {
            sb.append(entity.toString());
        }
        size = size + list.size();
        if (size > 10000) {
            size = 0;
            FILE_WRITER.close();
            file = new File("/Users/mac/Documents/yp_data_" + index++ + ".sql");
            if (!file.exists()) {
                file.createNewFile();
            }
            FILE_WRITER = new FileWriter(file, true);
            FILE_WRITER.write(START_SQL);
        }
        if(size >= 10000 - 30) sb = sb.replace(sb.length() - 2, sb.length(), ";");
        FILE_WRITER.write(sb.toString());
        FILE_WRITER.flush();
    }

    private static final ExecutorService SINGLE_POOL = Executors.newSingleThreadExecutor();
    private static final ExecutorService FIX_POOL = Executors.newFixedThreadPool(10);
}

class YPEntity {
    private String name;
    private String phone_number;
    private String locality;
    private String categories;
    private String street_address;
    private String web_site;

    public YPEntity(String name, String phone_number, String locality, String categories, String street_address, String web_site) {
        this.name = name;
        this.phone_number = phone_number;
        this.locality = locality;
        this.categories = categories;
        this.street_address = street_address;
        this.web_site = web_site;
    }

    public String getName() {
        return name;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public String getLocality() {
        return locality;
    }

    public String getCategories() {
        return categories;
    }

    public String getStreet_address() {
        return street_address;
    }

    public String getWeb_site() {
        return web_site;
    }

    @Override
    public String toString() {
        phone_number = phone_number.replaceAll("[^\\d.]", "");
        if (phone_number.length() < 11) {
            phone_number = "1" + phone_number;
        }
        name = name.replaceAll("\"", "");
        String rest_json = JSON.toJSONString(this);
        rest_json = rest_json.replaceAll("'", "\\\\'");
        return "(\"" + phone_number + "\",\"" + name + "\",'" + rest_json + "'),\n";
    }
}