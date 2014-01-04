/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package shopper.cart;

import java.io.*;

import javax.servlet.*;
import javax.servlet.http.*;

import shopper.business.*;
import shopper.util.*;
import shopper.data.*;
/**
 *
 * @author HP_Owner
 */
public class CheckCustomerServlet extends HttpServlet {
   
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
            out.println("<title>Servlet CheckCustomerServlet</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet CheckCustomerServlet at " + request.getContextPath () + "</h1>");
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
        String url = "/cart/customer.jsp";
        CustomerCl customer = (CustomerCl)session.getAttribute("customer");
        //If customer with Address1 exist go to processing invoice
          
        if(customer != null && !customer.getAddress1().equals("") ) {
            url= "/displayinvoice";
        }
        //othervise check email cookie
        
        else {
               Cookie[] cookies = request.getCookies();
             String username= CookieUtil.getCookie(cookies, "usernameCookie");
             
             if(username.equals("")) {
                customer = new CustomerCl();
             }
              else {
              customer= CustomerDB.selectCustomerMember(username);
              if(customer != null && !customer.getAddress1().equals("")  ) 
                url="/displayinvoice";
                
            }
         }
        
       session.setAttribute("customer", customer);
       
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
