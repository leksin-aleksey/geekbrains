package com.geekbrains.java.course.chat.objects;


import java.io.*;
import java.net.Socket;
import java.net.SocketException;
import java.util.Date;
import java.util.Queue;

public class NetworkReadHandler implements Runnable{
    private Queue<Message> queueNetworkIn;
    private DataInputStream networkIn;

    public NetworkReadHandler(Queue<Message> queueNetworkIn, Socket socket) throws IOException{
        this.queueNetworkIn = queueNetworkIn;
        networkIn = new DataInputStream(socket.getInputStream());
    }

    @Override
    public void run() {
        try {
            while (true) {
                readNetwork();
            }
        } catch (SocketException e){
            System.out.println("Connection is closed");
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    private void readNetwork() throws IOException{
        String str = networkIn.readUTF();
        queueNetworkIn.add(new Message(new Date(), str));
    }
}
