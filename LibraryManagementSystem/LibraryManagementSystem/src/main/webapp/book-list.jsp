<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Library Management System</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
</head>
<body>

	<header class="sticky-top">
        <div class="row flex-nowrap justify-content-between align-items-center" style="background-color: tomato">
          <div class="col-4 pt-1">
            <a href="<%=request.getContextPath()%>/listbook" class="nav-link py-2 d-none d-md-inline-block"><img src="Images/book.png" width="50" height="50" border="0"/><span class="sr-only">(current)</span></a>
          </div>
          <div class="col-4 text-center">
          <h1>
            <a class="blog-header-logo text-dark" href="home.jsp">University Library</a>
          </h1> 
          </div>
          <div class="col-2 d-flex justify-content-end align-items-center">
         	<a href="<%=request.getContextPath()%>/liststudent"class="nav-link py-2 d-none d-md-inline-block">Students</a>
            <%-- <a href="<%=request.getContextPath()%>/login" class="nav-link py-2 d-none d-md-inline-block">Students<span class="sr-only">(current)</span></a> --%>
          </div>
          <div class="col-4 d-flex justify-content-end align-items-center">
            <a href="<%=request.getContextPath()%>/login" class="nav-link py-2 d-none d-md-inline-block"><img src="Images/user.png" width="40" height="40" border="0"/><span class="sr-only">(current)</span></a>
          </div>
        </div>
    </header>

	<div class="row">
		<!-- <div class="alert alert-success" *ngIf='message'>{{message}}</div> -->

		<div class="container">
			<h3 class="text-center">List of Books</h3>
			<hr>
			<div class="container text-left">

				<a href="<%=request.getContextPath()%>/newBook" class="btn btn-success">Add New Book</a>
			</div>
			<br>
			<table class="table table-bordered">
				<thead>
					<tr>
						<th>Book ID</th>
						<th>Book Name</th>
						<th>Author Of Book</th>
						<th>Description</th>
						<th>Actions</th>
					</tr>
				</thead>
				<tbody>
					<!--   for (Todo todo: todos) {  -->
					<c:forEach var="book" items="${listBook}">

						<tr>
							<td><c:out value="${book.bookId}" /></td>
							<td><c:out value="${book.bookName}" /></td>
							<td><c:out value="${book.bookAuthor}" /></td>
							<td><c:out value="${book.description}" /></td>
							<td><a href="editbook?bookId=<c:out value='${book.bookId}' />">Edit</a>
								&nbsp;&nbsp;&nbsp;&nbsp; <a
								href="deletebook?bookId=<c:out value='${book.bookId}' />">Delete</a></td>
						</tr>
					</c:forEach>
					<!-- } -->
				</tbody>

			</table>
		</div>
	</div>
</body>
</html>