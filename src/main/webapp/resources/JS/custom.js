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
       var idDetail = productDetails.find(".quantity").data("iddetail");
       
       var nameProduct = $("#name-product").text();
       var idProduct = $("#name-product").data("name");
       
       var price = $(".new-price").data("price");
       var image = $(".product-img").data("img");
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
				img:image,
				quantity:quantity,
				idDetail:idDetail,
			},
			success:function(value){
				
			}
		}).done(function(){
			$.ajax({
			url:"/mini-shop-sam/api/countCart",
			type:"GET",
			success:function(value){
				$("#id-cart").find("div").addClass("cricle-count-cart");
				$("#id-cart").find("div").html("<span>"+ value+"</span");
			}
		})
		})
		
		
	});
		totalMoney();
	  function totalMoney(isEventChange){
		var moneyTotal = 0;
		var money = 0;
		$(".price-total").each(function(){
			var price = $(this).attr("data-price");
			var count = $(this).closest('.wrapper').find('.quantity').text();
			money = parseInt(price) * parseInt(count);
			if(!isEventChange){
				$(this).html(money);
			}
		    
			moneyTotal += money;
		});
		$("#total").html(moneyTotal);	
	}
	
	
	  $(".product-close-btn").click(function(){
		var self = $(this);
		var idProduct = $(this).closest('.product-card').find(".idproduct").data("idproduct");
    	var idSize = $(this).closest('.product-card').find(".idsize").data("idsize");
    	var idColor = $(this).closest('.product-card').find(".idcolor").data("idcolor");
    	$.ajax({
			url:"/mini-shop-sam/api/removeCart",
			type:"GET",
			data:{
				idProduct:idProduct,
				idColor:idColor,
				idSize:idSize,
			},
			success:function(value){
				self.closest('.product-card').remove();
				totalMoney();

			}
		})
	});
	
	  // Handle increment button click
        $(".increment").click(function(){
            let quantitySpan = $(this).siblings(".quantity");
            let currentQuantity = parseInt(quantitySpan.text());
            quantitySpan.text(currentQuantity + 1).trigger('quantityChange');
        });

        // Handle decrement button click
        $(".decrement").click(function(){
            let quantitySpan = $(this).siblings(".quantity");
            let currentQuantity = parseInt(quantitySpan.text());
            if(currentQuantity > 1) { // Ensure quantity doesn't go negative
                quantitySpan.text(currentQuantity - 1).trigger('quantityChange');
            }
        });

        // Handle direct edit in the contenteditable span
        $(".quantity").on('blur keyup paste input', function(){
            $(this).trigger('quantityChange');
        });

        

        // Handle the custom quantityChange event
        $(".quantity").on('quantityChange', function(){
            // Additional logic can be added here to update the cart or database
            var countProduct =$(this).text();
            var price = $(this).closest('.wrapper').find('.price-total').attr("data-price");
            var total = parseInt(price) * parseInt(countProduct);
            //var format = (total/1000).toFixed(3);
            $(this).closest('.wrapper').find('.price-total').html(total);
            totalMoney(true);
            //var idProduct = ;
            var idProduct = $(this).closest('.product-card').find(".idproduct").data("idproduct");
    		var idSize = $(this).closest('.product-card').find(".idsize").data("idsize");
    		var idColor = $(this).closest('.product-card').find(".idcolor").data("idcolor");
			
			$.ajax({
			url:"/mini-shop-sam/api/loadCart",
			type:"GET",
			data:{
				idProduct:idProduct,
				idColor:idColor,
				idSize:idSize,
				quantity:countProduct
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