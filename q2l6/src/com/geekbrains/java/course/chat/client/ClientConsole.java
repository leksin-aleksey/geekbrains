package com.geekbrains.java.course.chat.client;

import com.geekbrains.java.course.chat.objects.*;

import java.io.IOException;
import java.net.Socket;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

public class ClientConsole {

    private int port;

//    private Queue<Message> queueNetworkIn = new LinkedBlockingQueue<>();
//    private Queue<Message> queueNetworkOut = new LinkedBlockingQueue<>();
    private Queue<Message> queueNetworkIn = new ConcurrentChatLinkedList<>();
    private Queue<Message> queueNetworkOut = new ConcurrentChatLinkedList<>();

    public ClientConsole(int port) {
        this.port = port;
    }

    public void start(){
        System.out.println("Client is connecting...");

        try (Socket socket = new Socket("127.0.0.1", port)){
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

        } catch (IOException | InterruptedException e){
            e.printStackTrace();
        } finally {
            System.out.println("Client disconnected");
        }
    }
}
