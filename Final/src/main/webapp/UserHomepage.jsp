<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>



<meta charset="ISO-8859-1">



<title>Insert title here</title>
<link rel="stylesheet" href="Assets/CSS/UserManagement.css">

<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">


<style>
     <%@ include file="Assets/CSS/UserManagement.css"%>
</style>


</head>
<body>



   <div class="header">
        <a href="#">Home</a>
        <a href="#contactus">Contact Us</a>
        <a href="#aboutus">About Us</a>
         <c:forEach var="us" items="${usDet}">
   
    <c:set var="userid" value="${us.userID}"/>
    <c:set var="nic" value="${us.NIC}"/>
    <c:set var="fname" value="${us.firstName}"/>
    <c:set var="lname" value="${us.lastName}"/>
    <c:set var="pswd" value="${us.password}"/>
    <c:set var="otp" value="${us.OTP}"/>
    <c:set var="email" value="${us.email}"/>
    <c:set var="address" value="${us.address}"/>
    
    </c:forEach>
    <c:url value="Profile.jsp" var="profile">
        <c:param name="nic" value="${nic}"/>
        <c:param name="pswd" value="${pswd}"/>
        <c:param name="fname" value="${fname}"/>
        <c:param name="lname" value="${lname}"/>
        <c:param name="address" value="${address}"/>
    </c:url>
    <a href="${profile}" class="profile">
        <input type="button" name="profile" value="Profile">
    </a>
    <c:url value="DeleteUser.jsp" var="userdelete">
    
        <c:param name="nic" value="${nic}"/>
        <c:param name="pswd" value="${pswd}"/>
        <c:param name="fname" value="${fname}"/>
        <c:param name="lname" value="${lname}"/>
        <c:param name="address" value="${address}"/>
    
    </c:url>
    <a href="${userdelete}" class="deleteuser">
        <input type="button" name="delete" value="Delete Profile">
    </a>
    <a href="UserLogin.jsp" class="logout">
        <input type="button" name="logout" value="Log out">
    </a>
    </div>
      
       <div class="btnclass">
      <a class="userbtn" href="indexVehicle.jsp">Register Vehicle</a>
    </div>
    
    
    
<form action="prioritypage.jsp">
    <div class="btnclass2">
        <button type="submit" name="submit" class="userbtn2" value="NoticeBoard">View Notices</button>
    </div>
</form>




<script>
    var add1;
     var add;
     add1 = "${address}";



</script>




     <input type="text" placeholder="Search.." id = "searchAddress"  onkeyup="keypressHandler(event)"/>
    
    <script>
    function keypressHandler(e) {



       if(e.keyCode == 13){
           add = document.getElementById("searchAddress").value;
           add1=add;
           document.getElementById('map').src = "https://www.google.com/maps?q="+add1+"+Fuel+Station&output=embed";



       }



       
    }
    </script>



   <div class="mapbox">
  

<iframe id ="map" src="" width="1000" height="350" style="border:0;" allowfullscreen="" loading="lazy" referrerpolicy="no-referrer-when-downgrade"></iframe>
  </div>



<script>
    document.getElementById("map").src = "https://www.google.com/maps?q="+add1+"+Fuel+Station&output=embed";
</script>
        
  
  
</body>
</html>