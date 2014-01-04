<%-- 
    Document   : complete
    Created on : Jan 26, 2010, 8:20:38 AM
    Author     : HP_Owner
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<jsp:include page="/includes/header.jsp" >
    <jsp:param name= "title" value="Susan's Art Gallery" />
    
</jsp:include>
<jsp:include page="/includes/column_left_all.jsp" />

<td bgcolor="linen" valign="top">
<p>
    <h3>Thank you, ${cookie.firstnameCookie.value} </h3>
    
    If you have any questions according of your order please cotact
    customer service at <a href="mailto:${initParam.CastServEmail}">${initParam.CastServEmail}</a>
</p>

<jsp:include page="/includes/column_right_catalog.jsp" />
<jsp:include page="/includes/footer.jsp" />
