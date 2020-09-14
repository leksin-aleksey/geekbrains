package server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.SocketException;

public class ClientApplicationThree {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 8888);
            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            out.writeUTF("-auth l3 p3");
            Thread client = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        while (true) {
                            //This Client only receives messages
                            String message = in.readUTF();
                            System.out.println(message);
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
}
