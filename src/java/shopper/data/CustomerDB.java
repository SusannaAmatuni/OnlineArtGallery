/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package shopper.data;

import shopper.business.*;
import java.sql.*;


/**
 *
 * @author HP_Owner
 */
public class CustomerDB {
    
    
      public static int insert(CustomerCl user)
    {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;

        //This method adds a new record to the Users table in the database
        String query = 
                "INSERT INTO Customer (FirstName, LastName, EmailAddress, CompanyName, " + 
                "Address1, Address2, City, State, Zip, Country, " +
                "CreditCardType, CreditCardNumber, CreditCardExp,Username) " +
                "VALUES (?, ?, ?, ?, " +
                "?, ?, ?, ?, ?, ?, " +
                "?, ?, ?,?)";
        try
        {        
            ps = connection.prepareStatement(query);
            ps.setString(1, user.getFirstName());
            ps.setString(2, user.getLastName());
            ps.setString(3, user.getEmailAddress());
            ps.setString(4, user.getCompanyName());
            ps.setString(5, user.getAddress1());
            ps.setString(6, user.getAddress2());
            ps.setString(7, user.getCity());
            ps.setString(8, user.getState());
            ps.setString(9, user.getZipCode());
            ps.setString(10, user.getCountry());
            ps.setString(11, user.getCreditCardType());
            ps.setString(12, user.getCreditCardNumber());
            ps.setString(13, user.getCreditCardExpirationDate());
            ps.setString(14,user.getUserName());
            return ps.executeUpdate();
        }
        catch(SQLException e)
        {
            e.printStackTrace();
            return 0;
        }
        finally
        {
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }
    
    
    
    public static boolean emailExist(String emailAddress) {
    
  ConnectionPool pool = ConnectionPool.getInstance();
 Connection connection=  pool.getConnection();
 PreparedStatement ps= null;
 ResultSet rs=null;
 
 String sql = "SELECT EmailAddress FROM Customer WHERE EmailAddress= ?";
 
 try{
ps=  connection.prepareStatement(sql);

ps.setString(1, emailAddress);

  rs= ps.executeQuery();
  return rs.next();
  
      
  }
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
    
    public static boolean memberExist(String username) {
        
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        
        PreparedStatement ps= null;
        ResultSet rs= null;
        
        String sql = "SELECT Username FROM  Customer WHERE Username= ?";
        
        try {
          ps=  connection.prepareStatement(sql);
          ps.setString(1, username);
         rs= ps.executeQuery();
          return rs.next();
        }
        
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
    
    
    public static int update(CustomerCl customer) {
        
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps= null;
        ResultSet rs= null;
        
        String sql = "UPDATE Customer SET " +
                "FirstName= ?, "+
                "LastName= ?, " +
                "EmailAddress= ?,"+
                "CompanyName= ?, "+
                "Address1= ?, "+
                "Address2= ?, " +
                "City= ?, " +
                "State= ?, " +
                "Zip= ?, "+
                "Country= ?, "+
                "CreditCardExp = ?, "+
                "CreditCardNumber= ?, " +
                "CreditCardType= ? "+
                 "WHERE Username= ?" ;
                
                
        try {
            ps= connection.prepareStatement(sql);
            
            ps.setString(1,customer.getFirstName());
            ps.setString(2,customer.getLastName());
            ps.setString(3,customer.getEmailAddress());
            ps.setString(4,customer.getCompanyName());
            ps.setString(5,customer.getAddress1());
            ps.setString(6,customer.getAddress2());
            ps.setString(7,customer.getCity());
            ps.setString(8,customer.getState());
            ps.setString(9,customer.getZipCode());
            ps.setString(10,customer.getCountry());
            ps.setString(11,customer.getCreditCardExpirationDate());
            ps.setString(12, customer.getCreditCardNumber());
            ps.setString(13,customer.getCreditCardType());
            
            ps.setString(14, customer.getUserName());
            return ps.executeUpdate();
            
            
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
    
    




public static CustomerCl selectCustomer(String emailaddress) {
    
    ConnectionPool pool = ConnectionPool.getInstance();
    Connection connection = pool.getConnection();
    
    ResultSet rs= null;
    PreparedStatement ps= null;
   
    String sql = "SELECT * FROM Customer WHERE EmailAddress= ? ";
    
    try {
         
        ps= connection.prepareStatement(sql);
        ps.setString(1, emailaddress);
        rs=  ps.executeQuery();
        CustomerCl customer = null;
      if(rs.next()) {
          customer= new CustomerCl();
          customer.setCustomerID(rs.getInt("Customer_ID"));
          customer.setFirstName(rs.getString("FirstName"));
          customer.setLastName(rs.getString("LastName"));
          customer.setEmailAddress(rs.getString("EmailAddress"));
          customer.setAddress1(rs.getString("Address1"));
          customer.setAddress2(rs.getString("Address2"));
          customer.setCompanyName(rs.getString("CompanyName"));
          customer.setCity(rs.getString("City"));
          customer.setCountry(rs.getString("Country"));
            
          customer.setState(rs.getString("State"));
          customer.setZipCode(rs.getString("Zip"));
      }
      return customer;
     
}

      catch(SQLException e) {
         e.printStackTrace(); 
         return null;
      }
     finally{
         
         
         DBUtil.closeResultSet(rs);
         DBUtil.closePreparedStatement(ps);
        pool.freeConnection(connection);
    }
    
}

public static CustomerCl selectCustomerMember(String username) {
    
    ConnectionPool pool = ConnectionPool.getInstance();
    Connection connection = pool.getConnection();
    
    ResultSet rs= null;
    PreparedStatement ps= null;
    
    String sql = "SELECT * FROM Customer  WHERE Username= ?" ;
    CustomerCl customer= null;
    
    try {
       ps= connection.prepareStatement(sql);
       ps.setString(1,username );
       
       rs= ps.executeQuery();
       while(rs.next()) {
           
            customer = new CustomerCl();
            customer.setCustomerID(rs.getInt("Customer_ID"));
          customer.setFirstName(rs.getString("FirstName"));
          customer.setLastName(rs.getString("LastName"));
          customer.setEmailAddress(rs.getString("EmailAddress"));
          customer.setAddress1(rs.getString("Address1"));
          customer.setAddress2(rs.getString("Address2"));
          customer.setCompanyName(rs.getString("CompanyName"));
          customer.setCity(rs.getString("City"));
          customer.setCountry(rs.getString("Country"));
            
          customer.setState(rs.getString("State"));
          customer.setZipCode(rs.getString("Zip"));
          customer.setUserName(rs.getString("Username"));
           
       }
       return customer;
    }
    catch(SQLException e) {
        e.printStackTrace();
        return null;
    }
    
    finally {
        DBUtil.closePreparedStatement(ps);
        DBUtil.closeResultSet(rs);
        pool.getConnection();
    }
    
}



public static int selectCustomerID(CustomerCl customer ) {
    ConnectionPool pool = ConnectionPool.getInstance();
    Connection connection = pool.getConnection();
    PreparedStatement ps = null;
    ResultSet rs = null;
    String sql = "SELECT Customer_ID FROM Customer WHERE Username=?";
    try {
        String username = customer.getUserName();
        ps=connection.prepareStatement(sql);
        ps.setString(1,username);
      rs=  ps.executeQuery();
        if(rs.next()) 
           return rs.getInt("Customer_ID");
        else 
           return -1;
      }
    catch(SQLException e) {
        e.printStackTrace();
        return -1;
    }
    
    finally{
        
        
        DBUtil.closeResultSet(rs);
        DBUtil.closePreparedStatement(ps);
        pool.freeConnection(connection);
    }
}


public static CustomerCl selectCustomerByID(int customer_ID) {
    ConnectionPool pool = ConnectionPool.getInstance();
    Connection connection = pool.getConnection();
    ResultSet rs = null;
    PreparedStatement ps =null;
    CustomerCl customer= null;
    String sql = "SELECT * FROM Customer WHERE Customer_ID = ?" ;
    
    try {
        ps = connection.prepareStatement(sql);
        ps.setInt(1, customer_ID);
       rs= ps.executeQuery();
       if(rs.next()) {
            customer = new CustomerCl();
           customer.setFirstName(rs.getString("FirstName"));
           customer.setLastName(rs.getString("LastName"));
           customer.setAddress1(rs.getString("Address1"));
           customer.setAddress2(rs.getString("Address2"));
           customer.setCity(rs.getString("City"));
           customer.setCompanyName(rs.getString("CompanyName"));
           customer.setCountry(rs.getString("Country"));
           customer.setState(rs.getString("State"));
           customer.setCreditCardExpirationDate(rs.getString("CreditCardExp"));
           customer.setCreditCardNumber(rs.getString("CreditCardNumber"));
           customer.setCreditCardType(rs.getString("CreditcardType"));
           customer.setEmailAddress(rs.getString("EmailAddress"));
           customer.setZipCode(rs.getString("Zip"));
           customer.setCustomerID(rs.getInt("Customer_ID"));
       }
      return customer;
      
    }
    
    catch(SQLException e) {
        e.printStackTrace();
        return null;
    }
    
    finally {
        
        DBUtil.closeResultSet(rs);
        DBUtil.closePreparedStatement(ps);
        pool.freeConnection(connection);
    }
}


public static int signOut(String emailcookie) {
    
    ConnectionPool pool = ConnectionPool.getInstance();
   Connection connection= pool.getConnection();
   ResultSet rs= null;
   PreparedStatement ps=null;
   String emailaddress="";
   int del =0;
   String sql = "DELETE  FROM Customer WHERE Customer.EmailAddress = ? ";
  
   try {
   ps = connection.prepareStatement(sql);
    ps.setString(1, emailcookie);
  return  ps.executeUpdate();
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
}
    
    


