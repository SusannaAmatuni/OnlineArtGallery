<%-- 
    Document   : artist
    Created on : Dec 6, 2009, 8:59:08 AM
    Author     : HP_Owner
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<jsp:include page = "/includes/header.jsp" >
<jsp:param name="title" value = "Meet the Artist" />
</jsp:include>
<jsp:include page = "/includes/column_left_all.jsp" />
<td  class=middlecolumn >
    
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib prefix="pricer" uri="/WEB-INF/pricer" %>
    <p align="center">
    ${artist.artistFirstName}  ${artist.artistLastName}<br>
<a href="mailto:${artist.artistEmail}">email to ${artist.artistFirstName}${artist.artistLastName}</a></p>
      <img src="  ${artist.imageURL}" width="40%" height="40%">
        <p>${artist.bioFile}
        <br><br><br><a href="catalogofitems">&lt;Back to Catalog</a>
        <p>
            <hr size="12" >
                <p><br>
        <c:forEach var="item" items="${artistproducts}" > <em>
            <a href="product?productCode=${item.productCode}">   <img height="40%" width="40%"  src="/OnlineShopper2/images/${item.productCode}.JPG" align=bottom></a><br><p>
             <em>  <font size="3"> ${item.productName}</font></a><br>
                 <font size="3">${item.productDescription}</font><br>
             <pricer:pricecurrency product="${item}">
                     ${pricecurrency}
             </pricer:pricecurrency><br><p>
      
           <a href="<c:url value="checkcustomerforqorder?productCode=${item.productCode}" />" class =addcart>Add to Cart<br clear=left></a></p></em>
           <b> <hr size="3"  width="50%" align="middle" ></b>
      </c:forEach>         
        <a href ="artistinfo?artistCode=${artist.artistCode}&artistID=${artist.artistID}" ><p><b> &#094;Top</b></a> 
    
</td>

<jsp:include page="/includes/column_right_catalog.jsp" />

<jsp:include page="/includes/footer.jsp" />