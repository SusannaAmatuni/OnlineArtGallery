/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package shopper.data;

import shopper.business.*;
import java.sql.*;
import java.io.*;
import java.util.*;
/**
 *
 * @author HP_Owner
 */
public class WishListDB implements Serializable {
 
    public static int addMember(CustomerCl customer) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection= pool.getConnection();
        PreparedStatement ps=null;
        ResultSet rs = null;
        String sql= "INSERT INTO WishList (Customer_ID) VALUES (?)";
        
        try {
            ps= connection.prepareStatement(sql);
            ps.setInt(1, customer.getCustomerID());
                                    
             return ps.executeUpdate();
             
                 
             }
             
        catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
        finally {
            DBUtil.closePreparedStatement(ps);
            DBUtil.closeResultSet(rs);
            pool.freeConnection(connection);
                 
            
        }

        
    }
    
    public static WishListCl select(int customerID) {
        
        ConnectionPool pool= ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        
        PreparedStatement ps = null;
        ResultSet rs = null;
        WishListCl wishList= null;
        ArrayList<SelectedItemCl> items= new ArrayList<SelectedItemCl>();
        String sql= "SELECT* FROM WishList WHERE Customer_ID= ?";
        
        try {
            ps= connection.prepareStatement(sql);
            ps.setInt(1, customerID);
            rs= ps.executeQuery();
            
            if(rs.next()) {
                wishList = new WishListCl();
                CustomerCl customer= new CustomerCl();
             int  id = rs.getInt("Customer_ID");
                customer= CustomerDB.selectCustomerByID(id);
                
               wishList.setCustomer(customer);
               items= SelectedItemDB.selectAll(id);
             wishList.setSelectedItems(items);  
               wishList.setWishListID(rs.getInt("WishList_ID"));
               
               return wishList;
            }
            else {return null;}
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
