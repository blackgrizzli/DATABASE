

import java.sql.*;
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
            Statement statement = connection.createStatement();

            // создание таблицы
            statement.executeUpdate("CREATE TABLE Person.Products (Id INT PRIMARY KEY AUTO_INCREMENT,ProductName VARCHAR(20),Price INT) ");

            //добавление в таблицу
            statement.executeUpdate("INSERT Person.Products (ProductName, Price) VALUES ('Iphone10',80000)," +
                    "('iPhone14',120000),('iPhoneSE',49000)");

            //Изменение таблицы
            statement.executeUpdate("UPDATE Person.Products  SET Price = Price - 5000 WHERE ProductName = 'Iphone10'");

            // Извлекаем данные
            ResultSet resultSet = statement.executeQuery("SELECT * FROM Person.Products  ");
            while (resultSet.next()){
                int id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                int price = resultSet.getInt(3);
                System.out.printf("%d. %s - %d \n", id, name, price);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}