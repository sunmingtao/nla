<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<meta name="description" content="">
<meta name="author" content="">

<title>All persons</title>

<!-- Bootstrap core CSS -->
<link href="<c:url value="/resources/css/bootstrap.min.css" />"
	rel="stylesheet">

<script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
<script src="<c:url value="/resources/js/jquery-1.10.1.min.js" />"></script>
<script src="<c:url value="/resources/js/main.js" />"></script>

<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
<!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>

<body>
	<%@include file="includes/navbar.jsp" %>
	<div class="container">
		<div class="page-header">
			<h1>All persons</h1>
		</div>

		<div class="row">
			<div class="col-md-12">
				<table class="table table-striped">
					<thead>
						<tr>
							<th>Name</th>
							<th>Phone</th>
							<th>Email</th>
							<th>Borrowed books</th>
							<th></th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${persons}" var="person">
							<tr>
								<td>${person.name}</td>
								<td>${person.phone}</td>
								<td>${person.email}</td>
								<td id="borrowedBooks${person.id}"></td>
								<td><button class="loadbooks" id="${person.id}">Load books</button></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</body>
</html>
