import java.io.*;
import java.sql.*;

class sql {
    private static final String url = "jdbc:mysql://localhost:3306/canteen_system";
    private static final String root = "root";
    private static final String password = "MohantY#08";

    // Method to get a database connection
    public Connection getConnection() throws SQLException {
        try {
            // Load the MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            throw new SQLException("MySQL JDBC Driver not found", e);
        }
        // Return the connection using the defined credentials
        return DriverManager.getConnection(url, root, password);
    }

    public void readAll() throws SQLException {
        String query = "select * from Menu;";
        try (Connection con = getConnection();
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                System.out.println(
                    "Prod_id: " + rs.getInt("prod_id") +
                    ", Name: " + rs.getString("item_name") +
                    ", cost: " + rs.getInt("cost") +
                    ", Quantity: " + rs.getInt("quantity")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }
    }
}

public class User {
    public static void main(String[] args) {
        sql data = new sql();
        try {
            data.readAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}