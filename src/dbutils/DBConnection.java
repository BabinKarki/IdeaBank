package dbutils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DBConnection {
    String DB_URL = "jdbc:mysql://localhost:3306/ideabank";
    String DB_USER = "root";
    String DB_PASSWORD = "root";
    Connection connection = null;


    public DBConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(DB_URL,DB_USER, DB_PASSWORD);
            System.out.println("Database Connected");
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public PreparedStatement getPreparedStatement(String query){
        PreparedStatement pstm = null;
        try{
            pstm = connection.prepareStatement(query);
        }catch (SQLException e){
            e.printStackTrace();;
        }
        return pstm;
    }

//    public static void main(String[] args) {
//        DBConnection db=new DBConnection();
//
//    }

    public Connection getConnection(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }
    /**
     * Method to close the connection
     * @param con
     */
    public void closeConnection(Connection con){
        try {
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
