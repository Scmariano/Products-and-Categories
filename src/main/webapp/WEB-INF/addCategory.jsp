<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"  %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<title>New Category</title>
</head>
<body>
	<div class = "m-5">
		<h1 class="text-center m-5">New Product</h1>
		<a href="/">Home</a>
		<div class="container mx-auto mt-4">
			<form:form action="/category/create" modelAttribute="category" method="POST" class="col-5 mt-4 p-3">
				<div>
					<form:errors path="*" class="text-danger"/>
				</div>
				<div class="mb-3">
					<form:label path="name" >Name:</form:label>
					<form:input path="name" class="form-control" />
				</div>
				<button>Submit</button>
			</form:form>
		</div>
	</div>
</body>
</html>