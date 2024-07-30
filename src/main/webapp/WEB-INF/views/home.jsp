<%@page import="java.util.List"%>
<%@page import="com.checonbinh.entity.NhanVien"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>	
	<a href="details">Details</a>${name }
	<form action="details" method="post">
	 <input type="text" name="name">
	 <input type="text" name="age">
	 <input type="submit">
	</form>
	
</body>
</html>