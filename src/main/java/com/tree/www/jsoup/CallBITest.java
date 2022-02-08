package com.tree.www.jsoup;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author crystal
 * @since 2021/11/16
 */
public class CallBITest {

    public static final String URL = "jdbc:mysql://localhost:3306/dt-call-bi?characterEncoding=UTF8&amp;zeroDateTimeBehavior=convertToNull&amp;useServerPrepStmts=false&amp;rewriteBatchedStatements=true&amp;useCompression=true";
    public static final String USER = "root";
    public static final String PASSWORD = "password";
    public static Connection connection;

    static {
        //1.加载驱动程序
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        //2. 获得数据库连接
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        RestTemplate restTemplate = new RestTemplate();
        ExecutorService es = Executors.newFixedThreadPool(4);
        String exeUrl = "https://dt-apigatewayv2.dt-pn1.com/call-bi/risk/interceptorInfo/{phoneNumber}";
        int page = 0;
        do {
            List<String> phoneNumbers = selectByPage(page);
            if (CollectionUtils.isEmpty(phoneNumbers)) {
                return;
            }
            for (String phoneNumber : phoneNumbers) {
                es.submit(() -> {
                    try {
                        ResponseEntity<String> response = restTemplate.exchange(exeUrl, HttpMethod.GET, null,
                                String.class, Collections.singletonMap("phoneNumber", phoneNumber));
                        if (response.getStatusCode() == HttpStatus.OK) {
                            JSONObject obj = JSON.parseObject(response.getBody());
                            System.out.println(obj);
                            updateRow(obj);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                });
            }
            System.out.println("==================PAGE==================" + page);
            if (page % 10 == 0) {
                TimeUnit.SECONDS.sleep(60);
            }
        } while (page++ < 500);
    }

    private static void updateRow(JSONObject obj) {
        if (obj.getIntValue("Result") != 1) return;
        try {
            while (connection.isClosed()) {
                connection = DriverManager.getConnection(URL, USER, PASSWORD);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        String sql = "update record set phone_type_bi = ?, carrier_name_bi=?,country_bi=?,location_state_bi=?, location_city_bi=?,risk_level_bi=?,risk_score_bi=?,hit_codes=? where phone_number = ?";
        JSONObject data = obj.getJSONObject("data");
        try (PreparedStatement ptmt = connection.prepareStatement(sql)) {
            ptmt.setString(1, data.getString("phoneType"));
            ptmt.setString(2, data.getString("carrierName"));
            ptmt.setString(3, data.getString("locationCountry"));
            ptmt.setString(4, data.getString("locationState"));
            ptmt.setString(5, data.getString("locationCity"));
            ptmt.setString(6, data.getString("riskLevel"));
            ptmt.setInt(7, data.getIntValue("riskScore"));
            ptmt.setString(8, data.getString("hitRuleCodes"));
            ptmt.setString(9, data.getString("phoneNumber"));
            ptmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static List<String> selectByPage(int page) {
        try {
            while (connection.isClosed()) {
                connection = DriverManager.getConnection(URL, USER, PASSWORD);
            }
            String sql = "select phone_number, phone_type from record where carrier_name_bi is null " +
                    " order by phone_number limit " + page * 100 + ", 100;";
            Statement stmt = connection.createStatement();
            boolean flag = stmt.execute(sql);
            if (flag) {
                List<String> list = new ArrayList<>();
                ResultSet rs = stmt.getResultSet();
                while (rs.next()) {
                    list.add(rs.getString("phone_number"));
                }
                return list;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
