package com.geekbrains.java.course.chat.server;


import com.geekbrains.java.course.chat.objects.Message;
import com.geekbrains.java.course.chat.objects.MessageNetworkHandler;
import com.geekbrains.java.course.chat.objects.MessageReadHandler;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class ServerConsole {

    private int port;

    private Queue<Message> queueNetworkIn = new ConcurrentLinkedQueue<>();
    private Queue<Message> queueNetworkOut = new ConcurrentLinkedQueue<>();

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

                MessageNetworkHandler messageNetworkHandler = new MessageNetworkHandler(queueNetworkIn, queueNetworkOut, System.out, socket);
                Thread threadNetworkHandler = new Thread(messageNetworkHandler);
                threadNetworkHandler.start();

                MessageReadHandler messageReadHandler = new MessageReadHandler(queueNetworkOut, System.in);
                Thread threadReadHandler = new Thread(messageReadHandler);
                threadReadHandler.start();

                threadNetworkHandler.join();
                threadReadHandler.join();

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
