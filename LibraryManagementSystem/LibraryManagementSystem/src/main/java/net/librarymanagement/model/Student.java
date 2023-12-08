package net.librarymanagement.model;

//Book Java Bean Class
public class Student {
	
	private int studentId;
	private String studentFName;
	private String studentLName;
	private String studentEmailId;
	private String course;
	private String studentPassword;
	
	public Student(String studentFName, String studentLName, String studentEmailId, String course,
			String studentPassword) {
		super();
		this.studentFName = studentFName;
		this.studentLName = studentLName;
		this.studentEmailId = studentEmailId;
		this.course = course;
		this.studentPassword = studentPassword;
	}
	public Student(int studentId, String studentFName, String studentLName, String studentEmailId, String course,
			String studentPassword) {
		super();
		this.studentId = studentId;
		this.studentFName = studentFName;
		this.studentLName = studentLName;
		this.studentEmailId = studentEmailId;
		this.course = course;
		this.studentPassword = studentPassword;
	}
	
	
	
	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	public String getStudentFName() {
		return studentFName;
	}
	public void setStudentFName(String studentFName) {
		this.studentFName = studentFName;
	}
	public String getStudentLName() {
		return studentLName;
	}
	public void setStudentLName(String studentLName) {
		this.studentLName = studentLName;
	}
	public String getStudentEmailId() {
		return studentEmailId;
	}
	public void setStudentEmailId(String studentEmailId) {
		this.studentEmailId = studentEmailId;
	}
	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course = course;
	}
	public String getStudentPassword() {
		return studentPassword;
	}
	public void setStudentPassword(String studentPassword) {
		this.studentPassword = studentPassword;
	}
	

}
