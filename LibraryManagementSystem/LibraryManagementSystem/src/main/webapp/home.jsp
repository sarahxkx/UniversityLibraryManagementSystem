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
          <div class="col-2 d-flex justify-content-end align-items-center">
            <a href="<%=request.getContextPath()%>/login" class="nav-link py-2 d-none d-md-inline-block"><img src="Images/user.png" width="40" height="40" border="0"/><span class="sr-only">(current)</span></a>
          </div>
        </div>
    </header>

	<%-- test --%>
	<%-- <header class="sticky-top">
		<nav class="navbar navbar-expand-md navbar-dark"style="background-color: tomato">
			<a href="home.jsp" class="navbar-brand"> University Library </a>
			<div class="collapse navbar-collapse">
				<ul class="navbar-nav mr-auto">
					<li><a href="<%=request.getContextPath()%>/listbook" class="nav-link py-2 d-none d-md-inline-block"><b>Books</b><br><img src="Images/book.png" width="50" height="50" border="0"/><span class="sr-only">(current)</span></a></li>
					<li><a href="<%=request.getContextPath()%>/login" class="nav-link py-2 d-none d-md-inline-block"><b>Account</b><br><img src="Images/user.png" width="40" height="40" border="0"/><span class="sr-only">(current)</span></a></li>
				</ul>	
				<form class="form-inline my-2 my-lg-0">
		          <input class="form-control mr-sm-2" type="text" placeholder="Search" aria-label="Search">
		          <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
		        </form>
			</div>
		</nav>
	</header> --%>
	
	
	<br>

	<div class="row">
		<div class="container">
			<hr>
			<div class="container text-left">
				<a href="student-form.jsp" class="btn btn-success">Register as Student</a>
				<a href="student-form.jsp" class="btn btn-success">Register as Faculty</a>
				<a href="student-form.jsp" class="btn btn-success">Admin</a>
			</div>
			<br>
		</div>
	</div>
</body>
</html>