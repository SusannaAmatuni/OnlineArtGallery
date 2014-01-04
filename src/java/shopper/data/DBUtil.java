/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package shopper.data;

import java.sql.*;

/**
 *
 * @author HP_Owner
 */
public class DBUtil {

    public static void closeStatement(Statement statement) {
        try{
                if(statement!=null)
                {
                    statement.close();
                }
        }
                        
                
                catch(SQLException e) {
                 e.printStackTrace();  
                }
    }
    
    public static void closePreparedStatement(PreparedStatement ps) {
        try {
            if(ps!=null)
                ps.close();
        }
        catch(SQLException e) {
            e.printStackTrace();
            
        }
    }
    
    public static void closeResultSet(ResultSet rs) {
        try{
            if(rs!=null) {
                rs.close();
            }
        }
            catch(SQLException e) {
                e.printStackTrace();
            }
        }
    }

