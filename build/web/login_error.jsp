<%-- 
    Document   : login_error
    Created on : Dec 22, 2010, 1:39:58 PM
    Author     : HP_Owner
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

 <jsp:include page="/includes/header.jsp" >
<jsp:param name="title" value="Susan's Art Gallery" />
</jsp:include>
    
<jsp:include page="/includes/column_left_home.jsp" />
<div class="columnmiddle">
    
    <td class=middlecolumn ><p align="center"><b><font size='+1' color='#009999'  face="monospace">



<h1>Login Form - Error</h1>
<p>You did not log in successfully.</p>
<p>Please check your username and password and try again.</p>

<form action="j_security_check" method="get">
<table cellspacing="5" border="0">
    <tr>
        <td align="right"><p>Username: </p></td>
        <td><input type="text" name="j_username"></td>
    </tr>
    <tr>
        <td align="right"><p>Password: </p></td>
        <td><input type="password" name="j_password"></td>
    </tr>
    <tr>
      <td><input type="submit" value="Login"></td>
    </tr>
</table>
</form>

</td>

 
</div>   

<jsp:include page="/includes/column_right_home.jsp" />
<jsp:include page ="/includes/footer.jsp" />
