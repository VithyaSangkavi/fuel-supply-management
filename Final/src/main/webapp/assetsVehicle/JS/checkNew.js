/**
 * 
 */
 function chkFuel(){
    var need = document.getElementById('need').value;
    var remain = document.getElementById('remain').value;
    
        var nneed = need * 10;
    var rremain = remain * 10;
    
    if(need === ''){
        alert("No value inserted !!! ");
    }
    else if(nneed < 0){
        alert("Negative values cannot be entered !!!");
    }
    else if (nneed === 0){
   		alert("Zero cannot be entered !!!");
    }
    else if(nneed <= rremain){
	
		alert("You can generate the qr code :)");
            document.getElementById('remain').value = remain - need;
            document.getElementById("myBTN").disabled = false;
			
	}
	 else{
            alert("Remaining Fuel amount is " + remain + " !!!")
        }
    
}