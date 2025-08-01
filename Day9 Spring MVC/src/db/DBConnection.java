package db;
import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/";
    private static final String USER = "root";
    private static final String PASS = "password";

    public static Connection getConnection(String dbName) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(URL + dbName, USER, PASS);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}