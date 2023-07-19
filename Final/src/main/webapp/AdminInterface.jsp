<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
     <%@ include file="css/style.css"%>
</style>
<link rel="stylesheet" href="css/style.css">

</head>
<body>
	<div class="header">
    	<a href="Home.jsp">Home</a>
    	<a href="#contactus">Contact Us</a>
    	<a href="#aboutus">About Us</a>
  	</div>
	<div class = "homediv">
	<h1>Admin Interface</h1><br>
		<div class="btnclass">
      		<a class="userbtn" href="ListStaff.jsp">Staff Management</a> <br>
      		<a class="userbtn" href="#signup">Attendance Management</a><br>
      		<a class="userbtn" href="#signup">Salary Management</a><br>
      		<a class="userbtn" href="#signup">Notice Management</a>
    	</div>
	</div>
</body>
</html>