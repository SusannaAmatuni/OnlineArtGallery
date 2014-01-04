
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


<td colspan="3"  class=middlecolumn>

 

<font color="black"> <em > ${customer.firstName} ${customer.lastName}${posses}<p>  Shopping history</font><br>
                    Today is:    ${currentYear} / ${currentMonth}/ ${currentDay}<br>
                        
 
</td>
</tr>

<tr>
     <td  width=10%   class= leftcolumn >
      ${periodoftime} <br>
       <form action="shoppinghistorysnapshotmenue" bgcolor="#ffffcc">
         <input type="submit" value="Shopping History Snapshot">
     </form>  
    
     
     </td>
    
<td  align="absmiddle"  class=middlecolumn>
        
           
      <form action="shoppinghistorymenue" >
        <select name="periodoftime"   >
           <option > All Purchases</option>    
           <option>Last Two Purchases</option>
           <option>Last Five Purchases</option>
        </select>  <p><br><br>
        <input type="submit" value="Show My Purchases">
     </form>
     
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

</td>



<p><br>
    
  <p><br><br>
      
 


<td  width="10%" align="absmiddle"  class= rightcolumn >
  
   <form action="mailto:${initParam.CastServEmail}" method="Post" enctype="text/plain"  >
         
        <textarea name="message from ${customer.firstName}:" rows=5 cols="30"> </textarea>
       <input type="submit" value="Email to Customer Service" ><br>
       <input  type=reset    value=Delete >
    </form>
  
</td>
</tr>

<jsp:include page="/includes/footer.jsp" />

