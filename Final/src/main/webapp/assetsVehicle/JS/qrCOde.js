/**
 * 
 */
 function generateqr() {
	
	document.getElementById('popup-1').classList.toggle("active");

    var pNO = document.getElementById('pNo').value;
    var vType = document.getElementById('vType').value;
    var fType = document.getElementById('fType').value;
    var flimit = document.getElementById('limit').value;
    var rlimit = document.getElementById('remain').value;
    var nlimit = document.getElementById('need').value;
    
   

    var date = new Date().toLocaleDateString();

   // var url = "https://chart.googleapis.com/chart?cht=qr&chs=200x200&chl=No Plate : " +pNO +"%0AVehicle Type :  " + vType  + "%0AFuel Type :  " + fType +"%0AFuel limit (in Liters) :  " + flimit + "%0ARemaining Fuel (in Liters) :  " + rlimit + "%0ANeeded Fuel (in Liters)  :  " + nlimit 
    //			+"%0ADate :  " +date
    
 

    var ifr = `<iframe src="${url}" height="200" width="200"></iframe>`;

    document.getElementById('qrcode').innerHTML = ifr;
    
    document.getElementById('finish').disabled = false;
    
    document.getElementById('back').disabled = true;
  
}

