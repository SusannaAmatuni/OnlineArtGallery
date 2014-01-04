<%-- 
    Document   : noshophistory
    Created on : Oct 19, 2010, 11:50:06 AM
    Author     : HP_Owner
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<jsp:include page="/includes/header.jsp">
    <jsp:param name="title" value="Susan's Art Gallery" />
</jsp:include>
<jsp:include page="/includes/column_left_all.jsp" />

<%@ taglib  prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<td width="50%" valign="middle" align="absmiddle" bgcolor="#00FFFF" class=colmidlist>

    <font size ="+1" > <p>Your Cart is Empty !</font>
    </p>
    <hr size="8"  ><p><br><br><br><br><br>
    
        
    
      <p> Meet the New Artist<br><br>
    <img width="50%" src="/OnlineShopper2/images/SU18.JPG" alt="No image is available">
    <p align="center">If you like this piece of work and would like to know about the artist and his(her) work click the link below.</p><br>
    <a href= "newartist?artistCode = SU "> New Artist</a><br><br></td> 
    
</td>

<jsp:include page="/includes/column_right_catalog.jsp"   />

<jsp:include page="/includes/footer.jsp" /> 















