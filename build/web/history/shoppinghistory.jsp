<%-- 
    Document   : history
    Created on : May 4, 2010, 7:55:31 PM
    Author     : HP_Owner
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<jsp:include page="/includes/header.jsp">
    <jsp:param name="title" value="Susan's Art Gallery" />
</jsp:include>

<jsp:include page="/includes/column_left_all.jsp" />

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<td width="50%" valign="middle" align="absmiddle"  class=middlecolumn>
   
  <c:forEach   var="item" items="${products}" varStatus="itemsCount" >
        
        <a href ="product?productCode=${item.productCode}" ></a><img height="40%" width="40%" src="/OnlineShopper2/timages/${item.productCode}.jpg" align="left" alt="No image available" ><br><p>   
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

 <p><br>
 <p><hr width=30><em>
     
     <form action="shoppinghistorysnapshot" >
         <input type="submit" value="Shopping History Snapshot">
     </form>  

<font color="red">  <p><em > ${customer.firstName} ${customer.lastName} <p> Shopping history</font><p><br>
                    Today is:    ${currentYear} / ${currentMonth}/ ${currentDay}<br><br><p>
                        <!-- ${period} --> ${periodoftime}
 <p><br>
     <c:forEach  var="item" items="${invoices}">
           <form action="shoppinghistoryditails " method="post" ><br><br>
                <table border="2">
                     <tr><td >Invoice Date: </td>
                         <td><input type =submit value="${item.invoiceDate}"></td>
                         <td><input type=hidden  name="invoiceID" value="${item.invoiceID}"</td>
                    </tr>
                    <tr></tr>
                </table>
                
           </form> 
    </c:forEach>


<p><br>
    
    
    <form action="shoppinghistory" >
        <select name="periodoftime"   >
           <option > All Purchases</option>    
           <option>Last Two Purchases</option>
           <option>Last Five Purchases</option>
        </select>  <p><br><br>
        <input type="submit" value="Show My Purchases">
     </form>
     
     <p><br><br>
    
     <form action="mailto:${initParam.CastServEmail}" method="Post" enctype="text/plain"  >
         
        <textarea name="message from ${customer.firstName}:" rows=5 cols="30"> </textarea>
       <input type="submit" value="Email to Customer Service" ><br>
       <input  type=reset    value=Delete >
    </form>
     
</td>
<jsp:include page="/includes/footer.jsp" />


