/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package shopper.cart;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import javax.mail.MessagingException;
import shopper.business.*;
import shopper.data.*;
import java.util.*;
import shopper.util.*;

/**
 *
 * @author HP_Owner
 */
public class ProcessOrderServlet extends HttpServlet {
   
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
            out.println("<title>Servlet ProcessOrderServlet</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ProcessOrderServlet at " + request.getContextPath () + "</h1>");
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
        HttpSession session = request.getSession();
        CustomerCl customer= (CustomerCl)session.getAttribute("customer");
        InvoiceCl invoice =(InvoiceCl)session.getAttribute("invoice");
        String creditcardtype = request.getParameter("creditcardtype");
        String creditcardnumber= request.getParameter("creditcardnumber");
        String expirationyear= request.getParameter("expirationyear");
        String expirationmonth = request.getParameter("expirationmonth");
        
        customer.setCreditCardNumber(creditcardnumber);
        customer.setCreditCardExpirationDate(expirationmonth+"/" +expirationyear);
        customer.setCreditCardType(creditcardtype);
    
          if(CustomerDB.memberExist(customer.getUserName())) {
              CustomerDB.update(customer);
              
          }
        //  if(CustomerDB.emailExist(customer.getEmailAddress())) {
        //    CustomerDB.update(customer); 
           
       // }
        else {
            CustomerDB.insert(customer);
        }
        
        //Write a new invoice record
        InvoiceDB.insert(invoice);
        
    ArrayList<LineItemCl> invoiceitems=    invoice.getInvoiceItems();
        
       //Set the username cookie in the customers browser
        
        Cookie usernameCookie= new Cookie("usernameCookie", customer.getUserName());
        usernameCookie.setMaxAge(60*24*365*2*60);
        usernameCookie.setPath("/");
        response.addCookie(usernameCookie);
        Cookie firstnameCookie = new Cookie("firstnameCookie", customer.getFirstName());
        firstnameCookie.setMaxAge(60*60*24*365*2);
        firstnameCookie.setPath("/");
        response.addCookie(firstnameCookie);
        
        
        
        //Remove all items from the users cart
        
        CartCl cart = (CartCl)session.getAttribute("cart");
        cart.setItems(new ArrayList<LineItemCl>());
        
        //Send the email to the customer to confirm the order
        
        String to = customer.getEmailAddress(); 
        
        String from = "amatuni@att.net";
        String subject= "Order Confirmation";
        String body = "Dear" +customer.getFirstName() +",\n\n"+
                      "Thank you from ordering from us."+
                      "You should receive your order in 3-5 business days."+
                      "Please contact if you have any questions.\n"+
                      "Thank you,\nCustomer service.";
        
        boolean isBodyHTML = false;
        try{
            MailUtil.sendMail(to,from,subject,body,isBodyHTML);
        }
        catch(MessagingException e) {
            e.printStackTrace();
        }
        session.setMaxInactiveInterval(0);
        String url="/cart/complete.jsp";
        
        
        RequestDispatcher dispatcher =getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);
                
    }

    /** 
    * Returns a short description of the servlet.
    */
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
