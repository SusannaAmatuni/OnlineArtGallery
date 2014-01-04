/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package shopper.util;

import javax.servlet.*;
import java.util.*;

/**
 * Web application lifecycle listener.
 * @author HP_Owner
 */

public class ShopperContextListener implements ServletContextListener {

    public void contextInitialized(ServletContextEvent event) {
        ServletContext sc = event.getServletContext();
 String castServEmail=  sc.getInitParameter("CastServEmail");
 
 sc.setAttribute("CastServEmail",castServEmail);
 
 String greetingmessage= sc.getInitParameter("greetingmessage");
 sc.setAttribute("greetingmessage",greetingmessage);
 
  GregorianCalendar currentDate= new GregorianCalendar();
 int currentYear= currentDate.get(Calendar.YEAR);
 sc.setAttribute("currentYear", currentYear);
 
 ArrayList<String> creditcardyears  = new ArrayList<String>();
 
 for(int i= 1; i<=8 ; i++) {
   
     currentYear+=i;
  String currentYearString=   Integer.toString(currentYear);
     creditcardyears.add(currentYearString);
     
 }
 
 sc.setAttribute("creditcardyears",creditcardyears);
    
 
  
   


    }

    public void contextDestroyed(ServletContextEvent arg0) {
       // throw new UnsupportedOperationException("Not supported yet.");
    }
}