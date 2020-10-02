package db;

import server.AuthenticationService;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;

public class ClientService implements Service<AuthenticationService.Client> {
    @Override
    public Collection<AuthenticationService.Client> findAll() {
        ArrayList<AuthenticationService.Client> clients = null;
        try (Connection connection = ConnectionFactory.getInstance();
             Statement statement = connection.createStatement()){
            ResultSet rs = statement.executeQuery("SELECT * FROM users");
            clients = new ArrayList<>();
            while (rs.next()){
                AuthenticationService.Client client = new AuthenticationService.Client(
                        rs.getInt("id"),
                        rs.getString("username"),
                        rs.getString("password"),
                        rs.getString("name")
                        );
                clients.add(client);
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return clients;
    }

    @Override
    public AuthenticationService.Client findById(int id) {
        throw new NotImplementedException();
    }

    public AuthenticationService.Client findByUsername(String username) {
        AuthenticationService.Client client = null;
        try (Connection connection = ConnectionFactory.getInstance();
             PreparedStatement ps = connection.prepareStatement("SELECT * FROM users WHERE username = ?")){
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();
            if (rs.next()){
                client = new AuthenticationService.Client(
                        rs.getInt("id"),
                        rs.getString("username"),
                        rs.getString("password"),
                        rs.getString("name")
                );
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return client;
    }

    @Override
    public boolean add(AuthenticationService.Client user) {
        throw new NotImplementedException();
    }

    public boolean updateUsername(String usernameOld, String usernameNew) {
        boolean result = false;
        try (Connection connection = ConnectionFactory.getInstance();
             PreparedStatement ps = connection.prepareStatement("UPDATE users SET username = ? WHERE username = ?")){
            connection.setAutoCommit(false);
            ps.setString(1, usernameNew);
            ps.setString(2, usernameOld);
            result = ps.execute();
            connection.commit();
        } catch (SQLException e){
            e.printStackTrace();
        }
        return result;
    }

    public AuthenticationService.Client checkCredentials(String username, String password){
        AuthenticationService.Client client = null;
        String passwordStored;
        try (Connection connection = ConnectionFactory.getInstance();
             PreparedStatement ps = connection.prepareStatement("SELECT * FROM users WHERE username = ?")){
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();
            if (rs.next()){
                passwordStored = rs.getString("password");
                if (password.equals(passwordStored)){
                    client = new AuthenticationService.Client(
                            rs.getInt("id"),
                            rs.getString("username"),
                            rs.getString("password"),
                            rs.getString("name")
                    );
                }
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return client;
    }

}
