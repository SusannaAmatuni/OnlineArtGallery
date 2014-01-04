/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package shopper.catalog;


import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import shopper.business.*;
import shopper.data.*;


/**
 *
 * @author HP_Owner
 */
public class ArtTypeServlet extends HttpServlet {
   
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
            out.println("<title>Servlet ArtTypeServlet</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ArtTypeServlet at " + request.getContextPath () + "</h1>");
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
        ArrayList<ProductCl> products = new ArrayList<ProductCl>();
       String   arttype = request.getParameter("arttype");
       HttpSession session = request.getSession();
       session.setAttribute("arttype",arttype);
       
       int arttype_ID =0;        
         arttype_ID= ArtTypeDB.selectArtType(arttype);
           
           products= ProductDB.selectProducts(arttype_ID);
           
           session.setAttribute("arttype_ID", arttype_ID);
           session.setAttribute("products", products);
           session.setAttribute("arttype",arttype);
           String url = "/catalog/productswithtype.jsp";
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
      
        
           
           
          
        
    }

    /** 
    * Returns a short description of the servlet.
    */
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
