<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>

<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<jsp:include page="header.jsp" />
</head>
<body>

	<div id="header" class="container-fluid">

		<nav class="navbar navbar-expand-lg">
			<div class="container-fluid">
				<a style="color: w" class="navbar-brand" href="#"><i
					class="fa-solid fa-shop me-2"></i> <strong>GEAR SHOP</strong></a>
				<button class="navbar-toggler" type="button"
					data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
					aria-controls="navbarSupportedContent" aria-expanded="false"
					aria-label="Toggle navigation">
					<span class="navbar-toggler-icon"></span>
				</button>
				<div class="collapse navbar-collapse" id="navbarSupportedContent">
					<ul class="navbar-nav me-auto mb-2 mb-lg-0">
						<li class="nav-item"><a class="nav-link active"
							aria-current="page" href="#">Home</a></li>
						<li class="nav-item"><a class="nav-link" href="#">Service</a>
						</li>
						<li class="nav-item dropdown"><a
							class="nav-link dropdown-toggle" href="#" role="button"
							data-bs-toggle="dropdown" aria-expanded="false"> Dropdown </a>
							<ul class="dropdown-menu">
								<li><a class="dropdown-item" href="#">Action</a></li>
								<li><a class="dropdown-item" href="#">Another action</a></li>
								<li><hr class="dropdown-divider"></li>
								<li><a class="dropdown-item" href="#">Something else
										here</a></li>
							</ul></li>

						<li><a class="nav-link" href="#">Contact</a></li>
					</ul>

					<ul class="navbar-nav">
					    <c:set var = "na" scope = "session" value = "${firstName}"/>
					    <p>Your salary is : <c:out value = "${na}"/></p>
						<c:choose>
							<c:when test="${not empty na}">
							
						    <li class="nav-item"><a class="nav-link"><span>${firstName}</span></a></li>
							</c:when>
							<c:otherwise>
							<li class="nav-item"><a href="./login/" class="nav-link">Sign
										In</a></li>	
							</c:otherwise>
						</c:choose>

						<li><a class="nav-link"><img height="20px" width="20px"
								src='<c:url value = "/resources/Image/grocery-store.png"/>'></a></li>

					</ul>
				</div>
			</div>
		</nav>
	</div>


	<div id="info" class="container">
		<div class="row">
			<div class="col-12 col-sm-4 col-md-4 text-center">
				<img class="icon"
					src='<c:url value = "/resources/Image/shoppingbag.png"/>'> <span
					style="font-size: 32px">Chat Luong</span> <span>Chung toi
					cam ket se mang den cho ban chat luong san pham tot nhat</span>
			</div>
			<div class="col-12 col-sm-4 col-md-4 text-center">
				<img class="icon"
					src='<c:url value = "/resources/Image/shoppingbag.png"/>'> <span
					style="font-size: 32px">Chat Luong</span> <span>Chung toi
					cam ket se mang den cho ban chat luong san pham tot nhat</span>
			</div>
			<div class="col-12 col-sm-4 col-md-4 text-center">
				<img class="icon"
					src='<c:url value = "/resources/Image/shoppingbag.png"/>'> <span
					style="font-size: 32px">Chat Luong</span> <span>Chung toi
					cam ket se mang den cho ban chat luong san pham tot nhat</span>
			</div>
		</div>

		<div id="title-product" class="container">
			<span>San Pham</span>
			<div class="container mt-5">
				<div class="row">
					<!-- Card 1 -->
					
					<c:forEach var="product" items="${listProduct}">
						<div class="col-md-3">
						<div class="card">
							<img src="https://via.placeholder.com/150" class="card-img-top"
								alt="Product 1">
							<div class="card-body">
								<h5 class="card-title">${product.getNameProduct()}</h5>
								<p class="card-text">$10.00</p>
								<div class="d-flex justify-content-between">
									<a href="#" class="btn btn-primary">Buy</a> <a href="#"
										class="btn btn-secondary">Add to Cart</a>
								</div>
							</div>
						</div>
					</div>
					</c:forEach>
					
					
				</div>
			</div>
		</div>

	</div>


	<!-- Remove the container if you want to extend the Footer to full width. -->
	<div class="container-fluid my-5">

		<footer class="bg-dark text-center text-lg-start text-white">
			<!-- Grid container -->
			<div class="container p-4">
				<!--Grid row-->
				<div class="row mt-4">
					<!--Grid column-->
					<div class="col-lg-3 col-md-6 mb-4 mb-md-0">
						<h5 class="text-uppercase">See other books</h5>

						<ul class="list-unstyled mb-0">
							<li><a href="#!" class="text-white"><i
									class="fas fa-book fa-fw fa-sm me-2"></i>Bestsellers</a></li>
							<li><a href="#!" class="text-white"><i
									class="fas fa-book fa-fw fa-sm me-2"></i>All books</a></li>
							<li><a href="#!" class="text-white"><i
									class="fas fa-user-edit fa-fw fa-sm me-2"></i>Our authors</a></li>
						</ul>
					</div>
					<!--Grid column-->

					<!--Grid column-->
					<div class="col-lg-3 col-md-6 mb-4 mb-md-0">
						<h5 class="text-uppercase">Execution of the contract</h5>

						<ul class="list-unstyled">
							<li><a href="#!" class="text-white"><i
									class="fas fa-shipping-fast fa-fw fa-sm me-2"></i>Supply</a></li>
							<li><a href="#!" class="text-white"><i
									class="fas fa-backspace fa-fw fa-sm me-2"></i>Returns</a></li>
							<li><a href="#!" class="text-white"><i
									class="far fa-file-alt fa-fw fa-sm me-2"></i>Regulations</a></li>
							<li><a href="#!" class="text-white"><i
									class="far fa-file-alt fa-fw fa-sm me-2"></i>Privacy policy</a></li>
						</ul>
					</div>
					<!--Grid column-->

					<!--Grid column-->
					<div class="col-lg-3 col-md-6 mb-4 mb-md-0">
						<h5 class="text-uppercase">Publishing house</h5>

						<ul class="list-unstyled">
							<li><a href="#!" class="text-white">The BookStore</a></li>
							<li><a href="#!" class="text-white">123 Street</a></li>
							<li><a href="#!" class="text-white">05765 NY</a></li>
							<li><a href="#!" class="text-white"><i
									class="fas fa-briefcase fa-fw fa-sm me-2"></i>Send us a book</a></li>
						</ul>
					</div>
					<!--Grid column-->

					<!--Grid column-->
					<div class="col-lg-3 col-md-6 mb-4 mb-md-0">
						<h5 class="text-uppercase">Write to us</h5>

						<ul class="list-unstyled">
							<li><a href="#!" class="text-white"><i
									class="fas fa-at fa-fw fa-sm me-2"></i>Help in purchasing</a></li>
							<li><a href="#!" class="text-white"><i
									class="fas fa-shipping-fast fa-fw fa-sm me-2"></i>Check the
									order status</a></li>
							<li><a href="#!" class="text-white"><i
									class="fas fa-envelope fa-fw fa-sm me-2"></i>Join the
									newsletter</a></li>
						</ul>
					</div>
					<!--Grid column-->
				</div>
				<!--Grid row-->
			</div>
			<!-- Grid container -->

			<!-- Copyright -->
			<div class="text-center p-3"
				style="background-color: rgba(0, 0, 0, 0.2)">
				© 2021 Copyright: <a class="text-white"
					href="https://mdbootstrap.com/">MDBootstrap.com</a>
			</div>
			<!-- Copyright -->
		</footer>

	</div>
	<!-- End of .container -->

	<jsp:include page="footer.jsp" />

</body>
</html>