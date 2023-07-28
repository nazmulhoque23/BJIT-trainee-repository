package DBOperation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DBConnection {
    Connection conn = null;

    public DBConnection(){
        this.doConnectDB();
    }
    public void doConnectDB(){
        String connectionStr = "jdbc:mysql://localhost:3306/web_app";
        String user = "root";
        String password = "";

        // Connect to the database


        {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                conn = DriverManager.getConnection(connectionStr, user, password);
                System.out.print("DB Connection is successful!");
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }catch (ClassNotFoundException e){
                throw new RuntimeException(e);
            }
        }
    }

    public void insertOperation(String category, String date, String expense_name, String description, Integer amount){
        String INSERT_SQL = "INSERT INTO expense_manager"+"(category, date, expense_name, description, amount)VALUES"+"(?,?,?,?,?)";

        try{
            PreparedStatement preparedStatement = conn.prepareStatement(INSERT_SQL);
            preparedStatement.setString(1,category);
            preparedStatement.setString(2,date);
            preparedStatement.setString(3, expense_name);
            preparedStatement.setString(4, description);
            preparedStatement.setInt(5, amount);

            int result = preparedStatement.executeUpdate();
            System.out.println(result);
            //return result == 1;
        }catch (SQLException e){
            System.out.println(e.getMessage());
            //return false;
        }
    }

    public void selectOperation(){

    }
}
