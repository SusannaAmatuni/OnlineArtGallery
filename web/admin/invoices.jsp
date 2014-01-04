<%-- 
    Document   : invoices
    Created on : Feb 4, 2010, 6:37:00 PM
    Author     : HP_Owner
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
   <jsp:include page="/includes/header.jsp" >
       <jsp:param  name="title"  value="Invoices" />
    </jsp:include>
    
    <jsp:include page ="/includes/column_left_all.jsp" />
    
    <%@ taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
    <td bgcolor="linen">
        <h2>Invoices to be Processed</h2>
        <table bgcolor="linen" >
        <tr>
            <td ></td> 
            <td  ><h4>Customer Name: </h4></td>
            <td><h4>Invoice Date</h4></td>
        </tr>
        
      <c:forEach var="item" items="${unprocessedinvoices}" >
          <tr>
             <td><a href="<c:url value="displayoneinvoice?invoiceNumber=${item.invoiceID}" />" > Click to View</a>
             </td>
             <td >${item.customer.firstName} ${item.customer.lastName}</td>
             <td>${item.invoicedateFormat}</td>
             
         </tr> 
        </c:forEach>
    
       </table>
       
     <jsp:include page="/includes/footer.jsp"  />