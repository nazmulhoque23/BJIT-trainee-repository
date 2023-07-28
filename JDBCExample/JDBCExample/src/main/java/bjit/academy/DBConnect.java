package bjit.academy;

import java.sql.*;
public class DBConnect {

    public void doConnectDB(){
        String connectionStr = "jdbc:mysql://localhost:3306/bjit_db";
        String user = "root";
        String password = "";

        // Connect to the database
        Connection conn;

        {
            try {
                conn = DriverManager.getConnection(connectionStr, user, password);
                System.out.print("DB Connection is seccussful!");
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void main(String args[]){
        DBConnect dbObj = new DBConnect();
        dbObj.doConnectDB();
    }
}