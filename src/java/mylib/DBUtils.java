
package mylib;

import java.sql.Connection;
import java.sql.DriverManager;


public class DBUtils {
    
    public static Connection makeConnection() throws Exception{
        Connection cn=null;
        String IP="localhost";
        String instanceName="DESKTOP-DQ1HU9M";
        String port="1433";
        String uid="sa";
        String pwd="12345";
        String db="WS_PRJ301";
        String driver="com.microsoft.sqlserver.jdbc.SQLServerDriver";
        String url="jdbc:sqlserver://" +IP+"\\"+ instanceName+":"+port
                 +";databasename="+db+";user="+uid+";password="+pwd;
        Class.forName(driver);
        cn=DriverManager.getConnection(url);
        return cn;
    }
}