/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package shopper.cart;

import java.io.*;

import javax.servlet.*;
import javax.servlet.http.*;

import shopper.business.*;
import java.util.ArrayList;


/**
 *
 * @author HP_Owner
 */
public class DisplayInvoiceServlet extends HttpServlet {
   
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
            out.println("<title>Servlet DisplayInvoiceServlet</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet DisplayInvoiceServlet at " + request.getContextPath () + "</h1>");
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
        CartCl cart =(CartCl)session.getAttribute("cart");
        CustomerCl customer =(CustomerCl)session.getAttribute("customer");
        
        java.util.Date today = new java.util.Date();
        
        InvoiceCl invoice = new InvoiceCl();
        invoice.setCustomer(customer);
        invoice.setInvoiceDate(today);
        
     ArrayList<LineItemCl> invoiceitems =   cart.getItems();
     
        invoice.setInvoiceItems(invoiceitems);
        session.setAttribute("invoice",invoice);
        String url = "/cart/invoice.jsp";
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
