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
	<% Student student = (Student)request.getAttribute("student"); %>
	<h1>
		<% if (student != null) { %>
			Edit Student
		<% } else { %>
			Create Student
		<% } %>
	</h1>
	
	<%
		String formAction = "";
		if(student != null) {
			formAction = request.getContextPath() + "/students/edit";
		} else {
			formAction = request.getContextPath() + "/students/new";
		}
	%>
	
	<form method="POST" action="<%= formAction %>" class="form">
		<fieldset>
			<legend>Student Information</legend>
			
			<% 
				if (student != null) { 
			%>
					<input type="hidden" id="id" name="id" value="<%= student.getId() %>">
			<% 
				} else {
			%>
					<input type="hidden" id="id" name="id">		
			<%
				}
			%>
			
			<div class="form-group">
				<label for="firstName" class="label">First Name</label>
				<input type="text" id="firstName" name="firstName" value="<%= student != null ? student.getFirstName() : "" %>">
			</div>
			
			<div class="form-group">
				<label for="lastName" class="label">Last Name</label>
				<input type="text" id="lastName" name="lastName" value="<%= student != null ? student.getLastName() : "" %>">
			</div>
			
			<div class="form-group">
				<label for="email" class="label">Email</label>
				<input type="email" id="email" name="email" value="<%= student != null ? student.getEmail() : "" %>">
			</div>
			
			<div class="form-group">
				<label for="studentClass" class="label">Class</label>
				<input type="text" id="class" name="studentClass" value="<%= student != null ? student.getStudentClass() : "" %>">
			</div>
		
			<button type="submit" class="btn">Submit</button>
		</fieldset>
	</form>
</body>
</html>