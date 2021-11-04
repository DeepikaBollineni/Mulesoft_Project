package Musoft.data;

import java.sql.*;
   
public class Check{  

    public static Connection test(String s) {  
        Connection k = null;  
        try {  
            /* Database parameters  
        	   Class.forName("org.sqlite.JDBC");
             String url = "jdbc:sqlite:/D:\\sqlite\\test.db";  */
            
            // create a connection to the database  
            k = DriverManager.getConnection(s);  
           
            //conn = DriverManager.getConnection(url);
            System.out.println("SQLite Database Connected");  
            return k;  
        } catch (Exception e) {  
            return null;
        	//System.out.println(e.getMessage());  
        }
    }  

} 