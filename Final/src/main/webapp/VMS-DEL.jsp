<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@page import="java.io.PrintWriter , java.sql.*"%>
<!DOCTYPE html>

<%Connection conn;



Class.forName("com.mysql.cj.jdbc.Driver");
conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/fuelstaff?","root","Vithya24");
String np = request.getParameter("np");


PreparedStatement pst1 = conn.prepareStatement("delete from vehicle where plateNumber = ?");
pst1.setString(1, np);

pst1.executeUpdate();

	%>

<html>
<head>
<meta charset="ISO-8859-1">
<title>Deleting...</title>
</head>
<body>
<script>

alert("Deleted Successfully ...");
location.href="indexVehicle.jsp";
</script>

</body>
</html>