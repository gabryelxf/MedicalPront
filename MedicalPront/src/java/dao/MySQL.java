
package dao;

import com.mysql.cj.protocol.Resultset;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



public class MySQL {
    
    
     public static Connection getConnection () throws Exception {
        Connection con = null;
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
           
          System.out.println(ex.getLocalizedMessage());
        }
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mdb", "root", "root"); 
            
            
        } catch (SQLException ex) {
           
         System.out.println(ex.getLocalizedMessage());
        }
        
        return con;
    }
}
