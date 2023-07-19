<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Processing</title>
</head>

<%
	String np = (String)session.getAttribute("np");
%>
<body>
<script>
alert("Update details successfully :)")
location.href="VMS-ED.jsp?np=<% out.print(np); %>"
</script>
</body>
</html>