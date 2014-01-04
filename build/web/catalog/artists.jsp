<%-- 
    Document   : artists
    Created on : Dec 9, 2009, 2:25:54 PM
    Author     : HP_Owner
--%>

<jsp:include page="/includes/header.jsp" >
    <jsp:param name="title" value="Susan's Art Gallery" />
</jsp:include>
<jsp:include page="/includes/column_left_artists.jsp" />

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

 <td  class=colmidlist >
     <p><br><br>
 <c:forEach var="artist" items="${artists}" >
     <a href="artistinfo?artistCode=${artist.artistCode}&artistID=${artist.artistID}">${artist.artistFirstName} ${artist.artistLastName}</a><br><br>
 </c:forEach>
</td>

<jsp:include page="/includes/column_right_home.jsp" />
<jsp:include page="/includes/footer.jsp" />