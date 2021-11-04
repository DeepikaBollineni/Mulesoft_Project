package Musoft.data;

import java.sql.*;  
   
public class CreateData {  
  
    public static Connection createDatabase(String name) {  
    	Connection k = null;
        String url = "jdbc:sqlite:D:/sqlite/" + name;  
   
        try {  
            k = DriverManager.getConnection(url);  
            if (k != null) {  
                DatabaseMetaData meta = k.getMetaData();  
                System.out.println("Diver name is " + meta.getDriverName());
                System.out.println(name+" DataBase is created.");  
            }  
   
        } catch (Exception e) {  
            return null;
        	//System.out.println(e.getMessage());  
        }  
        return k;
    }
    public static void createTable(Connection con) {  
        // SQLite connection string  
        //String url = s;  
          
        // SQL statement for creating a new table  
        String table = "CREATE TABLE IF NOT EXISTS movies (\n"  
                + " movie text NOT NULL,\n"  
                + " actor text NOT NULL,\n"
                + " actress text NOT NULL,\n"
                + " year integer NOT NULL,\n"
                + " director text NOT NULL\n"
                + ");";  
          
        try{  
            //Connection conn = DriverManager.getConnection(url);  
            Statement stmt = con.createStatement();  
            stmt.execute(table);
            System.out.println("Table is Created");
        } catch (SQLException e) {  
            System.out.println(e.getMessage());  
        }  
    }
}  