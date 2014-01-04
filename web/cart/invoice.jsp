<%-- 
    Document   : invoice
    Created on : Jan 20, 2010, 7:48:38 PM
    Author     : HP_Owner
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
   <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
   
<jsp:include page ="/includes/header.jsp" >
    <jsp:param name="title" value="Susan's Art Gallery" />
 </jsp:include>
 <jsp:include page="/includes/column_left_all.jsp" />
 <td class=colmidlist>
 <h1>Please review your invoice,  ${invoice.customer.firstName}</h1><br>
     ${customer2.emailAddress} ${customer2.address1}
 <table  >
     <tr>
         <td align="center">Date : </td>
         <td align="center">${invoice.invoiceDate}</td>
        
     </tr>
        
     
     <tr>
         <td align="center" valign="top" rowspan="2">Ship to :</td>
         <td align=center >${customer.addressHtmlFormat}</td>
     </tr>
     </table>
     <hr size=2 color=black>
     <table>
         <tr>
             <td align="center"><h4>Product</h4></td>
             <td align="center"><h4>Quantity</h4></td>
             <td align="center"><h4>Total Price</h4></td>
         </tr>
         <c:forEach var="item" items="${cart.items}" >
         <tr>
             <td align=center >${item.product.productName} ${product.productDescription}</td>
             <td align="center">${item.quantity}</td>
             <td align="center">${item.totalCurrencyFormat}</td>
         </tr>
     </c:forEach>
     <tr></tr>
     <tr>
         <td colspan="3">
             <h4>Grand Total:${invoice.invoiceTotalFormat}</h4>
         </td>
     </tr>
             
         
     </table>
    <p>If You would like to make corrections to your invoice
    please select Edit</p>
 <form action="<c:url value='/cart/customer.jsp' />" method="post">
  <input type="submit" name="submit" value="Edit">
</form>
<br>
    <form action="<c:url value='/cart/credit_card.jsp' />" method="post" >
    <input type=submit name=submit value="Submit" >
</form>
</td>

<jsp:include page="/includes/column_right_cart.jsp" />
<jsp:include page="/includes/footer.jsp" />

 
