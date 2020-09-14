package server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ClientApplicationOne {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 8888);
            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            //1 (timeout)
            try {
                Thread.sleep(30000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            out.writeUTF("-auth l1 p1");
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        while (true) {
                            String message = in.readUTF();
                            System.out.println(message);
                            if (message.contains("Incorrect credentials")) {
                                out.writeUTF("-auth l1 p1");
                            }
                        }
                    } catch (IOException e){
                        e.printStackTrace();
                    }
                }
            }).start();

            out.writeUTF("-exit");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
