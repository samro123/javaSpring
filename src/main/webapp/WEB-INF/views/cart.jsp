<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
	href='<c:url value = "/resources/Styles/styles_index.css"/>' />
<link rel="stylesheet"
	href='<c:url value = "/resources/Styles/styles_cart.css"/>' />
<link
	href="https://cdn.jsdelivr.net/npm/remixicon@3.2.0/fonts/remixicon.css"
	rel="stylesheet" />

<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/css/all.min.css"
	integrity="sha512-+4zCK9k+qNFUR5X+cKL9EIR+ZOhtIloNl9GIKS57V1MyNsYpYcUrUeQc9vNfzsWfV28IaLL3i96P9sdNyeRssA=="
	crossorigin="anonymous" />
 <link href="https://fonts.googleapis.com/css2?family=Source+Sans+3:ital,wght@0,200..900;1,200..900&display=swap" rel="stylesheet">

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

	<%-- Header --%>
	<%-- Container --%>
	<main class="container">
        <h1 class="heading">

            <ion-icon name="cart-outline"></ion-icon>Shopping cart
        </h1>

        <div class="item-flex">
            <section class="checkout">
                <h2 class="section-heading">Payment Detail</h2>
                <div class="payment-form">
                    <form action="#">
                        <div class="card-number">
                            <label for="card-number" class="lable-default">Buyer Name</label>
                            <input type="text" name="card-number" id="card-number" class="input-default">
                        </div>
                        <div class="card-number">
                            <label for="card-number" class="lable-default">Phone Number</label>
                            <input type="text" name="card-number" id="card-number" class="input-default">
                        </div>
                        <div class="card-number">
                            <label for="card-number" class="lable-default">Address</label>
                            <input type="text" name="card-number" id="card-number" class="input-default">
                        </div>
                        <div class="card-number">
                            <label for="card-number" class="lable-default">Comment</label>
                            <textarea class="input-default" rows="5" id="comment"></textarea>
                        </div>
                    <!-- <div class="input-flex">
                        <div class="expire-date">
                            <label for="expire-date" class="label-default">Expiration date</label>
                            <div class="input-flex">
                                <input type="number" name="day" id="expire-date" min="1" max="31" class="input-default">/<input type="number" name="month" id="expire-date" placeholder="12" min="1" max="12" class="input-default">

                            </div>
                        </div>
                        
                        <div class="cvv">
                            <label for="cvv" class="lable-default">CVV</label>
                            <input type="text" name="card-number" id="cvv" class="input-default">
                        </div>


                    </div> -->
                        
                    </form>

                    <div class="payment-method">

                        <button class="method selected">

                            <ion-icon name="card"></ion-icon> 
                            <span>Credit Card</span>
                            <ion-icon class="checkmark fill" name="checkmark-circle"></ion-icon>
                        </button>

                        <button class="method">
                            <ion-icon name="logo-paypal"></ion-icon>
                            <span>PayPal</span>
                            <ion-icon class="checkmark" name="checkmark-circle-outline"></ion-icon>
                        </button>
                    </div>
                </div>
                <button class="btn btn-primary">
                    <b>Pay</b> $ <span id="payAmount">2.15</span>
                </button>
            </section>

            <!-- cart selection -->
             <section class="cart">
                <div class="cart-item-box">
                    <h2 class="section-heading">Order Summary</h2>
                    
			<c:forEach var="carts" items="${carts}" varStatus="status">
				<div class="product-card">
                        <div class="card">
                            <div class="img-box">
                              
                                <img src='<c:url value = "/resources/Image/assets/${carts.getImg()}"/>' alt="" class="product-img" width="80px" height="80px">
                            </div>

                            <div class="detail">
                                <h4 class="product-name idproduct" data-idproduct="${carts.getIdProduct()}">${carts.getNameProduct()}</h4>
                                <h4 class="product-name idsize" data-idsize="${carts.getIdSize()}">Size: ${carts.getNameSize()}</h4>
                                <h4 class="product-name idcolor" data-idcolor="${carts.getIdColor()}">Color: ${carts.getNameColor()}</h4>

                                <div class="wrapper">
                                    <div class="product-qty">
                                        <button class="decrement">
                                            <ion-icon name="remove-outline"></ion-icon>
                                        </button>
                                        <span class="quantity" contenteditable="true">${carts.getQuantity()}</span>
                                        <button class="increment">
                                            <ion-icon name="add-outline"></ion-icon>
                                        </button>
                                    </div>
                                    <div class="price">
                                         <span class="price-total" data-price="${carts.getPrice()}">${carts.getPrice()}</span>
                                    </div>
                                </div>
                            </div>

                            <button class="product-close-btn">
                                <ion-icon name="close-outline"></ion-icon>
                            </button>
                        </div>
                    </div>
			</c:forEach>
					
                    
    
                </div>

                <div class="wrapper">
                    <div class="discount-token">
                        <label for="discount-token" class="label-default">Gift card/Discount code</label>
                        <div class="wrapper-flex">
                            <input type="text" name="" id="discount-token" class="input-default">
                            <button class="btn btn-outline">Apply</button>
                        </div>
                    </div>

                    <div class="amount">
                        <div class="subtotal">
                            <span>Subtotal</span> <span>$ <span id="subtotal">2.05</span></span>
                        </div>

                        <div class="tax">
                            <span>Tax</span> <span>$ <span id="tax">2.05</span></span>
                        </div>

                        <div class="shipping">
                            <span>Shipping</span> <span>$ <span id="subtotal">0.00</span></span>
                        </div>

                        <div class="total">
                            <span>Total</span> <span>$ <span id="total">2.15</span></span>
                        </div>
                    </div>
                </div>
             </section>
        </div>

    </main> 
	
	<%-- Container --%>
	
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
	<script type="module" src="https://unpkg.com/ionicons@7.1.0/dist/ionicons/ionicons.esm.js"></script>
    <script nomodule src="https://unpkg.com/ionicons@7.1.0/dist/ionicons/ionicons.js"></script>
</body>
</html>