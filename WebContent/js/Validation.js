	function ValidateEmail(uemail)  
	{  
		var mailformat = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;  
	
		if(uemail.match(mailformat))  
		{  
			return true;  
		}  
		else  
		{  
		
		    return false;  
		}
		
	 }  
	function validateNumeric(value)
	{
	  if (isNaN(value)) 
	  {
	    return false;
	  }
	
	}
	function validatedate(inputText) {  
	  var dateformat = /^(0?[1-9]|[12][0-9]|3[01])[\/\-](0?[1-9]|1[012])[\/\-]\d{4}$/;  
	  if(inputText.value.match(dateformat))  
	  {  
	  document.form1.text1.focus();  
	  //Test which seperator is used '/' or '-'  
	  var opera1 = inputText.value.split('/');  
	  var opera2 = inputText.value.split('/');  
	  lopera1 = opera1.length;  
	  lopera2 = opera2.length;  
	  // Extract the string into month, date and year  
	  if (lopera1>1)  
	  {  
	  var pdate = inputText.value.split('/');  
	  }  
	  else if (lopera2>1)  
	  {  
	  var pdate = inputText.value.split('/');  
	  }  
	  var dd = parseInt(pdate[0]);  
	  var mm  = parseInt(pdate[1]);  
	  var yy = parseInt(pdate[2]);  
	  // Create list of days of a month [assume there is no leap year by default]  
	  var ListofDays = [31,28,31,30,31,30,31,31,30,31,30,31];  
	  if (mm==1 || mm>2)  
	  {  
	  if (dd>ListofDays[mm-1])  
	  {  
		
		  return false;  
	  }  
	  }  
	  if (mm==2)  
	  {  
		  var lyear = false;  
	  if ( (!(yy % 4) && yy % 100) || !(yy % 400))   
	  {  
		  	lyear = true;  
	  }  
	  if ((lyear==false) && (dd>=29))  
	  {  
			  return false;  
	  }  
	  if ((lyear==true) && (dd>29))  
	  {  
		  return false;  
      }  
	  }  
	  }  
	  else  
	  {  
		 document.form1.text1.focus();  
		  return false;  
	  }  
	 }  	
	function isValidDate(dateString)
	{
	    // First check for the pattern
	    if(!/^\d{1,2}\/\d{1,2}\/\d{4}$/.test(dateString))
	        return false;

	    // Parse the date parts to integers
	    var parts = dateString.split("/");
	    var day = parseInt(parts[1], 10);
	    var month = parseInt(parts[0], 10);
	    var year = parseInt(parts[2], 10);

	    // Check the ranges of month and year
	    if(year < 1000 || year > 3000 || month == 0 || month > 12)
	        return false;

	    var monthLength = [ 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 ];

	    // Adjust for leap years
	    if(year % 400 == 0 || (year % 100 != 0 && year % 4 == 0))
	        monthLength[1] = 29;

	    // Check the range of the day
	    return day > 0 && day <= monthLength[month - 1];
	};    
	function validateRequired(text){
		
		return (text!="");
		
	}