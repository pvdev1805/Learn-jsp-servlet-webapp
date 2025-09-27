package be08webapp.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import be08webapp.dto.Student;
import be08webapp.service.StudentService;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/students/*")
public class StudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private StudentService studentService;
	
	public void init() throws ServletException {
		// Initialize userService when Servlet is initialized
		this.studentService = new StudentService();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pathInfo = request.getPathInfo();
		
		try {
			String newPath = "/new";
			String deletePath = "/delete";
			String editPath = "/edit";
			if(newPath.equals(pathInfo)) {
				showNewForm(request, response);
			} else if(deletePath.equals(pathInfo)) {
				deleteStudent(request, response);
			} else if(editPath.equals(pathInfo)) {
				showEditForm(request, response);
			} else {
				showStudentList(request, response);
			}
		} catch (SQLException e) {
			// TODO: handle exception
			throw new ServletException(e);
		}
	}
	
	private void showStudentList(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		String studentClass = request.getParameter("class");
		List<Student> studentList = null;
		
		if(studentClass != null && !studentClass.isEmpty()) {
			studentList = studentService.getStudentsByClass(studentClass);
		} else {
			studentList = studentService.getAllStudents();
		}
		
		request.setAttribute("studentList", studentList);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/student-list.jsp");
		dispatcher.forward(request, response);
	}
	
	private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/student-form.jsp");
		dispatcher.forward(request, response);
	}
	
	private void deleteStudent(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		String idString = request.getParameter("id");
		int id = Integer.parseInt(idString);
		studentService.deleteStudent(id);
		
		response.sendRedirect(request.getContextPath() + "/students");
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pathInfo = request.getPathInfo();
		
		try {
			String newPath = "/new";
			String editPath = "/edit";
			if(newPath.equals(pathInfo)) {
				addStudent(request, response);
			} else if(editPath.equals(pathInfo)) {
				updateStudent(request, response);
			}
		} catch (SQLException e) {
			throw new ServletException(e);
		}
	}
	
	private void addStudent(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String email = request.getParameter("email");
		String studentClass = request.getParameter("studentClass");
		
		Student newStudent = Student.builder().firstName(firstName).lastName(lastName).email(email).studentClass(studentClass).build();
		studentService.addStudent(newStudent);
		response.sendRedirect(request.getContextPath() + "/students");
	}
	
	private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		String idString = request.getParameter("id");
		int id = Integer.parseInt(idString);
		Student student = studentService.getStudentById(id);
		
		request.setAttribute("student", student);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/student-form.jsp");
		dispatcher.forward(request, response);
	}
	
	private void updateStudent(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		String idString = request.getParameter("id");
		if(idString != null && !idString.isEmpty()) {
			int id = Integer.parseInt(idString);
			String firstName = request.getParameter("firstName");
			String lastName = request.getParameter("lastName");
			String email = request.getParameter("email");
			String studentClass = request.getParameter("studentClass");

			Student student = Student.builder()
					.id(id)
					.firstName(firstName)
					.lastName(lastName)
					.email(email)
					.studentClass(studentClass)
					.build();
			studentService.updateStudent(student);
			response.sendRedirect(request.getContextPath() + "/students");
		} 
	}
}
