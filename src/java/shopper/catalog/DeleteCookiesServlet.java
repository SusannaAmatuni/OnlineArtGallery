/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package shopper.catalog;

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
public class DeleteCookiesServlet extends HttpServlet {
   
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
            out.println("<title>Servlet DeleteCookiesServlet</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet DeleteCookiesServlet at " + request.getContextPath () + "</h1>");
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
       
         Cookie[] cookies = request.getCookies();
        for (int i=0; i<cookies.length; i++)
        {
            Cookie cookie = cookies[i];
            cookie.setMaxAge(0); //delete the cookie
            cookie.setPath("/"); //allow the entire application to access it
            response.addCookie(cookie);
        }
        // HttpSession session = request.getSession();
         //session.invalidate();
         
        
         
        String url = "/delete_cookies.jsp";
         
        RequestDispatcher dispatcher =
            getServletContext().getRequestDispatcher(url);
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
