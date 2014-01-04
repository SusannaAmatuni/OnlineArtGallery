
package shopper.wishlist;

import shopper.data.*;
import shopper.business.*;

import java.io.*;
import java.util.*;

import javax.servlet.*;
import javax.servlet.http.*;
import shopper.util.*;

/**
 *
 * @author HP_Owner
 */
public class AddToWishListServlet extends HttpServlet {
   
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
            out.println("<title>Servlet AddToWishListServlet</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AddToWishListServlet at " + request.getContextPath () + "</h1>");
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
           String productCode= (String)session.getAttribute("productCode");
           WishListCl wishList = (WishListCl)session.getAttribute("wishList");
           CustomerCl customer=(CustomerCl) session.getAttribute("customer");
          
           String url="/selecteditems";
          //at this point we have customer session & can define wishlist by customerID 
         if(wishList== null)
         {
            wishList=WishListDB.select(customer.getCustomerID());
            session.setAttribute("wishList", wishList);                     
          }
           
         else
           session.setAttribute("wishList",wishList); 
          // when we selected product for wish list             
         if(productCode!= null)
         {
            ProductCl selectedproduct= ProductDB.selectProduct(productCode);
            ArrayList<SelectedItemCl> selecteditems=   SelectedItemDB.selectAll(wishList.getWishListID());
         
            //if we allready have selected productin DB delete it.         
            for(SelectedItemCl item : selecteditems)
              {                                      
                if(item.getProduct().getProductID() != selectedproduct.getProductID()) 
                  ;
                 else 
                 {
                   SelectedItemDB.delete(item,wishList.getWishListID());
                   session.setAttribute("sameselection","Please note, you have selected this item before");
                    break;
                  }
              } 
             session.setAttribute("selectedproduct",selectedproduct);
                      
              SelectedItemCl selection = new SelectedItemCl();
              selection.setProduct(selectedproduct);
              selection.setWishListID(wishList.getWishListID());
                           
              SelectedItemDB.insert(selection,wishList.getWishListID());
                     
              session.setAttribute("selection", selection);
         }
                    
         url ="/selecteditems";
                 
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
