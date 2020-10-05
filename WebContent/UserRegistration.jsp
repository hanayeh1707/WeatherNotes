<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="css/mycss.css" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User Registration</title>
</head>
<body>
 <h1 align="center">Create Account</h1>
<form action='RegistrationServlet' method="post">
  <fieldset>
  <legend>User Info</legend>
 
  <table>
  <tr>
  <td>Name</td>
  <td><input type="text" name="uName" style="width: 150%"/></td>
    </tr>
   <tr>
  <td>Email</td>
  <td><input type="text" name="email" style="width: 150%"/></td>
    </tr>
   <tr>
  <td>Mobile</td>
  <td><input type="text" name="mobile"/></td>
    </tr>
   <tr>
  <td>Password</td>
  <td><input type="password" name="password"/></td>
    </tr>
  <tr>
  <td></td>
  <td align="right"><button onclick="submit()" Value="Register"  >Create Account</button></td>
  </tr>
  </table>
</fieldset>
</form>
<a href="UserLogin.jsp">Already have account</a><br/>
</body>
</html>