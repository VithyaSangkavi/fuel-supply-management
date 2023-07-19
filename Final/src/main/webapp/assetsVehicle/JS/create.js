/**
 * 
 */
 
 
 function ddlist(){
    let ddv = document.getElementById('vType').value;


    if(ddv === "van"){
            document.getElementById('fLimit').value = 100;
    }
    else if(ddv === "car"){
        document.getElementById('fLimit').value = 80;
    }
    else if(ddv === "bike"){
        document.getElementById('fLimit').value = 16;
        
    }
    else if (ddv === "3wheeler"){
        document.getElementById('fLimit').value = 20;
        
    }
    else if (ddv === "lorry"){
        document.getElementById('fLimit').value = 160;
       
    }
    else if(ddv === "bus"){
        document.getElementById('fLimit').value = 200;
      
    }
}