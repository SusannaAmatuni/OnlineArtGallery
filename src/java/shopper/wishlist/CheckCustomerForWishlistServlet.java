/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package shopper.wishlist;

import shopper.business.*;
import shopper.util.*;
import shopper.data.*;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.*;
import javax.servlet.http.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author HP_Owner
 */
public class CheckCustomerForWishlistServlet extends HttpServlet {
   
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
            out.println("<title>Servlet CheckCustomerForWishlistServlet</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet CheckCustomerForWishlistServlet at " + request.getContextPath () + "</h1>");
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
           HttpSession session =request.getSession();
           String productCode = request.getParameter("productCode");
         //  WishListCl wishList = (WishListCl)session.getAttribute("wishList");
           CustomerCl customer=(CustomerCl)session.getAttribute("customer");
           WishListCl wishlist = (WishListCl)session.getAttribute("wishlist");
           session.setAttribute("productCode",productCode);
           Cookie[] cookies= request.getCookies();
           String username= CookieUtil.getCookie(cookies, "usernameCookie");
           
           String url="/addtowishlist";
                       
                
            if(customer == null ) {
                              
            //if username cookiedoesn't exist go to register
              session.setAttribute("username", username);
                
                if(username== null ||username.equals("")) 
              
                    url="/history/noshophistory.jsp";
                    
            
            
            //the customer had been registered
                  else {
                    customer= new CustomerCl();
                    customer = CustomerDB.selectCustomerMember(username);
                    
                    wishlist = WishListDB.select(customer.getCustomerID());
                    session.setAttribute("wishlist", wishlist);
                    session.setAttribute("customer", customer);
                    url = "/addtowishlist";                       //"/addtowishlist";
                }
            }
            else
            url = "/addtowishlist";  
                
                 
           
           RequestDispatcher dispatcher = request.getRequestDispatcher(url);
           dispatcher.forward(request, response);
           
    } 
           
           
           
               
                    
                
    
    /** 
    * Handles the HTTP <code>POST</code> method.
    * @param request servlet request
    * @param response servlet response
    */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    }

    /** 
    * Returns a short description of the servlet.
    */
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
