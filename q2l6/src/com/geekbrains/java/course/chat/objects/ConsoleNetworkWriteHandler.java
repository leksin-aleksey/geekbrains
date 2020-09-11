package com.geekbrains.java.course.chat.objects;


import java.io.*;
import java.net.Socket;
import java.net.SocketException;
import java.util.Queue;

public class ConsoleNetworkWriteHandler implements Runnable{
    private Queue<Message> queueNetworkIn;
    private Queue<Message> queueNetworkOut;
    private DataOutputStream networkOut;
    private PrintStream hostOut;

    public ConsoleNetworkWriteHandler(Queue<Message> queueNetworkIn, Queue<Message> queueNetworkOut, PrintStream hostOut, Socket socket) throws IOException{
        this.queueNetworkIn = queueNetworkIn;
        this.queueNetworkOut = queueNetworkOut;
        networkOut = new DataOutputStream(socket.getOutputStream());
        this.hostOut = hostOut;
   }

    @Override
    public void run() {
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(hostOut))) {
            while (true) {

                try {
                    printConsole(bw);
                } catch (IOException e) {
                    throw new IOException(e.getCause());
                }

                try {
                    writeNetwork();
                } catch (SocketException e) {
                    throw e;
                } catch (IOException e) {
                    throw new IOException(e.getCause());
                }
            }
        } catch (SocketException e){
            System.out.println("Connection is closed");
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    private void printConsole(BufferedWriter bw) throws IOException{
        Message message;
        while ((message = queueNetworkIn.poll()) != null) {
            bw.write(message.getMessageText());
            bw.newLine();
            bw.flush();
        }
    }

    private void writeNetwork() throws IOException{
        Message message;
        while ((message = queueNetworkOut.poll()) != null) {
            networkOut.writeUTF(message.getMessageText());
        }
    }
}
