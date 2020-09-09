package com.geekbrains.java.course.chat.objects;


import java.io.*;
import java.net.Socket;
import java.net.SocketException;
import java.util.Date;
import java.util.Queue;

public class MessageNetworkHandler implements Runnable{
    private Queue<Message> queueNetworkIn;
    private Queue<Message> queueNetworkOut;
    private DataInputStream inNetwork;
    private DataOutputStream outNetwork;
    private PrintStream outHost;
    private Socket socket;

    public MessageNetworkHandler(Queue<Message> queueNetworkIn, Queue<Message> queueNetworkOut, PrintStream outHost, Socket socket) throws IOException{
        this.queueNetworkIn = queueNetworkIn;
        this.queueNetworkOut = queueNetworkOut;
        inNetwork = new DataInputStream(socket.getInputStream());
        outNetwork = new DataOutputStream(socket.getOutputStream());
        this.outHost = outHost;
        this.socket = socket;
   }

    @Override
    public void run() {
        boolean stopHandler = false;
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(outHost))) {
            while (!stopHandler) {
                try {
                    fromQueuePrint(bw);
                } catch (IOException e) {
                    stopHandler = true;
                    e.printStackTrace();
                }
                try {
                    toQueueReceive();
                } catch (SocketException e){
                    System.out.println("Connection is closed");
                } catch (IOException e) {
                    stopHandler = true;
                    e.printStackTrace();
                }

                try {
                    fromQueueSend();
                } catch (SocketException e){
                    System.out.println("Connection is closed");
                } catch (IOException e) {
                    stopHandler = true;
                    e.printStackTrace();
                }
            }
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    private void fromQueuePrint(BufferedWriter bw) throws IOException{
        if(!queueNetworkIn.isEmpty()){
            Message message = queueNetworkIn.poll();
            String str = message.toString();
            if(!str.isEmpty()) {
                bw.write(str);
                bw.newLine();
                bw.flush();
            }
        }
    }

    private void toQueueReceive() throws IOException{
        while(inNetwork.available() > 0) {
            String str = inNetwork.readUTF();
            if (!str.isEmpty()) {

                queueNetworkIn.add(new Message(new Date(), str));
            }
        }
    }

    private void fromQueueSend() throws IOException{
        if(!queueNetworkOut.isEmpty()){
            Message message = queueNetworkOut.poll();
            String str = message.toString();
            if(!str.isEmpty()) {
                outNetwork.writeUTF(message.toString());
            }
        }
    }
}
