<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Store Login Page</title>
</head>
<body>
<BR/><BR/>

	<form method = "post" action = "login">
	<p align="center">
	Login Page
	<label>Email as Username:</label><input type="email" name = "user_email" placeholder="Enter your email"/><BR/><BR/>
	<label>Password:</label><input type= "password" name="pass" placeholder = "Enter your password"/><BR/><BR/>
	<input type = "hidden" name  = "tryLogin" value = "login"/>
	
	<input type = "submit" value="Login"/> <br/>
	
	<font color="red"><c:out value="${error}"/></font>
	
	</p>
	</form>
	
<p align="center">
        <br/><br/>
		Welcome to XYZ corporation  <font color="blue"><c:out value="${user.userId}"/> </font> <BR/><BR/>
		<font color="green" size="12"><b>Earth is a crowded place, are you ready to go to Mars!! </b> </font>
    </p>
	

</body>
</html>

