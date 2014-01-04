<%-- 
    Document   : index
    Created on : Dec 10, 2009, 7:59:21 AM
    Author     : HP_Owner
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

 
 
 <jsp:include page="/includes/header.jsp" >
<jsp:param name="title" value="Susan's Art Gallery" />
</jsp:include>
    
<jsp:include page="/includes/column_left_home.jsp" />

    
    <td class=middlecolumn  ><p align="center"><b><font size='+1' color='#009999'  face="monospace">
        <%--${greetingmessage} --%> ${cookie.welcome.value} ${cookie.firstnameCookie.value} </font></b><br>
          <p>This is a place where you could  find the works of well known artists as well
    as discover the new ones. The works collected from US, Italy, France, Armenia. It is 
    unique  opportunity for you to experience the pleasure of buying the real art works from 
    arouwnd the world while you are sitting at your computer desk. So hurry up, 
    the art works are waiting for you!
    Enjoy!</p>
    <br><img align="left" width="45%"hight="70%"src="/OnlineShopper2/images/SU15.JPG" alt="Image is not available" t> <img src="/OnlineShopper2/images/SU12.JPG" width="45%" align="right" vspace="20">
 </td>
</div>   

<jsp:include page="/includes/column_right_home.jsp" />
<jsp:include page ="/includes/footer.jsp" />
