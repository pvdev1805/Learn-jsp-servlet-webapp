package be08webapp.model;

public class Student {
	private int id;
	private String firstName;
	private String lastName;
	private String email;
	private String studentClass;
	
	public Student() {
		// TODO Auto-generated constructor stub
	}
	
	public Student(int id, String firstName, String lastName, String email, String studentClass) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.studentClass = studentClass;
	}
	
	public int getId() {
		return id;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public String getEmail() {
		return email;
	}
	
	public String getStudentClass() {
		return studentClass;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public void setStudentClass(String studentClass) {
		this.studentClass = studentClass;
	}
}
