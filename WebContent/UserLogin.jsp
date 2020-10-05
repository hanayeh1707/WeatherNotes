<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script src="js/Validation.js"></script>
<script type="text/javascript">

function ValidatePlease() {
		var email = document.getElementById("email").value;
		var password = document.getElementById("password").value;
   var err="";
   if(!ValidateEmail(email)){
	   err="Invalid Email Address";
   }if(password.length==0){
	   err+="<br/> Please Enter Password";
   }
       if(err.length==0){
    	   
    	   return true;
       }
   return false;
}

</script>
<link rel="stylesheet" href="css/mycss.css" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User Login</title>
</head>
<body>
<div id="errorMsg"></div>
<h1 align="center">Account Login</h1>
<form action="LoginServlet" method="post" onsubmit="return ValidatePlease();">
 <fieldset >
<legend>Login Info</legend>
 <div align="center">
<table>
<tr>
<td>Email :</td>
<td><input type="text" name="email"/></td>
</tr>
<tr>
<td>Password:</td>
<td><input type="password" name="password"/></td>
</tr>

</table>
<button onclick="submit()">Login</button>
</div>
</fieldset>

</form>

<a href="UserRegistration.jsp">Create Account</a><br/>

</body>
</html>