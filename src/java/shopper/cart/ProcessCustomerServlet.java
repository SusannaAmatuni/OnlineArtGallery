/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package shopper.cart;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import shopper.business.*;



/**
 *
 * @author HP_Owner
 */
public class ProcessCustomerServlet extends HttpServlet {
   
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
            out.println("<title>Servlet ProcessCustomerServlet</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ProcessCustomerServlet at " + request.getContextPath () + "</h1>");
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
        String firstname= request.getParameter("firstname");
        String lastname= request.getParameter("lastname");
        String emailaddress=request.getParameter("emailaddress");
        String companyname= request.getParameter("companyname");
        String address1= request.getParameter("address1");
        String address2= request.getParameter("address2");
        String city = request.getParameter("city");
        String state= request.getParameter("state");
        String zipcode=request.getParameter("zip");
        String country = request.getParameter("country");
                
        HttpSession session = request.getSession();
        CustomerCl customer=(CustomerCl)session.getAttribute("customer");
        session.setAttribute("state", state);
      /*  if(customer==null) 
            customer= new CustomerCl(); //added jan26/2010 */
        
        customer.setAddress1(address1);
        customer.setAddress2(address2);
        customer.setCity(city);
        customer.setCompanyName(companyname);
        customer.setCountry(country);
        customer.setEmailAddress(emailaddress);
        customer.setFirstName(firstname);
        customer.setLastName(lastname);
        customer.setState(state);
        customer.setZipCode(zipcode);
        
        session.setAttribute("customer",customer);
        String url="/displayinvoice";
        RequestDispatcher dispatcher= getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);
              
    }

    /** 
    * Returns a short description of the servlet.
    */
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
