<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>

<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

</head>
<body>	
    <c:catch var="exception">
       <% int i = 5 / 0; %>
    </c:catch>
	 <c:if test="${exception != null }">
	 	Error: ${exception.message}
	 </c:if>
</body>
</html>