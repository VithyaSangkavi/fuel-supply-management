/**
 * 
 */
 
function chkTime(){

    alert("Your request has been created :)");
    
    var temp = document.getElementById('date').value;
    var date = new Date(temp);
    var current = new Date();
    
    var day = current.getTime() - date.getTime() ; 
    
    var tday = day / (1000 * 3600 * 24);
    

    if(current > date){
        if (tday > 30 ){
			var st= "yes";
			document.getElementById('status').value = st;
            document.getElementById('rfuel').value = document.getElementById('fLimit').value
            
        }

    }
    
}


function chkLimit(){
    var chk = document.getElementById('need').value;
    
    var chkInt = parseFloat(chk);

    if(chk === ''){
        alert("No values inserted");
    }else{
        if(chkInt < 0){
            alert("Negative values cannot be entered !!! ")
        }
        else if (chkInt === 0){
			alert("Zero cannot be entered !!! For pointed decimal ex: 0.5 -> .5")
		}
        else{
            
        var available = document.getElementById('limit').value;

        var navai = parseFloat(available)

        var Need = document.getElementById('need').value;

        var  Nnum = parseFloat(Need);
    
        var total1 = document.getElementById('remain').value;
    
        if (navai < Nnum){
            alert("Available limit is " + total1 );
           
        }
        else{
            
            //var total = document.getElementById('remain').value;
    
            //var tnum = parseFloat(total);

            if (Nnum > tnum){
                alert("Available limit is " + total1 );
            }
            else{
                alert("You can generate the qr code :)");
                document.getElementById('remain').value = total1 - Need;
                document.getElementById("myBTN").disabled = false;
            }
    
            
        }
        }
        
    
    }

    
}




function test(){
	alert("hello");
}