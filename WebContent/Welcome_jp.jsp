<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome Page</title>
<style>


	body{
	background-color:#e3d7d5;
	
	}


</style>
</head>
<body>
	<form action="./BookServlet" method="post">
	
	<center>
		<h1>Shopping Cart For Book Store</h1>
		<h1>Welcome Page</h1>
		
	<table border="2" cellspacing="5" cellspacing="">
		<tr>
			
			<th>Book Name</th>
			<th>Author</th>
			<th>Price</th>
		</tr>
	<%
	try
	   {
		ResultSet rs=(ResultSet)session.getAttribute("resultset");
		while(rs.next())
		{
			String BookName=rs.getString("Book_Name");
			String Auth=rs.getString("Author");
			int Price=rs.getInt("Price");
			
		%>
			<tr>
			<td><a href="Book.jsp?BKID=<%= rs.getString("books_id") %>"><%= rs.getString("Book_Name") %></a></td>
			<td><%= rs.getString("Author") %></td>
			<td><%= rs.getString("Price") %></td>
			</tr>
			
	<% 		
		}
	  }
	catch(Exception e)
	{
		e.printStackTrace();
	}
	
	%>
	
	</table>
	</center>
	</form>

</body>
</html>