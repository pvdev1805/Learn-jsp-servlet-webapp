package be08webapp.service;

import java.sql.SQLException;
import java.util.List;

import be08webapp.dto.Student;
import be08webapp.model.StudentDAO;

public class StudentService {
	private StudentDAO studentDAO;
	
	public StudentService() {
		this.studentDAO = new StudentDAO();
	}
	
	public List<Student> getAllStudents() throws SQLException {
		return studentDAO.getAllStudents();
	}
	
	public Student getStudentById(int id) throws SQLException {
		return studentDAO.getStudentById(id);
	}
	
	public List<Student> getStudentsByClass(String studentClass) throws SQLException{
		return studentDAO.getStudentsByClass(studentClass);
	}
	
	public void addStudent(Student student) throws SQLException {
		studentDAO.addStudent(student);
	}
	
	public void updateStudent(Student student) throws SQLException {
		studentDAO.updateStudent(student);
	}
	
	public boolean deleteStudent(int id) throws SQLException {
		return studentDAO.deleteStudent(id);
	}
}
