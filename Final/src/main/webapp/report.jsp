<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri= "http://java.sun.com/jsp/jstl/core" %>
    <%@page import="java.io.PrintWriter , java.sql.*"%>
    
   <%Connection conn;



Class.forName("com.mysql.jdbc.Driver");
conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/fuelstaff","root","Vithya24");
String sql = "SELECT avg(totalOT),avg(totalLeave),avg(totalDaysWorked) from fuelstaff.attendance ";
Statement pst1 = conn.createStatement();
    

   ResultSet result = pst1.executeQuery(sql);

	
		
	   
   
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
  <link rel="stylesheet" href="AttendanceCSS/table.css">
</head>
<body>


	<div class="add-postion">
		<button class="btn button-view btn-act-pos">
			<a href="slipinsert.jsp" class="a" > Create Slip </a>
		
		</button>
		<form action="searchdemo.jsp" method="get">
		
		    <input type="text" name="id" id="search" class="search" name="search"
			placeholder="Type Employee ID...">
	</form>
	</div>
<table class="content-table">
<thead>
	<tr>
		<th>Average OverTime Worked</th>
		<th>Average Total Leave Taken</th>
		<th>Average Total Days Worked</th>

	</tr>
	</thead>
	<tbody>
	<%while(result.next()){ %>
	<tr>
		<td><%out.print(result.getString("avg(totalOT)")); %></td>
			<td><%out.print(result.getString("avg(totalLeave)")); %></td>
				<td><%out.print(result.getString("avg(totalDaysWorked)")); %></td>
			
	</tr>
	<%} %>
	</tbody>
</table>

</body>
</html>