package batingaanimalmedicalcenterpetappointmentsystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    private static final String URL =
            "jdbc:mysql://localhost:3306/batinganimalmedicalcenter";

    private static final String USER = "root";

    private static final String PASSWORD = "";

    public static Connection getConnection() {

        try {
            return DriverManager.getConnection(
                    URL,
                    USER,
                    PASSWORD
            );

        } catch (SQLException e) {
            System.out.println("Database connection failed!");
            e.printStackTrace();
            return null;
        }
    }

    public static void main(String[] args) {

        Connection conn = getConnection();

        if (conn != null) {
            System.out.println("================================");
            System.out.println("DATABASE CONNECTED SUCCESSFULLY!");
            System.out.println("================================");

            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        } else {
            System.out.println("================================");
            System.out.println("DATABASE CONNECTION FAILED!");
            System.out.println("================================");
        }
    }
}   