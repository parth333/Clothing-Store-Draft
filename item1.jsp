<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="">

?????
 <!--<font color="blue"><c:out value="${items}"/> -->

	 while (<c:out value="${items}"/>.next()){
	 	String clothing = <c:out value="${items}"/>.getString("item");
	 <option value = clothing> clothing </option>

<!--
  while (rset.next()) {  // list all the authors
            String author = rset.getString("author");
            out.println("<option value='" + author + "'>" + author + "</option>");
         }
         out.println("</select><br />");
         out.println("<p>OR</p>");
-->
?????? 
Item:<select >
<option>Select...</option>
<option>shirt</option>
<option>pant</option>
<option>tie</option>

</select>
Quantity:
<!--  
<select>
	<option>0</option>
	<option>1</option>
	<option>2</option>
	<option>3</option>
</select>

-->
	
<input type='text' name='search' />	
<!--
<input type ="text" placeholder="input number">
<br><br>
-->
<input type ="submit" value="Confirm"/>
</form>
</body>
</html>
