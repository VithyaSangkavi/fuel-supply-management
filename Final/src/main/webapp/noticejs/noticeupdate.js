/**
 * 
 */

function updateNotice(){
		var x = document.forms["noticeInsert"]["email"];
		var valemail = /^[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,4}$/;
		
		if(!x.value.match(valemail)){
			alert("Your email is out of format");
			return false;
		}else{
			return true;
		}
		
	 }
 
 function deleteNotice(){
	 alert("The Notice was deleted successfully");
 }