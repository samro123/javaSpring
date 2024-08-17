$(document).ready(function(){
	$("#cot1").click(function(){
		alert("Hello!")
	});
	
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
					alert("Login success"+ value)
				}else{
					alert("Login fauil"+ value)
				}
			}
		})
	});
})