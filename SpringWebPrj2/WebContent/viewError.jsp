<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isErrorPage="true"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>error occur</title>
</head>
<body>
	<p>
		Error Type:
		<%=exception.getClass().getName()%><br> Error Message:
		<%=exception.getMessage()%><br>
	</p>
	<hr>
	<a href="${pageContext.request.contextPath}">Home</a>
</body>
</html>