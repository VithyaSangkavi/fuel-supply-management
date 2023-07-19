<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Notice Insert Page</title>
<!-- CSS link -->
  <link href="noticecss/noticesinsertstyles.css" rel="stylesheet"/>
 <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
 <link rel="icon" type="image/png" href="Images/inst-page-icon.png"/>
 <!-- Front End Form Validations -->
 <script type="text/javascript" src="noticejs/notinsertscript.js"></script>
<style>
     <%@ include file="noticecss/noticesinsertstyles.css"%>
     <%@ include file="Images/inst-page-icon.png"%>
</style>
<script>
	<%@ include file="noticejs/notinsertscript.js"%>
</script>

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
<div class="not-insert-header">
<h1>Post a Notice</h1>
</div>



<form action="insert" name="noticeInsert" onSubmit="return validateNotice();" method="post" id="notice-insert-form">

<label class="not-ins-label">Notice Title<span class="not-inst-span">*</span></label> <br>
		<input type="text" name="title" class="not-inst-input" maxlength="40" required/><br>
		
		
<label class="not-ins-label">Notice Type<span class="not-inst-span">*</span></label> <br>
			<select name="ntype" class="inst-not-select" required>
			<option value="1" class="inst-not-options">Priority Notice</option>
			<option value="2" class="inst-not-options">Normal Notice</option>
			</select><br>
			
			
<div class="inst-notice-desc">
<label class="not-ins-label-right">Notice Description</label> <br>
 <textarea name="ndesc" rows="4" cols="50" class="not-ins-textarea" placeholder= "Insert a breif introduction about the notice..." maxlength="500" required></textarea><br>
</div>


<label class="not-ins-label">Email <span class="not-inst-span">*</span></label> <br>


<input type="text" name="email" class="not-inst-input" placeholder="XXXXX@gmail.com" required/><br>

<input type="submit" class="not-inst-submit" value="Insert Notice">
</form>
<a href="search.jsp">
<button class="viewnoticebtn"  style="margin-left:250px;"><i class="fa fa-newspaper-o" id="instnoticeicon" >
</i></button>
</a>




</body>
</html>