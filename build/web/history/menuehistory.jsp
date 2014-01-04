
<%-- 
    Document   : column_right_catalog
    Created on : Nov 30, 2009, 12:50:35 PM
    Author     : HP_Owner
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

 
 <%@ taglib prefix='c' uri="http://java.sun.com/jsp/jstl/core" %>
 
 <c:choose>
 <c:when test = "${cookie.usernameCookie eq null}">
     <jsp:forward page="/history/noshophistory.jsp" />
     </c:when>
     <c:otherwise>
<jsp:include page="/includes/header.jsp">
    <jsp:param name="title" value="Susan's Art Gallery" />
</jsp:include>

<td   valign="middle" align="absmiddle" class="middlecolumn" >
  <p> 
 <form action="/OnlineShopper2/shoppinghistorysnapshotmenue" >
    <input type=submit value="Shopping History Snapshot">
</form><p><br><br>
  
</td> 
  
<td class=middlecolumn> ${cookie.firstnameCookie.value}'s Purcheses With Dates and All Details
  
      
    <form action="/OnlineShopper2/shoppinghistorymenue" >
       <select name="periodoftime"   >
          <option> All Purchases</option>    
          <option>Last Two Purchases</option>
          <option>Last Five Purchases</option>
          
          </select>  <p>
     <input type="submit" value="Show My Purchases">
     
     </form>
     
     
 
 </td> 
<td class =rightcolumn> <form action="mailto:${initParam.CastServEmail}" method="Post" enctype="text/plain"  >
         
        <textarea name="message from ${customer.firstName}:" rows=5 cols="30"> </textarea>
       <input type="submit" value="Email to Customer Service" ><br>
       <input  type=reset    value=Delete >
    </form>
     
</td>

 
 <jsp:include page="/includes/footer.jsp" />
 </c:otherwise>
</c:choose>
