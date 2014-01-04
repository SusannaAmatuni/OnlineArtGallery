/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package handlers;

import shopper.business.ProductCl;
import java.text.*;
import javax.servlet.jsp.JspException;
import java.io.IOException;
import javax.servlet.jsp.tagext.SimpleTagSupport;
/**
 *
 * @author HP_Owner
 */
public class PriceHandler extends SimpleTagSupport {
    
    private ProductCl product;
    
    public void doTag() throws JspException,  IOException {
        
      double price=  product.getProductPrice();
      getJspContext().setAttribute("price", price);
      NumberFormat currency= NumberFormat.getCurrencyInstance();
      String pricecurrency=currency.format(price);
      getJspContext().setAttribute("pricecurrency", pricecurrency);
      getJspBody().invoke(null);
    }
    
    public void setProduct(ProductCl product) {
        this.product=product;
    }

    public ProductCl getProduct() {
        return this.product;
    }
}
