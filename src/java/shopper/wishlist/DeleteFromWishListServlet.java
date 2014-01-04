/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package shopper.wishlist;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.RequestDispatcher;
 import shopper.data.*;
 import shopper.business.*;
 import shopper.util.CookieUtil;
 import java.util.ArrayList;
 
/**
 *
 * @author HP_Owner
 */
public class DeleteFromWishListServlet extends HttpServlet {
   
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
            out.println("<title>Servlet DeleteFromWishListServlet</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet DeleteFromWishListServlet at " + request.getContextPath () + "</h1>");
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
        String productCode = request.getParameter("productCode");
        ProductCl selectedproduct = ProductDB.selectProduct(productCode);
        CustomerCl customer =(CustomerCl) session.getAttribute("customer");
           
            WishListCl wishlist = WishListDB.select(customer.getCustomerID());
            int wishlistID= wishlist.getWishListID();
            SelectedItemCl selecteditem = new SelectedItemCl();
            selecteditem.setWishListID(wishlist.getWishListID());
            selecteditem.setProduct(selectedproduct);
            SelectedItemDB.delete(selecteditem, wishlistID);
            ArrayList<SelectedItemCl> wishlistitems=   SelectedItemDB.selectAll(wishlistID);
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
        doGet(request,response);
    }

    /** 
    * Returns a short description of the servlet.
    */
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
