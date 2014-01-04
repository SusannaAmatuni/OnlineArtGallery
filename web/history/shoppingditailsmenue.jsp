<%-- 
    Document   : shoppingditailsmenue
    Created on : Oct 19, 2010, 7:38:59 PM
    Author     : HP_Owner
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">


 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 
  <jsp:include page="/includes/header.jsp">
    <jsp:param name="title" value="Susan's Art Gallery" />
</jsp:include>


<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


  <td colspan="3"  class=leftcolumn>
  
     <font color="black " size=3>${customer.firstName} ${customer.lastName}<p> Shopping ditails</font><p>
     <br><p>
 </td>
 </tr>
 <tr>
  <td    valign="middle" align="absmiddle" class=leftcolumn >
  <p> <font size="+1">Shopping History Snapshot</font><p>
 <form action="/OnlineShopper2/shoppinghistorysnapshotmenue" >
    <input type=submit value="Shopping History Snapshot">
</form><br><br>
    
 </td>         
         
     <td class="middlecolumn">
     <form action="shoppinghistorymenue" >
  
      <select name="periodoftime"   >
        <option > All Purchases</option>    
        <option>Last Two Purchases</option>
        <option>Last Five Purchases</option>
        
      </select>  <p><br><br>
     <input type="submit" value="Show My Purchases">
     
     </form>
     <p>
     
     <font color="black" size=3>${customer.firstName} ${customer.lastName}'s shopping ditails</font>
     <br><p>
         
            
         
          <c:forEach var="lineitem"  items="${lineItems}" >
                 <table>
                    <tr>
                     <td><font color="black" size="+1"> Item:</font></td><td nowrap=true><img src="/OnlineShopper2/timages/${lineitem.product.productCode}T.jpg" align= absmiddle alt="No image is available"> ${lineitem.product.productName}${lineitem.product.priceCurrencyFormat}</td>
                    </tr>
                   <tr><td></td><td></td></tr>
                   <tr><td></td><td></td></tr>
                 
                   <tr>    
                    <td><font color="black" size="+1"> Qnt:</font> </td> <td> ${lineitem.quantity}</td>
                   </tr>
                  <tr><td></td><td></td></tr>
                  <tr><td></td><td></td></tr>
                 <tr>
                   <td><font color="black" size="+1"><p>Total:</font></td> <td>${lineitem.totalCurrencyFormat}</td>
                 </tr>
             </table><hr size="1"> <p>
         </c:forEach><br>   
             
                    
         Grand Total:${invoice.invoiceTotalFormat}
        <br><br><br><br>
    
         
    
</td>
       
  <td class=rightcolumn>      
     <form action="mailto:${initParam.CastServEmail}" method="Post" enctype="text/plain"  >
        <textarea name="message from ${customer.firstName}:" rows=5 cols="30"> </textarea>
        <input type="submit" value="Email to Customer Service" ><br>
        <input  type=reset    value=Delete>
     </form>
    
</td>
</tr>




<jsp:include page="/includes/footer.jsp" />



    
