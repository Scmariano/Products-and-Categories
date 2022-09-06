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
<title>Product Page</title>
</head>
<body class="m-5">
	<h2 class="m-5 text-center">${product.name}</h2>
	<a href="/">Home</a>
	<hr>
	<div>
		<h4>Categories</h4>
		<ul>
			<c:forEach var="category" items="${assignedCategories}">
				<li><c:out value="${category.name}"></c:out></li>
			</c:forEach>
		</ul>		
	</div><hr>
	<div>
		<form action="/products/${productId}" method="POST">
			<h4>Add Category</h4>
			<select name="categoryId" id="categoryId" class="input">
				<c:forEach var="category" items="${unassignedCategories}">
					<option value="${category.id}"> ${category.name}</option>
				</c:forEach>
			</select>
			<button>Add</button>
		</form>
	</div>
</body>
</html>