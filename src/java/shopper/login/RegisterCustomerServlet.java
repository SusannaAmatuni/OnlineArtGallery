/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package shopper.login;


import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.*;
import javax.servlet.http.*;

import shopper.data.*;
import shopper.business.*;

/**
 *
 * @author HP_Owner
 */
public class RegisterCustomerServlet extends HttpServlet {
   
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
            out.println("<title>Servlet RegisterCustomerForHeaderServlet</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet RegisterCustomerForHeaderServlet at " + request.getContextPath () + "</h1>");
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
         String url;
         HttpSession session= request.getSession();
         String cansel = request.getParameter("cansel");
         if (cansel != null ) {
              url="/";
         }
         else {
         
        session.invalidate();
        session=request.getSession();
        
        String username= request.getParameter("username");
        String firstname= request.getParameter("firstname");
       String lastname = request.getParameter("lastname");
        String emailaddress= request.getParameter("emailaddress");
        String password = request.getParameter("password");
        
        UserPassCl userpass= new UserPassCl();
        userpass.setUserName(username);
        userpass.setPassword(password);
        
      
        UserRoleCl userRole= new UserRoleCl();
        userRole.setUserName(username);
        userRole.setUserRole("member");
        
       
        
        CustomerCl customer= new CustomerCl();
        customer.setUserName(username);
        customer.setFirstName(firstname);
        customer.setLastName(lastname);
        customer.setEmailAddress(emailaddress);
       // session.setAttribute("customer",customer);
       
        
        String message=" ";
         url=" ";
        
        
       
         if(UserPassDB.userExists(username)) {
             
              message = "<font color='red' size='+1'>"+"This User Name Exists."+"<tr></tr><tr></tr><tr></tr><tr></tr><tr><td colspan=2>" 
                   +"Please enter another one:</font>"
                   +"</td></tr>";
                 request.setAttribute("message", message); 
                 
                 url="/login/register_page.jsp";
             
         }
         
      
            
        else {
             
               CustomerDB.insert(customer);
               customer= CustomerDB.selectCustomerMember(username);
               session.setAttribute("customer",customer);
               String registermessage= "Thank you for registering, ";
               request.setAttribute("registermessage",registermessage);
                UserPassDB.addMember(userpass);
                
                UserRoleDB.insertRole(userRole);
                
                WishListDB.addMember(customer);
               // customer=  CustomerDB.selectCustomerMember(username);
                //WishListDB.addMember(customer);
                url="/login/thanksregister.jsp";
               // url="/login/thanksforregistering.jsp";
            
      //  request.setAttribute("num",num);
           
           
         
         session.setAttribute("userpass",userpass);
        Cookie usernameCookie = new Cookie("usernameCookie", username);
        usernameCookie.setMaxAge(60*60*24*365*2);   //set age 2 year
        usernameCookie.setPath("/"); /*allow access to entire application */
        Cookie firstnameCookie = new Cookie("firstnameCookie", firstname);
        firstnameCookie.setMaxAge(60*60*24*365 *2);
        
        firstnameCookie.setPath("/");
        
        
        Cookie welcome= new Cookie("welcome","Welcome Back ");
        welcome.setMaxAge(60*60*24*365*2);
        welcome.setPath("/");
        response.addCookie(welcome);
        response.addCookie(usernameCookie);
        response.addCookie(firstnameCookie);
        }
         }
              
        
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
