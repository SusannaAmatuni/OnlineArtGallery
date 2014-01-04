<%-- 
    Document   : login
    Created on : Feb 4, 2010, 8:38:24 AM
    Author     : HP_Owner
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<jsp:include page="/includes/header.jsp" >
    <jsp:param name="title" value="Login for Administration" />
</jsp:include>
<jsp:include page="/includes/column_left_all.jsp" />
<td bgcolor="linen">
    
    <h2>Please Login</h2>
    <form  method="Post" action="j_security_check"><p>
            
    </p>
        <table bgcolor="linen" >
            
          <tr>
            <td> User Name:</td>
             <td>  <input type=text name="j_username"> </td>
          </tr>
        <tr>
          <td> Password: </td>
          <td><input  type="password" name=j_password></td>
        </tr>
        <tr>
            <td colspan="2">
              <input type="submit" value="Submit"> 
          </td>
        </tr>
    </table>
    </form>

</td>
<jsp:include page="/includes/column_right_home.jsp" />
<jsp:include page="/includes/footer.jsp" />
