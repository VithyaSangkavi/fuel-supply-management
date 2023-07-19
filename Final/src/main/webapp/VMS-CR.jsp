<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.io.PrintWriter , java.sql.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Your Vehicle</title>
	
	<style>
     	
     	<%@ include file="assetsVehicle/CSS/CR-CSS.css"%>
	</style>
	
	<script>
		<%@ include file="assetsVehicle/JS/validate.js"%>
		<%@ include file="assetsVehicle/JS/create.js"%>
	</script>
	
</head>
<%
Connection conn;

Class.forName("com.mysql.jdbc.Driver");
conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/fuelstaff","root","Vithya24");
PreparedStatement pst = conn.prepareStatement("select * from fuel_Type");

ResultSet result = pst.executeQuery();

%>
<body style="background-color:#2980b9;">

	<div class="page-section">
    <div class="container">
    <h1 class="text-center wow fadeInUp" style="color:white">Register Your Vehicle</h1>
      <form class="main-form" action="servlet" method="post">
        <div class="row mt-5">
          <div class="col-12 col-sm-6 py-2 wow fadeInLeft">
          	<h5 class = "text-left wow fadeInUp" style="color:white">Chassis Number</h5>
            <input type="text" class="form-control"  id="CN" placeholder="Chassis Number ..." name="cNumber" maxlength="17"required> 
          </div>
          <div class="col-12 col-sm-6 py-2 wow fadeInRight">
          <h5 class = "text-right wow fadeInUp" style="color:white">Plate Number</h5>
            	<input type="text" class="form-control" id="NoPl" placeholder="Plate Number ..." name="pNumber" title="Plate Number should be ex:'AB ABC 1234'" maxlength="11"required>
          </div>
          <div class="col-12 py-2 wow fadeInUp" data-wow-delay="300ms">
          <h5 class = "text-center wow fadeInUp" style="color:white">Vehicle Type</h5>
            <select id="vType" name="vType" class="custom-select" onchange="ddlist()"  >

                            <option disabled selected>Select Vehicle</option>
                            <option value="van">Van</option>
                            <option value="car">Car</option>
                            <option value="bike">Motor Bike</option>
                            <option value="3wheeler">Three Wheeler</option>
                            <option value="bus">Bus</option>
                            <option value="lorry">Lorry</option>

                           </select>
          </div>
          <div class="col-12 col-sm-6 py-2 wow fadeInLeft">
          	<h5 class = "text-left wow fadeInUp" style="color:white">Fuel Limit</h5>
			<input type="text" class="form-control" placeholder="Fuel Limit ..." readonly name = "fLimit" id="fLimit">

            
          </div>
          <div class="col-12 col-sm-6 py-2 wow fadeInRight">
          <h5 class = "text-right wow fadeInUp" style="color:white">Created Date</h5>
            <input type = "date" class="form-control" id = "date" name = "date" autocomplete="off" name="date" required>
          </div>
          <div class="col-12 py-2 wow fadeInUp" data-wow-delay="300ms">
          <h5 class = "text-center wow fadeInUp" style="color:white">Fuel Type</h5>
            	<select id="fuelType" name="fType" class="custom-select" required >
							<option disabled selected>Select Fuel Type</option>
							<% while(result.next()){ %>
                            
                            
                            <option value="<%=result.getString("fuelID") %>"><%=result.getString("FuelType") %></option>
                          <%} %>

               </select>
               
          </div>
          
        </div>
       <div class = "login_Btn">
        
      	<button name="action" class="btn col-12 btn-primary mt-3 wow zoomIn"value="register"onclick="return validate()">Register</button>
      	
      	
      	<a href = "index.jsp" class="btn col-12 btn-outline-accent  mt-3 wow zoomIn">Cancel</a>
      	
      	</div>
      	</form>
      	</div>
      	</div>
	
</body>

    <script type="text/javascript" src = "assetsVehicle/JS/create.js"></script>
    <script type="text/javascript" src = "assetsVehicle/JS/validate.js"></script>

    <link href="https://code.jquery.com/ui/jquery-ui-git.css" rel="stylesheet" type="text/css" />
    <script src="https://code.jquery.com/jquery-git.js"></script>
    <script src="https://code.jquery.com/ui/jquery-ui-git.js"></script>


</html>