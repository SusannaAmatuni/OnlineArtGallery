/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package shopper.data;

import shopper.business.*;
import java.io.*;
import java.sql.*;
import java.util.*;

/**
 *
 * @author HP_Owner
 */
public class SelectedItemDB implements Serializable{
    
   public static int insert(SelectedItemCl item,int wishlistid) {
       
       ConnectionPool pool = ConnectionPool.getInstance();
       Connection connection = pool.getConnection();
       
       PreparedStatement ps= null;
       ResultSet rs = null;
       
       String sql = "INSERT INTO SelectedItem (Product_ID,WishList_ID) VALUES (?,?)";
       
       try {
           ps= connection.prepareStatement(sql);
           ps.setInt(1, item.getProduct().getProductID());
           ps.setInt(2, wishlistid);
           return ps.executeUpdate();
              
       }
       catch(SQLException e) {
           e.printStackTrace();
           return 0;
       }
       
       finally {
           DBUtil.closePreparedStatement(ps);
           DBUtil.closeResultSet(rs);
           pool.freeConnection(connection);
           
       }
   }
   
   public static int delete(SelectedItemCl item,int wishListID ){
       ConnectionPool pool = ConnectionPool.getInstance();
       Connection connection= pool.getConnection();
       
       PreparedStatement ps= null;
       ResultSet rs= null;
       
       String sql = "DELETE FROM SelectedItem where Product_ID = ? AND WishList_ID = ?  ";
       
       try {
         ps= connection.prepareStatement(sql);
         ps.setInt(1, item.getProduct().getProductID());
         ps.setInt(2, wishListID);
        return ps.executeUpdate();
       }
       catch(SQLException e) {
           e.printStackTrace();
           return 0;
       }
       
       finally {
           DBUtil.closePreparedStatement(ps);
           DBUtil.closeResultSet(rs);
           pool.freeConnection(connection);
   }
   }
   
   
   
   public static boolean selectionExist(ProductCl product, int wishListID) {
       
       ConnectionPool pool = ConnectionPool.getInstance();
       Connection connection = pool.getConnection();
       PreparedStatement ps = null;
       ResultSet rs= null;
       
       
       String sql = "SELECT*  FROM SelectedItem WHERE WishList_ID =?";
       
       try {
           ps= connection.prepareStatement(sql);
           ps.setInt(1, wishListID);
           rs= ps.executeQuery();
           while(rs.next()) {
               int productid= rs.getInt("Product_ID");
               
               if(productid == product.getProductID())
               return true; 
               else
                 continue;  
            }              
            return false;
         
       }
       catch(SQLException e) {
           e.printStackTrace();
           return false;
       }
       finally {
           DBUtil.closePreparedStatement(ps);
           DBUtil.closeResultSet(rs);
           pool.freeConnection(connection);
       }
   }
   
   public static int select(int productID,int wishlistID) {
       
       ConnectionPool pool = ConnectionPool.getInstance();
       Connection connection = pool.getConnection();
       PreparedStatement ps= null;
       ResultSet rs= null;
       
       String sql= "SELECT SelectedItem_ID FROM SelectedItem Where Product_ID = ? AND WishList_ID = ?";
       
       try{
           ps.setInt(1, productID); 
           ps.setInt(2, wishlistID);
           rs= ps.executeQuery();
           if(rs.next()) {
               return rs.getInt("SelectedItem_ID");
           }
           else return 0;
       }
       catch(SQLException e) {
           e.printStackTrace();
           return 0;
       }
       
       finally {
           DBUtil.closePreparedStatement(ps);
           DBUtil.closeResultSet(rs);
           pool.freeConnection(connection);
       }
       
   }
   
   
   public static ArrayList<SelectedItemCl> selectAll(int wishListID) {
       
       ConnectionPool pool = ConnectionPool.getInstance();
       Connection connection = pool.getConnection();
       PreparedStatement ps= null;
       ResultSet rs= null;
       String sql = "SELECT* FROM SelectedItem WHERE WishList_ID= ?";
       ArrayList<SelectedItemCl> items = new ArrayList<SelectedItemCl>();
       try {
          ps= connection.prepareStatement(sql);
          ps.setInt(1, wishListID);
          rs=  ps.executeQuery();
        while(rs.next()) {
            int productID = rs.getInt("product_ID");
        ProductCl product=    ProductDB.selectProduct(productID);
            int selecteditemid =rs.getInt("SelectedItem_ID");
            int wishlistid= rs.getInt("WishList_ID");
            SelectedItemCl item = new SelectedItemCl();
            item.setProduct(product);
            item.setSelectedItemID(selecteditemid);
            item.setWishListID(wishlistid);
            items.add(item);
                   
        }
        return items;
       }
        catch(SQLException e) {
            e.printStackTrace();
            return null;
        }
       finally {
           DBUtil.closePreparedStatement(ps);
           DBUtil.closeResultSet(rs);
           pool.freeConnection(connection);
        }
          
       }
   }


