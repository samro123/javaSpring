<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>

<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="resources/Styles/styles.css">
<title>Insert title here</title>

</head>
<body>	
	<c:out value="${name }" />
	<a id="thea" href="details">Details</a>${name }
	<form action="details" method="post">
	 <input type="text" name="name">
	 <input type="text" name="age">
	 <input type="submit">
	</form>
	
</body>
</html>