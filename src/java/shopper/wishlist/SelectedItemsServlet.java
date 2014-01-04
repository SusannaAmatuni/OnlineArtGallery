/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package shopper.wishlist;
import shopper.data.*;
import shopper.business.*;

import java.util.ArrayList;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author HP_Owner
 */
public class SelectedItemsServlet extends HttpServlet {
   
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
            out.println("<title>Servlet SelectedItemsServlet</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet SelectedItemsServlet at " + request.getContextPath () + "</h1>");
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
     WishListCl wishList=(WishListCl)  session.getAttribute("wishList");
     ArrayList<SelectedItemCl> wishlistitems1= SelectedItemDB.selectAll(wishList.getWishListID());
      ArrayList<SelectedItemCl> wishlistitems= new ArrayList<SelectedItemCl>();
     int num= wishlistitems1.size();
     int ind= num-1;
      for(int i=ind; ind >= 0; ind--) {
        SelectedItemCl item=   wishlistitems1.get(ind);
        wishlistitems.add(item);
       }
         
       
     session.setAttribute("wishlistitems", wishlistitems);
     String url = "/wishlist/wishlistitems.jsp";
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
