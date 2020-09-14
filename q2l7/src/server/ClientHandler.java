package server;

import exceptions.IncorrectCredentialsException;
import exceptions.LoginTimeoutException;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

/**
 * Represents client session
 */
public class ClientHandler {
    private final long TIMEOUT = 12000;

    private String name;
    private Socket socket;
    private DataInputStream in;
    private DataOutputStream out;
    private Server server;

    public ClientHandler(Socket socket, Server server) {
        this.socket = socket;
        try {
            this.in = new DataInputStream(socket.getInputStream());
            this.out = new DataOutputStream(socket.getOutputStream());
            start();
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.server = server;
    }

    public String getName() {
        return name;
    }

    public void start() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    authenticate();
                    readMessage();
                } catch (LoginTimeoutException e){
                    System.out.printf("Your session expired due to inactivity.%nPlease log in in %d seconds", TIMEOUT);
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    closeConnection();
                }
            }
        }).start();
    }

    public void authenticate() throws LoginTimeoutException, IOException {
        System.out.println("Client auth is on going...");
        long connectTime = System.currentTimeMillis();
        try {
            while (true) {

                String loginInfo = in.readUTF();

                //1
                if (System.currentTimeMillis() - connectTime > TIMEOUT) {
                    throw new LoginTimeoutException();
                }

                if (loginInfo.startsWith("-auth")) {
                    // -auth l1 p1
                    String[] splittedLoginInfo = loginInfo.split("\\s");
                    AuthenticationService.Client maybeClient = server.getAuthenticationService()
                            .findByLoginAndPassword(
                                    splittedLoginInfo[1],
                                    splittedLoginInfo[2]
                            );
                    if (maybeClient != null) {
                        if (!server.checkLogin(maybeClient.getName())) {
                            sendMessage("status: auth ok");
                            name = maybeClient.getName();
                            server.broadcast(String.format("%s came in", name));
                            System.out.println("Client auth completed");
                            server.subscribe(this);
                            return;
                        } else {
                            sendMessage(String.format("%s already logged in", maybeClient.getName()));
                        }
                    } else {
                        throw new IncorrectCredentialsException(loginInfo);
                    }
                }
            }
        } catch (IncorrectCredentialsException e){
            sendMessage("Incorrect credentials");
        }
    }

    public void closeConnection() {
        server.unsubscribe(this);
        server.broadcast(String.format("%s left", name));
        try {
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void readMessage() throws IOException {
        while (true) {
            String message = in.readUTF();
            String formatterMessage = String.format("Message from %s: %s", name, message);
            System.out.println(formatterMessage);
            if (message.equalsIgnoreCase("-exit")) {
                return;
            }
            else if (message.startsWith("/w")){
                String[] splittedMessageInfo = message.split("\\s");
                server.sendMessageToClient(splittedMessageInfo[1], splittedMessageInfo[2]);
            }
            else {
                server.broadcast(formatterMessage);
            }
        }
    }

    public void sendMessage(String message) {
        try {
            out.writeUTF(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
