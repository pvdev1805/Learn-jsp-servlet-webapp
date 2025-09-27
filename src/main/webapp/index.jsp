<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Student Management</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/style.css">
</head>
<body>
	<h1>Welcome to Student Management App!</h1>
	<p>This is a simple JSP/Servlet web app to manage students!</p>
	
	<div class="container">
		<c:if test="${sessionScope.username != null }">
			<p>Hello, <c:out value="${sessionScope.username }"></c:out> !</p>
			
			<div class="actions">
				<a href="<c:url value='/students' />" class="btn">View Student List</a>
				<a href="<c:url value='/logout' />" class="btn-logout">Logout</a>
			</div>
		</c:if>
		
		<c:if test="${sessionScope.username == null }">
			<a href="<c:url value='/login' />" class="btn-login">Login</a>
		</c:if>
	</div>
</body>
</html>