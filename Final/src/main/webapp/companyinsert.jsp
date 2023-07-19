<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
     <%@ include file="essentialservicesCSS/mystyles.css"%>
</style>
</head>
<body>
<div class="formdiv">

	<h1>Enter Your Company Details</h1>
	<form action="insert" method="post">
	<table>
		<tr>
			<td>Company Name</td>
			<td><input type="text" name="Cname"></td>
		</tr>
		<tr>
			<td>Manager First Name</td>
			<td><input type="text" name="fName"></td>
		</tr>
		<tr>
			<td>Manager Last Name</td>
			<td><input type="text" name="lName"></td>
		</tr>
		<tr>
			<td>Service Type</td>
			<td><input type="text" name="type"></td>
		</tr>
		<tr>
			<td>Reason</td>
			<td><input type="text" name="reason"></td>
		</tr>
		<tr>
			<td>Address</td>
			<td><input type="text" name="address"></td>
		</tr>
		<tr>
			<td>Email</td>
			<td><input type="text" name="email"></td>
		</tr>
		<tr>
			<td>Fuel Limit</td>
			<td><input type="text" name="limit"></td>
		</tr>
		<tr>
			<td>Letter</td>
			<td><input type="text" name="letter"></td>
		</tr>
		<tr>
			<td>password</td>
			<td><input type="password" name="password"></td>
		</tr>	
	</table>
	<br>
		<input type="submit" name="submit" value="Create Company">
	</form>
</div>
</body>
</html>