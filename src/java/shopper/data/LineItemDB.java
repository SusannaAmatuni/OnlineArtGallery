/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package shopper.data;

import java.sql.*;
import shopper.business.*;
import java.util.*;
/**
 *
 * @author HP_Owner
 */
public class LineItemDB {
    
    
    public static int insert(int invoice_ID,LineItemCl lineitem) {
        
  ConnectionPool pool= ConnectionPool.getInstance();
  Connection connection= pool.getConnection();
  PreparedStatement ps= null;
  ResultSet rs = null;
  
  ProductCl product = lineitem.getProduct();
  int product_ID= ProductDB.selectproductID(product);
  String sql = "INSERT INTO  LineItem(Invoice_ID,Product_ID,Quantity) VALUES(?,?,?)";
  
  try{
      
    ps=  connection.prepareStatement(sql);
   
    ps.setInt(1, invoice_ID);
    ps.setInt(2,product_ID);
    ps.setInt(3, lineitem.getQuantity());
    
    return ps.executeUpdate();
  }
  catch(SQLException e) {
      e.printStackTrace();
      return 0;
  }
  
  finally {
      
      DBUtil.closeResultSet(rs);
      DBUtil.closePreparedStatement(ps);
      
      pool.freeConnection(connection);
  }
    }
    
    
   
    
    
    public static ArrayList<LineItemCl > selectlineitems(int invoice_ID) {
        
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        ResultSet rs = null;
        PreparedStatement ps = null;
        ArrayList<LineItemCl> lineitems= new ArrayList<LineItemCl>();
        
        String sql = "SELECT * FROM LineItem WHERE Invoice_ID = ?";
        
        try {
            ps = connection.prepareStatement(sql);
            ps.setInt(1,invoice_ID);
           rs= ps.executeQuery();
           
           while (rs.next()) {
               
               LineItemCl lineitem = new LineItemCl();
               int productID=rs.getInt("Product_ID");
               ProductCl product= ProductDB.selectProduct(productID);
               
               lineitem.setProduct(product);
               lineitem.setQuantity(rs.getInt("Quantity"));
               lineitems.add(lineitem);
           }
           return lineitems;
        }
        
        catch(SQLException e) {
            e.printStackTrace();
            return null;
        }
        
        finally{
            pool.freeConnection(connection);
            DBUtil.closePreparedStatement(ps);
            DBUtil.closeResultSet(rs);
        }
        
    }
    
    
}
