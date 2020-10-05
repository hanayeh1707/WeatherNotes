<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="data.pkg.*"%> 
 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
  <% User user =(User) request.getSession().getAttribute("user");%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="css/mycss.css" />
<script  src="js/Validation.js"></script>
<script type="text/javascript">
function ValidateNoteForm(form){	

}
</script>
<title>Notes Manager</title>
</head>
<body >
<c:if test="${ empty user}">
<% 
request.setAttribute("result", "This is the result of the servlet call");
request.getRequestDispatcher("NotesManagerServlet").forward(request, response); %>
 </c:if>
<h1 align="center">Add Note</h1>
<div >
<form action="NotesManagerServlet" method="Post" onsubmit="return ValidateNoteForm(this);">
<fieldset >
<legend >Note Info</legend>
<br/>
<table>
<tr><td > Add Note for :</td>
<td><input  type="text" size="12" placeholder="dd/mm/yyyy" name="noteDate" />
<small>(dd/mm/yyyy)</small>
</td>
</tr>
<tr><td>Note Description:</td>
<td><textarea rows="3" cols="50" name='noteDescription'  id='noteDescription'></textarea></td>
</tr>
<tr><td align="right" ><Input type="checkbox" name='isPredefined' value="checked"/></td>
<td>Set as Predefined Note</td>
</tr>
<tr><td >For Value </td>
<td></td>
</tr>
<tr><td align="right" >From </td>
<td> <input type='text' name='valueFrom' /></td>
</tr>
<tr><td align="right" >To </td>
<td><input type='text' name='valueTo' /></td>
</tr>
<tr>
<td></td>
<td  align="center"><button onclick="submit()" Value="Save"  >Save</button></td>
</tr>

</table>

</fieldset>

</form></div>
<a href="NotesManagerServlet">Cancel Insertion</a>
<a href="HomeServlet">Home</a>
</body>
</html>