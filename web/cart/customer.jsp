<%-- 
    Document   : customer
    Created on : Jan 15, 2010, 4:22:28 PM
    Author     : HP_Owner
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<jsp:include page = "/includes/header.jsp" >
    <jsp:param name="title" value="Susan's Art Gallery" />
</jsp:include>



<%@ taglib  uri="/WEB-INF/pricer" prefix="pricer" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<script language="JavaScript"> 
   function validate(form) {
       
       if(form.firstname.value=="") {
           alert("Please Enter Your First Name");
           form.firstName.focus();
       }
       else
         if(form.lastname.value=="") {
           alert("Please Enter Your Last Name");
           form.lastName.focus();
           
       }
        else
       
       if(form.emailaddress.value=="") {
           alert("Please Enter Your Email Address");
           form.emailAddress.focus();
           
       }
       else
       
       if(form.address1.value=="") {
           alert("Pleass Enter Your Address");
           form.address1.focus();
       }
   else
       if(form.city.value=="") {
           alert("Please Enter City");
           form.city.focus();
           
       }
      
       else
       if(form.zip.value=="") {
           alert("Please Enter tne Zip Code");
           form.zip.focus();
       }
       else
       if(form.country.value=="") {
           alert("Please Enter Country");
           form.country.focus();
       }
     else
     if(form.country.value=="USA" || form.country.value=="usa") {
       
       
       if(form.state.value==""){
       
       alert("Please Enter the State");
       form.state.focus();
       
   }
    else
        form.submit();
     }
   else {
       form.submit();
   }
   }
   
   
    
    </script>
    
    <jsp:include page="/includes/column_left_all.jsp" />
   
<td class=colmidlist  >
    
    
    <form action="<c:url value='/processcustomer' />"  method="post"  name="myform">
        <table>
            <tr>
                <td colspan="2"></td>
            </tr><p>
            <tr>
                 <td></td>
                 <td><p><b>Requered Fields Marked</b> <font color="red">*</font><p></td>
            </tr>
            <p>
            <tr>
                <td align="right" >First Name</td>
                <td><input type="text" name=firstname  value="${customer.firstName}"
                size=20 maxlength=20><font color="red">*</font></td>
                
            </tr>
            
            <tr>
                <td align="right">Last Name</td>
                <td><input type="text" name=lastname value=" ${customer.lastName}"
                           size=20 maxlength=20><font color="red" >*</font> </td>
            </tr>
            
            <tr>
                <td align="right">Email Address</td>
                <td><input type ="text" name = emailaddress value="${customer.emailAddress}"
                           size = 20 maxlength=20><font color="red">*</font></td>
            </tr>
            
            <tr>
                <td align="right" >Company Name</td>
                <td><input type="text" name="companyname" value="${customer.companyName}"
                      size=30 maxlength=30></td>
                                
            </tr>
            
            <tr>
                <td align="right">Addres1</td>
                <td>
                    <input type="text" name="address1" value="${customer.address1}"
                           size=20 maxlength=20><font color="red">*</font>
                </td>
                    
             </tr>
             
             <tr>
                 <td align=right>
                    Address2 
                 </td>
                 <td>
                     <input type=text name=address2 value="${customer.address2}">
                 </td>
             </tr>
             <p>
             <tr>
                 <td align="right">City</td>
                 <td>
                     <input type=text name="city" value="${customer.city}"
                            size =20 maxlength=20><font color="red">*</font>
                 </td>
             </tr>
              <tr>
                 <td align="right">Country</td>
                 <td>
                     <input type="text" align="left" name ="country"  value="${customer.country}"  ><font color="red">*</font> 
                 </td>
                 
             </tr>
            
            
             
             <tr>
                 
             <td align="right">State</td>
                     
                     
              <td>      <select name ="state" value=" "  > <%--multiple causes to have scrolling bar --%>
                             <option>
                             <option>Alabama
                             <option>Alacka
                             <option>Arizona
                             <option>Arkansas
                             <option>California
                             <option>Colorado
                             <option>Connecticut
                             <option>Delaware
                             <option>Florida
                             <option>Georgia
                             <option>Hawaii
                             <option>Idaho
                             <option>Illinois
                             <option>Indiana
                             <option>Iowa
                             <option>Kansas
                             <option>Kentucky
                             <option>Louisiana
                             <option>Main
                             <option>Maryland
                             <option>Massachusetts
                             <option>Michigan
                             <option>Minnesota
                             <option>Mississippi
                             <option>Missouri
                             <option>Montana
                             <option>Nebraska
                             <option>Nevada
                             <option>New Hamshire
                             <option>New Jersey
                             <option>New Mexico
                             <option>New York
                             <option>North Carolina
                             <option>North Dakota
                             <option>Ohio
                             <option>Oklahoma
                             <option>Oregon
                             <option>Pensilvania
                             <option>Rhopd Island
                             <option>South Carolina
                             <option>South Dakota
                             <option>Tennessee
                             <option>Texas
                             <option>Utah
                             <option>Vermont
                             <option>Virginia
                             <option>Washington
                             <option>West Virginia
                             <option>Wisconsin
                             <option>Wyoming
                         </select><font color=red>*</font> 
                                     
                                                                                 
                                 
                   
                 </td>
             </tr>
             <tr>
              <td align="right">Zip</td>
              <td><input type=text name=zip value="${customer.zipCode}" size=5 maxlength=5><font color="red">*</font> </td>
             </tr>
            
             <tr>
         <td></td><td><input type="button" value="Continue" onClick="validate(this.form)" align="right"></td>
             </tr>
        
        </table>
    </form>


</td>
<jsp:include page="/includes/column_right_cart.jsp" />

<jsp:include page="/includes/footer.jsp" />