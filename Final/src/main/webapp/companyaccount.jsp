<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
     <%@ include file="essentialservicesCSS/mystyles.css"%>
</style>

</head>
<body>

<div class="list" >

<h1 class="accTitle">Company Details</h1>

	<table>
		<c:forEach var="ess" items="${essDetails}">
		<c:set var="cid" value="${ess.cid}"/>
		<c:set var="cname" value="${ess.cname}"/>
		<c:set var="fname" value="${ess.fname}"/>
		<c:set var="lname" value="${ess.lname}"/>
		<c:set var="sType" value="${ess.sType}"/>
		<c:set var="reason" value="${ess.reason}"/>
		<c:set var="address" value="${ess.address}"/>
		<c:set var="email" value="${ess.email}"/>
		<c:set var="fLimit" value="${ess.fLimit}"/>
		<c:set var="letter" value="${ess.letter}"/>
		<c:set var="password" value="${ess.password}"/>
		
	
		
		<tr>
			<td>Company ID</td>
			<td>${ess.cid}</td>
		</tr>
		<tr>
			<td>Company Name</td>
			<td>${ess.cname}</td>
		</tr>
		<tr>
			<td>First Name</td>
			<td>${ess.fname}</td>
		</tr>
		<tr>
			<td>Last Name</td>
			<td>${ess.lname}</td>
		</tr>
		<tr>
			<td>Service Type</td>
			<td>${ess.sType}</td>
		</tr>
		<tr>
			<td>Reason</td>
			<td>${ess.reason}}</td>
		</tr>
		<tr>
			<td>Address</td>
			<td>${ess.address}</td>
		</tr>
		<tr>
			<td>Email</td>
			<td>${ess.email}</td>
		</tr>
		<tr>
			<td>Limit</td>
			<td>${ess.fLimit}</td>
		</tr>
		<tr>
			<td>Letter</td>
			<td>${ess.letter}</td>
		</tr>
		<tr>
			<td>Password</td>
			<td>${ess.password}</td>
		</tr>
	
		</c:forEach>
	</table>
		
		<c:url value="updatecompany.jsp" var="comupdate">
		<c:param name="cid" value="${cid}"/>
		<c:param name="cname" value="${cname}"/>
		<c:param name="fname" value="${fname}"/>
		<c:param name="lname" value="${lname}"/>
		<c:param name="sType" value="${sType}"/>
		<c:param name="reason" value="${reason}"/>
		<c:param name="address" value="${address}"/>
		<c:param name="email" value="${email}"/>
		<c:param name="fLimit" value="${fLimit}"/>
		<c:param name="letter" value="${letter}"/>
		<c:param name="password" value="${password}"/>
	</c:url>
	<div class="center">
	<a href="${comupdate}">
	<button class="button-9" role="button"  type="button" name="update" >Update Company Data</button>
	</a>
	
	
	<br>
	
	<c:url value="deletecompany.jsp" var="comdelete">
		<c:param name="cid" value="${cid}"/>
		<c:param name="cname" value="${cname}"/>
		<c:param name="fname" value="${fname}"/>
		<c:param name="lname" value="${lname}"/>
		<c:param name="sType" value="${sType}"/>
		<c:param name="reason" value="${reason}"/>
		<c:param name="address" value="${address}"/>
		<c:param name="email" value="${email}"/>
		<c:param name="fLimit" value="${fLimit}"/>
		<c:param name="letter" value="${letter}"/>
		<c:param name="password" value="${password}"/>
	</c:url>
	<a href="${comdelete}">
	<button class="button-9" role="button"  type="button" name="delete" >Delete My Account</button>
	</a>
	</div>
</div>	
	
	
	
</body>
</html>