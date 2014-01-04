/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package shopper.catalog;

import java.io.*;

import javax.servlet.*;
import javax.servlet.http.*;

import shopper.business.*;
import shopper.data.*;
import shopper.util.*;


/**
 *
 * @author HP_Owner
 */
public class CheckCustomerforQorder extends HttpServlet {
   
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
            out.println("<title>Servlet CheckCustomerforQorder</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet CheckCustomerforQorder at " + request.getContextPath () + "</h1>");
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
     HttpSession session = request.getSession();
     String productcode= "";
     productcode=request.getParameter("productCode");
     CartCl cart= (CartCl)session.getAttribute("cart");
     CustomerCl customer = (CustomerCl) session.getAttribute("customer");
     String url="";
     //If customer object doesn't exist
     session.setAttribute("productcode", productcode);
     Cookie[] cookies = request.getCookies();
         String username = CookieUtil.getCookie(cookies,"usernameCookie");
                
         
     if(customer == null) 
     {
         
         //If username cookie doesn't exist go to register page
         session.setAttribute("username", username);
         if(username==null || username.equals("")) 
         {
             
             url="/history/noshophistory.jsp";
         }
         
         //If emailcookie does exist ,create the new Customer object
         //from email cookie and skip registration
         
         else {
             customer = CustomerDB.selectCustomerMember(username);
              
                 
             session.setAttribute("customer",customer);
             
             
             url = "/addtocart";
         }
         
         }
     
    
     
     
     //If customer object exist skip the registration page
  else  
         
         url="/addtocart";
     
     
       
     
     RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
     dispatcher.forward(request, response);
        
    
    }

    /** 
    * Handles the HTTP <code>POST</code> method.
    * @param request servlet request
    * @param response servlet response
    */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        doGet(request,response);
    }

    /** 
    * Returns a short description of the servlet.
    */
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
