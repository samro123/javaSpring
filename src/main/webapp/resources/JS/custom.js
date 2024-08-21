$(document).ready(function(){
	$("#buttonLogin").click(function(){
		var name = $("#name").val();
		var password = $("#password").val();
		$.ajax({
			url:"/mini-shop-sam/api/checkLogin",
			type:"GET",
			data:{
				name:name,
				password:password
			},
			success:function(value){
				if(value=="true"){
					linkCurrent = window.location.href;
					link = linkCurrent.replace("login/", "home/");
					window.location = link;
				}else{
					$("#result").text("Login Fauil")
				}
			}
		})
	});
	
	$(".btn-cart").click(function(){
		var productDetails = $(".product-details:visible");
      // Get the color, size, and available values
       var color = productDetails.find(".color").text();
       var idColor = productDetails.find(".color").data("color");
		
 	   var quantity = productDetails.find(".quantity").text();
 	   
	  var size = productDetails.find(".size").text();
       var idSize = productDetails.find(".size").data("size");
       
       var nameProduct = $("#name-product").text();
       var idProduct = $("#name-product").data("name");
       
       var price = $(".new-price").data("price");

		$.ajax({
			url:"/mini-shop-sam/api/addCart",
			type:"GET",
			data:{
				idProduct:idProduct,
				idColor:idColor,
				idSize:idSize,
				nameProduct:nameProduct,
		 		price:price,
		 		nameSize:size,
				nameColor:color,
				quantity:quantity
			},
			success:function(value){
			}
		})
		
		
	});
	
	$("#pageLogin").click(function(){
		$("#login-form").show();
		$("#sign-up-form").hide();
	});
	$("#pageRegister").click(function(){
		$("#login-form").hide();
		$("#sign-up-form").show();
	});
})