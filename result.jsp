<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%-- 
 From a servlet  to obtain a list containing the item's info
 then show the result in this page
 --%>
 <form action="">
 <table align="center" border="1" width="500px">
 <tr>
 	<th>&nbsp;</th>
 	<th>Name</th>
 	<th>Price</th>
 	<th>Quantity</th>
 </tr>
<c:forEach items="${ }" var="i" varStatus="">
<tr>
<td><input  type="checkbox" name="id" id=${i.id}></td>
<td>shirt</td>
<td>100</td>
<td align="center"><input type="text" value="1" size="3" name="qty"/></td>
</tr>
</c:forEach>



</table>

<input type="submit" value="confirm">
<input type="reset" value="Reset">
</form>
</body>
</html>