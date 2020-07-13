<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>userList</title>
</head>
<body>
	<div>
		<h2>user list</h2>
		<table border="1">
			<thead>
				<tr>
					<th>id</th>
					<th>name</th>
					<th>gender</th>
					<th>city</th>
					<th>&nbsp;</th>
					<th>&nbsp;</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="user" items="${userList}">
					<tr>
						<td><a href="getUser.do?id=${user.userId}">${user.userId}</a></td>
						<td>${user.name}</td>
						<td>${user.gender}</td>
						<td>${user.city}</td>
						<td><a href="updateUserForm.do?id=${user.userId}">update</a></td>
						<td><a href="deleteUser.do/${user.userId}">delete</a></td>
					</tr>
				</c:forEach>
				<tr>
					<td colspan="7"><a href="insertUserForm.do">register</a></td>
				</tr>
			</tbody>
		</table>
	</div>
</body>
</html>