<%@page import="com.itp.model.Staff"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.itp.service.StaffInterface"%>
<%@page import="com.itp.service.StaffInterfaceImpl"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

<link rel = "stylesheet" type = "text/css" href = "myCSS\staff.css" />
<link rel="stylesheet" href="css/style.css">

</head>
<body>

<%@include file = "Header.jsp" %>

<div class = "searchbar">
	<form action="SearchStaff.jsp" method = "post"> 
		<input type = "text" placeholder = "Enter Staff ID" name="StaffID">
		<button type = "submit"> <i class="fa fa-search" aria-hidden="true"></i> </button>
	</form>
</div>

<div class = "list">
	
	<a class="backbtn" href="AdminInterface.jsp"><i class="fa fa-arrow-left" aria-hidden="true"></i> HomePage</a>
	<table cellpadding="12">
			 <caption><h2>LIST OF STAFFS</h2> <br>
			 
			 <a id="generatebtn" href="#">Generate Monthly Report</a> 
			 <a id="bluebtn" href="RegisterStaff.jsp">Register New Staffs</a>
			 </caption>
			 
			  <tr>
	                <th>Staff ID</th>
	                <th>First Name</th>
	                <th>Last Name</th>
	                <th>NIC</th>
	                <th>Address</th>
	                <th>Email</th>
	                <th>Account No</th>
	                <!-- <th>Password</th> -->
	                <th>Staff Type</th>
	                <th>Contract Years</th>
	                <th>Basic Salary</th>
	                <th>OT/h</th>
	                <th>Select</th>
	            </tr>
	            <%
	            StaffInterface iss = new StaffInterfaceImpl();
				ArrayList<Staff> arrayList = iss.getStaffs();
				
				for(Staff s1 : arrayList){
				%>
				 <tr>
					<td> <%=s1.getStaffID() %> </td>
					<td> <%=s1.getFirstName() %> </td>
					<td> <%=s1.getLastName() %> </td>
					<td> <%=s1.getNIC() %> </td>
					<td> <%=s1.getAddress() %> </td>
					<td> <%=s1.getEmail() %> </td>
					<td> <%=s1.getAccNo() %> </td>
					<!-- <td> <%=s1.getPassword() %> </td> -->
					<td> <%=s1.getStaffType() %> </td>
					<td> <%=s1.getContactYears() %> </td>
					<td> <%=s1.getBasicSalary() %> </td>
					<td> <%=s1.getOt() %> </td>	
					<td> 
					<form method="POST" action="GetStaff">
					<input type="hidden" name="StaffID" value="<%=s1.getStaffID()%>"/>
					<input type="submit" value= "Select Staff" /> 
					</form>
					</td>	
					</tr>			
				<%	
				   }
	            %>     
	</table>

</div>
</body>
</html>