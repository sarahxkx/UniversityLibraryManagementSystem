package net.librarymanagement.model;

//Book Java Bean Class
public class Book {
	
	private int bookId;
	private String bookName;
	private String bookAuthor;
	private String description;
	
	
	public Book(String bookName, String bookAuthor, String description) {
		super();
		this.bookName = bookName;
		this.bookAuthor = bookAuthor;
		this.description = description;
	}
	public Book(int bookId, String bookName, String bookAuthor, String description) {
		super();
		this.bookId = bookId;
		this.bookName = bookName;
		this.bookAuthor = bookAuthor;
		this.description = description;
	}
	public int getBookId() {
		return bookId;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getBookAuthor() {
		return bookAuthor;
	}
	public void setBookAuthor(String authorName) {
		this.bookAuthor = bookAuthor;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

}
