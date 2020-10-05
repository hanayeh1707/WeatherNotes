<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%> 
 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%@ page import="java.util.List"%>
 <%@ page import="data.pkg.*"%>
  <% User user = (User)request.getSession().getAttribute("user");
  Note note=(Note)request.getAttribute("note");
  %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="css/mycss.css" />
<title>Home</title>
</head>
<body>
<h1 align="center">Today' Weather Notes </h1>
<c:if test="${not empty user}">
<div align="right"><a href="LogoutServlet">Logout</a></div>
<c:if test="${ empty note}">
<% 
request.setAttribute("result", "This is the result of the servlet call");
request.getRequestDispatcher("HomeServlet").forward(request, response); %>
 </c:if>
    <fieldset > <legend>Weather Status</legend>
    <table  align="center">
    <tr>
    <td>Temperature</td>
        <td> <c:out value="${note.getTemperature()}"></c:out> C   </td>
    </tr>
    <tr>
    <td>Humidity</td>
        <td> <c:out value="${note.getHumidity()}"></c:out>  %  </td>
    </tr> <tr>
    <td>Wind</td>
        <td> <c:out value="${note.getWindSpeed()}"></c:out> km/h </td>
    </tr> <tr>
    <td>Notes</td>
        <td> <c:out value="${note.getDescription()}"></c:out>    </td>
    </tr> 
    </table>
  
    </fieldset>
</c:if>
<c:if test="${empty user}">
      <a href='UserLogin.jsp'>Login</a>
      <a href='UserRegistration.jsp'>Create Account</a>
</c:if>
</body>
</html>