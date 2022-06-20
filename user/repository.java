package user;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import user.userEntity;

public class repository {
    private Connection connection;
    private Statement statement;

    public repository(Connection connection) throws SQLException {
        this.connection = connection;
        this.statement = this.connection.createStatement();
    }

    public void addUser(String nickname, String password) {
        try {
            String addQuery = "insert into user1 values(" + "'" + nickname + "'" + "," + "'" + password + "'" + ")";
            this.statement.executeUpdate(addQuery);
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public userEntity getUser(String nickname) {
        try {
            String getQuery = "select * from user1 where nickname=" + "'" + nickname + "'";
            ResultSet resultSet = this.statement.executeQuery(getQuery);
            userEntity user = new userEntity();
            if (resultSet.next()) {
                user.nickname = resultSet.getString("nickname");
                user.password = resultSet.getString("password");
            }
            return user;
        } catch (SQLException e) {
            System.out.println(e);
        }
        return new userEntity();
    }

    public void updateUser(String nickname, String password) {
        try {
            String updateQuery = "update user1 set password=" + "'" + password + "'" + "where nickname=" + "'" + nickname + "'";
            System.out.println(updateQuery);
            this.statement.executeUpdate(updateQuery);
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void deleteUser(String nickname) {
        try {
            String deleteQuery = "delete from user1 where nickname=" + "'" + nickname + "'";
            this.statement.executeUpdate(deleteQuery);
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
}
