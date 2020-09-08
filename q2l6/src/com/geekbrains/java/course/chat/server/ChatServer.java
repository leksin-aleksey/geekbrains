package com.geekbrains.java.course.chat.server;

import com.geekbrains.java.course.chat.objects.ChatHost;
import com.geekbrains.java.course.chat.objects.Handler;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class ChatServer extends ChatHost {

    private int port;

    public ChatServer(int port) {
        super(System.in, System.out);
        this.port = port;
    }

    public void start(){
        try (ServerSocket serverSocket = new ServerSocket(port)){
            Socket socket = serverSocket.accept();

            Runnable handlerInput = new Handler(super.)
            new Thread()

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
