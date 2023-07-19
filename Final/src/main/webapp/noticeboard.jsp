<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <!-- including JSTL Core libraries to use tags  -->
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>NoticeBoard</title>
<!-- CSS link -->
<link href="noticecss/notboardstyles.css" rel="stylesheet"/>
 <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
 <style>
     <%@ include file="noticecss/notboardstyles.css"%>
</style>
</head>
<body>
<!-- header menu bar -->
<div class="header">
    	<a href="#">Home</a>
    	<a href="#">Contact Us</a>
    	<a href="#">About Us</a>
  	</div>
  	

<!-- middle banner design -->
<div class = "homediv">

</div>
<div class="not-insert-header">
<h1>Your Notice Board</h1>
</div>
<!-- Search bar  -->
<div class="searchwrap">
<form action ="srchuser" method="post" class="searchbar">
	
	<input type="text" class="searchname" name="usernid" placeholder="Search Your Notice Here" required/> 
	<button type="submit" class="searchbutton" name="submit" value="search"><i class="fa fa-search" aria-hidden="true"></i></button>
	
	
</form>
</div>	


<!-- Search The Notice Table -->
<table>
	<tr class="not-search-table-row">
		<th class="not-search-table-header" >Notice Number</th>
		<th class="not-search-table-header" >Notice Title</th>
		<th class="not-search-table-header" >Notice Type</th>
		<th class="not-search-table-header" >Posted On</th>
		<th class="not-search-table-header" >Notice owner</th>
		
		
	</tr>
</table>
<table>
<c:forEach var="notic" items="${noticeDet}">
<tr>
	
	<c:set var="id" value="${notic.id}"/>
	<c:set var="title" value="${notic.title}"/>
	<c:set var="ntype" value="${notic.notice_type}"/>
	<c:set var="ndate" value="${notic.date}"/>
	<c:set var="ndesc" value="${notic.notice_desc}"/>
	<c:set var="nemail" value="${notic.email}"/>
	
	<td style="text-align:center;">${notic.id}</td>
	<td>${notic.title}</td>
	<c:if test="${notic.notice_type  == 'Priority Notice'}">
		<td style="text-align:center; font-size:20px;"><i class="fa fa-flag" aria-hidden="true"></i></td>
	</c:if>
	<c:if test="${notic.notice_type  == 'Normal Notice'}">
		<td style="text-align:center; font-size:20px;"><i class="fa fa-flag-o" aria-hidden="true"></i></td>
	</c:if>
	<td>${notic.date}</td>
	<td>${notic.email}</td>
	
	

	<c:url value="noticedetails.jsp" var="noticdetails">
		<c:param name="noticeid" value="${id}"/>
		<c:param name="noticetitle" value="${title}"/>
		<c:param name="noticetype" value="${ntype}"/>
		<c:param name="noticedate" value="${ndate}"/>
		<c:param name="noticedesc" value="${ndesc}"/>
		<c:param name="noticeemail" value="${nemail}"/>
	</c:url>
	<!--view button navigating to noticedetails.jsp -->
	<td>
	<a href="${noticdetails}">
	<button type="submit" name="update" value="View" class="all-not-viewbtn">View</button>
	</a>
	
	</td>
	
	</tr>
</c:forEach>

</table>

<!-- All notices board Table -->
<table>

<c:forEach var="noticebrd" items="${notusers}">
<tr>
	<c:set var="id" value="${noticebrd.id}"/>
	<c:set var="title" value="${noticebrd.title}"/>
	<c:set var="ntype" value="${noticebrd.notice_type}"/>
	<c:set var="ndate" value="${noticebrd.date}"/>
	<c:set var="ndesc" value="${noticebrd.notice_desc}"/>
	<c:set var="nemail" value="${noticebrd.email}"/>
	
	<td style="text-align:center;">${noticebrd.id}</td>
	<td>${noticebrd.title}</td>
	<c:if test="${noticebrd.notice_type  == 'Priority Notice'}">
		<td style="text-align:center; font-size:20px;"><i class="fa fa-flag" aria-hidden="true"></i></td>
	</c:if>
	<c:if test="${noticebrd.notice_type  == 'Normal Notice'}">
		<td style="text-align:center; font-size:20px;"><i class="fa fa-flag-o" aria-hidden="true"></i></td>
	</c:if>
	<td>${noticebrd.date}</td>
	<td>${noticebrd.email}</td>
	
	<c:url value="noticedetails.jsp" var="noticdetails">
		<c:param name="noticeid" value="${id}"/>
		<c:param name="noticetitle" value="${title}"/>
		<c:param name="noticetype" value="${ntype}"/>
		<c:param name="noticedate" value="${ndate}"/>
		<c:param name="noticedesc" value="${ndesc}"/>
		<c:param name="noticeemail" value="${nemail}"/>
	</c:url>
	<!--view button  navigating to noticedetails.jsp -->
	<td>
	<a href="${noticdetails}">
	<button type="submit" name="update" value="View" class="all-not-viewbtn">View</button>
	</a>
	
	</td>
</tr>
</c:forEach>

</table>
</body>
</html>