<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
	href='<c:url value = "/resources/Styles/styles_index.css"/>' />
<link
	href="https://cdn.jsdelivr.net/npm/remixicon@3.2.0/fonts/remixicon.css"
	rel="stylesheet" />

<link rel="stylesheet"
	href='<c:url value = "/resources/Styles/style_detail.css"/>'>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/css/all.min.css"
	integrity="sha512-+4zCK9k+qNFUR5X+cKL9EIR+ZOhtIloNl9GIKS57V1MyNsYpYcUrUeQc9vNfzsWfV28IaLL3i96P9sdNyeRssA=="
	crossorigin="anonymous" />
<title>Insert title here</title>
</head>
<body>
	<%-- Header --%>
	<div class="header__bar">Free Shipping on Orders Over $50</div>
	<nav class="section__container nav__container">
		<a href="#" class="nav__logo">Mon'sa</a>
		<ul class="nav__links">
			<li class="link"><a href="#">HOME</a></li>
			<li class="link"><a href="#">SHOP</a></li>
			<li class="link"><a href="#">PAGES</a></li>
			<li class="link"><a href="#">BLOG</a></li>
			<li class="link"><a href="#">LOOKBOOK</a></li>
		</ul>
		<div class="nav__icons">
			<span><i class="ri-shield-user-line"></i></span> <span><i
				class="ri-search-line"></i></span> 
				<span><i id="id-cart" class="ri-shopping-bag-2-line">
				<c:if test="${countCart > 0}">
				<div class="cricle-count-cart"><span>${countCart}</span></div>
				</c:if>
				
			    <c:if test="${countCart < 0 || countCart == null}">
			    <div ><span>${countCart}</span></div>
			    </c:if>
				
				
				
				</i></span>
		</div>
	</nav>

	<%-- HeaderEnd --%>
	<%-- Content --%>
	
	
	<%-- ContentEnd --%>
	
	
   	<%-- Footer --%>
	<div class="card-wrapper">
		<div class="card">
			<!-- card left -->
			<div class="product-imgs">
				<div class="img-display">
					<div class="img-showcase">
						<img
							src='<c:url value = "/resources/Image/assets/${product.getImage()}"/>'
							alt="shoe image"> 
							<img src='<c:url value = "/resources/Image/assets/shoe_2.jpg"/>'
							alt="shoe image"> 
							<img src='<c:url value = "/resources/Image/assets/shoe_3.jpg"/>'
							alt="shoe image"> 
							<img src='<c:url value = "/resources/Image/assets/shoe_4.jpg"/>'
							alt="shoe image">
					</div>
				</div>
				<div class="img-select">
					<div class="img-item">
						<a href="#" data-id="1"> <img class="product-img" data-img="${product.getImage()}" src='<c:url value = "/resources/Image/assets/${product.getImage()}"/>'
							alt="shoe image">
						</a>
					</div>
					<div class="img-item">
						<a href="#" data-id="2"> <img src='<c:url value = "/resources/Image/assets/shoe_2.jpg"/>'
							alt="shoe image">
						</a>
					</div>
					<div class="img-item">
						<a href="#" data-id="3"> <img src='<c:url value = "/resources/Image/assets/shoe_3.jpg"/>'
							alt="shoe image">
						</a>
					</div>
					<div class="img-item">
						<a href="#" data-id="4"> <img src='<c:url value = "/resources/Image/assets/shoe_4.jpg"/>'
							alt="shoe image">
						</a>
					</div>
				</div>
			</div>
			<!-- card right -->
			<div class="product-content">
				<h2 id="name-product" class="product-title" data-name="${product.getIdProduct()}">${product.getNameProduct()}</h2>
				<a href="#" class="product-link">visit nike store</a>
				<div class="product-rating">
					<i class="fas fa-star"></i> <i class="fas fa-star"></i> <i
						class="fas fa-star"></i> <i class="fas fa-star"></i> <i
						class="fas fa-star-half-alt"></i> <span>4.7(21)</span>
				</div>

				<div class="product-price">
					<p class="last-price">
						Old Price: <span>$257.00</span>
					</p>
					<p class="new-price" data-price="${product.getPrice()}">
						New Price: <span>${product.getPrice()}</span>
					</p>
				</div>

				<div class="product-detail">
					<h2>about this item:</h2>
					<p>Lorem ipsum dolor sit amet consectetur adipisicing elit.
						Illo eveniet veniam tempora fuga tenetur placeat sapiente
						architecto illum soluta consequuntur, aspernatur quidem at sequi
						ipsa!</p>
					<p>Lorem ipsum dolor sit amet consectetur adipisicing elit.
						Consequatur, perferendis eius. Dignissimos, labore suscipit. Unde.</p>
					 <c:forEach var="productDetails" items="${ product.getDetailProducts()}" varStatus="status"> 
					<div class="product-details" id="product-${status.index}" style="display: ${status.first ? 'block' : 'none'};">
					<ul>
						<li >Color: <span class="color" data-color="${productDetails.getColor().getIdColor()}" >${productDetails.getColor().getNameColor()}</span></li>
						<li>Available: <span class="quantity">${productDetails.getQuantity()}</span></li>
						<li>Category: <span>Shoes</span></li>
						<li>Size: <span class="size" data-size="${productDetails.getSize().getIdSize()}">${productDetails.getSize().getNameSize()}</span></li>
						<li>Date: <span>${productDetails.getEntryDate()}</span></li>
					</ul>
					</div>
					</c:forEach>
				
				<button onclick="prevProduct()">Previous</button>
				<button onclick="nextProduct()">Next</button>
				</div>

				<div class="purchase-info">
					<input type="number" min="0" value="1">
					<button type="button" class="btn btn-cart">
						Add to Cart <i class="fas fa-shopping-cart"></i>
					</button>
					<button type="button" class="btn">Compare</button>
				</div>

				<div class="social-links">
					<p>Share At:</p>
					<a href="#"> <i class="fab fa-facebook-f"></i>
					</a> <a href="#"> <i class="fab fa-twitter"></i>
					</a> <a href="#"> <i class="fab fa-instagram"></i>
					</a> <a href="#"> <i class="fab fa-whatsapp"></i>
					</a> <a href="#"> <i class="fab fa-pinterest"></i>
					</a>
				</div>
			</div>
		</div>
	</div>



	<%-- Content --%>

	<%-- Footer --%>
	<footer class="section__container footer__container">
		<div class="footer__col">
			<h4 class="footer__heading">CONTACT INFO</h4>
			<p>
				<i class="ri-map-pin-2-fill"></i> 123, London Bridge Street, London
			</p>
			<p>
				<i class="ri-mail-fill"></i> support@monsa.com
			</p>
			<p>
				<i class="ri-phone-fill"></i> (+012) 3456 789
			</p>
		</div>
		<div class="footer__col">
			<h4 class="footer__heading">COMPANY</h4>
			<p>Home</p>
			<p>About Us</p>
			<p>Work With Us</p>
			<p>Our Blog</p>
			<p>Terms & Conditions</p>
		</div>
		<div class="footer__col">
			<h4 class="footer__heading">USEFUL LINK</h4>
			<p>Help</p>
			<p>Track My Order</p>
			<p>Men</p>
			<p>Women</p>
			<p>Shoes</p>
		</div>
		<div class="footer__col">
			<h4 class="footer__heading">INSTAGRAM</h4>
			<div class="instagram__grid">
				<img
					src='<c:url value = "/resources/Image/assets/instagram-1.jpg"/>'
					alt="instagram" /> <img
					src='<c:url value = "/resources/Image/assets/instagram-2.jpg"/>' />
				<img
					src='<c:url value = "/resources/Image/assets/instagram-3.jpg"/>' />
				<img
					src='<c:url value = "/resources/Image/assets/instagram-4.jpg"/>' />
				<img
					src='<c:url value = "/resources/Image/assets/instagram-5.jpg"/>' />
				<img
					src='<c:url value = "/resources/Image/assets/instagram-6.jpg"/>' />
			</div>
		</div>
	</footer>

	<hr />

	<div class="section__container footer__bar">
		<div class="copyright">Copyright © 2023 Web Design Mastery. All
			rights reserved.</div>
		<div class="footer__form">
			<form>
				<input type="text" placeholder="ENTER YOUR EMAIL" />
				<button class="btn" type="submit">SUBSCRIBE</button>
			</form>
		</div>
	</div>

	<%-- Footer --%>

	<script src="https://code.jquery.com/jquery-3.7.1.js" integrity="sha256-eKhayi8LEQwp4NKxN+CfCh+3qOVUtJn3QNZ0TciWLP4=" crossorigin="anonymous"></script>
	<script src='<c:url value = "/resources/JS/script_detail.js"/>'></script>
	<script src='<c:url value = "/resources/JS/custom.js"/>'></script>
</body>
</html>