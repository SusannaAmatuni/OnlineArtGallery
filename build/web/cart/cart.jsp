<%-- 
    Document   : mycart
    Created on : Jan 7, 2010, 3:18:58 PM
    Author     : HP_Owner
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="/includes/header.jsp" >
    <jsp:param name="title" value="Susan's Art Gallery" />
    
</jsp:include>
<jsp:include page="/includes/column_left_all.jsp" />



<td    class=colmidlist>
<table>
    
   <tr> 
       <td align="left"><font size="+1" color="black" >Quantity</font></td>
        <td align="center"><font size="+1" color="black" >Price</font></td>
        <td align="center"><font size="+1" color="black">Product Name</font></td>
        <td align="center"><font size="+1" color="black" >Total</font></td>
   <td></td>
   <td></td>
</tr>

 <c:forEach var="item" items="${cart.items}" varStatus="itemcount">
     
      <tr>
      <td> 
      <form action=" <c:url value='addtocart' />" method='post'>
           <input type=hidden name='productCode' value='${item.product.productCode}'>
            <input type=text size=2 name="quantity" value="${item.quantity}">
            <input type=submit name="quantitybutton" value="Update">
             <input type="submit" name="removebutton" value="Remove" >            
        </form>             
        
       </td>
       
       <td align="center">${item.product.priceCurrencyFormat}</td>
       <td align="center">${item.product.productName}</td>
       <td align="right">${item.totalCurrencyFormat}</td>
       

     </tr>

</c:forEach>
<tr>
<td colspan=6><p>
    
    To remove item from Cart please click <b> Remove</b> button.<br>
    To make other purcheses please click <b>Continue Shopping</b><br>
    To finish making selections please click <b>Proceed Order</b>    
    </td>
</tr>


  <tr>
      <td colspan=2>
    <form action="<c:url value="quickorder" />" method=post>
     <input type=submit value= "Continue Shopping" name=continueshopping >
 </form>
</td>
<td colspan="2">
 <form action="<c:url value="checkcustomer" />" method=post>
   <input type=submit value="Proceed Order" name=checkout >
</form>
</td>
<td colspan="2">
<form action="<c:url value="canselorder" />" method=post  >
   <input type=submit value="Cancel the Order" >
</form>
</td>

</tr>
</table>
<jsp:include page="/includes/column_right_cart.jsp" />
<jsp:include page="/includes/footer.jsp" />

         

         
         