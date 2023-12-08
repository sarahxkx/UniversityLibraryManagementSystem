package net.librarymanagement.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import net.librarymanagement.model.Book;



//This DAO class provides CRUD database operations for the table Books in the database
public class BookDAO {
	
	private String jdbcURL = "jdbc:mysql://localhost:3306/LibraryManagementSystem?useSSL=false";
	private String jdbcUsername = "root";
	private String jdbcPassword = "root";
	
	private static final String INSERT_BOOKS_SQL = "INSERT INTO books" + "  (bookId, bookName, bookAuthor, description) VALUES "
			+ " (?, ?, ?, ?);";

	private static final String SELECT_BOOKS_BY_bookId = "select bookId, bookName, bookAuthor, description from books where bookId =?";
	private static final String SELECT_ALL_BOOKS = "select * from books";
	private static final String DELETE_BOOKS_SQL = "delete from books where bookId = ?;";
	private static final String UPDATE_BOOKS_SQL = "update books set bookName = ?, bookAuthor= ?, description =? where bookId = ?;";
	
	
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
	
	
	public void insertBook(Book book) throws SQLException {
		try(Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(INSERT_BOOKS_SQL);){
			preparedStatement.setInt(1, book.getBookId());
			preparedStatement.setString(2, book.getBookName());
			preparedStatement.setString(3,  book.getBookAuthor());
			preparedStatement.setString(4, book.getDescription());
			preparedStatement.executeUpdate();
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	//update books
		public boolean updateBook(Book book) throws SQLException {
			boolean rowUpdated;
			try(Connection connection =getConnection();
					PreparedStatement statement = connection.prepareStatement(UPDATE_BOOKS_SQL);){
				statement.setString(1, book.getBookName());
				statement.setString(2,  book.getBookAuthor());
				statement.setString(3, book.getDescription());
				statement.setInt(4, book.getBookId());
				
				rowUpdated = statement.executeUpdate() > 0;
				
			}
				return rowUpdated;
			
		}
		
		//select book by id
		public Book selectBook(int bookId) {
			Book book = null;
			// Step 1: Establishing a Connection
			try (Connection connection = getConnection();
					// Step 2:Create a statement using connection object
					PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BOOKS_BY_bookId);) {
				preparedStatement.setInt(1, bookId);
				System.out.println(preparedStatement);
				// Step 3: Execute the query or update query
				ResultSet rs = preparedStatement.executeQuery();

				// Step 4: Process the ResultSet object.
				while (rs.next()) {
					String bookName = rs.getString("bookName");
					String authorName = rs.getString("bookAuthor");
					String description = rs.getString("description");
					book = new Book(bookId, bookName, authorName, description);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			return book;
		}
		
		
		
		
		//select books
		public List<Book> selectAllBooks() {
			List<Book> books = new ArrayList<>();
			// Step 1: Establishing a Connection
			try (Connection connection = getConnection();
					// Step 2:Create a statement using connection object
					PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_BOOKS);) {
				System.out.println(preparedStatement);
				// Step 3: Execute the query or update query
				ResultSet rs = preparedStatement.executeQuery();

				//System.out.println("executed");

				// Step 4: Process the ResultSet object.
				while (rs.next()) {
					int bookId = rs.getInt("bookId");
					String bookName = rs.getString("bookName");
					String authorName = rs.getString("bookAuthor");
					String description = rs.getString("description");
					books.add(new Book(bookId, bookName, authorName, description));
				}
			} catch (Exception e) {
				e.printStackTrace();

			}
			return books;
		}
		
		//delete books 
		public boolean deleteBook(int bookId) throws SQLException {
			boolean rowDeleted;
			try (Connection connection = getConnection();
					PreparedStatement statement = connection.prepareStatement(DELETE_BOOKS_SQL);) {
				statement.setInt(1, bookId);
				rowDeleted = statement.executeUpdate() > 0;
			}
			return rowDeleted;
		}

}
