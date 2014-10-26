<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE HTML">
<html>
<head>
<title>Home</title>
		<link href="style1.css" type="text/css"
			rel="stylesheet" />
		<meta name="description"
			  content="E-commerce website"/>
		<meta name="keywords"
			content="E-commerce, India, Buy, Electronics"/>
		<meta name="robots" 
			content="index, follow">
		<meta name="copyright" 
			content="Kush Bavishi">
		<meta http-equiv="author" 
			content="Kush Bavishi">
		<meta name="email" 
			content="kush.bavishi@gmail.com">
		<meta http-equiv="pragma"
			content="no-cache" />
</head>
<body>
<%
if(session.getAttribute("user")==null)
	response.sendRedirect("Login.jsp");
else if(session.getAttribute("user").equals("Admin"))
	response.sendRedirect("Admin.jsp");
else
{
%>


<div id="welcome">
<h1>Welcome!</h1>
</div>
<div class="navbar-main">
<ul>
	<li class="navbar"><a href="Home.jsp">Home</a></li>
	<li class="navbar"><a href="#">About</a></li>
	<li class="navbar"><a href="#">Contact Us</a></li>
</ul>
</div>

<ul class="ca-menu">
<% 
if(request.getParameter("opt")==null)
{
%>
<li>
	<a href="Home.jsp?opt=search">
    	<div class="ca-content">
        	<h2 style="margin-left: 60px; line-height: 51px;" class="ca-main">Search</h2>
        </div>
    </a>
</li>
<%
}
%>


<li>
	<a href="ItemController?opt=view">
		<div class="ca-content">
			<h2 style="margin-left: 60px; line-height: 51px;" class="ca-main">Browse</h2>
		</div>
	</a>
</li>
<li>
	<a href="LoginController">
		<div class="ca-content">
			<h2 style="margin-left: 60px; line-height: 51px;" class="ca-main">Logout</h2>
		</div>
	</a>
</li>    
</ul>

<%
if(request.getParameter("opt") != null && request.getParameter("opt").equals("search"))
{
%>

<div >
<form id="Sform" action="ItemController" method="post">
<input type="text" name="query"/>
<input id="btn" type="submit" name="search" value="Search"/>
</form>
</div>
<%
}
%>

<%
}
%>
</body>
</html>