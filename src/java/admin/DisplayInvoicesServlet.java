/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package admin;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import shopper.data.*;
import shopper.business.*;
import java.util.*;


/**
 *
 * @author HP_Owner
 */
public class DisplayInvoicesServlet extends HttpServlet {
   
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
            out.println("<title>Servlet DisplayInvoicesServlet</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet DisplayInvoicesServlet at " + request.getContextPath () + "</h1>");
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
        doPost(request,response);
    } 

    /** 
    * Handles the HTTP <code>POST</code> method.
    * @param request servlet request
    * @param response servlet response
    */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        HttpSession session = request.getSession();
        
        ArrayList<InvoiceCl> unprocessedinvoices= InvoiceDB.selectUnprocessedInvoices();
        if(unprocessedinvoices.size()<=0 || unprocessedinvoices==null) {
            response.sendRedirect("/OnlineShopper2/admin");
        }
        
        else {
            session.setAttribute("unprocessedinvoices",unprocessedinvoices);
            
            String sql= "/admin/invoices.jsp" ;
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(sql);
            dispatcher.forward(request, response);
        }
        
        
        
    }

    /** 
    * Returns a short description of the servlet.
    */
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
