<%@page import="be08webapp.model.Student"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Students</title>
<link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
	<h1>Student List</h1>
	<%
		List<Student> students = (List<Student>)request.getAttribute("studentList");
		if(students != null && !students.isEmpty()){
	%>
		<table>
			<thead>
				<tr>
					<th>ID</th>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Email</th>
					<th>Class</th>
				</tr>
			</thead>
			
			<tbody>
	<%
			for(Student student: students){
	%>
				<tr>
					<td><%= student.getId() %></td>
					<td><%= student.getFirstName() %></td>
					<td><%= student.getLastName() %></td>
					<td><%= student.getEmail() %></td>
					<td><%= student.getStudentClass() %></td>
				</tr>
				
	<%
			}
	%>
			</tbody>
		</table>
	<%
		} else {
	%>
		<p>Student Not Found or Query Param "?class" is not available in URL.</p>
	<%
		}
	%>
</body>
</html>