
<%-- 
    Document   : signin
    Created on : Nov 4, 2010, 5:55:36 PM
    Author     : HP_Owner
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">







<jsp:include page="/includes/header.jsp">
    <jsp:param name="title" value="Susan's Art Gallery" />
</jsp:include>

<jsp:include page="/includes/column_left_all.jsp" />

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<td align="center"  valign="top"  width="50%" class=colmidlist  >
 <script language="JavaScript">
function validate(form)
{
    if (form.username.value=="") 
    {
        alert("Please fill in your user name");
        form.firstname.focus();
    }
    else if (form.password.value=="") 
    {
        alert("Please fill in your password");
        form.password.focus();
    }
  
    else 
    {
        form.submit();
    }
}
</script>
 
 <form action="<c:url value='/checkmember' />" method="post" >
     <table>
         <tr></tr>
         <tr></tr>
         <tr>
             <td colspan="2"><font size="+1" color="black" ><p>&nbsp; &nbsp; &nbsp; &nbsp;&nbsp; &nbsp;   Please Sign In</font><p><p><font color=red size="-1">${loginmessage}</font>
             
         </tr> 
         <tr></tr>
         <tr></tr>
         <tr></tr>
        
         <tr></tr>
         <tr></tr>
         <tr></tr>
         <tr></tr>
         <tr></tr>
         <tr><td colspan="2">${messagemember}</td></tr>
         <tr></tr>
         <tr></tr>
            <tr>
                <td align=left>User Name: </td> <td><input type="text"  align="center" name=username ></td>
            </tr>               
         
            <tr>
                <td align="left">Password: </td> <td><input type="password" align="center" name=password ></td>
            </tr>
           
             <tr>
              <td colspan="2"><input type=button  name= "Submit" value="Sign In" onClick="validate(this.form)"></td>
            </tr>
      </table>
 </form>
</td>

<jsp:include page="/includes/column_right_home.jsp" />
<jsp:include page="/includes/footer.jsp" />
