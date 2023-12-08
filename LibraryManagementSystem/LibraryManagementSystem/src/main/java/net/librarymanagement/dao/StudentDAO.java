package net.librarymanagement.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import net.librarymanagement.model.Student;



//This DAO class provides CRUD database operations for the table Students in the database
public class StudentDAO {
	
	private String jdbcURL = "jdbc:mysql://localhost:3306/LibraryManagementSystem?useSSL=false";
	private String jdbcUsername = "root";
	private String jdbcPassword = "root";
	
	private static final String INSERT_STUDENTS_SQL = "INSERT INTO students" + "  (studentId, studentFName, studentLName, studentEmailId, course, studentPassword ) VALUES "
			+ " (?, ?, ?, ?, ?, ?);";

	private static final String SELECT_STUDENTS_BY_studentId = "select studentId, studentsFName, studentsLName, studentEmailId, course, studentPassword from students where studentsId =?";
	private static final String SELECT_ALL_STUDENTS = "select * from students";
	private static final String DELETE_STUDENTS_SQL = "delete from students where studentId = ?;";
	private static final String UPDATE_STUDENTS_SQL = "update students set studentFName = ?, studentLName= ?, studentEmailId =? course =? studentPassword =? where studentId = ?;";
	
	
	protected Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;
	}
	
	
	public void insertStudent(Student student) throws SQLException {
		try(Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(INSERT_STUDENTS_SQL);){
			preparedStatement.setInt(1, student.getStudentId());
			preparedStatement.setString(2, student.getStudentFName());
			preparedStatement.setString(3,  student.getStudentLName());
			preparedStatement.setString(4, student.getStudentEmailId());
			preparedStatement.setString(5, student.getCourse());
			preparedStatement.setString(6, student.getStudentPassword());
			preparedStatement.executeUpdate();
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	//update students
		public boolean updateStudent(Student student) throws SQLException {
			boolean rowUpdated;
			try(Connection connection =getConnection();
					PreparedStatement statement = connection.prepareStatement(UPDATE_STUDENTS_SQL);){
				statement.setString(1, student.getStudentFName());
				statement.setString(2,  student.getStudentLName());
				statement.setString(3, student.getStudentEmailId());
				statement.setString(4, student.getCourse());
				statement.setString(5, student.getStudentPassword());
				
				rowUpdated = statement.executeUpdate() > 0;
				
			}
				return rowUpdated;
			
		}
		
		//select student by id
		public Student selectStudent(int studentId) {
			Student student = null;
			// Step 1: Establishing a Connection
			try (Connection connection = getConnection();
					// Step 2:Create a statement using connection object
					PreparedStatement preparedStatement = connection.prepareStatement(SELECT_STUDENTS_BY_studentId);) {
				preparedStatement.setInt(1, studentId);
				System.out.println(preparedStatement);
				// Step 3: Execute the query or update query
				ResultSet rs = preparedStatement.executeQuery();

				// Step 4: Process the ResultSet object.
				while (rs.next()) {
					String studentFName = rs.getString("studentFName");
					String studentLName = rs.getString("studentLName");
					String studentEmailId = rs.getString("studentEmailId");
					String course = rs.getString("course");
					String studentPassword = rs.getString("studentPassword");
					student = new Student(studentId, studentFName, studentLName, studentEmailId, course, studentPassword);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			return student;
		}
		
		
		
		
		//select students
		public List<Student> selectAllStudents() {
			List<Student> students = new ArrayList<>();
			// Step 1: Establishing a Connection
			try (Connection connection = getConnection();
					// Step 2:Create a statement using connection object
					PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_STUDENTS);) {
				System.out.println(preparedStatement);
				// Step 3: Execute the query or update query
				ResultSet rs = preparedStatement.executeQuery();

				//System.out.println("executed");

				// Step 4: Process the ResultSet object.
				while (rs.next()) {
					int studentId = rs.getInt("studentId");
					String studentFName = rs.getString("studentFName");
					String studentLName = rs.getString("studentLName");
					String studentEmailId = rs.getString("studentEmailId");
					String course = rs.getString("course");
					String studentPassword = rs.getString("studentPassword");
					students.add(new Student(studentId, studentFName, studentLName, studentEmailId, course, studentPassword));
				}
			} catch (Exception e) {
				e.printStackTrace();

			}
			return students;
		}
		
		//delete students 
		public boolean deleteStudent(int studentId) throws SQLException {
			boolean rowDeleted;
			try (Connection connection = getConnection();
					PreparedStatement statement = connection.prepareStatement(DELETE_STUDENTS_SQL);) {
				statement.setInt(1, studentId);
				rowDeleted = statement.executeUpdate() > 0;
			}
			return rowDeleted;
		}


}
