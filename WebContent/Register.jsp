<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="style1.css" type="text/css"
			rel="stylesheet" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registration</title>
</head>
<body>

<%
String role = "";
if(session.getAttribute("user")!=null && session.getAttribute("user").equals("Admin"))
{
	role = "Admin";
}
else
{
	role = "User";
}
%>

<form id="Lform" action="LoginController" method="post">
	<pre>
Enter email:	<input type="text" name="email"></input>
Enter password:	<input type="password" name="pass"></input>
Enter phone:	<input type="text" name="phone"></input>
Enter Address:	<input type="text" name="addr"></input>
<input type="hidden" name="role" value="<%=role %>"></input>
<input type="submit" name="submit" value="Register"></input>
	</pre>
</form>

</body>
</html>