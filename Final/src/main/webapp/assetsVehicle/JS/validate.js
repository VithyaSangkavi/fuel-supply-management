/**
 * 
 */
 
 function validate(){
			
				var np = document.getElementById('NoPl').value;
				var cn = document.getElementById('CN').value;
			
				if(validateChassisNo(cn) && validateNoPlate(np)){
					return true;
				}else{
					return false;
				}
			
}

function editValid(){
	var cn = document.getElementById('CN').value;
	
		if(validateChassisNo(cn)){
				return true;
		}else{
				return false;
		}
}


function validateNoPlate(eVal){
    var val = /^([A-Z]{2})+\s+([A-Z]{2,3})+\s+([0-9]{4})$/;
    
	if(eVal === ""){
		alert("Number Plate Field Cannot be Empty");
		return false;
	}
	else{
		if( val.test(eVal)){
        	return true;
    	}else{
       		alert("Plate Number should be, All Capital Letters ex: AB ABC 1234 (Only one space between each of them)");
       		return false;
    	}
    	
	}
}


function validateChassisNo(eVal){
    var val = /^([A-Za-z0-9]{17})$/;
    
	if(eVal === ""){
		alert("Chassis Number Field Cannot be Empty")
		return false;
	}
	else{
		if( val.test(eVal)){
        	return true;
    	}else{
       		alert("Chassis Number should be contain 17 Characters ex: LJCPCBLCX11000237 ");
       		return false;
   	    }
   	    
	}
}
