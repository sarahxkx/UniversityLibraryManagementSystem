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
    
	<div class="container col-md-5">
		<div class="card">
			<div class="card-body">
				<c:if test="${student != null}">
					<form action="updatestudent" method="post">
				</c:if>
				<c:if test="${student == null}">
					<form action="insertstudent" method="post">
				</c:if>

				<caption>
					<h2>
						<c:if test="${student != null}">
            			Edit Student
            		</c:if>
						<c:if test="${student == null}">
            			Add New Student
            		</c:if>
					</h2>
				</caption>

				<!--<c:if test="${book != null}">
					<input type="hidden" name="bookId" value="<c:out value='${book.bookId}' />" />
				</c:if> -->
				
				<fieldset class="form-group">
					<label>Student ID</label> <input type="text"
						value="<c:out value='${student.studentId}' />" class="form-control"
						name="studentId" required="required">
				</fieldset>
				

				<fieldset class="form-group">
					<label>Student First Name</label> <input type="text"
						value="<c:out value='${student.studentFName}' />" class="form-control"
						name="studentFName" required="required">
				</fieldset>

				<fieldset class="form-group">
					<label>Student Last Name</label> <input type="text"
						value="<c:out value='${student.studentLName}' />" class="form-control"
						name="studentLName">
				</fieldset>

				<fieldset class="form-group">
					<label>Email Id</label> <input type="text"
						value="<c:out value='${student.studentEmailId}' />" class="form-control"
						name="studentEmailId">
				</fieldset>
				
				<fieldset class="form-group">
					<label>Course</label> <input type="text"
						value="<c:out value='${student.course}' />" class="form-control"
						name="course">
				</fieldset>
				
				<fieldset class="form-group">
					<label>Password</label> <input type="text"
						value="<c:out value='${student.studentPassword}' />" class="form-control"
						name="studentPassword">
				</fieldset>

				<button type="submit" class="btn btn-success">Save</button>
				</form>
			</div>
		</div>
	</div>
</body>
</html>