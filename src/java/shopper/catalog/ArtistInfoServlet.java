/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package shopper.catalog;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import shopper.business.*;
import shopper.data.*;
import java.util.ArrayList;

/**
 *
 * @author HP_Owner
 */
public class ArtistInfoServlet extends HttpServlet {
   
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
            out.println("<title>Servlet ArtistInfoServlet</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ArtistInfoServlet at " + request.getContextPath () + "</h1>");
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
        String artistCode = request.getParameter("artistCode");
        String StringArtistID = request.getParameter("artistID");
       // int artistID = Integer.parseInt(StringArtistID);
        HttpSession session = request.getSession();
        ArtistCl artist = ArtistDB.selectArtist(artistCode);
        int artistID= artist.getArtistID();
        session.setAttribute("artist", artist);
        session.setAttribute("artistID",artistID);
        ArrayList<ProductCl> artistproducts= ProductDB.selectProductsForArtist(artistID);
        session.setAttribute("artistproducts", artistproducts);
        String url = "/catalog/artist.jsp";
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
