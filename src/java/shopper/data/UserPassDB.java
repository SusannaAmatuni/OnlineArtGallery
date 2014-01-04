/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package shopper.data;


import shopper.business.*;
import java.sql.*;
import java.io.*;

/**
 *
 * @author HP_Owner
 */
public class UserPassDB implements Serializable{
    
    public static int addMember(UserPassCl userpass) {
        
       ConnectionPool pool = ConnectionPool.getInstance();
       Connection connection = pool.getConnection();
       int records = 0;
       
       PreparedStatement ps= null;
       ResultSet rs= null;
       String username= userpass.getUserName();
       String password= userpass.getPassword();
       
       String sql = "INSERT INTO Userpass (Username,Password) VALUES(?,?)";
       try {
           ps=connection.prepareStatement(sql);
           ps.setString(1, username);
           ps.setString(2, password);
          records= ps.executeUpdate();
           
            
           return records;
         
       }
       catch(SQLException e) {
           e.printStackTrace();
           return 0;
           
       }
       finally{
                 DBUtil.closeResultSet(rs);
                 DBUtil.closePreparedStatement(ps);
                 pool.freeConnection(connection); 
              }
    }
    
    
    public static boolean userExists(String username) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps= null;
        ResultSet rs=null;
        String name = "";
        String sql = "SELECT Username From UserPass WHERE Username= ?";
        
        try {
            ps=connection.prepareStatement(sql);
            ps.setString(1,username);
           rs= ps.executeQuery();
            if(rs.next()) {
                 name= rs.getString("Username");
                            
            } 
            return (username.equalsIgnoreCase(name)) ;
       }
            
            
       /*   ps=  connection.prepareStatement(sql);
          ps.setString(1, username);
            rs=ps.executeQuery();
            return rs.next(); */
          
          
           
        
          catch(SQLException e) {
              e.printStackTrace();
              return false;
          } 
        finally {
            
                DBUtil.closeResultSet(rs);
               DBUtil.closePreparedStatement(ps);
               pool.freeConnection(connection); 
              }
        
    }
    
    
    public static UserPassCl selectMember(String username) {
        
        ConnectionPool pool= ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        
        PreparedStatement ps=null;
        ResultSet rs= null;
        
        UserPassCl userPass= null;
        
        String sql = "SELECT * FROM Userpass WHERE Username= ? ";
        
        try {
          ps=  connection.prepareStatement(sql);
          ps.setString(1, username);
          
          rs= ps.executeQuery();
          
           if(rs.next()) {
               userPass= new UserPassCl();
              userPass.setPassword(rs.getString("Password"));
              userPass.setUserName(rs.getString("Username"));
           }
          return userPass;
        }
      catch(SQLException e)  {
          e.printStackTrace();
          return userPass;
      }
        
        finally {
           DBUtil.closeResultSet(rs);
               DBUtil.closePreparedStatement(ps);
               pool.freeConnection(connection);   
        }
        
    }
    
}
