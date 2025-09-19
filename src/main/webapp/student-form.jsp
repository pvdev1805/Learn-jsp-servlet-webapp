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
	
	<form method="POST" action="/students">
		<fieldset>
			<legend>Student Information</legend>
			
			<div class="form-group">
				<label for="id" class="label">Id</label>
				<input type="text" id="id" name="id">
			</div>
			
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
				<label for="class" class="label">Class</label>
				<input type="text" id="class" name="class">
			</div>
		
			<button type="submit" class="btn">Submit</button>
		</fieldset>
	</form>
</body>
</html>