package be08webapp.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO {
	public List<Student> getStudentsByClass(String studentClass){
		List<Student> students = new ArrayList<Student>();
		String sql = "SELECT * FROM students WHERE class = ?";
		
		try(Connection conn = DatabaseConnection.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, studentClass);
			
			try(ResultSet rs = pstmt.executeQuery()){
				while(rs.next()) {
					Student student = new Student(
							rs.getInt("id"),
							rs.getString("first_name"),
							rs.getString("last_name"),
							rs.getString("email"),
							rs.getString("class")
					);
					students.add(student);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return students;
	}
}
