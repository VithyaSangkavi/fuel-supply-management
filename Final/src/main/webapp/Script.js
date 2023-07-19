function validateFName()
{
	var fname = document.getElementById('fname');
	
	if(fname.value.length >= 3 && /^[a-zA-Z\-/']+$/.test(fname.value))
	{
		fname.style.border= "none";
		return true;
  	}
  	else
 	{
    fname.style.border="2px solid #FF0000";
    return false;
	}
}

function validateLName()
{
	var lname = document.getElementById('lname');
	
	if(lname.value.length >= 3 && /^[a-zA-Z\-/']+$/.test(lname.value))
	{
		lname.style.border= "none";
		return true;
  	}
  	else
 	{
    lname.style.border="2px solid #FF0000";
    return false;
	}
}

function validateNIC()
{
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

function validateAddress()
{
  	var address = document.getElementById('address');

 	if((address.value.length >= 3 ))
	{
		address.style.border= "none";
		return true;
  	}
  	else
 	{
    address.style.border="2px solid #FF0000";
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

function validateAccNo()
{
  var accno = document.getElementById('accno');
  
  if (/^[0-9]+$/.test(accno.value))
  {
    accno.style.border="none";
    return true;
  }
  else
  {
    accno.style.border="2px solid #FF0000";
    return false;
  }
}

function validateSType()
{
  var stafftype = document.getElementById('stafftype');
  var cyears = document.getElementById('cyears');
  var cyears1 = document.getElementById('cyears1');
  
  if(stafftype.value == "Contract Basis" || stafftype.value == "contract basis")
  {
	stafftype.style.border="none";
	cyears.style.display="block";
	cyears1.style.display="block";
    return true;
    
  }
  else if (stafftype.value == "Permanent" || stafftype.value == "permanent")
  {
    stafftype.style.border="none";
    cyears.style.display="none";
	cyears1.style.display="none";
    return true;
  }
  else 
  {
	cyears.style.display="none";
	cyears1.style.display="none";
    stafftype.style.border="2px solid #FF0000";
    return false;
  }
}

function validateYears()
{
  var cyears = document.getElementById('cyears');
  
  if (/^[0-9]+$/.test(cyears.value))
  {
    cyears.style.border="none";
    return true;
  }
  else 
  {
    cyears.style.border="2px solid #FF0000";
    return false;
  }
}

function validateSalary()
{
  var salary = document.getElementById('salary');
  
  if (/^[0-9]+$/.test(salary.value))
  {
    salary.style.border="none";
    return true;
  }
  else 
  {
    salary.style.border="2px solid #FF0000";
    return false;
  }
}

function validateOT()
{
  var ot = document.getElementById('ot');
  
  if (/^[0-9]+$/.test(ot.value))
  {
    ot.style.border="none";
    return true;
  }
  else 
  {
    ot.style.border="2px solid #FF0000";
    return false;
  }
}

function validateForm()
{
  if(!validateFName() || !validateLName() || !validateNIC() || !validateAddress() || !validateEmail() || !validateAccNo() || !validateSType() || !validateYears() || !validateSalary() || !validateOT())
  {
    return false;
  }
  else
  {
    return true;
  }
}

