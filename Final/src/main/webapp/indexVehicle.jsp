<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.io.PrintWriter , java.sql.*"%>
<!DOCTYPE html>

<%Connection conn;

session = request.getSession();
String uname = (String)session.getAttribute("uid");

Class.forName("com.mysql.jdbc.Driver");
conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/fuelstaff?characterEncoding=utf8","root","Vithya24");
String sql1 = "select userID from user where NIC = '"+uname+"'";
Statement pst2 = conn.createStatement();
ResultSet result1 = pst2.executeQuery(sql1);
String userid = "";
if(result1.next()){
	userid = result1.getString("userID");
}

String sql = "select * from vehicle where userID = '"+userid+"'";
Statement pst1 = conn.createStatement();

session.setAttribute("userID", userid);

System.out.println(userid);
	

	ResultSet result = pst1.executeQuery(sql); 
	%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Vehicle Management DashBoard</title>


 
  <link rel="stylesheet"
    href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
    integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
    crossorigin="anonymous">
     
	<style>
     	<%@ include file="assetsVehicle/CSS/dashboard.css"%>
	</style>

  
</head>
<body style="background-color:#2980b9;">
   <header>
        <nav class="navbar navbar-expand-md navbar-dark text-center"
            style="background-color: #00008B; text-align:center;">
     			<h1 class="text-center wow fadeInUp" style="color:white;">Vehicle Management</h1>
        </nav>
    </header>
    
	<div class="header-top">
    <a href="#" class="head-a btn button-view">Home</a>
    <a href="#contactus" class="head-a btn button-view">Contact Us</a>
    <a href="#aboutus" class="head-a btn button-view">About Us</a>
  </div>

<div class="add-postion">
	<button class="btn button-view btn-act-pos"><a href="VMS-CR.jsp" class="a">Add Vehicle</a></button>
	<form action="SearchVehicle.jsp" method="get">
	<input type="text" name="key" id="search" class="search " name="search" placeholder="search vehicle..." autocomplete="off">
	
</form>
</div>

<form>
<table class="content-table" >
<thead>
	<tr>
		<th>Plate Number</th>
		<th>Actions</th>
	</tr>
</thead>
<tbody>
		<%
			while (result.next()){
				%>
				
				<tr>
				
				 <td><%out.print(result.getString("plateNumber")); %>  </td>  
				
					<td> &nbsp;&nbsp; <button class="button button-view "><a class="a" href="VMS-Vw.jsp?np=<%out.print(result.getString("plateNumber"));%>"> View</a></button>
					
						&nbsp;&nbsp; <button class="button button-edit "><a class="a" href="VMS-ED.jsp?np=<%out.print(result.getString("plateNumber"));%>"> Edit</a></button>
						
						 &nbsp;&nbsp; <button class="button button-delete"><a class="a" href="VMS-DEL.jsp?np=<%out.print(result.getString("plateNumber"));%>" onclick="return confirm('Are you sure want to delete vehicle <% out.print(result.getString("plateNumber"));  %>?')" id="link"> Delete</a></button>
					</td>		
				</tr>
				
				
				<%
			}
		
		%>	
	</tbody>	
	</table>
</form>
</body>
<script type="text/javascript" src = "assetsVehicle/JS/validations.js"></script>
</html>