/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package admin;

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
public class DisplayOneInvoiceServlet extends HttpServlet {
   
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
            out.println("<title>Servlet DisplayOneInvoiceServlet</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet DisplayOneInvoiceServlet at " + request.getContextPath () + "</h1>");
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
        
        String invoiceNumberString= request.getParameter("invoiceNumber");
        int invoiceNumber= Integer.parseInt(invoiceNumberString);
        
        ArrayList<InvoiceCl> invoices = InvoiceDB.selectUnprocessedInvoices();
        InvoiceCl invoice= null;
        Iterator it = invoices.iterator();
        while(it.hasNext()) {
            invoice= (InvoiceCl)it.next();
           if(invoice.getInvoiceID()==invoiceNumber) 
               break;
           
        }
       session.setAttribute("customer", invoice.getCustomer()); 
        session.setAttribute("invoice", invoice);
        Date invoicedate=invoice.getInvoiceDate();
       String invoicedateformat=  invoice.getInvoicedateFormat(invoicedate);
       session.setAttribute("invoicedateformat",invoicedateformat);
        
        
        
        String url = "/admin/invoice.jsp";
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
