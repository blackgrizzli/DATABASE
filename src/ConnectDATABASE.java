

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectDATABASE {
    public static void main(String[] args) throws ClassNotFoundException {
        String userName = "root";
        String password = "12wq12wQ";
        String url = "jdbc:mysql://127.0.0.1:3306";
        Class.forName("com.mysql.jdbc.Driver");
        try (Connection connection = DriverManager.getConnection(url, userName, password)) {
            System.out.println("База подключена");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}