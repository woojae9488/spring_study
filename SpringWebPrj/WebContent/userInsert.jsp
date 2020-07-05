<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>userInsert</title>
</head>
<body>
	<div>
		<h2>register user</h2>
		<div>
			<form method="post" action="insertUser.do">
				<table border="1">
					<tr>
						<td>id :</td>
						<td><input type="text" name="userId" /></td>
					</tr>
					<tr>
						<td>name :</td>
						<td><input type="text" name="name" /></td>
					</tr>
					<tr>
						<td>gender :</td>
						<td><c:forEach var="genderName" items="${map.genderList}">
								<input type="radio" name="gender" value="${genderName}" />${genderName}
							</c:forEach></td>
					</tr>
					<tr>
						<td>city :</td>
						<td><select name="city">
								<c:forEach var="cityName" items="${map.cityList}">
									<option value="${cityName}">${cityName}</option>
								</c:forEach>
						</select></td>
					</tr>
					<tr>
						<td colspan="2"><input type="submit" value="register" /></td>
					</tr>
					<tr>
						<td colspan="2"><a href="getUserList.do"> show user list</a>
						</td>
					</tr>
				</table>
			</form>
		</div>
	</div>
</body>
</html>