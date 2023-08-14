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
	<c:if test = "${existingEmp eq null }">
		<form method="post" action="insertEmployeeInfo">
	</c:if>
	
	<c:if test = "${existingEmp ne null }">
		<form method="post" action="updateEmployeeInfo">
	</c:if>
		<input type="hidden" name="id" value="${existingEmp.id}">
		Name : <input type="text" name="name" value="${existingEmp.name}"><br/>
		Age : <input type="text" name="age" value="${existingEmp.age}"><br/>
		<input type="submit">
	</form>
</body>
</html>