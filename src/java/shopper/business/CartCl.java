/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package shopper.business;

import java.util.*;
import java.io.*;

/**
 *
 * @author HP_Owner
 */
public class CartCl implements Serializable{
    private ArrayList<LineItemCl> items;

    
 public   CartCl() {
        items= new ArrayList<LineItemCl>();
    }
    
      
    public ArrayList<LineItemCl> getItems() {
        return this.items;
    }
    
    public void setItems(ArrayList<LineItemCl> items) {
        this.items= items;
      }
    
    public void addItem(LineItemCl item) {
        
        String code = item.getProduct().getProductCode();
        int quantity= item.getQuantity();
        Iterator it = getItems().iterator();
        while(it.hasNext()) {
            LineItemCl lineitem = (LineItemCl)it.next();
            if(lineitem.getProduct().getProductCode().equals(code)) {
              lineitem.setQuantity(quantity);
              return;
            
            }
        }
        
        items.add(item); 
        
    } 
    
    
    
  /*   public void addItem(LineItemCl item)
    {
        //If the item already exists in the cart, only the quantity is changed.
        String code = item.getProduct().getProductCode();
        int quantity = item.getQuantity();
        for (int i = 0; i<items.size(); i++)
        {
            LineItemCl lineItem = items.get(i);
            if (lineItem.getProduct().getProductCode().equals(code))
            {
                lineItem.setQuantity(quantity);
                return;
            }
        }
        items.add(item);
    }
    */
    
    public void removeItem(LineItemCl item) {
     
        String code = item.getProduct().getProductCode();
        int quantity= item.getQuantity();
        LineItemCl lineitem;
        Iterator it= getItems().iterator();
        while(it.hasNext()) {
           lineitem= (LineItemCl)it.next();
           if(lineitem.getProduct().getProductCode().equals(code)) {
               it.remove();
               return;
           }
        }
        
        
    }
    
    
    
}
