/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package shopper.login;

import shopper.cart.*;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.*;
import javax.servlet.http.*;



import shopper.data.*;
import shopper.business.*;
import shopper.util.*;
/**
 *
 * @author HP_Owner
 */
public class CheckMemberServlet extends HttpServlet {
   
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
            out.println("<title>Servlet CheckMemberServlet</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet CheckMemberServlet at " + request.getContextPath () + "</h1>");
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
        String username= request.getParameter("username");
        String password = request.getParameter("password");
        UserPassCl userPass= null;
        CustomerCl customer = null;
        WishListCl wishlist=null;
        HttpSession session = request.getSession();
        session.invalidate();
        session=request.getSession();
        
        String url ="/login/thankslogin.jsp";        //"/quickorder";
       if( UserPassDB.userExists(username)) {
        
           userPass = UserPassDB.selectMember(username);
           request.setAttribute("userPass",userPass);
           if(password.equals(userPass.getPassword())) {
              customer=     CustomerDB.selectCustomerMember(username);
              session.setAttribute("customer",customer);
             String firstname = customer.getFirstName();
             Cookie firstnameCookie = new Cookie("firstnameCookie", firstname);
             Cookie usernameCookie = new Cookie("usernameCookie",userPass.getUserName());
             Cookie welcome= new Cookie("welcome","Welcome Back ");
             welcome.setMaxAge(60*60*24*365*2);
             welcome.setPath("/");
             response.addCookie(welcome);
             firstnameCookie.setMaxAge(60*60*24*365 *2);
             firstnameCookie.setPath("/");
             usernameCookie.setMaxAge(60*60*24*365*2);
             usernameCookie.setPath("/");
             response.addCookie(usernameCookie);
             response.addCookie(firstnameCookie);
             wishlist= WishListDB.select(customer.getCustomerID());
             session.setAttribute("wishlist",wishlist);
          }
           else 
           { url= "/login/signin.jsp";
             String loginmessage = "Please check user name or password ";
             session.setAttribute("loginmessage", loginmessage);
           }
       }
           else {url= "/login/signin.jsp";
                 
       String loginmessage = "Please check user name or password or go to register";
             session.setAttribute("loginmessage", loginmessage);
           }
     
               
           
         
           
           
        Cookie[] cookies = request.getCookies();
        String firstName=CookieUtil.getCookie(cookies,"firstnameCookie");
        String greetingmessage= "Welcome Back ";
        session.setAttribute("firstName", firstName);
        
        getServletContext().setAttribute("greetingmessage",greetingmessage);
        
           
           
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
        doGet(request,response);
    }

    /** 
    * Returns a short description of the servlet.
    */
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
