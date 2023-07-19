<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	
   
<html>
<head>
<title>User Management Application</title>
<link rel="stylesheet" href="mystyles.css">
<style>
     <%@ include file="mystyles.css"%>
</style>
	
</head>
<body>

	<header>
		<nav class="navbar navbar-expand-md navbar-dark"
			style="background-color: green">
			<div>
				<a href="https://www.javaguides.net" class="navbar-brand"> SALARY </a>
			</div>

			<ul class="navbar-nav">
				<li><a href="<%=request.getContextPath()%>/list"
					class="nav-link">Users</a></li>
			</ul>
		</nav>
	</header>
	<br>
	
			
	
		`<div class= "formdiv">
	
				<c:if test="${user != null}">
					<form action="updateSalary" method="post">
				</c:if>
				<c:if test="${user == null}">
					<form action="insertSalary" method="post">
				</c:if>

				<caption>
					<h2>
						<c:if test="${user != null}">
            			Edit User
            		</c:if>
						<c:if test="${user == null}">
            			SALARY DETAILS
            		</c:if>
					</h2>
				</caption>

				<c:if test="${user != null}">
					<input type="hidden" name="id" value="<c:out value='${user.id}' />" />
				</c:if>

				<fieldset class="form-group">
					<label>Date</label> <input type="date"
						value="<c:out value='${user.date}' />" class="form-control"
						name="date" required="required">
				</fieldset>

				<fieldset class="form-group">
					<label>Deducted Amount</label> <input type="number"
						value="<c:out value='${user.amount}' />" class="form-control"
						name="amount" required="required">
				</fieldset>

				<fieldset class="form-group">
					<label>Reason</label> <input type="text"
						value="<c:out value='${user.reason}' />" class="form-control"
						name="reason" required="required">
				</fieldset>

				<button type="submit" class="btn btn-success">Save</button>
				</form>
				</div>
			
		
	
</body>
</html>