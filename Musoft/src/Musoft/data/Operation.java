package Musoft.data;

import java.sql.*;

public class Operation {
	public void Upload(Connection conn,String movie, String actor, String actress, String year, String director) 
	{  
        String sql = "INSERT INTO movies(movie, actor, actress, year, director) VALUES(?,?,?,?,?)";  
   
        try{    
            PreparedStatement pstmt = conn.prepareStatement(sql);  
            pstmt.setString(1, movie);
            pstmt.setString(2, actor);
            pstmt.setString(3, actress);
            pstmt.setInt(4, Integer.parseInt(year));
            pstmt.setString(5, director);
            pstmt.executeUpdate();  
            System.out.println("Data Uploaded");
        } catch (Exception e) {  
            System.out.println(e.getMessage());  
        }  
    }

    public void getAll(Connection c){  
        String sql = "SELECT * FROM movies";  
          
        try {    
            Statement stmt  = c.createStatement();  
            ResultSet rs    = stmt.executeQuery(sql);  
              
            // loop through the result set  
            while (rs.next()) {  
                System.out.println(rs.getString("movie") + "\t" +
                		rs.getString("actor") + "\t" +
                		rs.getString("actress") + "\t" +
                		rs.getString("year") + "\t" +
                		rs.getString("director"));  
            }  
        } catch (Exception e) {  
            System.out.println(e.getMessage());  
        }  
    }
    
    public void getMovie(Connection c,String s){  
        String sql = "SELECT movie FROM movies where actor is '"+s+"'";  
          
        try {    
            Statement stmt  = c.createStatement();  
            ResultSet rs    = stmt.executeQuery(sql);  
              
            // loop through the result set  
            while (rs.next()) {  
                System.out.println(rs.getString("movie"));  
            }  
        } catch (Exception e) {  
            System.out.println(e.getMessage());  
        }  
    }
}
