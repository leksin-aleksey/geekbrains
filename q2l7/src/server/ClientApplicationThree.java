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

            //1
//            try {
//                Thread.sleep(15000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }

            String auth = String.format("%s %s %s", args[0], args[1], args[2]);
            out.writeUTF(auth);
//            out.writeUTF("-auth l1 p2");
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        while (true) {
                            String message = in.readUTF();
                            System.out.println(message);
//                            if (message.contains("Incorrect credentials")) {
//                                out.writeUTF("-auth l1 p1");
//                            }
                        }
                    } catch (SocketException e){
                        System.out.println("Logged out");
                    } catch (IOException e) {
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
