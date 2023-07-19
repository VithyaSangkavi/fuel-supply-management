<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri= "http://java.sun.com/jsp/jstl/core" %>
    <%@page import="java.io.PrintWriter , java.sql.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
 <%
 String stid = request.getParameter("id");
 
 %>
 
 <%Connection conn;



Class.forName("com.mysql.jdbc.Driver");
conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/fuelstaff","root","Vithya24");
String sql = "select * from staff where staffID = '"+stid+"'";
Statement pst1 = conn.createStatement();
String sql1 = "select * from attendance where staffID = '"+stid+"'";
Statement ps = conn.createStatement();

   ResultSet result = pst1.executeQuery(sql);
   ResultSet result1 = ps.executeQuery(sql1);
   if(result.next()){
	   
   
    %>
<body>
<table>
	<tr>
	<th>Employee ID</th>
    <th>Name</th>
    <th>Email</th>
    <th>Slip ID</th>
    <th>Total OT</th>
    <th>Total Leave</th>
    <th>Month</th>
    <th>Total Days Worked</th>
	</tr>
	
	<tr>
	 <td><%out.print(result.getString("staffID"));%></td>
    <td> <%out.print(result.getString("FirstName"));%></td>
    <td><%out.print(result.getString("email"));%></td>
    
 <%}
 if(result1.next()){
 %>
  <td><%out.print(result1.getString("attendanceID"));%></td>
   <td><%out.print(result1.getString("totalOT"));%></td>
    <td><%out.print(result1.getString("totalLeave"));%></td>
     <td><%out.print(result1.getString("month"));%></td>
      <td><%out.print(result1.getString("totalDaysWorked"));%></td>
	</tr>
	   <%} %>
</table>

<button onclick="window.print()">Print this page</button>	
</body>
</html>