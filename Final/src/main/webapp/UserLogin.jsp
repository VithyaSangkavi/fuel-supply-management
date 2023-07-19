<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Login</title>
<!--  <link rel="stylesheet" href="Assets/CSS/Userlogin.css">-->
<style>
     <%@ include file="Assets/CSS/Userlogin.css"%>
</style>
</head>
<body>
<div class="center">
	<form action="LoginServlet" method="post">
	<h3>Login</h3>
		<div class="text_field">
		
			<input type="text" name="username" required/>
			<span></span>
			<label>Username</label>
			
		</div>
		
		<div class="text_field">
			<input type="password" name="pswd" required/>
			<span></span>
			<label>Password</label>
			
		</div>
		
		
		
	    <input type ="submit" name="Loginbtn" Value="Login"><br>
	    <br><br>
	    <div class="fpass">
	    	<a href="forgot1.jsp">Forgot password?</a>
	    </div>
	    <div class="signup">
	    Not a member?<a href="UserRegistration.jsp">Sign Up</a>
	    </div>
	</form>
</div>


</body>
</html>