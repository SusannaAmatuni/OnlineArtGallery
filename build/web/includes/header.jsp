<%-- 
    Document   : header
    Created on : Nov 16, 2009, 10:03:18 AM
    Author     : HP_Owner
--%>
 
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
   <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <div class="top"> 
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Online Store</title>
        <link rel="stylesheet" href="/OnlineShopper2/styles.css" >
            
    </head>
</div>

    <body vlink ="#FF00FF" bgcolor="linen" >
         
        <table  bgcolor="linen"  border="20"   bordercolor="#baba78" align="center" cellspacing="0"   width="100%" >
        <tr><td>
           <table bgcolor="linen"   cellspacing="0" >
            <tr>
                <td bgcolor="linen" align="right" colspan="3" >
                <a href="/OnlineShopper2/login/register_page.jsp"  > <font color="black" size="-1">Please Register</font></a>&nbsp;&nbsp;|&nbsp; 
                
                <a href="/OnlineShopper2/newcart"><font color= black size="-1">Sign Out</font></a>&nbsp;&nbsp;|&nbsp; 
                <a href="/OnlineShopper2/login/signin.jsp"><font color="black" size="-1">Sign In</font></a>&nbsp;&nbsp;|&nbsp;
                <a href="/OnlineShopper2/showmycart"><font color="black" size="-1">My Cart</a>&nbsp;&nbsp;|&nbsp;
                <a href="/OnlineShopper2/checkcustomerforwishlist"><font color=black size="-1">My Wish List</font> </a>&nbsp;&nbsp;
                   
            </tr>
           
            <tr>
                <td bgcolor="linen" align=right colspan=3 >
                <font color = black size="-1"><DL><DT><strong dir="LTR">${cookie.firstnameCookie.value}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</strong></DT><DD DIR="LTR"><em ><a href="/OnlineShopper2/history/menuehistory.jsp">  <font color = black size="-1">Your Account</font></em></DD></font></a>&nbsp;&nbsp; 
           <td>
         </tr>
         
         
           <tr   >
               <th class ="top" colspan=3  height="30%" > <p align="center" > ${param.title}</p></th>
            </tr>
         
           
       <tr >
            <td   bgcolor="linen" align="left" colspan="3">
             <a href="/OnlineShopper2/index.jsp" class="menue"><font size="+1">Home</font></a>&nbsp;&nbsp;|&nbsp;
             <a href= "/OnlineShopper2/artists" class=menue ><font size="+1">Artists</font></a>&nbsp;&nbsp;|&nbsp;
             <a href="/OnlineShopper2/author/aboutus.jsp" class=menue ><font size="+1">About Us</font> </a> &nbsp;&nbsp;|&nbsp;  
              <a href="/OnlineShopper2/author/contactus.jsp" class=menue><font size="+1"> Contact US </font></a> 
            </td>
            
       
        </tr>
        <tr> 
           <td colspan="3"></td>
        </tr>
        <tr> 
          <td colspan="3"></td>
        </tr>
       <tr>
     
    
  