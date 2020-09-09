package com.geekbrains.java.course.chat.client;

import com.geekbrains.java.course.chat.objects.Message;
import com.geekbrains.java.course.chat.objects.MessageNetworkHandler;
import com.geekbrains.java.course.chat.objects.MessageReadHandler;

import java.io.IOException;
import java.net.Socket;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class ClientConsole {

    private int port;

    private Queue<Message> queueNetworkIn = new ConcurrentLinkedQueue<>();
    private Queue<Message> queueNetworkOut = new ConcurrentLinkedQueue<>();

    public ClientConsole(int port) {
        this.port = port;
    }

    public void start(){
        System.out.println("Client is connecting...");

        try (Socket socket = new Socket("127.0.0.1", port)){
            System.out.println("Connected");

            MessageNetworkHandler messageNetworkHandler = new MessageNetworkHandler(queueNetworkIn, queueNetworkOut, System.out, socket);
            Thread threadNetworkHandler = new Thread(messageNetworkHandler);
            threadNetworkHandler.start();

            MessageReadHandler messageReadHandler = new MessageReadHandler(queueNetworkOut, System.in);
            Thread threadReadHandler = new Thread(messageReadHandler);
            threadReadHandler.start();

            threadNetworkHandler.join();
            threadReadHandler.join();

        } catch (IOException | InterruptedException e){
            e.printStackTrace();
        } finally {
            System.out.println("Client disconnected");
        }
    }
}
