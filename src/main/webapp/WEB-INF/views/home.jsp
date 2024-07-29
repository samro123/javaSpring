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
	<% 
		//String nameUser = (String)request.getAttribute("username");
		List<NhanVien> list = (List<NhanVien>)request.getAttribute("nhanvien");
		for(NhanVien nv: list){
		
	%>
	<h3><%= nv.getName() %> </h3>
	<% } %>
</body>
</html>