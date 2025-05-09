import java.sql.*;
import java.util.Scanner;

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
                    ", Quantity: " + rs.getInt("quantity")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }
    }

    public void delete(int prod_id) throws SQLException {
        Scanner sc=new Scanner(System.in);
        String query = "delete from Menu where prod_id=?";

        try (Connection con = getConnection();
                PreparedStatement Pstmt = con.prepareStatement(query)){
                    // System.out.println("Enter the Index of the row ");
                    // int id=sc.nextInt();
                    // System.out.println("Enter the Columnn Name:");
                    // String colName=sc.next();
                    Pstmt.setInt(1,prod_id);
                    int rowsAffected=Pstmt.executeUpdate();
                    System.out.println(rowsAffected +"deleted");
                            
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }
    }
    
    public void update(int prod_id) throws SQLException {
        Scanner sc=new Scanner(System.in);
        String query = "update from Menu where prod_id=?";

        try (Connection con = getConnection();
                PreparedStatement Pstmt = con.prepareStatement(query)){
                    // System.out.println("Enter the Index of the row ");
                    // int id=sc.nextInt();
                    // System.out.println("Enter the Columnn Name:");
                    // String colName=sc.next();
                    Pstmt.setInt(1,prod_id);
                    int rowsAffected=Pstmt.executeUpdate();
                    System.out.println(rowsAffected +"deleted");
                            
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }
}

public class User {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        sql data = new sql();
        System.out.println("Enter the number for the operation :\n 1:read all data \n 2:delete one");
        int n=in.nextInt();
        switch(n){
            case 1:{
                try{
                    data.readAll();
                }catch(SQLException e){
                    e.printStackTrace();
                }
            }case 2:{
                try{
                    data.delete(1);
                }catch(SQLException e){
                    e.printStackTrace();
                }
            }
            
        }        
    }
}