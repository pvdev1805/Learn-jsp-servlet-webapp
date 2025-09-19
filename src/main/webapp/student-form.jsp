<%@page import="be08webapp.dto.Student"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Student Form</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/style.css">
</head>
<body>
	<h1>
		Create Student
	</h1>
	
	<form method="POST" action="${pageContext.request.contextPath}/students/new" class="form">
		<fieldset>
			<legend>Student Information</legend>
			
			<input type="hidden" id="id" name="id">
			
			<div class="form-group">
				<label for="firstName" class="label">First Name</label>
				<input type="text" id="firstName" name="firstName">
			</div>
			
			<div class="form-group">
				<label for="lastName" class="label">Last Name</label>
				<input type="text" id="lastName" name="lastName">
			</div>
			
			<div class="form-group">
				<label for="email" class="label">Email</label>
				<input type="email" id="email" name="email">
			</div>
			
			<div class="form-group">
				<label for="studentClass" class="label">Class</label>
				<input type="text" id="class" name="studentClass">
			</div>
		
			<button type="submit" class="btn">Submit</button>
		</fieldset>
	</form>
</body>
</html>