
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%@page import="java.util.ArrayList"%>
 <%@ page import="data.pkg.*"%>
 <% ArrayList<Note> notes = (ArrayList<Note> )request.getAttribute("notes");%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="css/mycss.css" />
<title>Notes History</title>
</head>
<body>
<c:if test="${ empty notes}">
<% 

request.getRequestDispatcher("NotesManagerServlet").forward(request, response); %>
 </c:if>
 <fieldset>
 <legend >Notes History</legend>
    
    <a href="NotesManager.jsp">Add Note</a>

    <table align="center"  width="85%"  border="1px;">
	<thead><tr><th>Date</th><th>Description</th>
	<th>Is Predefined</th><th>Value Form</th><th>Value To</th>
	</tr></thead>
     <c:forEach var="note" items="${notes}" >
          <tr>
            <td> <c:out value="${note.getNoteDate()}"></c:out> </td>  
            <td> <c:out value="${note.getDescription()}"></c:out></td>
            <td> <c:out value="${note.getIsPredefined()}"></c:out> </td>  
            <td> <c:out value="${note.getValueFrom()}"></c:out></td>
            <td><c:out value="${note.getValueTo()}"></c:out></td>
           </tr>
    </c:forEach>
    </table>
 </fieldset>
 <a href="HomeServlet">Home</a>
</body>
</html>