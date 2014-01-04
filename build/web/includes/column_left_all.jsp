<%-- 
    Document   : column_left_product
    Created on : Dec 9, 2009, 11:09:37 AM
    Author     : HP_Owner
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">


<td class="leftcolumn"><br><br>
    <a href="/OnlineShopper2/"><p>Home</a><br><br>
    <a href="catalogofitems">Catalog of Works</a><br><br>  
    <a href="quickorder">Quick Order</a><br><br> 
    <a href="artists" >Artists</a><br><br>
     
    <form action= "arttype" class="colon" >
       <select name=arttype>
            <option>paintings</option>
            <option>pastel</option>
            <option>drawings</option>
            <option>posters</option>
            <option>art_for_kids</option>
            <option>craft</option>
            <option>photography</option>
       </select>
       <input type =submit name="worktype" value=" Submit"  >
   </form>
          
 </td>