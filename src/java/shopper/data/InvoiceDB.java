/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package shopper.data;


import shopper.business.*;
import java.sql.*;
import java.util.*;
import java.text.*;

/**
import java.text.
 *
 * @author HP_Owner
 */
public class InvoiceDB  {

    
    
    public static InvoiceCl selectInvoice(int invoiceID) {
        
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps=null;
        ResultSet rs = null;
        InvoiceCl invoice=null;
        
        String sql = "SELECT * FROM invoice WHERE invoice_ID = ?";
        
        try {
          ps =  connection.prepareStatement(sql);
          ps.setInt(1, invoiceID);
          rs= ps.executeQuery();
          if(rs.next()){
             invoice= new InvoiceCl();
             invoice.setInvoiceDate(rs.getDate("InvoiceDate"));
                          
          }
          return invoice;
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
    
    
    
    
    public static ArrayList<InvoiceCl> select(int customerID) {
   ArrayList<InvoiceCl> invoices = new ArrayList<InvoiceCl>();
      
   ConnectionPool pool= ConnectionPool.getInstance();
    Connection connection = pool.getConnection();
    ResultSet rs= null;
    PreparedStatement ps = null;
    String sql = "SELECT * FROM invoice WHERE Customer_ID = ?";
    try {
      ps=  connection.prepareStatement(sql);
      ps.setInt(1, customerID);
     rs= ps.executeQuery(); 
     
        while(rs.next()) {
         
            InvoiceCl invoice = new InvoiceCl();
            invoice.setInvoiceID(rs.getInt("Invoice_ID"));
            invoice.setInvoiceDate(rs.getDate("InvoiceDate"));
             invoices.add(invoice);
        }
       return invoices;
     }
            
   catch(SQLException ex) {
        
        ex.printStackTrace();
        return null;
    }
    
    finally {
        DBUtil.closePreparedStatement(ps);
        DBUtil.closeResultSet(rs);
        pool.freeConnection(connection);
    }
    
    }
    
    
    public static ArrayList<InvoiceCl> select(int customerID,int period) {
      
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        ResultSet rs= null;
        PreparedStatement ps=null;
        ArrayList<InvoiceCl> invoices= new ArrayList<InvoiceCl>();
          GregorianCalendar currentdate = new GregorianCalendar();
       
       int currentYear = currentdate.get(Calendar.YEAR);
       int currentMonth= currentdate.get(Calendar.MONTH);
       int currentDay = currentdate.get(Calendar.DAY_OF_MONTH);
       
       String sql = "SELECT * FROM Invoice WHERE Customer_ID = ? ";
       
       try {
         ps=  connection.prepareStatement(sql); 
         ps.setInt(1,customerID);
         rs= ps.executeQuery();
         rs.afterLast();
          rs.previous();
          InvoiceCl lastinvoice = new InvoiceCl();
          lastinvoice.setInvoiceID(rs.getInt("Invoice_ID"));
          lastinvoice.setInvoiceDate(rs.getDate("InvoiceDate"));
         
           invoices.add(lastinvoice);
       
         
         while(rs.previous()) {
            
            
           /*  java.sql.Date dayasdate =rs.getDate("InvoiceDate");
            String stringDay= dayasdate.toString();
            String day= stringDay.substring(5);
        */
             -- period;
             if(period==0)
                 break;
            
             
              InvoiceCl invoice = new InvoiceCl();
            invoice.setInvoiceID(rs.getInt("Invoice_ID"));
            invoice.setInvoiceDate(rs.getDate("InvoiceDate"));
             invoices.add(invoice);
            
           // int dayint= Integer.parseInt(day);
          
       
        
       }
         return invoices;
       }
      
       catch(SQLException ex) {
           ex.printStackTrace();
           return null;
       }
       
       finally {
          DBUtil.closePreparedStatement(ps);
        DBUtil.closeResultSet(rs);
        pool.freeConnection(connection); 
       }
        
    }


    public static int  insert(InvoiceCl invoice) {
        
        ConnectionPool pool = ConnectionPool.getInstance();
    Connection connection = pool.getConnection();
    ResultSet rs = null;
    PreparedStatement ps= null;
    CustomerCl customer = invoice.getCustomer();
            int Customer_ID =CustomerDB.selectCustomerID(customer);
    
        //The sql function: NOW() returns current date
        
        double invoicetotal= invoice.getInvoiceTotal();
        
        
        try{
            String sql = "INSERT INTO Invoice (Customer_ID,InvoiceDate,InvoiceGrandTotal,IsProcessed)" +
                "Values (?,NOW(),?,'N') ";
            
            
           ps= connection.prepareStatement(sql);
            ps.setInt(1, Customer_ID);        
             ps.setDouble(2, invoice.getInvoiceTotal());
           ps.executeUpdate();
         
        
        
            
          
           //In Microsoft SQL there is a spesial variable called @@IDENTITY 
           //that always contains the primary key of the last entry that 
           //was inserted into table.AS means alias.
           //LAST_INSERTED_ID(), LAST_INSERTED_ID(expr} is similiar to@@..
           //the functions return the last authomatically generated value
           //that was inserted into an AUTO_INCREMENT column
           //"SELECT Last_Inserted_ID() AS IDENTITY"; 
           
           String invoiceIDsql = "SELECT @@IDENTITY AS IDENTITY"; 
           Statement identitystatement = connection.createStatement();
           ResultSet identityResultSet = identitystatement.executeQuery(invoiceIDsql);
             identityResultSet.next();
             //Found out under what AUTO_INCREMENT key the invoice is writen
           int invoice_ID= identityResultSet.getInt("IDENTITY");
          
            identitystatement.close();
           identityResultSet.close();
          
           //write lineitems into LineItem table
           
           ArrayList<LineItemCl> items = invoice.getInvoiceItems();
           Iterator<LineItemCl> it = items.iterator();
           while(it.hasNext()) {
               LineItemDB.insert(invoice_ID,it.next());
           }
           return 1;
        }
        catch(SQLException e ) {
         e.printStackTrace();
         return 0;
        }
        
        finally{
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
            
            pool.freeConnection(connection);
        }
        
    }
    
    
    public static ArrayList<InvoiceCl> selectUnprocessedInvoices() {
        
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        ResultSet rs = null;
        PreparedStatement ps = null;
        ArrayList<InvoiceCl> invoices = new ArrayList<InvoiceCl>();
        
        
        String sql = "SELECT *  FROM  Customer "+
                "INNER JOIN Invoice " +
                "ON Customer.Customer_ID = Invoice.Customer_ID " +
                "WHERE Invoice.IsProcessed='N' " +
                "ORDER BY InvoiceDate " ;
       
        try {
                   
          ps= connection.prepareStatement(sql);
            rs=ps.executeQuery();
            ArrayList<LineItemCl> invoiceitems= new ArrayList<LineItemCl>(); 
            while(rs.next()) {
                
                 CustomerCl customer = new CustomerCl();
                
                 customer.setFirstName(rs.getString("FirstName"));
                customer.setLastName(rs.getString("LastName"));
                customer.setEmailAddress(rs.getString("EmailAddress"));
                customer.setCompanyName(rs.getString("CompanyName"));
                customer.setAddress1(rs.getString("Address1"));
                customer.setAddress2(rs.getString("Address2"));
                customer.setCity(rs.getString("City"));
                customer.setState(rs.getString("State"));
                customer.setZipCode(rs.getString("Zip"));
                customer.setCountry(rs.getString("Country"));
                customer.setCreditCardType(rs.getString("CreditCardType"));
                customer.setCreditCardNumber(rs.getString("CreditCardNumber"));
                customer.setCreditCardExpirationDate(rs.getString("CreditCardExp"));

              
                 int invoiceID=rs.getInt("Invoice.Invoice_ID");
                 
                invoiceitems=LineItemDB.selectlineitems(invoiceID);
                
                InvoiceCl invoice= new InvoiceCl();
                
                invoice.setInvoiceID(invoiceID);
                invoice.setInvoiceDate(rs.getDate("InvoiceDate"));
                invoice.setCustomer(customer);
                invoice.setInvoiceItems(invoiceitems);
             invoices.add(invoice);
                        
        }
            return invoices;
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
    
    
    public static int processinvoice(int invoiceNumber) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection= pool.getConnection();
        ResultSet rs= null;
        PreparedStatement ps= null;
        
        String sql = "Update Invoice " +
                     "SET IsProcessed= 'Y' "+
                     "WHERE Invoice_ID= ?";
        
        
       try {
           
           ps= connection.prepareStatement(sql);
           ps.setInt(1, invoiceNumber);
          return  ps.executeUpdate();
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
    
   
        }
    

