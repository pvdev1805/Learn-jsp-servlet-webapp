<%@page import="be08webapp.dto.Student"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Students</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/style.css">
</head>
<body>
	<h1>Student List</h1>
	<a href="students/new" class="btn mb-2">+ Add New Student</a>
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
					<th>Action</th>
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
					<td>
						<a href="<%= request.getContextPath() %>/students/edit?id=<%= student.getId() %>" class="btn btn-edit">Edit</a>
						<a href="<%= request.getContextPath() %>/students/delete?id=<%= student.getId() %>" class="btn btn-delete">Delete</a>
					</td>
				</tr>
				
	<%
			}
	%>
			</tbody>
		</table>
	<%
		} else {
	%>
		<p>No student available.</p>
	<%
		}
	%>
</body>
</html>