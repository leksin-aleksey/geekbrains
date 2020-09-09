package com.geekbrains.java.course.chat.objects;

import java.io.*;
import java.util.Date;
import java.util.Queue;

public class MessageReadHandler implements Runnable {
    private Queue<Message> queueNetworkOut;
    private InputStream inHost;

    public MessageReadHandler(Queue<Message> queueNetworkOut, InputStream inHost) {
        this.queueNetworkOut = queueNetworkOut;
        this.inHost = inHost;
    }

    @Override
    public void run() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(inHost))) {
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
