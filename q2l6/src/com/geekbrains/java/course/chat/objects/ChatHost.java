package com.geekbrains.java.course.chat.objects;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public abstract class ChatHost {
    private Queue<ChatMessage> queueInput = new ConcurrentLinkedQueue<>();
    private Queue<ChatMessage> queueOutput = new ConcurrentLinkedQueue<>();

    private InputStream serverInputStream;
    private OutputStream serverOutputStream;

    public ChatHost(InputStream serverInputStream, OutputStream serverOutputStream) {
        this.serverInputStream = serverInputStream;
        this.serverOutputStream = serverOutputStream;
    }

    public abstract void start();

    public InputStream getHostInputStream(){
        return serverInputStream;
    }

    public OutputStream getHostOutputStream(){
        return serverOutputStream;
    }

    public void addMessageOutput(ChatMessage message){
        queueOutput.add(message);
    }

    public ChatMessage getMessageOutput(){
        return queueOutput.poll();
    }

    public void addMessageInput(ChatMessage message){
        queueInput.add(message);
    }

    public ChatMessage getMessageInput(){
        return queueInput.poll();
    }
}
