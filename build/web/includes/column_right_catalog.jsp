<%-- 
    Document   : column_right_catalog
    Created on : Nov 30, 2009, 12:50:35 PM
    Author     : HP_Owner
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

 
 <%@ taglib prefix='c' uri="http://java.sun.com/jsp/jstl/core" %>
 
<td  class=rightcolumn >
    <p align="center"> <a href ="artists" >Artists</a></p>
   <%-- <p align="center"><a href="< c:url value='checkcustomerforqorder?productCode=${item.productCode}'/>" >Show My Cart</a> --%>
   <p align="center"><a href="<c:url value='showmycart' />">My Cart</a>
    <p align=center><a href="deletecookies" >Delete Cookies</a></p>
    <p align="center"><a href="checkcustomerforwishlist">My Wish List</a>
 
  
     
 <p><hr width=2><em>
 <form action="mailto:${initParam.CastServEmail}" method="Post" enctype="text/plain"  >
     
     
     
 <textarea name="customer message : " rows=5 cols="30">
      
 </textarea>
 <input type="submit" value="Email Customer Service" ><br>
 <input  type=reset    value=Erase >
</form>

<p><br>


    
   
</td>