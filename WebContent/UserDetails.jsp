 <%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style>
  body{
	background-color:#a2f5df;
	
	}
	
	.button1{
			padding: 1.3em 3em;
  			font-size: 8px;
  			text-transform: uppercase;
  			letter-spacing: 2.5px;
  			font-weight: 500;
  			color: #000;
  			background-color: #fff;
  			border: none;
  			border-radius: 45px;
  			box-shadow: 0px 8px 15px rgba(0, 0, 0, 0.1);
  			transition: all 0.3s ease 0s;
  			cursor: pointer;
  		    outline: none;
		}	
		.button1:hover {
         background-color: #23c483;
  		box-shadow: 0px 15px 20px rgba(46, 229, 157, 0.4);
  		color: #fff;
  		transform: translateY(-7px);
        }
        .button1:active {
  		transform: translateY(-1px);
		}
		#button2{
		margin-left:15px;
		}
</style>
</head>
<body>
		<center>
			<form action="./ThankServlet" method="post">
				<b>Customer Name :</b> <input type="text" name="Cname"><br><br>
				<b>Address       :</b> <input type="text" name="Add"><br><br>
				<b>Phone No 	 :</b> <input type="text" name="PhNo"><br><br>
				
				<h3>Your Order Details</h3>
				
				<%
				ResultSet r=(ResultSet)session.getAttribute("UserResultSet");
				r.next();
				String Bookid=r.getString("Books_Id");
				String BookName=r.getString("Book_Name");
				String Auth=r.getString("Author");
				int Price=r.getInt("Price");
				%>
				<b>Order Id  :</b><% out.println(session.getAttribute("random")); %><br><br>
				<b>Book Name :</b><% out.println(BookName);%><br><br>
				<b>Author    :</b><% out.println(Auth);%><br><br>
				<b>Price     :</b><% out.print(Price);%><br><br>
				<b>Quantity  :</b><%
				int qnt =(int)session.getAttribute("qnt");
				out.print(qnt);
				%><br><br>
				
				<b>Total Price :</b> <% out.println(Price*qnt); %><br><br>
				
				<input class="button1" type="submit" value="Confirm" name="UserButton">
				<input class="button1" id="button2" type="submit" value="Cancel"  name="UserBotton">
			
			</form>
		</center>

</body>
</html>