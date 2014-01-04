<%-- 
    Document   : cart
    Created on : Jan 6, 2010, 1:56:39 PM
    Author     : HP_Owner
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">


<jsp:include page="/includes/header.jsp" >
    <jsp:param name="title" value="Susan's Art Gallery" />
    
</jsp:include>
<jsp:include page="/includes/column_left_all.jsp" />

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="pricer" uri="/WEB-INF/pricer" %>
<td  class=middlecolumn>
    
        
      <c:forEach   var="item" items="${products}" varStatus="itemsCount" >
        <p><em> 
         <a href ="product?productCode=${item.productCode}" ><img height="40%" width="40%" src="/OnlineShopper2/images/${item.productCode}.JPG" align="left" ></a>   
           <br><br> <a href="product?productCode=${item.productCode}" ><font size="3" > ${item.productName} </font></a><br>
            
           <font size="3">${item.productDescription}</font><br>
     <pricer:pricecurrency product= "${item}" >
           ${pricecurrency}
   </pricer:pricecurrency><br>
   <a href="<c:url value='checkcustomerforqorder?productCode=${item.productCode}'/>" class=addcart>Add to Cart</a><br>  
   <a href="<c:url value='checkcustomerforwishlist?productCode=${item.productCode}' />" >Add to My Wishlist</a><br clear="left">
 </p> <br><br>      

</c:forEach>
<p><a href="quickorder"><b>&#094;Top</b></a><p>
   
</td>

<jsp:include page="/includes/column_right_catalog.jsp" />
     
 <jsp:include page="/includes/footer.jsp" />
 