<%-- 
    Document   : signinheader
    Created on : Dec 19, 2010, 7:23:01 PM
    Author     : HP_Owner
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Online Store</title>
        <link rel="stylesheet" href="/OnlineShopper2/styles.css" >
            
    </head>
</div>

    <body vlink ="#FF00FF"  bgcolor="linen">
         
        <table width="100%" hight="100%"  >
            <tr >
              <th class ="top" colspan=3 >   <p align="center" >${param.title}</p></th>
            </tr>
            <tr>
                <td bgcolor="linen" align="right" colspan="3">
                <a href="/OnlineShopper2/login/register_page.jsp"  > <font color="black" size="-1">Please Reagister</font></a>&nbsp;&nbsp;|&nbsp; 
              <%--  <a href="/OnlineShopper2/history/menuehistory.jsp"><font color = black size="-1">${customer.firstName} Account</font></a> &nbsp;&nbsp;|&nbsp; --%>
                <a href="/OnlineShopper2/newcart"><font color= black size="-1">Sign Out</font></a>&nbsp;&nbsp;|&nbsp; 
                <a href="/OnlineShopper2/login/signin.jsp"><font color="black" size="-1">Sign In</font></a>&nbsp;&nbsp;|&nbsp;
                <a href="/OnlineShopper2/showmycart"><font color="black" size="-1">My Cart</a>&nbsp;&nbsp;|&nbsp;
                <a href="checkcustomerforwishlist"><font color=black size="-1">My Wish List</font> </a>
                   
            </tr>
            <tr>
                <td bgcolor="linen" align=right colspan=3>
                <font color = black size="-1"><DL><DT><strong dir="LTR">${customer.firstName}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</strong></DT><DD DIR="LTR"><em ><a href="/OnlineShopper2/history/menuehistory.jsp">  <font color = black size="-1">Your Account</font></em></DD></font></a>&nbsp;&nbsp; 
           <td>
         </tr>
         <tr >
            <td   bgcolor="linen" align="left" colspan="3">
             <a href="/OnlineShopper2/index.jsp" class="menue"><font size="+1">Home</font></a>&nbsp;&nbsp;|&nbsp;
             <a href= "/OnlineShopper2/artists" class=menue ><font size="+1">Artists</font></a>&nbsp;&nbsp;|&nbsp;
             <a href="/OnlineShopper2/aboutUs.jsp" class=menue ><font size="+1">About-Us</font> </a> &nbsp;&nbsp;|&nbsp;  
              <a href="/OnlineShopper2/contact.jsp" class=menue><font size="+1"> Contact-US </font></a> 
            </td>
            
       
        </tr>
        <tr> 
     
    
  