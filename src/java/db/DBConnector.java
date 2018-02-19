package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 *
 * @author SHUBHAM
 */
public class DBConnector 
{
    public static Statement st=null;
    public static Connection con=null;
    
    static
    {
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Driver Loaded");
            
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Attendance","root","root");
            System.out.println("Connected");
            
            st=con.createStatement();
        }
        catch(Exception e)
        {
            System.out.println(e);
        } 
    }
    
    public static Connection getConnection()
    {
        return con;
    }
    
    public static Statement getStatement()
    {
        return st;
    }
}
