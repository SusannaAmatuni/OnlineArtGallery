/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package shopper.data;

import java.io.*;


import java.sql.*;
import shopper.business.*;
import java.util.*;
/**
 *
 * @author HP_Owner
 */
public class ArtistDB {
    
   public static ArrayList<ArtistCl> selectArtists() {
     
   ArtistCl artist ;    
   ArrayList<ArtistCl> artists= new ArrayList<ArtistCl>();
   
   ConnectionPool pool = ConnectionPool.getInstance();
   Connection connection = pool.getConnection();
   Statement st= null;
   ResultSet rs= null;
   String wholeClob = null;
   String sql = "SELECT * FROM Artists";
   
   try{
     st=  connection.createStatement();
    rs=  st.executeQuery(sql);
    while(rs.next()) {
       artist= new ArtistCl();
       artist.setArtistCode(rs.getString("ArtistCode"));
       artist.setArtistEmail(rs.getString("ArtistEmail"));
       artist.setArtistFirstName(rs.getString("ArtistFirstName"));
       artist.setArtistID(rs.getInt("Artist_ID")); 
       artist.setArtistLastName(rs.getString("ArtistLastName")); 
       Clob artistBio = rs.getClob("ArtistBio");
       int cloblength= (int)artistBio.length();
       wholeClob = artistBio.getSubString(1, cloblength);
       artist.setBioFile(wholeClob);
       artists.add(artist);
    }
    return artists;
   }
   catch(SQLException e) {
       e.printStackTrace();
       return null;
   }
   
   finally{
       pool.freeConnection(connection);
       DBUtil.closeResultSet(rs);
       DBUtil.closeStatement(st);
   }
       
   }
    
   public static ArtistCl selectArtist(String artistCode) {
       ConnectionPool pool = ConnectionPool.getInstance();
       Connection connection = pool.getConnection();
       PreparedStatement ps=null;
       ResultSet rs= null;
       String sql = "SELECT * FROM Artists WHERE ArtistCode= ?";
       
       try{
          ps=  connection.prepareStatement(sql);
          ps.setString(1, artistCode);
         rs= ps.executeQuery();
         if(rs.next()) {
       ArtistCl artist = new ArtistCl();
         artist.setArtistCode(rs.getString("ArtistCode"));
         artist.setArtistEmail(rs.getString("ArtistEmail"));
         artist.setArtistFirstName(rs.getString("ArtistFirstName"));
         artist.setArtistLastName(rs.getString("ArtistLastName"));
         Clob artistBio =rs.getClob("ArtistBio");
         int cloblength = (int)artistBio.length();
         String wholeClob = artistBio.getSubString(1, cloblength);
         artist.setBioFile(wholeClob);
          artist.setArtistID(rs.getInt("Artist_ID"));
          return artist;
         }
         else {return null;}
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
   
    
    public static ArtistCl selectArtist(int artist_ID) {
   
      ConnectionPool pool = ConnectionPool.getInstance();
      Connection connection= pool.getConnection();
      PreparedStatement ps=null;
      ResultSet rs=null;
     
      String wholeClob=null;
      String sql= "SELECT * FROM Artists WHERE Artist_ID= ? ";
     try{
      ps = connection.prepareStatement(sql);
      ps.setInt(1, artist_ID);
     rs=  ps.executeQuery();
     
     if(rs.next()){
         ArtistCl artist = new ArtistCl();
       Clob artistBio=  rs.getClob("ArtistBio");
       int clobLength= (int)artistBio.length();
       wholeClob = artistBio.getSubString(1, clobLength);
       
       artist.setBioFile(wholeClob);
     artist.setArtistEmail(rs.getString("ArtistEmail"));
     artist.setArtistFirstName(rs.getString("ArtistFirstName"));
     artist.setArtistLastName(rs.getString("ArtistLastName"));
     artist.setArtistCode(rs.getString("ArtistCode"));
     artist.setArtistID(rs.getInt("Artist_ID"));
     return artist;
          }
     else {
         return null;
     }
     
     }
     
     catch(SQLException e) {
         e.printStackTrace();
         return null;
         
         
     }
      finally{
          pool.freeConnection(connection);
          DBUtil.closeResultSet(rs);
          DBUtil.closePreparedStatement(ps);
      
     }
    
    }

}
