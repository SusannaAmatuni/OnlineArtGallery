/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package shopper.business;

import java.io.Serializable;
import java.util.*;
import java.text.*;

/**
 *
 * @author HP_Owner
 */
public class InvoiceCl implements Serializable{
  private  CustomerCl customer;
  private  Date invoiceDate;
   private ArrayList<LineItemCl> invoiceItems;
   private int invoiceID;
    
    
    public InvoiceCl(){
        
    }
    
  public void setCustomer(CustomerCl customer) {
      this.customer= customer;
  }
  
  public CustomerCl getCustomer() {
      return this.customer;
      
  }
  
  public void setInvoiceDate(Date invoiceDate) {
      this.invoiceDate= invoiceDate;
  }
  
  public Date getInvoiceDate() {
      return this.invoiceDate;
  }
  
  
  public void setInvoiceItems(ArrayList<LineItemCl> items) {
      this.invoiceItems= items;
      
}
  
  public ArrayList<LineItemCl> getInvoiceItems() {
      return this.invoiceItems;
  }
  
  public void setInvoiceID(int number) {
      this.invoiceID= number;
  }
  
  public int getInvoiceID() {
      return this.invoiceID;
  }
  
  public String getInvoicedateFormat(Date invoiceDate) {
 DateFormat df= DateFormat.getDateInstance();
String dateformated= df.format(invoiceDate);
return dateformated;
  }
  
   public String getInvoicedateFormat() {
 DateFormat df= DateFormat.getDateInstance();
String dateformated= df.format(invoiceDate);
return dateformated;
  }
  
  
  public double getInvoiceTotal() {
      double invoiceTotal=0.0;
      for(LineItemCl item:invoiceItems) {
        invoiceTotal+=  item.getTotalPrice();
          
      }
      return invoiceTotal;
  }
  
  public String getInvoiceTotalFormat() {
      
   NumberFormat nf=   NumberFormat.getCurrencyInstance();
   String invoiceTotalFormat = nf.format(this.getInvoiceTotal());
   return invoiceTotalFormat;
  }
}

