/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package shopper.business;
import java.text.*;
import java.io.Serializable;
/**
 *
 * @author HP_Owner
 */
public class LineItemCl implements Serializable {
    
    private ProductCl product;
    private int quantity;
    private int lineItemID;
    
    public void setLineItemID(int lineItemID) {
        this.lineItemID= lineItemID;
    }
    
    
    public int getLineItemID() {
        return this.lineItemID;
    }
    
     public ProductCl getProduct() {
         return this.product;
         
     } 
     
     public int getQuantity() {
         return this.quantity;
  }
     
     public void setProduct(ProductCl product) {
         this.product= product;
     }
     
     public void setQuantity(int quantity) {
         this.quantity= quantity;
     }
     
     public double getTotalPrice() {
        
        double total= product.getProductPrice()*quantity;
        return total;
       }
     
     public String getTotalCurrencyFormat() {
      
         NumberFormat nf = NumberFormat.getCurrencyInstance();
       String curencyTotal=  nf.format(this.getTotalPrice());
       return curencyTotal;
     }
}