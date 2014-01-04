/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package shopper.login;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.*;
import javax.servlet.http.*;
import shopper.util.*;


/**
 *
 * @author HP_Owner
 */
public class NewCartServlet extends HttpServlet {
   
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
            out.println("<title>Servlet NewCartServlet</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet NewCartServlet at " + request.getContextPath () + "</h1>");
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
       HttpSession session= request.getSession();
       
       
            Cookie[] cookies = request.getCookies();
        for (int i=0; i<cookies.length; i++)
        {
            Cookie cookie = cookies[i];
            cookie.setMaxAge(0); //delete the cookie
            cookie.setPath("/"); //allow the entire application to access it
            response.addCookie(cookie);
        }
         
         session.invalidate();
         
        
        
       
       
       String url = "/login/signout.jsp";
         
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
