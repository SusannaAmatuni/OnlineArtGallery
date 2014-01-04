/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package shopper.data;
import shopper.business.*;
import java.util.*;
import java.sql.*;
/**
 *
 * @author HP_Owner
 */
public class ProductDB {
    
    
    public static ProductCl selectProduct(String productCode) {
        ConnectionPool pool =ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        
      PreparedStatement ps=null;
      ResultSet rs= null;
      
      String sql = "SELECT * FROM Product WHERE ProductCode = ?";
      
      try {
     ps= connection.prepareStatement(sql);
     ps.setString(1,productCode);
     rs= ps.executeQuery();
      
      if(rs.next()){
    ProductCl  product = new ProductCl();
      product.setArtDescriptionID(rs.getInt("ArtDescription_ID"));
     product.setArtTypeID(rs.getInt("ArtType_ID"));
     product.setArtistID(rs.getInt("Artist_ID"));
     product.setProductCode(rs.getString("ProductCode"));
     product.setProductDescription(rs.getString("ProductDescription"));
     product.setProductName(rs.getString("ProductName"));
     product.setProductPrice(rs.getDouble("ProductPrice"));
     product.setProductID(rs.getInt("Product_ID"));  
        return product;
      }
        else {return null;}
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
    
   public static ArrayList<ProductCl> selectProductDesc(int artDescriptionID) {
       ConnectionPool pool = ConnectionPool.getInstance();
       Connection connection = pool.getConnection();
       ResultSet rs= null;
       PreparedStatement ps= null;
       ArrayList<ProductCl> products = new ArrayList<ProductCl>();
       
       String sql = "SELECT * FROM Product WHERE ArtDescription_ID = ?";
       
       try {
        ps = connection.prepareStatement(sql);
        ps.setInt(1,artDescriptionID);
        rs=ps.executeQuery();
        while(rs.next()) {
            ProductCl product = new ProductCl();
            product.setArtDescriptionID(rs.getInt("ArtDescription_ID"));
            product.setArtTypeID(rs.getInt("ArtType_ID"));
            product.setArtistID(rs.getInt("Artist_ID"));
            product.setProductCode(rs.getString("ProductCode"));
            product.setProductDescription(rs.getString("ProductDescription"));
            product.setProductName(rs.getString("ProductName"));
            product.setProductPrice(rs.getDouble("productPrice"));
            
            products.add(product);
                   
        }
        return products;
        
       }
       catch(SQLException e) {
           e.printStackTrace();
           return null;
           
       }
       finally {
           pool.freeConnection(connection);
           DBUtil.closePreparedStatement(ps);
           DBUtil.closeResultSet(rs);
       }
   } 
    
    
    public static ArrayList<ProductCl> selectProducts() {
     
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        
        
        ArrayList<ProductCl> products = new ArrayList<ProductCl>();
        
        PreparedStatement ps=null;
         ResultSet rs= null;
         String sql = "SELECT * FROM product";
         
    try{
        
       
        
     ps= connection.prepareStatement(sql);
    
   rs= ps.executeQuery();
  while(rs.next()) {
    ProductCl  product= new ProductCl();
  product.setProductCode(rs.getString("ProductCode"));
  product.setProductDescription(rs.getString("ProductDescription"));
  product.setArtistID(rs.getInt("Artist_ID"));
  product.setProductName(rs.getString("productName"));
  product.setProductPrice(rs.getDouble("ProductPrice"));   
  product.setArtTypeID(rs.getInt("ArtType_ID"));
  product.setArtDescriptionID(rs.getInt("ArtDescription_ID")); 
  products.add(product);
    }
  return products;
    }
    catch(SQLException e) {
        e.printStackTrace();
      return null;  
    }
    finally {
        pool.freeConnection(connection);
        DBUtil.closeResultSet(rs);
        DBUtil.closeStatement(ps);
    }
    }
    
   public static ArrayList<ProductCl> selectProductsForArtist(int artistID) {
       ConnectionPool pool = ConnectionPool.getInstance();
       Connection connection = pool.getConnection();
       PreparedStatement ps = null;
       ResultSet rs= null;
       ArrayList<ProductCl> products = new ArrayList<ProductCl>();
       
       String sql = "SELECT * FROM Product WHERE Artist_ID = ? ";
       
       try {
           ps= connection.prepareStatement(sql);
           ps.setInt(1, artistID);
           rs=ps.executeQuery();
           while(rs.next()) {
              ProductCl  product = new ProductCl();
              product.setArtDescriptionID(rs.getInt("ArtDescription_ID"));
              product.setArtTypeID(rs.getInt("ArtType_ID"));
              product.setArtistID(rs.getInt("Artist_ID"));
              product.setProductCode(rs.getString("ProductCode"));
              product.setProductDescription(rs.getString("ProductDescription"));
              product.setProductName(rs.getString("ProductName"));
              product.setProductPrice(rs.getDouble("ProductPrice"));
              products.add(product);
           }
        return products;
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
       
       
       
   
    
    
    public static int selectProductsArtistID(String productCode) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps= null;
        ResultSet rs= null;
        int artistID= 0;
        
        String sql = "SELECT Artist_ID FROM Product WHERE ProductCode = ? ";
        
        try {
            ps= connection.prepareStatement(sql);
            ps.setString(1, productCode);
            rs = ps.executeQuery();
            if(rs.next()) {
            artistID = rs.getInt("Artist_ID");
            return artistID;
                   
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
            DBUtil.closeResultSet(rs);
        }
        
    }
    
    public static ArrayList<ProductCl> selectProducts(int arttype_ID) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps=null;
        ResultSet rs= null;
        ArrayList<ProductCl> products = new ArrayList<ProductCl>();
        
        String sql = "SELECT * FROM Product WHERE ArtType_ID = ?";
        
        try{
            ps= connection.prepareStatement(sql);
            ps.setInt(1, arttype_ID);
            rs= ps.executeQuery();
            while(rs.next()) {
                ProductCl product = new ProductCl();
                product.setArtDescriptionID(rs.getInt("ArtDescription_ID"));
                product.setArtTypeID(rs.getInt("ArtType_ID"));
                product.setArtistID(rs.getInt("Artist_ID"));
                product.setProductCode(rs.getString("ProductCode"));
                
                product.setProductDescription(rs.getString("ProductDescription"));
                product.setProductName(rs.getString("ProductName"));
                product.setProductPrice(rs.getDouble("ProductPrice"));
                products.add(product);
            
            }
            return products;
        }
            catch(SQLException e) {
                e.printStackTrace();
                return null;
            }
         finally {
             pool.freeConnection(connection);
             DBUtil.closePreparedStatement(ps);
             DBUtil.closeResultSet(rs);}
        }
        
    
    public static int selectproductID(ProductCl product) {
        
        ConnectionPool pool=ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        String sql= "SELECT Product_ID FROM Product WHERE ProductCode=?";
        
        try{
          ps=  connection.prepareStatement(sql);
          ps.setString(1,product.getProductCode());
           rs= ps.executeQuery();
           rs.next();
          return   rs.getInt("Product_ID");
        }
        catch(SQLException e) {
            e.printStackTrace();
            return 0;
        }
        
        finally {
            pool.freeConnection(connection);
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
        }
    }
    
    
    public static ProductCl selectProduct(int productID) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
         ProductCl product=null;
        String sql= "Select * FROM Product WHERE Product_ID = ?";
        
        try {
            ps= connection.prepareStatement(sql);
            ps.setInt(1, productID);
           rs= ps.executeQuery();
           while(rs.next()) {
                product = new ProductCl();
                product.setArtDescriptionID(rs.getInt("ArtDescription_ID"));
                product.setArtTypeID(rs.getInt("ArtType_ID"));
                product.setArtistID(rs.getInt("Artist_ID"));
                product.setProductCode(rs.getString("ProductCode"));
                product.setProductID(rs.getInt("Product_ID"));
                product.setProductDescription(rs.getString("ProductDescription"));
                product.setProductName(rs.getString("ProductName"));
                product.setProductPrice(rs.getDouble("ProductPrice"));
           }
           return product;
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

    