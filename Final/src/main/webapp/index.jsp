<%@page import="sal.dao.Staff"%>

<%@page import="java.util.ArrayList"%>
<%@page import="java.io.PrintWriter , java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%Connection conn;
ResultSet result=null;
Class.forName("com.mysql.jdbc.Driver");
conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/fuelstaff?autoReconnect=true&useSSL=false","root","Vithya24");
String sql = "select * from staff";
Statement pst1 = conn.createStatement();
    
//session.setAttribute("name",uname );




        



   result = pst1.executeQuery(sql);



   
    %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<!--  <link rel="stylesheet" href="mystyles.css"> -->
<style>
      <%@ include file="css/style.css"%>
     <%@ include file="myCSS/staff.css"%>
</style>

</head>
<body>
<!--  
<div class = "searchbar">
	<form action="SearchStaff.jsp" method = "post"> 
		<input type = "text" placeholder = "Enter Staff ID">
		<button type = "submit"> <i class="fa fa-search" aria-hidden="true"></i> </button>
	</form>
</div>-->

<div class = "list">
	
	<table cellpadding="12">
			 <caption><h2>LIST OF STAFF</h2> <br> <br>
			 <!-- 
			 <a id="bluebtn" href="#">Back To HomePage</a>
			 <a id="bluebtn" href="#">Register New Staff</a>
			  -->
			 </caption>
			 
			  <tr>
	                <th>Staff ID</th>
	                <th>First Name</th>
	                <th>Last Name</th>
	                <th>NIC</th>
	                <th>Address</th>
	                <th>Email</th>
	                <th>Account No</th>
	                <th>Password</th>
	                <th>Staff Type</th>
	                <th>Contract Years</th>
	                <th>Basic Salary</th>
	                <th>OT/h</th>
	                <th>Select</th>
	            </tr>
	            <%
	           	 while (result.next()){

				%>
				 <tr>
					<td> <%out.print(result.getString("StaffID")); %> </td>
					<td> <%out.print(result.getString("FirstName")); %> </td>
					<td> <%out.print(result.getString("LastName")); %> </td>
					<td> <%out.print(result.getString("NIC")); %></td>
					<td> <%out.print(result.getString("Address")); %> </td>
					<td> <%out.print(result.getString("Email")); %> </td>
					<td> <%out.print(result.getString("AccNo")); %> </td>
					<td> <%out.print(result.getString("Password")); %></td>
					<td> <%out.print(result.getString("StaffType")); %> </td>
					<td> <%out.print(result.getString("ContractYears")) ; %> </td>
					<td> <%out.print(result.getString("BasicSalary")); %>  </td>
					<td> <%out.print(result.getString("OTRate")); %> </td>	
					
					<td><a href="display.jsp?sid=<%out.print(result.getString("StaffID")); %>">Select</a>
					<input type="button"  name="select" 
					onclick="document.forms[0].action = 'display.jsp'; return true;" />
					</td>
					
					</tr>			
				<%	
					}
	            %>     
	</table>

</div>
</body>
</html>