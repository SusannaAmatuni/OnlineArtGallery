<%-- 
    Document   : favoriteproducts
    Created on : Dec 4, 2009, 9:51:55 AM
    Author     : HP_Owner
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<jsp:include page= "/includes/header.jsp" >
    <jsp:param name="title" value="Susan's Art Gallery" />
</jsp:include>
<jsp:include page="/includes/column_left_home.jsp" />
<td width="50%"  align="absmiddle"  class="middlecolumn" height="100%">
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <c:forEach var="product" items="${favoriteProducts}" >
        
        <a href="product?productCode=${product.productCode}"  ><img src=${product.imageURL} height="40%" width="40%" align="bottom"></a><br>
       <em><p> &nbsp;&nbsp;    <a href="product?productCode=${product.productCode}"  ><font size="3">${product.productName}</font></a> <br>                                                             
       &nbsp;&nbsp;<em> <font size="3">${product.productDescription}<br clear=left></font></em></p><hr size="1" >
    </em>
    </c:forEach><p>
    <a href= "product?productCode=${product.productCode}"><b>&lt; Back</b></a>  
</td>
<jsp:include page= "/includes/column_right_catalog.jsp" />

<jsp:include page="/includes/footer.jsp" />


