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
public class ArtTypeDB {
    
    public static int selectArtType(String arttype) {
  ConnectionPool pool = ConnectionPool.getInstance();
  Connection connection = pool.getConnection();
  PreparedStatement ps = null;
  ResultSet rs = null;
  int arttype_ID=0;
  
  String sql = "SELECT ArtType_ID FROM ArtType WHERE ArtTypeName= ?";
  try {
   ps=   connection.prepareStatement(sql);
      
   ps.setString(1,arttype);
   rs= ps.executeQuery();
   if(rs.next()) {
     arttype_ID= rs.getInt("ArtType_ID");
     
      return arttype_ID;
  }
   else {
       return 0;
  }
  }
  
  catch(SQLException e) {
      e.printStackTrace();
      return 0;
      
  }
  
  finally {
      pool.freeConnection(connection);
      DBUtil.closePreparedStatement(ps);
      DBUtil.closeResultSet(rs);}
  }

}
