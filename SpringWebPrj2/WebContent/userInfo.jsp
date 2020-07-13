<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>userInfo</title>
</head>
<body>
	<div>
		<h2>user info</h2>
		<table border="1">
			<tr>
				<td>id :</td>
				<td>${user.userId}</td>
			</tr>
			<tr>
				<td>name :</td>
				<td>${user.name}</td>
			</tr>
			<tr>
				<td>gender :</td>
				<td>${user.gender}</td>
			</tr>
			<tr>
				<td>city :</td>
				<td>${user.city}</td>
			</tr>
		</table>
	</div>
</body>
</html>