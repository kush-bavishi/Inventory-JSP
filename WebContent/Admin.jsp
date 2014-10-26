<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Administrator</title>
<link href="style1.css" type="text/css"
			rel="stylesheet" />
</head>
<body>

<%
if(session.getAttribute("user")==null)
	response.sendRedirect("Login.jsp");
else if(session.getAttribute("user").equals("User"))
	response.sendRedirect("Home.jsp");
else
{
	if(request.getParameter("opt") != null && request.getParameter("opt").equals("add"))
	{
		
%>

<form action="FileUploadController" method="post" enctype="multipart/form-data">
	<pre>
		Enter the id:		<input type="text" name="id"></input>
		Enter the name:		<input type="text" name="name"></input>
		Enter the manufacturer:	<input type="text" name="manu"></input>
		Enter the type:		<input type="text" name="type"></input>
		Enter the description:	<input type="text" name="desc"></input>
		Enter the quantity:	<input type="text" name="quan"></input>
		Enter the color:	<input type="text" name="color"></input>
		Enter the price:	<input type="text" name="price"></input>
		Enter the image:	<input type="file" name="img"></input>
		<input type="submit" name="submit" value="Submit"></input>
	</pre>
</form>
<!-- <div class="adminlist"> -->
<ul id="adminlist" style="background: #555555;
padding: 25px 20px 25px 20px;
text-align: center;
width: 300px;
margin: 120px auto;
border-radius: 15px;
box-shadow: 0px 0px 5px #000;
font-family: sans-serif;">
<%
	}
	else
	{
%>
<ul class="ca-menu" id="adminlist" style="background: #555555;
padding: 25px 20px 25px 20px;
text-align: center;
width: 300px;
margin: 120px auto;
border-radius: 15px;
box-shadow: 0px 0px 5px #000;
font-family: sans-serif;">
<li class="ca-main"><a href="Admin.jsp?opt=add">Add Item</a></li>
<%
	}
%>
<li class="ca-main"><a href="ItemController?opt=view">View All Items</a></li>

<li class="ca-main"><a href="Register.jsp">Register New Admin</a></li>

<li class="ca-main"><a href="LoginController">Logout</a></li>
</ul>
<!-- </div> -->

<%
}
%>

</body>
</html>