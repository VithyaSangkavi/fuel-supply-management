/**
 * 
 */
function validateNotice(){
	var x = document.forms["noticeInsert"]["email"];
	var valemail = /^[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,4}$/;
	
	if(!x.value.match(valemail)){
		alert("Please enter a valid email address");
		return false;
	}else{
		return true;
	}
	
 }