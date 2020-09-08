package com.geekbrains.java.course.chat.server;

public class ChatServerStart {

    public static void main(String[] args){
        ChatServer server = new ChatServer(16486);
        server.start();
    }
}
