/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package shopper.business;

import java.util.*;
import shopper.business.*;

/**
 *
 * @author HP_Owner
 */
public class WishListCl {
    private CustomerCl customer;
    private ArrayList<SelectedItemCl> selectedItems ; 
    private int wishListID;
    
   
  
    public void setWishListID(int wishListID) {
        this.wishListID= wishListID;
    }
    
    public int getWishListID() {
        return wishListID;
    }
    
    
    public void setCustomer(CustomerCl customer) {
        
        this.customer= customer;
    }
    
    public CustomerCl getCustomerID() {
        return customer;
    }
    
    public ArrayList<SelectedItemCl > getSelectedItems() {
        
        return this.selectedItems;
    }
    
    public void setSelectedItems(ArrayList<SelectedItemCl> selectedItems ) {
        this.selectedItems= selectedItems; 
        
    }
    
    public void addItem(SelectedItemCl item) {
        Iterator it= getSelectedItems().iterator();
        while(it.hasNext()) {
            SelectedItemCl selection=(SelectedItemCl)it.next();
            if(selection.getProduct().getProductCode().equals(item.getProduct().getProductCode()))
                continue;
            else
             getSelectedItems().add(selection);   
        }
        
    }

}


