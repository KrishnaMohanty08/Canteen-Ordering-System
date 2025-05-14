import java.sql.*;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;

class sql {

    private static final String url = "jdbc:mysql://localhost:3306/canteen_system";
    private static final String root = "root";
    private static final String password = "MohantY#08";

    public Connection getConnection() throws SQLException {
        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            throw new SQLException("MySQL JDBC Driver not found", e);
        }
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
                                ", Quantity: " + rs.getInt("quantity"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }
    }

    public void delete(int prodId, int quantity) throws SQLException {
        String query = "DELETE FROM Menu WHERE prod_id = ? AND quantity = ?";

        try (Connection con = getConnection();
                PreparedStatement pstmt = con.prepareStatement(query)) {
            pstmt.setInt(1, prodId);
            pstmt.setInt(2, quantity);
            int rowsAffected = pstmt.executeUpdate();
            System.out.println(rowsAffected + " row(s) deleted.");
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }
    }

    public void add(int prodId, String itemName, int cost, int quantity) throws SQLException {

        Scanner sc = new Scanner(System.in);

        String query = "UPDATE Menu SET  quantity = ? ,cost=? WHERE prod_id = ?";
        String query2 = "UPDATE Menu SET  quantity = ?  WHERE prod_id = ?";

        System.out.println("Do you want to modify cost?");
        String choice = sc.next();
        try (Connection con = getConnection()) {

            if (choice.toLowerCase().equals("yes")) {
                PreparedStatement pstmt = con.prepareStatement(query);
                pstmt.setInt(1, quantity);
                pstmt.setInt(2, cost);
                pstmt.setInt(3, prodId);
                int rowsAffected = pstmt.executeUpdate();
                System.out.println(rowsAffected + " row(s) updated.");

            } else {
                PreparedStatement pstmt = con.prepareStatement(query2);
                pstmt.setInt(1, quantity);
                pstmt.setInt(2, prodId);
                int rowsAffected = pstmt.executeUpdate();
                System.out.println(rowsAffected + " row(s) updated.");
            }

        }
    }

    public void export() throws SQLException {
        String query = "select * from menu";

        StringBuilder json = new StringBuilder("[");

        try (
                Connection con = getConnection();
                Statement stmt = con.createStatement();) {
            ResultSet rs = stmt.executeQuery(query);

            boolean first = true;
            while (rs.next()) {
                if (!first) {
                    json.append(',');
                }
                first = false;
                json.append("{\n")
                        .append("\"prod_id\":").append(rs.getInt("prod_id")).append(",\n")
                        .append("\"item_name\":").append("\"").append(rs.getString("item_name")).append("\"").append(",\n")
                        .append("\"cost\":").append(rs.getInt("cost")).append(",\n")
                        .append("\"quantity\":").append(rs.getInt("quantity"))
                        .append("}\n");

            }
            json.append(']');
            String data=json.toString();
            try {
                FileWriter sqlWrite = new FileWriter("sql.json");
                sqlWrite.write(data);
                sqlWrite.close();
            } catch (IOException e) {
                System.out.println("Error in reading " + e.getMessage());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}

public class User {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        sql data = new sql();

        System.out.println(
                "Enter the number for the operation :\n 1:read all data \n 2:delete one \n 3:add one \n 4:export json");
        int n = in.nextInt();

        switch (n) {
            case 1: {
                try {
                    data.readAll();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            }
            case 2: {
                try {
                    System.out.println("Enter the prod_id:");
                    int prodId = in.nextInt();
                    System.out.println("Enter the quantity:");
                    int quantity = in.nextInt();
                    data.delete(prodId, quantity);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            }
            case 3: {
                try {

                    System.out.println("Enter the prod_id:");
                    int id = in.nextInt();
                    System.out.println("Enter the itemName:");
                    String name = in.next();
                    System.out.println("Enter the cost:");
                    int cost = in.nextInt();
                    System.out.println("Enter the quantity:");
                    int quant = in.nextInt();

                    data.add(id, name, cost, quant);

                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            }
            case 4: {
                try {
                    data.export();
                    System.out.println("JSON Output:succesfully done");
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            }
            default:
                System.out.println("Invalid option.");
        }

    }
}