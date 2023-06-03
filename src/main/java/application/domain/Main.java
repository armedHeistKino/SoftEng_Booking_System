package application.domain;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/BOOKING_SYSTEM";
        String username = "res_master";
        String password = "res_manager";

        try (Connection conn = DriverManager.getConnection(url, username, password)) {
            String query = "INSERT INTO Customer (phoneNumber, password, name) VALUES (?, ?, ?)";
            PreparedStatement statement = conn.prepareStatement(query);

            statement.setString(1, "0000-0000-0000");
            statement.setString(2, "00");
            statement.setString(3, "현장손님");

            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("A new customer was inserted successfully!");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }
}