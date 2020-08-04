package DataAccess;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ConnectDB {
    private static String url = "jdbc:mysql://localhost:3308/baseprocesos?serverTimezone=US/Central";
    private static String driverName = "com.mysql.cj.jdbc.Driver";
    private static String username = "user";
    private static String password = "password";
    private static Connection con;

    public static Connection getConnection() throws SQLException, ClassNotFoundException {
        Class.forName(driverName);
        con = DriverManager.getConnection(url, username, password);
        return con;
    }

   public void closeConnection() {
       if (con != null){
           try {
               if(!con.isClosed()){
                   con.close();
               }
           }catch (SQLException exc){
               Logger.getLogger(ConnectDB.class.getName()).log(Level.SEVERE, null, exc);
           }
       }
   }
}



