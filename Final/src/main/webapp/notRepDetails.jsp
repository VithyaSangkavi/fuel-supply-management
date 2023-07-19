<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <!-- including JSTL Core libraries to use tags  -->
     <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Notice Reports</title>
<!-- CSS link -->
 <link href="noticecss/noticereportsstyles.css" rel="stylesheet"/>
   <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
   
<style>
     <%@ include file="noticecss/noticereportsstyles.css"%>
</style>
</head>
<body>

  
  <!-- middle banner -->
<div class = "homediv">

</div>
  
<!-- Back Button -->
<a href="search.jsp"><button class="not-rep-backbtn"><i class="fa fa-times" aria-hidden="true"></i></button></a>


<!-- page header -->
<div class="not-insert-header">
<h1>Report</h1>
<hr>
</div>
<!-- Notice Report Page Description -->
<h3 class="report-desc">Notices generated for each month along with its respective year is represented below</h3>

<!-- Report Table -->
<table>
<tr>
	<th class="not-gen-rep-header">Number Of Notices</th>
	<th class="not-gen-rep-header">Month</th>
	<th class="not-gen-rep-header">Year</th>
</tr>

<c:forEach var="repnot" items="${repnotice}">

	<c:set var="notcount" value="${repnot.num_notices}"/>
	<c:set var="notmonth" value="${repnot.month}"/>
	<c:set var="notyear" value="${repnot.year}"/>
	


<tr>
		<td class="rep-table-data">${repnot.num_notices}</td>
		<td class="rep-table-data">${repnot.month}</td>
		<td class="rep-table-data">${repnot.year}</td>
</tr>
</c:forEach>
</table>

</body>
</html>