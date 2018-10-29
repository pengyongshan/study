package com.tree.www.netty;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Calendar;

/**
 * Created by pysh on 2018/9/29.
 */
public class TimeServerHandler implements Runnable {
    private Socket clientProxy;

    public TimeServerHandler(Socket clientProxy) {
        this.clientProxy = clientProxy;
    }

    @Override
    public void run() {
        BufferedReader reader = null;
        PrintWriter writer = null;
        try {
            reader = new BufferedReader(new InputStreamReader(clientProxy.getInputStream()));
            writer = new PrintWriter(clientProxy.getOutputStream());
            while (true) {
                String request = reader.readLine();
                if(!"GET CURRENT TIME".equals(request)) {
                    writer.println("Bad Requst.");
                } else {
                    writer.println(Calendar.getInstance().getTime().toString());
                }
                writer.flush();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                writer.close();
                reader.close();
                clientProxy.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
