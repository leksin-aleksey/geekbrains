package server;

import client.History;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.SocketException;
import java.util.List;

public class ClientApplicationTwo {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 8888);
            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            out.writeUTF("-auth l1_NEW2 p2");
            Thread client = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        printHistory();

                        while (true) {
                            //This Client just sends messages every 10sec to Client "u3"
                            try {
                                Thread.sleep(10000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
//                            String messageOut = String.format("/w %s Привет", "u3");
                            String messageOut = String.format("/c %s", "l1_NEW2");
                            out.writeUTF(messageOut);
                        }
                    } catch (SocketException e){
                        System.out.println("Logged out");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            });
            client.start();

            try {
                client.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            out.writeUTF("-exit");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void printHistory(){
        History history = new History();
        List<String> historyLog = history.readAtStartup();
        for (String line : historyLog) {
            System.out.println(line);
        }
    }
}
