package com.geekbrains.java.course.chat.objects;

import java.io.*;
import java.util.Date;
import java.util.Queue;

public final class Handler implements Handle, Runnable {
    private ChatHost host;

    private InputStream handlerInputStream;
    private OutputStream handlerOutputStream;

    public Handler(ChatHost host) {
        this.host = host;
        handlerInputStream = host.getHostInputStream();
        handlerOutputStream = host.getHostOutputStream();
    }

    @Override
    public void handleMessages() throws IOException{
        try(BufferedReader br = new BufferedReader(new InputStreamReader(handlerInputStream));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(handlerOutputStream))) {

            while (true) {
                String str;
                if ((str = br.readLine()) != null && !str.isEmpty()) {
                    host.addMessageInput(new ChatMessage(new Date(), str));
                }

                if (!queueOutput.isEmpty()){
                    bw.write(host.getMessageOutput().toString());
                    bw.newLine();
                }
            }
        }
    }

    @Override
    public void run() {
        try {
            handleMessages();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
