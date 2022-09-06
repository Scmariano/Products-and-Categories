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
<title>Category Page</title>
</head>
<body class="m-5">
	<h2 class="m-5 text-center">${category.name}</h2>
	<a href="/">Home</a>
	<hr>
	<div>
		<h4>Products</h4>
		<ul>
			<c:forEach var="product" items="${assignedProducts}">
				<li><a href="/products/${product.id}" class="nav-link"><c:out value="${product.name}" /></a> </li>
			</c:forEach>
		</ul>		
	</div><hr>
	<div>
		<form action="/categories/${categoryId}" method="POST">
			<h4>Add Product</h4>
			<select name="productId" id="productId" class="input">
				<c:forEach var="product" items="${unassignedProducts}">
					<option value="${product.id}"> ${product.name}</option>
				</c:forEach>
			</select>
			<button>Add</button>
		</form>
	</div>
</body>
</html>