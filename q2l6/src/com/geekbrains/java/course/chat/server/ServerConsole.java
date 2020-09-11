package com.geekbrains.java.course.chat.server;


import com.geekbrains.java.course.chat.objects.*;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

public class ServerConsole {

    private int port;

//    private Queue<Message> queueNetworkIn = new LinkedBlockingQueue<>();
//    private Queue<Message> queueNetworkOut = new LinkedBlockingQueue<>();
    private Queue<Message> queueNetworkIn = new ConcurrentChatLinkedList<>();
    private Queue<Message> queueNetworkOut = new ConcurrentChatLinkedList<>();

    public ServerConsole(int port) {
        this.port = port;
    }

    public void start(){

        System.out.println("Server is starting...");

        try (ServerSocket serverSocket = new ServerSocket(port)){
            System.out.println("Started");

            System.out.println("Waiting for connections");

            try (Socket socket = serverSocket.accept()){
                System.out.println("Connected");

                ConsoleReadHandler consoleReadHandler = new ConsoleReadHandler(queueNetworkOut, System.in);
                Thread threadConsoleReadHandler = new Thread(consoleReadHandler);
                threadConsoleReadHandler.start();

                NetworkReadHandler networkReadHandler = new NetworkReadHandler(queueNetworkIn, socket);
                Thread threadNetworkReadHandler = new Thread(networkReadHandler);
                threadNetworkReadHandler.start();

                ConsoleNetworkWriteHandler consoleNetworkWriteHandler = new ConsoleNetworkWriteHandler(queueNetworkIn, queueNetworkOut, System.out, socket);
                Thread threadNetworkHandler = new Thread(consoleNetworkWriteHandler);
                threadNetworkHandler.start();

                threadConsoleReadHandler.join();
                threadNetworkReadHandler.join();
                threadNetworkHandler.join();

            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
            }
        } catch (IOException e){
            e.printStackTrace();
        } finally {
            System.out.println("Server stopped");
        }
    }


}
