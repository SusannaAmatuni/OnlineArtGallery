/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package shopper.business;
import java.text.*;
import java.io.*;
/**
 *
 * @author HP_Owner
 */
public class ProductCl implements Serializable {
    private int productID;
    private String productCode;
    private String productName;
    private String productDescription;
    private double productPrice;
    private int artistID;
    private int artTypeID;
    private int artDescriptionID;
    private String imageURL;
    
  
    
    public int getProductID(){
        return productID;
    }
    
    public void setProductID(int productID) {
    this.productID= productID;
} 

    
    public void setProductCode(String productCode) {
        
        this.productCode= productCode;
        
    }
    
public void setProductName(String productName) {
    
    this.productName= productName;
    
}

public void setProductDescription(String productDescription) {
    
    this.productDescription = productDescription;
    
}

public void setProductPrice(double productPrice) {
    
    this.productPrice= productPrice;
}
public void setArtistID(int artistID){
    this.artistID=artistID;
}

public void setArtTypeID(int artTypeID) {
    this.artTypeID= artTypeID;
}

public void  setArtDescriptionID(int artDescriptionID) {
    this.artDescriptionID= artDescriptionID;
}



public String getProductCode() {
    return  productCode;
    
}

public int getArtistID() {
    return artistID;
}

public String getProductName() {
    
    return productName;
    
}

public String getProductDescription() {
    return productDescription;
}


public  int getArtDescriptionID() {
    return artDescriptionID;
}


public  double getProductPrice() {
    return productPrice;
}




 

public String getImageURL() {
        imageURL ="/OnlineShopper2/images/" +productCode+".JPG";
      return imageURL; 
    }

public String getPriceCurrencyFormat() {
    NumberFormat currency = NumberFormat.getCurrencyInstance();
    return currency.format(this.productPrice);
}
}
