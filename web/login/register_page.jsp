<%-- 
    Document   : register_page
    Created on : Jan 20, 2010, 8:34:12 AM
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
<td align="center" valign ="top" width="50%" class=colmidlist >
 <script language="JavaScript">
function validate(form)
{
    if(form.username.value=="") {
        
        alert("Please fill in your user name");
    }
    else if (form.password.value=="") 
    {
        alert("Please fill in your password");
        form.password.focus();
    }
    else if(form.repassword.value=="")
        {
            alert("Please reenter your password");
            form.repassword.focus();
        }
    
    else if(form.repassword.value != form.password.value) {
        
       alert("Please check the password");
       form.password.focus();       
    }
    
   else if (form.firstname.value=="") 
    {
        alert("Please fill in your first name");
        form.firstname.focus();
    }
    else if(form.lastname.value=="") {
        alert("Please fill in your last name");
        form.lastname.focus();
    }
    
    else if (form.emailaddress.value=="") 
    {
        alert("Please fill in your email address");
        form.emailAddress.focus();
    }
    else 
    {
        form.submit();
    }
}
</script>
 
 <form action="<c:url value='/registercustomer' />" method="post" >
     <table>
         <tr></tr>
         <tr></tr>
         <tr>
             <td colspan="2"><font size="+1" color="black" ><p>To make purchases, you must register for an acount first.</p><p>Please register</p></font>
             
         </tr> 
         <tr></tr>
         <tr></tr>
         <tr></tr>
        
         <tr></tr>
         <tr></tr>
         <tr></tr>
         <tr></tr>
         <tr></tr>
         <tr><td colspan="2"><p><hr size="1"><p><em>${message}</em></td></tr>
         <tr></tr>
         <tr></tr>
            <tr>
                <td align=left>User Name: </td> <td> <input type="text" name=username ></td>
            </tr> 
            <tr>
                <td align="left">Password: </td> <td><input type="password" name=password ></td>
            </tr>
            <tr>
                <td align="left">Retype Password: </td><td><input type=password name=repassword></td>
            </tr>
            <tr></tr>
            <tr></tr>
            <tr>
                <td align=left>First name:</td><td><input type=text name=firstname></td>
            </tr>
          <tr>
              <td align="left">Last Name: </td><td><input type =text name=lastname ></td>
            </tr>  
            
            <tr>
              <td align="left">Email Address: </td><td><input type="text" name=emailaddress ></td>
            </tr>
          
             <tr>
              <td ><input type=button  name= "Submit" value="Submit" onClick="validate(this.form)"></td> <td><input type=submit name="cansel" value= Cansel>
            </tr>
      </table>
 </form>
</td>

<jsp:include page="/includes/column_right_home.jsp" />
<jsp:include page="/includes/footer.jsp" />