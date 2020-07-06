package PresentationLayer;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;


public class MySQLConn {
    public static Connection getConnection() throws Exception {
        
        String dbRoot = "jdbc:mysql://";
        String hostName = "localhost:3306/";
        String dbName = "projectdatabase";
        String dbUrl = dbRoot+hostName+dbName;
        
        String hostUsername = "root";
        String hostPassword = "";
        
        Connection myConn = (Connection)DriverManager.getConnection(dbUrl, hostUsername, hostPassword);
        return myConn;
    }
}
