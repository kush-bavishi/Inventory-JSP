<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<link href="./style1.css" type="text/css"
			rel="stylesheet" />
			
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
</head>
<body>
<%
if(request.getAttribute("result2") != null)
{
	
%>

<h4><%=request.getAttribute("result2") + " "%>users registered successfully.</h4>

<%

}
%>
<div id="lgbutton">
		
	<a href="Register.jsp">Register</a>
		
</div>
<form id="Lform" method="post" action="LoginController" >


			<input placeholder="Email" type="text" name="user" ></input>
			<br></br>
			<input placeholder="Password" type="password" name="pass" ></input>
			<br></br>
			<input type="submit" name="submit" value="Login" id="loginbtn"></input>
</form>

<%
	if(request.getAttribute("result")!=null){
%>
	<h4 style="color: #eee;
background: #A80008;
width: 400px;
margin: 0 auto;
text-align: center;
padding: 25px;
border-radius: 10px;
box-shadow: 0px 0px 5px #000;
font-family: sans-serif;"><%=request.getAttribute("result") %></h4>
<%
	}
%>
</body>
</html>