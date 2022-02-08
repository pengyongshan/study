package com.tree.www.jsoup;

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

/**
 * 黄页数据爬取
 *
 * @author crystal
 * @since 2021/11/15
 */
public class YPJsoup_b {
    public static void main(String[] args) {
        String[] strings = {
             };
        for (String reqUrl : strings) {
            FIX_POOL.submit(() -> {
                crawling(reqUrl, 1);
                System.out.println("done: " +  reqUrl);
            });
        }
    }

    public static void crawling(String reqUrl, int pageNum) {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        CloseableHttpResponse response = null;
//        System.out.println(reqUrl);
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
            System.out.println("请求错误:" + reqUrl);
        } finally {
            //6.关闭
            HttpClientUtils.closeQuietly(response);
            HttpClientUtils.closeQuietly(httpClient);
        }
    }

    private static volatile int size = 0;
    private static volatile int index = 1001;
    private static volatile File file =
            new File("/Users/mac/Documents/yp_data_bu_" + index++ + ".sql");
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
        if (list.size() == 0) return;
        StringBuilder sb = new StringBuilder();
        for (YPEntity entity : list) {
            sb.append(entity.toString());
        }
        size = size + list.size();
        if (size > 10000) {
            size = 0;
            FILE_WRITER.close();
            file = new File("/Users/mac/Documents/yp_data_bu_" + index++ + ".sql");
            if (!file.exists()) {
                file.createNewFile();
            }
            FILE_WRITER = new FileWriter(file, true);
            FILE_WRITER.write(START_SQL);
        }
        if (size >= 10000 - 30) sb = sb.replace(sb.length() - 2, sb.length(), ";");
        FILE_WRITER.write(sb.toString());
        FILE_WRITER.flush();
    }

    private static final ExecutorService SINGLE_POOL = Executors.newSingleThreadExecutor();
    private static final ExecutorService FIX_POOL = Executors.newFixedThreadPool(10);
}