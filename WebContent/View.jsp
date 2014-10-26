<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@page import="java.util.ArrayList"%>
<%@page import="com.kush.model.entity.Item"%><html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View</title>
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
if(request.getAttribute("change")!= null)
{	
%>

<h4><%=request.getAttribute("change") + " " %>record(s) modified.</h4>

<%
}
%>


<%
ArrayList<Item> list = (ArrayList<Item>) request.getAttribute("result");
if(list == null)
{
%>
	<h5>Unable to fetch list</h5>
	
<%
}
else if(list.size() == 0)
{
%>

<h5>Sorry, your search query does not meet any items. Please try different keywords.</h5>

<%
}
else
{
%>
	<table style="padding: 25px 20px 25px 20px;
margin: 20px auto;
border-radius: 15px;
box-shadow: 0px 0px 15px #000;
font-family: sans-serif;">
		<tr>
			<th class="namecol">Name</th>
			<th class="manucol">Manufacturer</th>
			<th class="quancol">Quantity</th>
			<th class="money">Price</th>			
		</tr>
		
<%
	for(Item item: list)
	{
%>

		<tr>
			<td><a href="ViewItemController?opt=<%=item.getItemId()%>"><%= item.getItemName() %></a></td>
			<td><%= item.getItemManufacturer() %></td>
			<td><%= item.getItemQuantity() %></td>
			<td> Rs.<%= item.getItemPrice() %></td>
		</tr>
<%
	}
%>
	</table>
<%
}
%>

<form id="Sform" action="ItemController" method="post">
	
		<input type="text" name="query"/>
		
		<input id="btn" type="submit" name="search" value="Search"/>
	
</form>

</body>
</html>