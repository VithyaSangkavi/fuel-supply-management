<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<!-- <link rel="stylesheet" href="Assets/CSS/forgotpass1.css">-->
<!-- <script type="text/javascript" defer src="UserReg.js"> </script>  -->
<style>
	<%@ include file="Assets/CSS/forgotpass1.css"%>
</style>
<script>
	<%@ include file="UserReg.js"%>
</script>
</head>
<body>


	<div class="center">
	<form action="ForgotPass1" method="post">
	<h3>Forgot Password</h3>
		<div class="text_field">
			
			<input type="email" required name="email" id="em" >
			<br><br>
			<label>Email</label>
			<script>
			
				
				
				openPage = function() {
				var em = document.getElementById("em").value;
				location.href = "SendOtp2.jsp?Key="+em;
				}
			</script>
			<button type="button" class="sendotpbtn" ><a href= "javascript:openPage()" >Send OTP</a></button>
			
		</div>
		
		<div class="text_field">
			
			<input  type="text" required name="otp" id="otp">
			<br><br>
			<label>OTP</label>
			<button type="button" onclick="verifyOtp()" class="verifyotp"  >Verify OTP</button>
			
			
		</div>
		
		
		
	    <input type ="submit" name="forgotnext" Value="Next"><br>
	    <br><br>
	   
	</form>
</div>
</body>
</html>