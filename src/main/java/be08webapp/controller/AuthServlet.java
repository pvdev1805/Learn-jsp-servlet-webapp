package be08webapp.controller;

import java.io.IOException;
import java.sql.SQLException;

import be08webapp.service.AuthService;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet({"/login", "/logout"})
public class AuthServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final String homePath = "/";
    private final String loginPath = "/login";
    private final String logoutPath = "/logout";
	private AuthService authService;
    

    public void init() {
        this.authService = new AuthService();
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	String path = request.getServletPath();
    	
    	if(logoutPath.equals(path)) {
    		handleLogout(request, response);
    	} else if(loginPath.equals(path)) {
    		showLoginForm(request, response);
    	}
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	String path = request.getServletPath();
    	
    	if(loginPath.equals(path)) {
    		handleLogin(request, response);
    	}
    }
    
    private void showLoginForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	RequestDispatcher dispatcher = request.getRequestDispatcher("/login-form.jsp");
    	dispatcher.forward(request, response);
    }
    
    private void handleLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	String username = request.getParameter("username");
    	String password = request.getParameter("password");
    	
    	try {
    		boolean isAuthenticated = authService.validateUser(username, password);
    		
    		if(isAuthenticated) {
    			HttpSession session = request.getSession();
    			session.setAttribute("username", username);
    			session.setMaxInactiveInterval(30 * 60); // Set Timeout after 30 minutes
    			
    			response.sendRedirect(request.getContextPath() + homePath);
    		} else {
    			request.setAttribute("errorMessage", "Username or password is invalid");
    			showLoginForm(request, response);
    		}
    	} catch(SQLException e) {
    		request.setAttribute("errorMessage", "System Error: Could not connect to Database.");
    		showLoginForm(request, response);
    		
    		throw new ServletException("Database error during login", e);
    	}
    }
    
    private void handleLogout(HttpServletRequest request, HttpServletResponse response) throws IOException {
    	HttpSession session = request.getSession(false);
    	if(session != null) {
    		session.invalidate();
    	}
    	
    	response.sendRedirect(request.getContextPath() + loginPath);
    }
}
