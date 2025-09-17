package be08webapp.controller;

import java.io.IOException;
import java.util.List;

import be08webapp.model.Student;
import be08webapp.model.StudentDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/students")
public class StudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String studentClass = request.getParameter("class");
		
		List<Student> studentList = null;
		if(studentClass != null && !studentClass.isEmpty()) {
			StudentDAO studentDAO = new StudentDAO();
			studentList = studentDAO.getStudentsByClass(studentClass);
		}
		
		request.setAttribute("studentList", studentList);
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}
}
