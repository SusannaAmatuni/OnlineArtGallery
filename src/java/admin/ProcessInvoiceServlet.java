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


/**
 *
 * @author HP_Owner
 */
public class ProcessInvoiceServlet extends HttpServlet {
   
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
            out.println("<title>Servlet ProcessInvoiceServlet</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ProcessInvoiceServlet at " + request.getContextPath () + "</h1>");
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
        HttpSession session= request.getSession();
        InvoiceCl invoice= (InvoiceCl)session.getAttribute("invoice");
        
        //this does't do what i intent to do.
        //I was trying to print the invoice page
        //but this understandebly prints on the screen the invoice.jsp.
        //Code works fine that' why i didn't delete it
      /*   ServletContext sc=getServletContext();
         InputStream is = sc.getResourceAsStream("/admin/invoice.jsp");
         int read= 0;
         byte[] bytes= new byte[1024];
         OutputStream os= response.getOutputStream();
         while((read=is.read(bytes)) != -1) {
             os.write(bytes, 0, read);
         }
         os.flush();
         os.close();
         
        */
        
        int invoiceNumber= invoice.getInvoiceID();
        InvoiceDB.processinvoice(invoiceNumber);
        String url = "/admin/invoices.jsp";
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
