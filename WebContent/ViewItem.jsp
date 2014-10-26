<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@page import="com.kush.model.entity.Item"%>
<%@page import="com.kush.model.dao.ItemCRUD"%>
<%@page import="java.io.File"%><html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View Item</title>
<link href="style1.css" type="text/css"
			rel="stylesheet" />
</head>
<body>

<div class="navbar-main">
<ul>
	<li class="navbar"><a href="Home.jsp">Home</a></li>
	<li class="navbar"><a href="#">About</a></li>
	<li class="navbar"><a href="#">Contact Us</a></li>
</ul>
</div>

<%
	Item item=(Item)request.getAttribute("Item");
	System.out.println("File name: "+request.getAttribute("FileName"));
%>
<table id="details">
<tr>
<td><b>Name</b></td>
<td><%=item.getItemName() %></td>
</tr>
<tr>
<td><b>Manufacturer</b></td>
<td><%=item.getItemManufacturer() %> </td>
</tr>
<tr>
<td><b>Description</b></td>
<td><%=item.getItemDescription() %></td>
</tr>
<tr>
<td><b>Quantity</b></td>
<td><%=item.getItemQuantity() %></td>
</tr>
<tr>
<td><b>Color</b></td>
<td><%=item.getItemColor() %></td>
</tr>
<tr>
<td><b>Price</b></td>
<td>Rs.<%=item.getItemPrice() %></td>
</tr>
</table>
<div id="image">
<img width="300px" height="200px" alt="Unable to Open Image" src="<%=(String)request.getAttribute("FileName") %>">
</div>
<%
if(session.getAttribute("user").equals("Admin"))
{
%>
<form action="ItemController" method="post">
<input type="hidden" name="itemId" value="<%=item.getItemId() %>"></input>
<input type="submit" name="delete" value="Delete"></input>
</form>
<%
}
%>

<ul class="ca-menu">
<li>
	<a href="ItemController?opt=view">
		<div class="ca-content">
			<h2 style="margin-left: 60px; line-height: 51px;" class="ca-main">Browse</h2>
		</div>
	</a>
</li>
</ul>

<form id="Sform" action="ItemController" method="post">
	
		<input type="text" name="query"/>
		<input type="submit" name="search" value="Search"/>
	
</form>

</body>
</html>