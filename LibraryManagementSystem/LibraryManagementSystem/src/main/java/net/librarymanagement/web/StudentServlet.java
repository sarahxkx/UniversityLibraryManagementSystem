package net.librarymanagement.web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.librarymanagement.dao.StudentDAO;
import net.librarymanagement.model.Student;


public class StudentServlet {
	
	private static final long serialVersionUID = 1L;
	private StudentDAO studentDAO;
		
		
	public StudentServlet() {
		this.studentDAO = new StudentDAO();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		this.doGet(request, response);
	}	

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		String action = request.getServletPath();
		
		
		try {
			switch (action) {
			case "/newstudent":
				showNewFormStudent(request, response);
				break;
			case "/insertstudent":
				insertStudent(request, response);
				break;
			case "/deletestudent":
				deleteStudent(request, response);
				break;
			case "/editstudent":
				showEditFormStudent(request, response);
				break;
			case "/updatestudent":
				updateStudent(request, response);
				break;
			default:
				listStudent(request, response);
				break;
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}

	private void listStudent(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		List<Student> listStudent = studentDAO.selectAllStudents();
		request.setAttribute("listStudent", listStudent);
		RequestDispatcher dispatcher = request.getRequestDispatcher("student-list.jsp");
		dispatcher.forward(request, response);
	}

	private void updateStudent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException{
		int studentId = Integer.parseInt(request.getParameter("studentId"));
		String studentFName = request.getParameter("studentFName");
		String studentLName = request.getParameter("studentLName");
		String studentEmailId = request.getParameter("studentEmailId");
		String course = request.getParameter("course"); 
		String studentPassword = request.getParameter("studentPassword"); 
		
		Student student = new Student(studentId, studentFName, studentLName, studentEmailId, course, studentPassword);
		studentDAO.updateBook(student);
		response.sendRedirect("liststudent");
	}

	private void showEditFormStudent(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		int studentId = Integer.parseInt(request.getParameter("studentId"));
		Student existingStudent = studentDAO.selectStudent(studentId);
		RequestDispatcher dispatcher = request.getRequestDispatcher("student-form.jsp");
		request.setAttribute("student", existingStudent);
		dispatcher.forward(request, response);
		
	}

	private void deleteStudent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException{
		
		int studentId = Integer.parseInt(request.getParameter("studentId"));
		studentDAO.deleteStudent(studentId);
		response.sendRedirect("liststudent");
	}

	private void insertStudent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException{
		int studentId = Integer.parseInt(request.getParameter("studentId"));
		String studentFName = request.getParameter("studentFName");
		String studentLName = request.getParameter("studentLName");
		String studentEmailId = request.getParameter("studentEmailId");
		String course = request.getParameter("course"); 
		String studentPassword = request.getParameter("studentPassword"); 
		
		Student newStudent = new Student(studentId, studentFName, studentLName, studentEmailId, course, studentPassword);
		studentDAO.insertStudent(newStudent);
		response.sendRedirect("liststudent");
		
	}

	private void showNewFormStudent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		RequestDispatcher dispatcher = request.getRequestDispatcher("student-form.jsp");
		dispatcher.forward(request, response);
	}

}
