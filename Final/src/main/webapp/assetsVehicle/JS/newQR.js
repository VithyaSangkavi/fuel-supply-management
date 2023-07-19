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
    
    var qr = new QRCode(document.getElementById('qrcode'));
   
   		
  	 var np = "Number Plate : " + pNO
  	 var vt = "Vehicle Type : " + vType
  	 var ft = "Fuel Type : " + fType
  	 var fl = "Fuel Limit (in Liters) : " + flimit
  	 var rl = "Remaining Fuel Limit (in Liters) : " + rlimit
  	 var nl = "Needed Fuel Limit (in Liters) : " + nlimit
   	qr.makeCode("Date : "+date+"\n\n"+np + "\n" + vt + "\n" + ft + "\n" + fl + "\n" + rl + "\n" + nl);


    
    
    document.getElementById('finish').disabled = false;
    
    document.getElementById('back').disabled = true;
  
}
