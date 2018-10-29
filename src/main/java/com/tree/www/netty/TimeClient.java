package com.tree.www.netty;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by pysh on 2018/9/29.
 */
public class TimeClient {
    public static void main(String[] args) {
        BufferedReader reader = null;
        PrintWriter writer = null;
        Socket client = null;
        try {
            client = new Socket("127.0.0.1", 8080);
            writer = new PrintWriter(client.getOutputStream());
            reader = new BufferedReader(new InputStreamReader(client.getInputStream()));

            ExecutorService es = Executors.newFixedThreadPool(10);
            for (int i = 0; i < 10; i++) {
                PrintWriter finalWriter = writer;
                BufferedReader finalReader = reader;
                es.submit(() -> {
                    finalWriter.println("GET CURRENT TIME");
                    finalWriter.flush();
                    try {
                        String response = finalReader.readLine();
                        System.out.println(response);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });
            }
            Thread.sleep(2000);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                writer.close();
                reader.close();
                client.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
