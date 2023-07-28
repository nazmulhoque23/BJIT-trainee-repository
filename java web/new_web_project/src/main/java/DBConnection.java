import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    Connection conn;

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
}
