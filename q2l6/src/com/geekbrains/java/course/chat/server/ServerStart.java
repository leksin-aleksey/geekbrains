package com.geekbrains.java.course.chat.server;

public class ServerStart {

    private static final int PORT = 16486;

    public static void main(String[] args){
        ServerConsole serverConsole = new ServerConsole(PORT);
        serverConsole.start();
    }
}
