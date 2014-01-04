<%-- 
    Document   : credit_cart
    Created on : Jan 21, 2010, 6:08:44 PM
    Author     : HP_Owner
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
   <%@ taglib prefix='c' uri="http://java.sun.com/jsp/jstl/core" %>
   
<jsp:include page="/includes/header.jsp" >
    <jsp:param name="title" value="Susan's Art Gallery" />
</jsp:include>





<td  width="100%"  bgcolor="linen"  colspan="3">
<p align="center"> <font color="#000080"  size="+1"><em>We are sory for not processing your order.<br>
    You won't be able to enter credit card information, because this is just a demo web site<br>
    
This is an example of e-commerce web site developed by the owner of "Susan's Art Gallery". 
<p>Employers or an companies, who wish to have an e-commerce web site
   for further information please visit <a href="/OnlineShopper2/author/aboutus.jsp" class=menue ><font size="+1">About Us</font> </a> or <a href="/OnlineShopper2/author/contactus.jsp" class=menue><font size="+1"> Contact US </font></a> .
   Thank you for your time.</em></font>
    <table  >
      <form action="<c:url value='/processorder' />" method=post >
          <tr>
              <td colspan="2"><h3><h3>Please Enter Your Credit Card Information</h3> 
              </td>
          </tr>
         
         <tr>
              <td>
                  Credit Card Number:
              </td>
              <td>
                  <input  type="text" size="25" name="creditcardnumber"  value="xxxxxxxxxxxx" readonly>
                  
              </td>
              
          </tr>
          <tr>
              <td>
                  Credit Card Type:
              </td>
              <td>
                  <select  name="creditcardtype" size=1 >
                      <option>Master Card
                      <option>Visa
                      <option>Discover
                      <option>American Express
                  </select>
              </td>
              </tr>
              <tr>
                  <td>
                      Credit Card Expiration (mm/yyyy) :
                  </td>
                  <td>
                      <select   name = "expirationmonth" value="">
                          <option value="01" >01
                          <option value="02" >02
                          <option value="03">03
                          <option value="04">04
                          <option value="05">05
                          <option value="06">06
                          <option value="07">07
                          <option value="08">08
                          <option value="09">09
                          <option value="10">10
                          <option value="11">11
                          <option value="12">12
                      </select> /
                      <select name="expirationyear" >
                          <c:forEach var="year" items="${creditcardyears}">
                              <option>${year}
                          </c:forEach>
                          
                      </select>
                  </td>
              </tr>
              <tr>
                  <td colspan="2">
                      <input type=submit value="Check Out" name=submit >
                  </td>
              </tr>
          
  </form>
    </table>
    

  
  <jsp:include page="/includes/footer.jsp" />
  
  
