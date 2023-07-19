<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.io.PrintWriter , java.sql.*"%>
<!DOCTYPE html>
<%Connection conn;



	Class.forName("com.mysql.cj.jdbc.Driver");
	conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/fuelstaff?","root","Vithya24");
	String np = request.getParameter("np");
	session.setAttribute("np",np);
	PreparedStatement pst1 = conn.prepareStatement("select * from vehicle where plateNumber = ?");
	pst1.setString(1, np);
	

	ResultSet result = pst1.executeQuery(); 
	String cNo="";
	String pNo ="";
	String vType ="";
	String FType ="";
	String FLimit ="";
	String date = "";
	String rfuel="";
	String status = "";
	
				if(result.next()){
				 cNo = result.getString("chassisNumber");
				 pNo = result.getString("plateNumber");
				 vType= result.getString("vehicleType");
				 FType = result.getString("fuelID");
				 FLimit = result.getString("fuelLimit");
				 date = result.getString("updatedDate");
				 rfuel = result.getString("remainingFuel");
				 status = result.getString("status");
			}
			
	PreparedStatement pst2 = conn.prepareStatement("select * from fuel_type where fuelID = ?");
	pst2.setString(1, FType);	
	
	ResultSet result1 = pst2.executeQuery(); 
	String fuelType = "";
	
		if(result1.next()){
			fuelType = result1.getString("FuelType");
		}
				
	%>
<html>
<head>
<link rel="stylesheet" type="text/css" href="assets/CSS/popUP.css">
<meta charset="ISO-8859-1">
<title>Your (<% out.println(pNo); %>) Vehicle Details</title>
	
	<style>
     	<%@ include file="assetsVehicle/CSS/popUP.css"%>
     	<%@ include file="assetsVehicle/CSS/CR-CSS.css"%>
	</style>
	
	<script>
		<%@ include file="assetsVehicle/JS/checkNew.js"%>
		<%@ include file="assetsVehicle/JS/view.js"%>
		<%@ include file="assetsVehicle/JS/qrcode.min.js"%>
		<%@ include file="assetsVehicle/JS/newQR.js"%>
	</script>
	
</head>
<body style="background-color:#2980b9;">


<div class="page-section">
    <div class="container">
    <h1 class="text-center wow fadeInUp" style="color:white">Your (<% out.println(pNo); %>) Vehicle Details</h1>
      <form class="main-form" action="view" method="post">
        <div class="row mt-5 ">
          <div class="col-12 col-sm-6 py-2 wow fadeInLeft">
          	<h5 class = "text-left wow fadeInUp" style="color:white">Chassis Number</h5>
            <input type="text" class="form-control"  id="CN" placeholder="Chassis Number ..."  name="cNumber" value="<% out.println(cNo); %>" required readonly> 
          </div>
          <div class="col-12 col-sm-6 py-2 wow fadeInRight">
          <h5 class = "text-right wow fadeInUp" style="color:white">Plate Number</h5>
            	<input type="text" class="form-control" id="pNo" placeholder="Plate Number ..." value="<% out.println(pNo); %>" readonly  name="pNumber"  title="Plate Number should be ex:'AB ABC 1234'" required>
          </div>
             <div class="col-12 col-sm-6 py-2 wow fadeInLeft">
          	<h5 class = "text-left wow fadeInUp" style="color:white">Vehicle Type</h5>
            <input type="text" class="form-control"  id="vType" placeholder="Chassis Number ..."  name="cNumber" value="<% out.println(vType); %>" required readonly> 
          </div>
          <div class="col-12 col-sm-6 py-2 wow fadeInRight">
          <h5 class = "text-right wow fadeInUp" style="color:white">Fuel Type</h5>
            	<input type="text" class="form-control" id="fType" placeholder="Plate Number ..." value="<% out.println(fuelType); %>" readonly  name="pNumber"  title="Plate Number should be ex:'AB ABC 1234'" required>
          </div>
    	     <div class="col-12 col-sm-6 py-2 wow fadeInLeft">
          	<h5 class = "text-left wow fadeInUp" style="color:white">Fuel Limit</h5>
            <input type="text" class="form-control"  id="limit" name="fLimit" placeholder="Chassis Number ..."  value="<% out.println(FLimit); %>" required readonly> 
          </div>
          <div class="col-12 col-sm-6 py-2 wow fadeInRight">
          <h5 class = "text-right wow fadeInUp" style="color:white">Updated Date</h5>
            	<input type="text" class="form-control" id="date" placeholder="Plate Number ..." value="<% out.println(date); %>" readonly  name="pNumber"  title="Plate Number should be ex:'AB ABC 1234'" required>
          </div>
          
       	   <div class="col-12 py-2 wow fadeInUp" data-wow-delay="300ms">
          <h5 class = "text-center wow fadeInUp" style="color:white">Remaining Fuel</h5>
       			<input type="text" class="form-control" placeholder="Vehicle Type ..." readonly value="<% out.println(rfuel); %>" name="rfuel" readonly id="remain">
          </div>
          <div class="col-12 col-sm-6 py-2 wow fadeInLeft">
          	<h5 class = "text-left wow fadeInUp" style="color:white">Needed Fuel</h5>
            <input type="text" class="form-control"  id="need" placeholder="Enter Needed Fuel ..."  > 
          </div>
          
          <div class="col-12 col-sm-6 py-2 wow fadeInRight">
          			<input type = "button" value = "Check" class="btn btn-primary mt-3N wow zoomIn form-control btmButton"  id = "chktime" onclick="chkFuel()">
          </div>
          	<input type="hidden" value="<% out.println(status); %>" name="status" id="status">
	
		        <div class="popup" id="popup-1">
    			        <div class="overlay"></div>
                <div class="content">
                    <div class="close-btn" onclick="generateqr()">&times;</div>
                    <h1>Scan this QR Code</h1>
                        <div id="qrcode" style="position:absolute ; right:50% ;left:21%"></div>
                </div>
        </div>
        
		   <div class="col-12 col-sm-6 py-2 wow fadeInLeft">
					<button name = "action" value="renew" class="btn btn-primary mt-3 wow zoomIn form-control btmButton" onclick="chkTime()">Make Renew Request</button>          
			</div>
			<div class="col-12 col-sm-6 py-2 wow fadeInRight">
					<input type = "button" value = "Generate QR Code" class="btn btn-primary mt-3 wow zoomIn form-control btmButton" id = "myBTN" onclick="generateqr()" disabled>
          </div>
     
          
        </div>
       <div class = "login_Btn">
        
      	<button name="action" class="btn col-12 btn-primary mt-3 wow zoomIn" value="finish" id="finish" disabled>Finish</button>
      	
      	<a href = "indexVehicle.jsp" id="back" class="btn col-12 btn-outline-accent  mt-3 wow zoomIn">Back</a>
      	
      	</div>
      	</form>
      	</div>
      	</div>

</body>
<script type="text/javascript">
 
</script>
		
</html>