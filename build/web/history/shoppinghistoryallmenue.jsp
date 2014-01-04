<%-- 
    Document   : shoppinghistorysnapsotmenue
    Created on : Oct 18, 2010, 1:57:44 PM
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

<td class= leftcolumn >
    
  
     <font color="black " size=3>${customer.firstName} ${customer.lastName}<p>  Shopping ditails</font><p>
     <br><p>
         
     
             <font size="+1">Shopping History Snapshot</font><p>
                          
                    
              
               <c:forEach var="lineitem"  items="${alllineitems}" >
                                                                      
                     <img src="/OnlineShopper2/timages/${lineitem.product.productCode}T.jpg" alt="No image is available" align=left >
                     <font color="black" size="+1"> Item:</font>${lineitem.product.productName}${lineitem.product.priceCurrencyFormat} &nbsp;
                      
                    <font color="black" size="+1"> Qnt:</font> ${lineitem.quantity}&nbsp;
                                             
                    <font color="black" size="+1">Total:</font>${lineitem.totalCurrencyFormat}<br><br clear="left">
            
              </c:forEach>
           <p><br>
             
         </td>         
         
     <td class="middlecolumn">
          <c:forEach  var="item" items="${invoices}">
           <form action="shoppingditailsmenue " method="post" ><br><br>
                <table border="2">
                     <tr><td >Invoice Date: </td>
                         <td><input type =submit value="${item.invoiceDate}"></td>
                         <td><input type=hidden  name="invoiceID" value="${item.invoiceID}"</td>
                    </tr>
                    <tr></tr>
                </table>
                
           </form> 
    </c:forEach>

        <p>
        
     <form action="mailto:${initParam.CastServEmail}" method="Post" enctype="text/plain"  >
        <textarea name="message from ${customer.firstName}:" rows=5 cols="30"> </textarea>
        <input type="submit" value="Email to Customer Service" ><br>
        <input  type=reset    value=Delete >
     </form>
    
</td>

<td class="rightcolumn">
    <p>Meet the new Artist<br><br>
    <img width="100%" src="/OnlineShopper2/images/SU10.JPG" alt="No image is available">
    <p align="center">If you like this piece of work and would like to know about the artist and his(her) work click the link below.</p><br>
    <a href="newartist">New Artist</a><br><br>

</td>


<jsp:include page="/includes/footer.jsp" />



    
