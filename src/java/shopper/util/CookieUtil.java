/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package shopper.util;

import javax.servlet.http.*;

/**
 *
 * @author HP_Owner
 */
public class CookieUtil {
    
    public static String getCookie(Cookie[] cookies,String cookiename) {
       String cookieValue = "";
        Cookie cookie;
        if (cookies != null)
        {
            for (int i = 0; i < cookies.length; i++)
            {
                cookie = cookies[i];
                if (cookiename.equals(cookie.getName()))
                {
                    cookieValue = cookie.getValue();
                }
            }
        }
        return cookieValue;
    }
}
