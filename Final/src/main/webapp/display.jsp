<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<%@page import="java.io.PrintWriter , java.sql.*"%>
	
<html>
<head>
<title>User Management Application</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
</head>
<body>

<%Connection conn;
ResultSet result=null;
String sid = request.getParameter("sid");
Class.forName("com.mysql.jdbc.Driver");
conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/fuelstaff","root","Vithya24");
String sql = "select * from staff where StaffID = '"+sid+"'";
Statement pst1 = conn.createStatement();
    
//session.setAttribute("name",uname );




        



   result = pst1.executeQuery(sql);



   
    %>    



	<header>
		<nav class="navbar navbar-expand-md navbar-dark"
			style="background-color: Green">
			<div>
				<a href="https://www.javaguides.net" class="navbar-brand"> SALARY </a>
			</div>

			<ul class="navbar-nav">
				<li><a href="<%=request.getContextPath()%>/list"
					class="nav-link">Users</a></li>
			</ul>
		</nav>
	</header>
	<br>

	<div class="row">
		<!-- <div class="alert alert-success" *ngIf='message'>{{message}}</div> -->

		<div class="container">
			<h3 class="text-center">Selected Salary Detail</h3>
			<hr>
			<div class="container text-left">

				<a href="<%=request.getContextPath()%>/new" class="btn btn-success" > Create </a>
			</div>
			<br>
			<table class="table table-bordered">
				<thead>
					<tr>
						<th>ID</th>
						<th>FirstName</th>
						<th>LastName</th>
						<th>AccountNumber</th>
						<th>StaffType</th>
						<th>BasicSalary</th>
					
					</tr>
				</thead>
				<tbody>
					<!--   for (Todo todo: todos) {  -->
					 <%
	           	 if (result.next()){

				%>

						<tr>
							<td><%out.print(result.getString("StaffID")); %></td>
							<td><%out.print(result.getString("FirstName")); %></td>
							<td><%out.print(result.getString("LastName")); %></td>
							<td><%out.print(result.getString("AccNo")); %></td>
							<td><%out.print(result.getString("StaffType")); %></td>
							<td><%out.print(result.getString("BasicSalary")); %></td> 
						</tr>
						 <%
	           	 }
				%>
					
					<!-- } -->
				</tbody>

			</table>
		</div>
	</div>
</body>
</html>