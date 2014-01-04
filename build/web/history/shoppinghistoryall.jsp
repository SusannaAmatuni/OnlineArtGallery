<%-- 
    Document   : soppinghistoryall
    Created on : May 12, 2010, 1:10:27 PM
    Author     : HP_Owner
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 
  <jsp:include page="/includes/header.jsp">
    <jsp:param name="title" value="Susan's Art Gallery" />
</jsp:include>

<jsp:include page="/includes/column_left_all.jsp" />

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<td width="50%" valign="middle" align="absmiddle"  class=middlecolumn>
   
  <c:forEach   var="item" items="${products}" varStatus="itemsCount" >
        
        <a href ="product?productCode=${item.productCode}" ><img height="40%" width="40%" src="/OnlineShopper2/timages/${item.productCode}.jpg" align="left" ></a><br><p>   
        <a href="product?productCode=${item.productCode}" ><font size="3" > ${item.productName}</font></a><br>
            
       <font size="3">${item.productDescription}</font><br>
         <a href="<c:url value='checkcustomerforqorder?productCode=${item.productCode}'/>" >Add to Cart<br clear=left></a></p>
   </c:forEach>
   <a href="catalogofitems">&lt;Top</a> 
    
   
</td>


<td  class=rightcolumn >
    <p align="center"> <a href ="artists" >Artists</a></p>
    <p align="center"> <a href="<c:url value='addtocart' />">Add to Cart</a></p>
    <p align=center><a href="deletecookies" >Delete Cookies</a>
    

 <p><hr width=2><em>


 <p><br>
     
           
<p><br>
  <form action="shoppinghistory" >
  
      <select name="periodoftime"   >
        <option > All Purchases</option>    
        <option>Last Two Purchases</option>
        <option>Last Five Purchases</option>
        
      </select>  <p><br><br>
     <input type="submit" value="Show My Purchases">
     
     </form>
     <p>
     
     <font color="red " size=3>${customer.firstName} ${customer.lastName}<p> Shopping ditails</font>
     <br><p>
         
         
             
             
                
                     <c:forEach var="lineitem"  items="${alllineitems}" >
                         <table>
                 <tr>
                     <td><font color="black" size="+1"> Item:</font></td><td nowrap=true> ${lineitem.product.productName}${lineitem.product.priceCurrencyFormat}</td>
                 </tr>
                 <tr><td></td><td></td></tr>
                 <tr><td></td><td></td></tr>
                 
                <tr>    
                    <td><font color="black" size="+1"> Qnt:</font> </td> <td> ${lineitem.quantity}</td>
                 
             </tr>
             <tr><td></td><td></td></tr>
             <tr><td></td><td></td></tr>
             <tr>
                 
                 <td><font color="black" size="+1">Total:</font></td> <td>${lineitem.totalCurrencyFormat}</td>
             </tr>
                </table><p><br>
              </c:forEach>
           <p><br>
             
                 
         
     
    
     <form action="mailto:${initParam.CastServEmail}" method="Post" enctype="text/plain"  >
        <textarea name="message from ${customer.firstName}:" rows=5 cols="30"> </textarea>
        <input type="submit" value="Email to Customer Service" ><br>
        <input  type=reset    value=Delete >
     </form>
    
</td>

<jsp:include page="/includes/footer.jsp" />



    
