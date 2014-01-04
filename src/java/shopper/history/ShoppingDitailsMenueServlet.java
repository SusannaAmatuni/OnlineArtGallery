/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package shopper.history;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.ArrayList;
import shopper.business.*;
import shopper.data.*;


/**
 *
 * @author HP_Owner
 */
public class ShoppingDitailsMenueServlet extends HttpServlet {
   
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
            out.println("<title>Servlet ShoppingDitailsMenueServlet</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ShoppingDitailsMenueServlet at " + request.getContextPath () + "</h1>");
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
        
        
        

         
        String invoiceIDString = request.getParameter("invoiceID");
        int invoiceID = Integer.parseInt(invoiceIDString);
        request.setAttribute("invoiceID",invoiceID);
        
         ArrayList<LineItemCl> lineItems= LineItemDB.selectlineitems(invoiceID);
           
           InvoiceCl invoice = InvoiceDB.selectInvoice(invoiceID);
           invoice.setInvoiceItems(lineItems);
           
            request.setAttribute("lineItems", lineItems);
            request.setAttribute("invoice",invoice);
              String     url = "/history/shoppingditailsmenue.jsp";
         
             RequestDispatcher  dispatcher = request.getRequestDispatcher(url);
         
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
