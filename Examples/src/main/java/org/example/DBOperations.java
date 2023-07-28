package org.example;

import java.sql.*;
public class DBOperations {

    Connection conn;
    public void doConnectDB(){
        String connectionStr = "jdbc:mysql://localhost:3306/bjit_db";
        String user = "root";
        String password = "";

        // Connect to the database


        {
            try {
                conn = DriverManager.getConnection(connectionStr, user, password);
                System.out.print("DB Connection is successful!");
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void fetchData(){
        try{
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM user_table");

            while(rs.next()){
                String name = rs.getString("name");
                int age = rs.getInt("age");
                String bloodGroup = rs.getString("blood_group");

                System.out.println("Name:"+name+" Age:"+age+" Blood Group:"+bloodGroup);
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args){
        DBOperations dbObj = new DBOperations();
        dbObj.doConnectDB();
        System.out.println();
        dbObj.fetchData();
    }
}