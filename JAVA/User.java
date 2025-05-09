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
    
    public void update(int prodId, String itemName, int cost, int quantity) throws SQLException {
        String query = "UPDATE Menu SET item_name = ?, cost = ?, quantity = ? WHERE prod_id = ?";
        try (Connection con = getConnection();
             PreparedStatement pstmt = con.prepareStatement(query)) {
            pstmt.setString(1, itemName);
            pstmt.setInt(2, cost);
            pstmt.setInt(3, quantity);
            pstmt.setInt(4, prodId);
            int rowsAffected = pstmt.executeUpdate();
            System.out.println(rowsAffected + " row(s) updated.");
        }
    }

    public String export() throws SQLException{

        String query ="Select * from menu";
        StringBuilder json=new StringBuilder("[");
        try(
            Connection con=getConnection();
            Statement stmt = con.createStatement();
            ResultSet rs= stmt.executeQuery(query);){

            boolean first =true;
            while(rs.next()){
                if(!first){
                    json.append(',');
                }
                first=false;
                json.append('{')
                .append("\"prod_id\":").append(rs.getInt("prod_id")).append(',')
                .append("\"item_name\":").append(rs.getString("item_name")).append(',')
                .append("\"cost\":").append(rs.getString("cost")).append(',')
                .append("\"quantity\":").append(rs.getString("quantity")).append('}');
            }
            json.append("]");
            return json.toString();
        }
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
            case 3:{
                try{
                    data.update(2,"B",34,7);
                }catch(SQLException e){
                    e.printStackTrace();
                }
            }
            
        }        
    }
}