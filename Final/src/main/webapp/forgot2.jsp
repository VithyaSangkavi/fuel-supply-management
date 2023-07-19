<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="Assets/CSS/UserRegistration.css">
<script type="text/javascript" defer src="UserReg.js"></script>
<style>
     <%@ include file="Assets/CSS/UserRegistration.css"%>
</style>
<script>
	<%@ include file="UserReg.js"%>
</script>
</head>
<body>

<%
	String nic =request.getAttribute("NIC").toString();
%>

 
	<div class="center">
	<form action="ForgotPass2" method="post">
	<h3>Forgot Password</h3>
		<div class="text_field">
		
			<input type="text" name="username" value ="<%=nic %>" readonly>
			<label>Username</label>
			
		</div>
		
		<div class="text_field">
			
			<input type="password" required name="password" id="password">
			
			<label for="password">Password</label>
		</div>
		
		<div class="text_field">
			
			<input type="password" required name="cpassword" id="cpassword">
			
			<label for="cpassword">Confirm Password</label>
			<p id="message"></p>
			<button type="button" onclick="checkpassword()" class="nextbtn">Next</button>
			
		</div>
		
		
		
	    <input type ="submit" name="Loginbtn" Value="Update"><br>
	    <br><br>
	  
	</form>
</div>

</body>
</html>