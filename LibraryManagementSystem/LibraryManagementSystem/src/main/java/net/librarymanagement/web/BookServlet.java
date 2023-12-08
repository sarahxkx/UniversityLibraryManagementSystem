package net.librarymanagement.web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import net.librarymanagement.dao.BookDAO;
import net.librarymanagement.model.Book;


@WebServlet("/")
public class BookServlet  extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
	private BookDAO bookDAO;
		
		
	public BookServlet() {
		this.bookDAO = new BookDAO();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		this.doGet(request, response);
	}	

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		String action = request.getServletPath();
		
		
		try {
			switch (action) {
			case "/newbook":
				showNewForm(request, response);
				break;
			case "/insertbook":
				insertBook(request, response);
				break;
			case "/deletebook":
				deleteBook(request, response);
				break;
			case "/editbook":
				showEditForm(request, response);
				break;
			case "/updatebook":
				updateBook(request, response);
				break;
			default:
				listBook(request, response);
				break;
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}

	private void listBook(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		List<Book> listBook = bookDAO.selectAllBooks();
		request.setAttribute("listBook", listBook);
		RequestDispatcher dispatcher = request.getRequestDispatcher("book-list.jsp");
		dispatcher.forward(request, response);
	}

	private void updateBook(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException{
		int bookId = Integer.parseInt(request.getParameter("bookId"));
		String bookName = request.getParameter("bookName");
		String authorName = request.getParameter("bookAuthor");
		String description = request.getParameter("description"); 
		
		Book book = new Book(bookId, bookName, authorName, description);
		bookDAO.updateBook(book);
		response.sendRedirect("listbook");
	}

	private void showEditForm(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		int bookId = Integer.parseInt(request.getParameter("bookId"));
		Book existingBook = bookDAO.selectBook(bookId);
		RequestDispatcher dispatcher = request.getRequestDispatcher("book-form.jsp");
		request.setAttribute("book", existingBook);
		dispatcher.forward(request, response);
		
	}

	private void deleteBook(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException{
		
		int bookId = Integer.parseInt(request.getParameter("bookId"));
		bookDAO.deleteBook(bookId);
		response.sendRedirect("listbook");
	}

	private void insertBook(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException{
		int bookId = Integer.parseInt(request.getParameter("bookId"));
		String bookName = request.getParameter("bookName");
		String bookAuthor = request.getParameter("bookAuthor"); 
		String description = request.getParameter("description"); 
		Book newBook = new Book(bookId, bookName, bookAuthor, description);
		bookDAO.insertBook(newBook);
		response.sendRedirect("listbook");
		
	}

	private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		RequestDispatcher dispatcher = request.getRequestDispatcher("book-form.jsp");
		dispatcher.forward(request, response);
	}
		
}	
		
	
	
