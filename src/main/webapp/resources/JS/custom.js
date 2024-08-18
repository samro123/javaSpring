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
	
	$("#pageLogin").click(function(){
		$("#login-form").show();
		$("#sign-up-form").hide();
	});
	$("#pageRegister").click(function(){
		$("#login-form").hide();
		$("#sign-up-form").show();
	});
})