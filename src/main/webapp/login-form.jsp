<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/style.css">
</head>
<body>
	<%
		String formAction = request.getContextPath() + "/login";
	%>

	<h1>Student Login</h1>
	
	<c:if test="${errorMessage != null}">
        <p class="error-message">
            <c:out value="${errorMessage}" />
        </p>
    </c:if>
	
	<form action="<%= formAction %>" method="POST" class="form">
		<fieldset>
			<legend>
				Login
			</legend>
			
			<div class="form-group">
				<label for="username">Username</label>
				<input type="text" id="username" name="username" />
			</div>
			
			<div class="form-group">
				<label for="password">Password</label>
				<input type="password" id="password" name="password" />
			</div>
			
			<button type="submit" class="btn">Submit</button>
		</fieldset>
	</form>
</body>
</html>