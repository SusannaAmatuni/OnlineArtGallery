<%-- 
    Document   : invoice
    Created on : Feb 6, 2010, 5:12:58 PM
    Author     : HP_Owner
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<jsp:include page="/includes/header.jsp" >
<jsp:param name="title" value="Invoice" />
</jsp:include>

<%@ taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<td bgcolor="linen" width=150%>
<table width="100%" bgcolor="linen" >
   <h3>Your Invoice</h3> 
    <tr>
    <td><b>Date:</b></td>
    <td>${invoicedateformat}</td>
    <td></td>
    <td></td>
   </tr>
  <p>
  <tr>
       <td><b><b>Ship to:</b></td>
       <td>${customer.addressHtmlFormat}</td>
        <td></td>
        <td ></td>
        
        <p>
    <tr>
        <td colspan="4"><hr></td>
        <td></td>
        <td></td>
        <td></td>
    </tr>
    <tr>
      <td><b>Qty</b></td>
       <td><b>Description</b> </td>
        <td><b>Price</b></td>
        <td></td>
            </tr>
       <c:forEach var="item" items="${invoice.invoiceItems}" >
           <tr>
              <td>${item.quantity}</td>
              <td>${item.product.productName} ${item.product.productDescription}</td>
              <td>${item.product.priceCurrencyFormat}</td>
              <td></td>
            </tr> 
            
            </c:forEach>
            <br>
                
                <tr>
                    
                    <td colspan="2"><hr></td>
                    <td><b>Total:${invoice.invoiceTotal}</b></td>
                    
                    <td></td>
                </tr> 
                <tr>
                    <td>
                        <b>Payment Information</b>
                     </td>
                     <td>${customer.creditCardType} ${customer.creditCardNumber}(${customer.creditCardExpirationDate})</td>
                     <td></td>
                 </tr>
                 
                 <tr>
                     <td>
                         <b>Email Address:</b>
                     </td>
                     <td>${customer.emailAddress}</td>
                     <td></td>
                 </tr>
            
        </table>
        <form action="processinvoice" >
            <input type=submit name=processinvoice value="Process Invoice">
              
        </form>
        <br>
        <form action="displayinvoices" >
            <input type="submit" name=dislayinvoices value="View Unprocessed Invoices">
        </form>
    </td>
    <jsp:include page="/includes/column_right_admin.jsp" />
    
    <jsp:include page="/includes/footer.jsp" />
    
