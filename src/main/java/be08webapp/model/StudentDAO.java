package be08webapp.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import be08webapp.dto.Student;

public class StudentDAO {
	public Student getStudentById(int id) throws SQLException {
		String sqlQuery = "SELECT * FROM students WHERE id = ?";
		
		try(Connection conn = DatabaseConnection.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sqlQuery)) {
			pstmt.setInt(1, id);
			
			try(ResultSet rs = pstmt.executeQuery()){
				if(rs.next()) {
					Student student = Student.builder()
							.id(rs.getInt("id"))
							.firstName(rs.getString("first_name"))
							.lastName(rs.getString("last_name"))
							.email(rs.getString("email"))
							.studentClass(rs.getString("class"))
							.build();
					return student;
				}
			}
		}
		
		// No student is found
		return null;
	}
	
	public List<Student> getStudentsByClass(String studentClass) throws SQLException {
		List<Student> students = new ArrayList<Student>();
		String sqlQuery = "SELECT * FROM students WHERE class = ?";
		
		try(Connection conn = DatabaseConnection.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sqlQuery)) {
			pstmt.setString(1, studentClass);
			
			try(ResultSet rs = pstmt.executeQuery()){
				while(rs.next()) {
					Student student = Student.builder()
							.id(rs.getInt("id"))
							.firstName(rs.getString("first_name"))
							.lastName(rs.getString("last_name"))
							.email(rs.getString("email"))
							.studentClass(rs.getString("class"))
							.build();
					students.add(student);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return students;
	}
	
	public List<Student> getAllStudents() throws SQLException {
		List<Student> students = new ArrayList<Student>();
		String sqlQuery = "SELECT * FROM students";
		
		try(Connection conn = DatabaseConnection.getConnection(); 
				PreparedStatement pstmt = conn.prepareStatement(sqlQuery)){
			
			try(ResultSet rs = pstmt.executeQuery()){
				while(rs.next()) {
					Student student = Student.builder()
							.id(rs.getInt("id"))
							.firstName(rs.getString("first_name"))
							.lastName(rs.getString("last_name"))
							.email(rs.getString("email"))
							.studentClass(rs.getString("class"))
							.build();
					students.add(student);
				}
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		return students;
	}
	
	public void addStudent(Student student) throws SQLException {
		String sqlQuery = "INSERT INTO students (first_name, last_name, email, class) VALUES (?, ?, ?, ?)";
		
		try(Connection conn = DatabaseConnection.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sqlQuery)) {
			pstmt.setString(1, student.getFirstName());
			pstmt.setString(2, student.getLastName());
			pstmt.setString(3, student.getEmail());
			pstmt.setString(4, student.getStudentClass());
			
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void updateStudent(Student student) throws SQLException {
		String sqlQuery = "UPDATE students SET first_name = ?, last_name = ?, email = ?, class = ? WHERE id = ?";
		
		try(Connection conn = DatabaseConnection.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sqlQuery)) {
			pstmt.setString(1, student.getFirstName());
			pstmt.setString(2, student.getLastName());
			pstmt.setString(3, student.getEmail());
			pstmt.setString(4, student.getStudentClass());
			pstmt.setInt(5, student.getId());
			
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public boolean deleteStudent(int id) throws SQLException {
		String sqlQuery = "DELETE FROM students WHERE id = ?";
		try(Connection conn = DatabaseConnection.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sqlQuery)) {
			pstmt.setInt(1, id);
			int rowsAffected = pstmt.executeUpdate();
			return rowsAffected > 0;
		}
	}
}
