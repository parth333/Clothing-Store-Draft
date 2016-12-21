<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Register for store</title>
</head>
<body>
<BR/><BR/>


<form method = "post" action = "reg" >
	<p align = "center">

		Please register <br/><br/>
		<label>Email as User ID: </label> <input type="email" name="user_id" placeholder="Enter your email"/><BR/><BR/>
		<label>First and Last Names:</label><input type="text" name="name" placeholder="Enter first and last name"/><BR/><BR/>
		<label>User Password:</label> <input type="password" name="pass" placeholder="Enter password"/><BR/><BR/>
		
		<input type="hidden" name="tryReg" value="register"/>
		<input type="submit" value="Register"/></br>
	
	
		<font color="red"><c:out value="${error}"/> </font>
		<font color="red"><c:out value="${newRegistration}"/> </font>
	</p>

</form>
</body>
</html>