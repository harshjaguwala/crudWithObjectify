<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form method="post" action="searchByName" >
		Enter Name Here : <input type="text" name="SearchName" >
		<input type="submit">
	</form>
	
	<br/>
	<br/>
	<table border="10">
		<tr>
			<td>Name</td>
			<td>Age</td>
			<td>Action</td>
		</tr>
		
		<c:forEach var="listofempinfo" items="${listofempinfo}">
			<tr>
				<td>${listofempinfo.name}</td>
				<td>${listofempinfo.age}</td>
				<td><a href="editEmployeeInfo?id=<c:out value='${listofempinfo.id}' />">Edit</a>
								&nbsp;&nbsp;&nbsp;&nbsp; 
					<a href="deleteemployeeinfo?id=<c:out value='${listofempinfo.id}' />">Delete</a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>