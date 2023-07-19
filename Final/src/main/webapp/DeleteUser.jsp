<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<!--  <link rel="stylesheet" href="Assets/CSS/Userdel.css"> -->
<style>
     <%@ include file="Assets/CSS/Userdel.css"%>
</style>
</head>
<body>



<%
	String nic=request.getParameter("nic");
	String pswd=request.getParameter("pswd");
	String fname=request.getParameter("fname");
	String lname=request.getParameter("lname");
	String address=request.getParameter("address");
%>
<div class="center">
	<form action="DeleteUserServlet" method="post">
	<div class="text_field">
		NIC<input type="text" name="nic" value="<%= nic %>" readonly><br>
	</div>
	<div class="text_field">
		Password<input type="password" name="pswd" value="<%= pswd %>" readonly ><br>
	</div>
	<div class="text_field">
		First Name<input type="text" name="fname" value="<%= fname %>" readonly><br>
	</div>
	<div class="text_field">
		Last Name<input type="text" name="lname" value="<%= lname %>" readonly><br>
	</div>
	<div class="text_field">
		Address<input type="text" name="address" value="<%= address %>" readonly><br>
	</div>
		<input type="submit" name="submit" value="Delete Account"><br><br><br><br>
	</form>
</div>

</body>
</html>