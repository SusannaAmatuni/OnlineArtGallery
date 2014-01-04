/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package shopper.history;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.*;
import javax.servlet.http.*;

import java.util.*;
import shopper.business.*;
import shopper.data.*;

/**
 *
 * @author HP_Owner
 */
public class ShoppingHistorySnapshotServlet extends HttpServlet {
   
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
            out.println("<title>Servlet ShoppingHistorySnapshotServlet</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ShoppingHistorySnapshotServlet at " + request.getContextPath () + "</h1>");
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
        
        String username;
        CustomerCl customer= new CustomerCl();
        ArrayList<InvoiceCl> invoices = new ArrayList<InvoiceCl>();
        ArrayList<LineItemCl> alllineitems= new ArrayList<LineItemCl>();
       Cookie[] cookies = request.getCookies();
       int customerID=0;
             
        
       GregorianCalendar currentdate = new GregorianCalendar();
       
       int currentYear = currentdate.get(Calendar.YEAR);
       int currentMonth= currentdate.get(Calendar.MONTH);
       int currentDay = currentdate.get(Calendar.DAY_OF_MONTH);
       
       request.setAttribute("currentYear",currentYear);
       request.setAttribute("currentMonth", currentMonth);
       request.setAttribute("currentDay", currentDay);
       
         
       for(int i=0 ; i<cookies.length;i++) {
           Cookie cookie = cookies[i];
           if(cookie.getName().equals("usernameCookie")) {
                username= cookie.getValue(); 
                customer = CustomerDB.selectCustomerMember(username);
                 customerID = customer.getCustomerID();
                 invoices = InvoiceDB.select(customerID);
                 request.setAttribute("invoices", invoices);
                 session.setAttribute("customer",customer); }
       }
                for(InvoiceCl invoice:invoices) {
                    
                  int invoiceID=  invoice.getInvoiceID();
                
               ArrayList<LineItemCl> lineItems= LineItemDB.selectlineitems(invoiceID);
                 
                 alllineitems.addAll(lineItems);
       }
       request.setAttribute("alllineitems",alllineitems);    
       
           String url = "/history/shoppinghistoryall.jsp";
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
        processRequest(request, response);
    }

    /** 
    * Returns a short description of the servlet.
    */
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
