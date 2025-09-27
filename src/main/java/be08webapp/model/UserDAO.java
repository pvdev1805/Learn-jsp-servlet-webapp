package be08webapp.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import be08webapp.dto.User;

public class UserDAO {
	public User findByUsername(String username) throws SQLException {
		String sqlQuery = "SELECT id, username, password_hash FROM users WHERE username = ?";
		
		try(Connection conn = DatabaseConnection.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sqlQuery)){
			pstmt.setString(1, username);
			
			try(ResultSet rs = pstmt.executeQuery()){
				if(rs.next()) {
					return User.builder()
							.id(rs.getInt("id"))
							.username(rs.getString("username"))
							.passwordHash(rs.getString("password_hash"))
							.build();
				}
			}
		}
		return null;
	}
}
