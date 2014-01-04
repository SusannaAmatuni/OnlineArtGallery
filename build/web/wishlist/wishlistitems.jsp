<%-- 
    Document   : wishlistproducts
    Created on : Nov 11, 2010, 4:33:13 PM
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
    <p>${sameselection}<p>
    <c:forEach   var ="item" items="${wishlistitems}" varStatus="num" >
    <p>       
  
    <img  src="/OnlineShopper2/timages/${item.product.productCode}T.jpg"   align="left" alt="No image is available" ><%--</a> --%>&nbsp;&nbsp;   
               
       <a href="product?productCode=${item.product.productCode}"  >${item.product.productName}</a><br><p>
     <a href="<c:url value='checkcustomerforqorder?productCode=${item.product.productCode}'/>" class=addcart>Add to Cart</a><br><p>
    <a href="<c:url value="deletefromwishlist?productCode=${item.product.productCode} " />" >Delete From Wish List</a><br clear="left">

    <hr size="1">

</c:forEach>

<p><a href= "catalogofitems" class="order"><font  color="black">&lt; Catalog</font></a>



</td>

<jsp:include page="/includes/column_right_catalog.jsp" />
<jsp:include page="/includes/footer.jsp" />


