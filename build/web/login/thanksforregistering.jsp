<%-- 
    Document   : thanksforregistering
    Created on : Jan 9, 2010, 1:21:09 PM
    Author     : HP_Owner
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<jsp:include page="/includes/header.jsp" >
<jsp:param name= "title" value="Susan's Art Gallery" />
</jsp:include>
<jsp:include page="/includes/column_left_all.jsp" />

<td class = middlecolumn >
    <p>
    <em><b> Thank you for registering, ${customer.firstName}!</b></em><p>

   <hr size="3"><p><br><br>
      <p> Meet the New Artist<br><br>
    <img width="50%" src="/OnlineShopper2/images/SU18.JPG" alt="No image is available">
    <p align="center">If you like this piece of work and would like to know about the artist and his(her) work click the link below.</p><br>
    <a href= "newartist?artistCode = SU "> New Artist</a><br><br></td> 

    
</td>

<jsp:include page="/includes/column_right_catalog.jsp" />
<jsp:include page="/includes/footer.jsp" />