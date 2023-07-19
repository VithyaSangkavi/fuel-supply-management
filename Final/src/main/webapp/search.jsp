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
 <link href="noticecss/noticessearchstyles.css" rel="stylesheet"/>
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
  
<style>
     <%@ include file="noticecss/noticessearchstyles.css"%>
</style>
  
</head>
<body>

<!-- header menu bar -->
<div class="header">
    	<a href="AdminInterface.jsp">Home</a>
    	<a href="#">Staff Management</a>
        <a href="#">Attendance Management</a>
        <a href="#">Salary Management</a>
        <a href="search.jsp">Notice Management</a>
  	</div>
  
<!-- Insert Notice Button -->
<a href="noticeinsert.jsp"><button class="insert-notice-btn">Insert Notice</button></a> 	

<!--  Generate Report Button -->
<form action="notrep" method="post" class="gen-rep-form">
	<button type="submit" name="generate" value="Generate Report" class="gen-repbtn"><i class="fa fa-download" aria-hidden="true"></i>&nbsp;  Generate Report</button>
	
</form>
<!-- middle banner -->
<div class = "homediv">

</div>


<!-- All Notices Button -->
<div class="allnoticebtnwrap">
<form action="all" method="post">
	<button type="submit" name="submit" value="All Notices" class="all-not-btn"><i class="fa fa-bullhorn" aria-hidden="true"></i></button>	
</form>
</div>

<!-- Search bar  -->

<div class="searchwrap">
<form action ="search" method="post" class="searchbar">
	
	<input type="text" class="searchname" name="nid" placeholder="Search Your Notice Here" required/> 
	<button type="submit" class="searchbutton" name="submit" value="search"><i class="fa fa-search" aria-hidden="true"></i></button>
	
	
</form>
</div>	

<!-- Search The Notice -->
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
	
	

	<c:url value="updatenotice.jsp" var="noticupdate">
		<c:param name="noticeid" value="${id}"/>
		<c:param name="noticetitle" value="${title}"/>
		<c:param name="noticetype" value="${ntype}"/>
		<c:param name="noticedate" value="${ndate}"/>
		<c:param name="noticedesc" value="${ndesc}"/>
		<c:param name="noticeemail" value="${nemail}"/>
	</c:url>
	<td >
	<a href="${noticupdate}">
	<button type="submit" name="update" value="View" class="all-not-viewbtn">View</button>
	</a>
	
	</td>
	
	</tr>
</c:forEach>

</table>


<!-- View All the Notices -->
<table>


<c:forEach var="allnot" items="${allnotDet}">
<tr>
	<c:set var="id" value="${allnot.id}"/>
	<c:set var="title" value="${allnot.title}"/>
	<c:set var="ntype" value="${allnot.notice_type}"/>
	<c:set var="ndate" value="${allnot.date}"/>
	<c:set var="ndesc" value="${allnot.notice_desc}"/>
	<c:set var="nemail" value="${allnot.email}"/>
	
	<td style="text-align:center;">${allnot.id}</td>
	<td>${allnot.title}</td>
	<c:if test="${allnot.notice_type  == 'Priority Notice'}">
		<td style="text-align:center; font-size:20px;"><i class="fa fa-flag" aria-hidden="true"></i></td>
	</c:if>
	<c:if test="${allnot.notice_type  == 'Normal Notice'}">
		<td style="text-align:center; font-size:20px;"><i class="fa fa-flag-o" aria-hidden="true"></i></td>
	</c:if>
	<td>${allnot.date}</td>
	<td>${allnot.email}</td>
	
	<c:url value="updatenotice.jsp" var="noticupdate">
		<c:param name="noticeid" value="${id}"/>
		<c:param name="noticetitle" value="${title}"/>
		<c:param name="noticetype" value="${ntype}"/>
		<c:param name="noticedate" value="${ndate}"/>
		<c:param name="noticedesc" value="${ndesc}"/>
		<c:param name="noticeemail" value="${nemail}"/>
	</c:url>
	
	<td>
	<a href="${noticupdate}">
	<button type="submit" name="update" value="View" class="all-not-viewbtn">View</button>
	</a>
	
	</td>

	</tr>

</c:forEach>

</table>
</body>
</html>