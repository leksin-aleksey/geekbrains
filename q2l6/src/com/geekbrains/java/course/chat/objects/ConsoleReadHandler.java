package com.geekbrains.java.course.chat.objects;

import java.io.*;
import java.util.Date;
import java.util.Queue;

public class ConsoleReadHandler implements Runnable {
    private Queue<Message> queueNetworkOut;
    private InputStream hostIn;

    public ConsoleReadHandler(Queue<Message> queueNetworkOut, InputStream hostIn) {
        this.queueNetworkOut = queueNetworkOut;
        this.hostIn = hostIn;
    }

    @Override
    public void run() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(hostIn))) {
            String str;
            while ((str = br.readLine()) != null) {
                if (!str.isEmpty()) {
                    queueNetworkOut.add(new Message(new Date(), str));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
