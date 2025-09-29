<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Register</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/style.css">
</head>
<body>
	<h1>Student Register</h1>
	
	<c:if test="${errorMessage != null}">
        <p class="error-message">
            <c:out value="${errorMessage}" />
        </p>
    </c:if>
	
	<form action="<c:url value='/register' />" method="POST" class="form">
		<fieldset>
			<legend>
				Register
			</legend>
			
			<div class="form-group">
				<label for="username">Username</label>
				<input type="text" id="username" name="username" required />
			</div>
			
			<div class="form-group">
				<label for="password">Password</label>
				<input type="password" id="password" name="password" required/>
			</div>
			
			<div class="form-group">
				<label for="confirmPassword">Confirm Password</label>
				<input type="password" id="confirmPassword" name="confirmPassword" required/>
			</div>
			
			<button type="submit" class="btn">Submit</button>
		</fieldset>
	</form>
	
	<p>Already have an account? <a href="<c:url value='/login' />">Login</a></p>
</body>
</html>