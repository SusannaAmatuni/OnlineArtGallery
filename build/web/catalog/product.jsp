<%-- 
    Document   : product
    Created on : Dec 3, 2009, 10:01:32 AM
    Author     : HP_Owner
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<jsp:include page="/includes/header.jsp" >
    <jsp:param name="title" value="Susan's Art Gallery"/>
</jsp:include>
<jsp:include page="/includes/column_left_all.jsp" />
<td  class=middlecolumn >

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="pricer" uri="/WEB-INF/pricer" %>

 <img  height="60%" width="60%" src = "/OnlineShopper2/images/${product.productCode}.JPG" align=bottom><br>
   <p> <a  href="artist?artistID=${product.artistID}" ><font size="+1"> Artist Info</font></a><br>
       <em> ${product.productDescription}</em><br>
<pricer:pricecurrency product="${product}">
    ${pricecurrency}
</pricer:pricecurrency><br>
   
<a href="<c:url value ='/checkcustomerforqorder?productCode=${product.productCode}' />" class=addcart >Add to Cart</a><br><br> 
<a href= "catalogofitems" class="order"><font  color="black"> Catalog</font></a><br>
  
  <a href="checkcustomerforwishlist"><font  color="black">My Wish List</font></a><br>
    <a href="<c:url value='checkcustomerforwishlist?productCode=${product.productCode}' />"> Add to My Wishlist<br></a>    
  </p>   
</td>
 <jsp:include page="/includes/column_right_favorite.jsp" />
   
<jsp:include page="/includes/footer.jsp" />