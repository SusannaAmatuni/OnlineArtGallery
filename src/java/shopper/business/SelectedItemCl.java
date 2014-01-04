/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package shopper.business;
import java.io.*;

/**
 *
 * @author HP_Owner
 */
public class SelectedItemCl implements Serializable {
    
    private int selectedItemID;
    private ProductCl product;
    private int wishListID;
    
    

  
  
    
    public void setSelectedItemID(int selectedItemID) {
        this.selectedItemID= selectedItemID;
        
    }
    
    public int getSelectedItemID() {
        return selectedItemID;
    }
    
    public void setProduct(ProductCl product) {
        this.product= product;
    }
    
    public ProductCl getProduct() {
        return this.product;
    }
    
    public void setWishListID(int wishListID) {
        this.wishListID= wishListID;
    }
    
    public int getWishListID() {
        return wishListID;
    }

}
