package be08webapp.service;

import java.sql.SQLException;

import org.mindrot.jbcrypt.BCrypt;

import be08webapp.dto.User;
import be08webapp.model.UserDAO;

public class AuthService {
	private UserDAO userDAO;
	
	public AuthService() {
        this.userDAO = new UserDAO();
    }
	
	public String hashPassword(String rawPassword) {
		return BCrypt.hashpw(rawPassword, BCrypt.gensalt(12));
	}
	
	public boolean validateUser(String username, String rawPassword) throws SQLException {
		User user = userDAO.findByUsername(username);
		
		if(user == null) return false;
		
		String storedHashedPassword = user.getPasswordHash();
		
		boolean passwordMatches = BCrypt.checkpw(rawPassword, storedHashedPassword);
		
		return passwordMatches;
	}
	
	public boolean registerUser(String username, String rawPassword) throws SQLException {
		// Check whether username has already existed or not
		if(userDAO.findByUsername(username) != null) {
			return false;
		}
		
		// Hashing password
		String hashedPassword = hashPassword(rawPassword);
		
		// Save new user to database
		return userDAO.saveUser(username, hashedPassword);
	}
}
