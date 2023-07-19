<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="AttendanceCSS/mystyles.css">

<style>
     <%@ include file="AttendanceCSS/mystyles.css"%>
</style>
</head>
<body>



<!-- <form action ="insert" method = "post"> -->

<!-- Total OT <input type = "text" name = "tot"><br> -->
<!-- Total Leave Taken <input type = "text" name = "tlt"><br> -->
<!-- Month <input type = "text" name = "month"><br> -->
<!-- Total Days Worked <input type = "text" name = "tdw"><br> -->
<h1 ><center>Attendance Management</center></h1>
<div class="formdiv">

      <form action="employeeinsert" method = "post">
     <h2> Create Slip</h2>
     
     
     <table>

			<tr>
				<td> Employee ID</td>
				<td><input type="text" name = "sid" placeholder="Enter ID" required></td>
			</tr>
			<tr>
				<td>Total Over Time</td>
				<td><input type="text" name = "tot" placeholder="Twenty (*h)" required></td>
			</tr>
			<tr>
				<td>Total Leave Taken</td>
				<td><input type="text" name = "tlt" placeholder="Enter Days in Words(*)" required></td>
			</tr>
			
			<tr>
			<td>Month</td>
			<td><select name = "month" required>
            <option value = "january">January</option>
            <option value = "february">February</option>
            <option value = "march">March</option>
            <option value = "april">April</option>
            <option value = "may">May</option>
            <option value = "june">June</option>
            <option value = "july">July</option>
            <option value = "August">August</option>
            <option value = "september">September</option>
            <option value = "october">October</option>
            <option value = "november">November</option>
            <option value = "december">December</option>
            </select></td>
            </tr>
			<tr>
				<td>Total Days Worked</td>
				<td><input type="text" name = "tdw" placeholder="Days(*)" required></td>
			</tr>
			
<!--       Employee ID<input type="text" name = "sid" placeholder="enter" required> -->
         
<!--      Total Over Time<input type="text" name = "tot" placeholder="Twenty 20h" required><br> -->
<!--         Total Leave Taken<input type="text" name = "tlt" placeholder="Enter Days in Words(*)" required> -->
<!--           Month<select name = "month" required> -->
<!--             <option value = "january">January</option> -->
<!--             <option value = "febrary">February</option> -->
<!--             <option value = "january">March</option> -->
<!--             <option value = "january">April</option> -->
<!--             <option value = "january">May</option> -->
<!--             <option value = "january">June</option> -->
<!--             <option value = "january">July</option> -->
<!--             <option value = "january">August</option> -->
<!--             <option value = "january">September</option> -->
<!--             <option value = "january">October</option> -->
<!--             <option value = "january">November</option> -->
<!--             <option value = "january">December</option> -->
<!--             </select> -->
<!--           Total Days Worked<input type="text" name = "tdw" placeholder="Enter Date" required> -->
            
<tr>
<td colspan="2"><input type="submit" name="submit" value="Create Slip"> </td>
</tr>
 </table>
      </form>
    </div>

</body>
</html>