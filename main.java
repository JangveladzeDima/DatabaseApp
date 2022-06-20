import java.sql.*;

import user.repository;
import user.userEntity;

public class main {
    public static void main(String[] args) {
        String jbdcURL = "jdbc:postgresql://localhost:5432/user";
        String username = "postgres";
        String password = "dikadika007";
        try {
            Connection connection = DriverManager.getConnection(jbdcURL, username, password);
            repository userRepository = new repository(connection);
            userRepository.addUser("grigoli", "grigolichi");
            userEntity user = userRepository.getUser("grigoli");
            user.print();
            userRepository.updateUser("grigoli", "vaska");
            userEntity updatedUser = userRepository.getUser("grigoli");
            updatedUser.print();
            userRepository.deleteUser("dima");
            connection.close();
        } catch (SQLException e) {
            System.out.println("Error in connection database");
            e.printStackTrace();
        }
    }
}
