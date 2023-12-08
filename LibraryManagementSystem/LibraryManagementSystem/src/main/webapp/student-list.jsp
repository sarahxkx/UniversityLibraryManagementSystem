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

	<%-- <header>
		<nav class="navbar navbar-expand-md navbar-dark"
			style="background-color: tomato">
			<div>
			
		
				<a href="home.jsp"
				class="navbar-brand"> Library Management System </a>
			</div>
			

			<ul class="navbar-nav">
				<li><a href="<%=request.getContextPath()%>/liststudent"
					class="nav-link">Students</a></li>
			</ul>
		</nav>
	</header> --%>
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
	<br>

	<div class="row">
		<!-- <div class="alert alert-success" *ngIf='message'>{{message}}</div> -->

		<div class="container">
			<h3 class="text-center">List of Students</h3>
			<hr>
			<div class="container text-left">
				<a href="<%=request.getContextPath()%>/newstudent" class="btn btn-success">Add
					New Student</a>
			</div>
			<br>
			<table class="table table-bordered">
				<thead>
					<tr>
						<th>Student ID</th>
						<th>Student First Name</th>
						<th>Student Last Name</th>
						<th>Email Id</th>
						<th>Course</th>
						<th>Actions</th>
					</tr>
				</thead>
				<tbody>
					<!--   for (Todo todo: todos) {  -->
					<c:forEach var="student" items="${listStudent}">

						<tr>
							<td><c:out value="${student.studentId}" /></td>
							<td><c:out value="${student.studentFName}" /></td>
							<td><c:out value="${student.studentLName}" /></td>
							<td><c:out value="${student.studentEmailId}" /></td>
							<td><c:out value="${student.course}" /></td>
							<td><a href="editstudent?studentId=<c:out value='${student.studentId}' />">Edit</a>
								&nbsp;&nbsp;&nbsp;&nbsp; <a
								href="deletestudent?studentId=<c:out value='${student.studentId}' />">Delete</a></td>
						</tr>
					</c:forEach>
					<!-- } -->
				</tbody>

			</table>
		</div>
	</div>
</body>
</html>