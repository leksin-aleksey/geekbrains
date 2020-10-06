package server;

import db.ClientService;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class AuthenticationService {
    private Set<Client> clients;

    public AuthenticationService() {
//        clients = Set.of(
//                new Client("l1", "p1", "u1"),
//                new Client("l2", "p2", "u2"),
//                new Client("l3", "p3", "u3")
//        );
//        clients = new HashSet<>(Arrays.asList(new Client("l1", "p1", "u1"),
//                new Client("l2", "p2", "u2"),
//                new Client("l3", "p3", "u3")));
    }

    public Client findByLoginAndPassword(String login, String password) {
        //1. Добавить в сетевой чат авторизацию через базу данных SQLite.
        //Postgres
        ClientService clientService = new ClientService();
        return clientService.checkCredentials(login, password);

//        for (Client c : clients) {
//            if (c.getLogin().equals(login) && c.getPassword().equals(password)) {
//                return c;
//            }
//        }
//        return null;
    }

    static public class Client {
        private int id;
        private String login;
        private String password;
        private String name;

        public Client(int id, String login, String password, String name) {
            this.login = login;
            this.password = password;
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public String getLogin() {
            return login;
        }

        public String getPassword() {
            return password;
        }

        public String getName() {
            return name;
        }
    }
}
