<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri= "http://java.sun.com/jsp/jstl/core" %>
    <%@page import="java.io.PrintWriter , java.sql.*"%>
    
   <%Connection conn;


   String key = request.getParameter("id");
Class.forName("com.mysql.jdbc.Driver");
conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/fuelstaff","root","Vithya24");
String sql = "select * from attendance where staffID = '"+key+"' ";
Statement pst1 = conn.createStatement();
    

   ResultSet result = pst1.executeQuery(sql);

	
		
	   
   
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="searchdemo.jsp" method="get">

	
		<button>
			<a href="slipinsert.jsp" > Create Slip </a>
		
		</button>
		<br>
		    <input type="text" name="id" id="search" name="search"
			placeholder="Type Employee ID...">
	</form>
<table>
	<tr>
		<th>Employee Name</th>
		<th>Actions</th>
	</tr>
	<%while(result.next()){ %>
	<tr>
		<td><%out.print(result.getString("staffID")); %></td>
		
		
			<td>
			&nbsp;&nbsp; 
				<button><a href = "testAttendance.jsp?id=<%out.print(result.getString("staffID")); %>">View</a></button>
				<button><a href = "updateslip.jsp?id=<%out.print(result.getString("staffID")); %>">Edit</a></button>
				<button><a href = "deleteslip.jsp?id=<%out.print(result.getString("staffID")); %>">Delete</a></button>
			
			</td>
		
		
	</tr>
	<%} %>
</table>

</body>
</html>