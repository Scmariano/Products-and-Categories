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
<title>Home Page</title>
</head>
<body class="m-5">
	<h1 class="text-center m-5">Home Page</h1>
	
	<div class = "m-5">
		<div>
			<p><a href="/products/new" class="nav-link">New Product</a></p>
		</div>
		<div>
			<p><a href="/categories/new" class="nav-link">New Category</a></p>
		</div>
	</div><hr>
	<div class="row mx-auto mt-3 m-5">
		<table class="table table-striped table-bordered caption-top">
			<thead class="table-info">
				<tr  class="align-middle text-center">
					<th>Products</th>
					<th>Categories</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>
						<ul>
							<c:forEach var="product" items="${products}">
								<li><a href="/products/${product.id}" class="nav-link"><c:out value="${product.name}" /></a> </li>
							</c:forEach>
						</ul>
					</td>
					<td>
						<ul>
							<c:forEach var="category" items="${categories}">
								<li><a href="/categories/${category.id}" class="nav-link"><c:out value="${category.name}" /></a> </li>
							</c:forEach>
						</ul>
					</td>
				</tr>
			</tbody>
		</table>
	</div>
	
</body>
</html>