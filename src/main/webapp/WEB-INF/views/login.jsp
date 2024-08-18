<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<jsp:include page="header.jsp"/>
</head>
<body id="body-login">
	<div id="body-flex-login">
		<div id="container-login">
		<div id="container-login-left">
			<div id="container-text">
				<h2 class="text-h2">Ideas and UI components in your</h2>
				<p>Sign up to receive ideas, free <br> components and free resources plus 15% on all of our <br> pro UI kits.</p>
			</div>
			<div>Hello</div>
		</div>
		
		<div id="container-login-right">
		    <div class="btn-box">
		      <button class="btn btn-1" id="pageLogin">Sign In</button>
		      <button class="btn btn-2" id="pageRegister">Sign Up</button>
		    </div>
		    
		    <div id="login-form"> 
		    <div class="form-title">
		    	<span id="">Sign In</span>
		    </div>
				  
				  <input id="name" name="name" placeholder="Email address">
				  <input id ="password" name="password" type="password" placeholder="Password">
			      <button id="buttonLogin" type="submit">Login</button>
			      <span>${name}</span>
		    </div>
		    
		    <div id="sign-up-form"> 
		    <div class="form-title">
		    	<span>Sign Up</span>
		    </div>
				  
				  <input id="name1" name="name" placeholder="Email address">
				  <input id ="password1" name="password" type="password" placeholder="Password">
				  <input id ="password2" name="password" type="password" placeholder="Password">
			      <button id="buttonLogin2" type="submit">Login</button>
			      <span>${name}</span>
		    </div>
		    
		   
		    
		</div>
		
		</div>
	</div>
	
<jsp:include page="footer.jsp"/>
</body>

</html>