package com.geekbrains.java.course.chat.client;

public class ClientStart {

    private static final int PORT = 16486;

    public static void main(String[] args){
        ClientConsole clientConsole = new ClientConsole(PORT);
        clientConsole.start();
    }
}
