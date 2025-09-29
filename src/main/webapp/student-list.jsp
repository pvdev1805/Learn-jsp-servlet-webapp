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
	<a href="<c:url value='/students/new' />" class="btn mb-2">+ Add New Student</a>
	<c:choose>
        <c:when test="${not empty requestScope.studentList}">
            
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
                    <c:forEach var="student" items="${requestScope.studentList}">
                        <tr>
                            <td><c:out value="${student.id}" /></td>
                            <td><c:out value="${student.firstName}" /></td>
                            <td><c:out value="${student.lastName}" /></td>
                            <td><c:out value="${student.email}" /></td>
                            <td><c:out value="${student.studentClass}" /></td>
                            <td>
                                <a href="<c:url value='/students/edit'>
                                            <c:param name='id' value='${student.id}'/>
                                        </c:url>" 
                                   class="btn btn-edit"
                                >
                                        Edit
                                </a>
                                
                                <a href="<c:url value='/students/delete'>
                                            <c:param name='id' value='${student.id}'/>
                                        </c:url>" 
                                   class="btn btn-delete"
                                >
                                        Delete
                                </a>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </c:when>

        <c:otherwise>
            <p>No students available.</p>
        </c:otherwise>
	</c:choose>
</body>
</html>