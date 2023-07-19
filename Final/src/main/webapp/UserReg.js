




function checkpassword(){
	
	let password= document.getElementById("password").value;
	let cpassword=document.getElementById("cpassword").value;

	
	console.log(password,cpassword);
	let message=document.getElementById("message");
	
	if (password.length!=0){
		if(password==cpassword){
			
			message.textContent="Password matched";
			message.style.backgroundColor="#3ae374";
		}else{
			
			message.textContent="Password don't match";
			message.style.backgroundColor="#ff4d4d";
			return false;
		}
		
	}else{
		alert("Password can't be empty !")
		message.textContent="";
		return false;
	}
	
	
}


function validateNIC(nic){

	if(nic.length != 10){
		
		return false;
	}else{
		
		return true;
	}
}


function validateForm()
{
	let nic = document.getElementById('nic').value;
	
	  
  if(validateNIC(nic)==false && checkpassword()==undefined && verifyOtp()==true)
  {
 	alert("Invalid NIC");
    return false;
  }
  else if(validateNIC(nic)==true && checkpassword()==false && verifyOtp()==true )
  {
	alert("	Password does not match");
    return false;
  }else if(validateNIC(nic)==false && checkpassword()==false && verifyOtp()==true){
	
	alert("Invalid NIC and Password");
    return false;
	
  }else if(validateNIC(nic)==true && checkpassword()==true && verifyOtp()==false){
	
	alert("OTP verification Unsuccessfull !");
    return false;
	
	
  }else if(validateNIC(nic)==true && checkpassword()==undefined && verifyOtp()==true){
	
	alert("Succesfull");
	return true;
	
	}else{
		
		alert("Unsuccesfull");
		return false;
	
		
	}
  
}

 verifyOtp =function(){
			
			
			let otp = sessionStorage.getItem("otp");
			let inputOtp = document.getElementById('otp').value;
			
			

			if (otp==inputOtp){
				
				alert("OTP Verification Succesfull");
				return true;
			}else{
				alert("Unsuccessfull Verification")
				return false;
			}

}
 
 
/*
function checkpassword(){
	
	let password= document.getElementById("password").value;
	let cpassword=document.getElementById("cpassword").value;

	
	console.log(password,cpassword);
	let message=document.getElementById("message");
	
	if (password.length!=0){
		if(password==cpassword){
			
			message.textContent="Password matched";
			message.style.backgroundColor="#3ae374";
		}else{
			
			message.textContent="Password don't match";
			message.style.backgroundColor="#ff4d4d";
			return false;
		}
		
	}else{
		alert("Password can't be empty !")
		message.textContent="";
		return false;
	}
	
	validateForm();
	
}


function validateNIC(){
	
	
	var nic = document.getElementById('nic');



     if(/^[0-9]{9}[vVxX]$/.test(nic.value) )
      {
            nic.style.border="none";
           return true;
      }else if( /^[0-9].{8,11}$/.test(nic.value))
      {
        nic.style.border="none";
           return true;
      }
      else
      {
        nic.style.border="2px solid #FF0000";
        return false;
      }
}


function validateEmail()
{
  var email = document.getElementById('email');
  
  if (/^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/.test(email.value))
  {
    email.style.border="none";
    return true;
  }
  else
  {
    email.style.border="2px solid #FF0000";
    return false;
  }
}



function validateForm()
{
  if(!validateEmail() || !validateNIC() || !checkpassword())
  {
    return false;
  }
  else
  {
    return true;
  }
}




let x=0;

function test(){
	x=5;
	
}
console.log(x);
test();
console.log(x);



if (nic.length != 10){
		alert("Invalid Nic")
		return false;
		
	}
function checkpassword2(){
	
	let nic ="456789567"




	if (nic.length != 10){
		console.log("Invalid nigga")
		return false;
		
	}
}


let res= checkpassword2();
console.log(res);


function NicValidation(){
	console.log(nic);
	if (nic.length != 10){
		alert("Invalid Nic")
		return false;
	}else{
		nicV = 1;
		return true;

	}
	
	
}


function FinalValidation(){
	

	
	if(pswdV==1 && nicV==1){
		return true;
	}else{
		
		alert("Unsuccessfull")
		return false;
	}
}

*/