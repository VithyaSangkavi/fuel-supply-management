<%@ page import = "java.util.Date" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="myCSS/staff.css">
<link rel="stylesheet" href="css/style.css">

<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<script type="text/javascript" defer src="Script.js"></script>

</head>
<body>

<div class="staffreg">

	<a class="crossbtn" href="ListStaff.jsp"><i class="fa fa-times" aria-hidden="true"></i></a>
	
	<form method="POST" action= "<%= request.getContextPath() %>/RegisterStaff" onsubmit="return validateForm();">
	  		<center><h2> STAFF MANAGEMENT </h2></center>
	  		
	  		<br>
	  		
		    <table>

			<tr>
				<td>First Name</td>
				<td><input id="fname" type="text" name="FirstName" onkeyup="validateFName()"/></td>
			</tr>
			<tr>
				<td>Last Name</td>
				<td><input id="lname" type="text" name="LastName" onkeyup="validateLName()"/></td>
			</tr>
			<tr>
				<td>NIC</td>
				<td><input id="nic" type="text" name="NIC" onkeyup="validateNIC()"/></td>
			</tr>
			<tr>
				<td>Address</td>
				<td><textarea id="address" name="Address" onkeyup="validateAddress()"></textarea> </td>
			</tr>
			<tr>
				<td>Email</td>
				<td><input id="email" type="text" name="Email" onkeyup="validateEmail()"/></td>
			</tr>
			<tr>
				<td>Account No</td>
				<td><input id="accno" type="text" name="AccNo" onkeyup="validateAccNo()"/></td>
			</tr>
			<tr>
				<td>Staff Type</td>
				<td>
				<input id="stafftype" type="text" name="StaffType" onkeyup="validateSType()"/>
					<!--  <select>
						<option> Permanent </option>
						<option> Contract Basis</option>
					</select> -->
				</td>
			</tr>
			<tr>
				<td id="cyears1">Contract Years</td>
				<td><input id="cyears" type="text" name="ContactYears" onkeyup="validateYears()" value="0"/></td>
			</tr>
			<tr>
				<td>Basic Salary</td>
				<td><input id="salary" type="text" name="BasicSalary" onkeyup="validateSalary()"/></td>
			</tr>
			<tr>
				<td>OT Rate/h</td>
				<td><input id="ot" type="text" name="Ot" onkeyup="validateOT()"/></td>
			</tr>

			<tr>
				<td colspan="2"><input type="submit" value="Register Staff" /> </td>
			</tr>
			<tr>
				<td colspan="2"><input type="reset" id="redbtn" value="Reset" /></td>
			</tr>
		</table>
	</form>
	</div>

</body>
</html>