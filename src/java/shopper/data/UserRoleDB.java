/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package shopper.data;

/**
 *
 * @author HP_Owner
 */
import shopper.business.*;
import java.sql.*;
import java.io.*;

public class UserRoleDB implements Serializable {
    
    public static int insertRole(UserRoleCl userRole) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps= null;
        ResultSet rs=null;
        int records=0;
        
        String sql = "INSERT INTO Userrole(Username,Rolename) VALUES(?,?) ";
        
        try {
            
           ps= connection.prepareStatement(sql);
           ps.setString(1,userRole.getUserName());
           ps.setString(2, userRole.getUserRole());
           
           records= ps.executeUpdate();
           return records;
        }
        
        catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
        
        finally {
             DBUtil.closeResultSet(rs);
                 DBUtil.closePreparedStatement(ps);
                 pool.freeConnection(connection); 
        }
        
    }
    
}
