<%-- 
    Document   : products
    Created on : Nov 30, 2009, 11:38:27 AM
    Author     : HP_Owner
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<jsp:include page="/includes/header.jsp">
    <jsp:param name="title" value="Susan's Art Gallery" />
</jsp:include>

<jsp:include page="/includes/column_left_catalog.jsp" />

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<td width="50%" valign="middle"  class=middlecolumn  >
   
   
    
    <c:forEach   var="item" items="${products}" varStatus="itemsCount" >
        <em><p><br><br>
            <a href ="<c:url value='product?productCode=${item.productCode}' />"><img height="40%" width="40%" src="/OnlineShopper2/images/${item.productCode}.JPG" align="left"   ></a><br><br>   
          <spam align=top>  <a href="product?productCode=${item.productCode}" ><font size="3"  > ${item.productName}</font></a><br>
            
       <font size="3">${item.productDescription}</font><br>
       <a href="<c:url value='checkcustomerforqorder?productCode=${item.productCode}'/>" class=addcart >Add to Cart<br></a><p>
       <a href="<c:url value='checkcustomerforwishlist?productCode=${item.productCode}' />"> Add to My Wishlist<br></a>
       <a href="<c:url value='checkcustomerforwishlist' />"> My Wishlist<br clear=left><p></a>
</em></spam><hr size="1">
 </c:forEach>
 <a href="catalogofitems"><b>&#094;Top</b></a>
</td>

<jsp:include page="/includes/column_right_catalog.jsp"/>
<jsp:include page="/includes/footer.jsp" />



