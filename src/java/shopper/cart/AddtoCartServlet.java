/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package shopper.cart;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;

import shopper.business.*;
import shopper.data.*;



/**
 *
 * @author HP_Owner
 */
public class AddtoCartServlet extends HttpServlet {
   
    /** 
    * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
    * @param request servlet request
    * @param response servlet response
    */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            /* TODO output your page here
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet AddtoCartServlet</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AddtoCartServlet at " + request.getContextPath () + "</h1>");
            out.println("</body>");
            out.println("</html>");
            */
        } finally { 
            out.close();
        }
    } 

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
    * Handles the HTTP <code>GET</code> method.
    * @param request servlet request
    * @param response servlet response
    */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        doPost(request,response);
    } 

    /** 
    * Handles the HTTP <code>POST</code> method.
    * @param request servlet request
    * @param response servlet response
    */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        String productCode= request.getParameter("productCode");
        String quantitybutton=request.getParameter("quantitybutton");
        String  quantityString = request.getParameter("quantity");
        String removebutton= request.getParameter("removebutton");
        
        String url ="";
        
        HttpSession session =request.getSession();
        session.setAttribute("removebutton", removebutton);
        
        CartCl cart = (CartCl)session.getAttribute("cart");
        if(cart==null) {
            cart = new CartCl();
            session.setAttribute("cart", cart);
            
         }
        
        //If customer enters negative or invalid number
        //In the Update text box
        int quantity=1;
        try {
             quantity= Integer.parseInt(quantityString);
            if(quantity<0) 
                quantity=1;
                
            }
        catch(NumberFormatException e) {
            quantity=1;
        }
        
        if(removebutton != null) {
            quantity=0;
        }
        
        if(quantitybutton != null) {
            quantity= Integer.parseInt(quantityString);
        }
        
        //Get Product from product code
        
        ProductCl product= ProductDB.selectProduct(productCode);
        session.setAttribute("product",product);
              
        
        if(product != null ){
            LineItemCl lineitem = new LineItemCl();
            lineitem.setProduct(product);
              lineitem.setQuantity(quantity);     
             ArrayList<LineItemCl> cartitems = cart.getItems();
             Iterator<LineItemCl> it= cartitems.iterator();
              int newquantity = 0;
             if(cartitems != null && removebutton == null && quantitybutton== null) {
              
              while(it.hasNext()) {
                  LineItemCl cartitem= it.next();
                if(productCode.equals(cartitem.getProduct().getProductCode())) {
                     newquantity= cartitem.getQuantity();
                     newquantity++;
                     lineitem.setQuantity(newquantity);
                     }
                                 
                 }
              
                }
                          
                 
            if(quantity> 0  )
             cart.addItem(lineitem);
            
             else
                 
                cart.removeItem(lineitem);
        
        
       }
        
                    
        session.setAttribute("cart", cart);
        
        //If no item exists forward to quickorder 
        //Otherwise to cart page
        
       
        if(cart.getItems().size() <= 0) 
        {
            url= "/quickorder"; }
        else {
              
            url="/cart/cart.jsp";
        }
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);
         
    }
    

    /** 
    * Returns a short description of the servlet.
    */
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
