<%-- 
    Document   : index.jsp
    Created on : Feb 4, 2010, 8:20:07 AM
    Author     : HP_Owner
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">


    <jsp:include page="/includes/header.jsp" >
        <jsp:param name="title" value="Susan's Art Gallery" />
    </jsp:include>
    <jsp:include page="/includes/column_left_all.jsp" />
    
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
    <td class=middlecolumn >
        <h3> Online Shopper-Administration</h3>
        <form action="<c:url value="/displayinvoices" />" method= 'post'>
        
         <input type="submit" name= invoices value="Display Invoices">
        </form><p>
        <form action="<c:url value="displayreports" />" method='post' >
            <input type="submit" name="displayreports" value = "Display Reports">
         </form> 
         
     </td>
     <td class=middlecolumn><a href="/OnlineShopper2/logOff.jsp"><b>Log off</b></a></td>

    
    <jsp:include page="/includes/footer.jsp"  />