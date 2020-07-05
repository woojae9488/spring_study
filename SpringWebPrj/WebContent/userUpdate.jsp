<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>userUpdate</title>
</head>
<body>
	<div>
		<h2>update user</h2>
		<div>
			<form method="post" action="updateUser.do">
				<input type="hidden" name="userId" value="${map.user.userId}">
				<table border="1">
					<tr>
						<td>id :</td>
						<td>${map.user.userId}</td>
					</tr>
					<tr>
						<td>name :</td>
						<td><input type="text" name="name" value="${map.user.name}" /></td>
					</tr>
					<tr>
						<td>gender :</td>
						<td><c:forEach var="genderName" items="${map.genderList}">
								<c:choose>
									<c:when test="${genderName eq map.user.gender}">
										<input type="radio" name="gender" value="${genderName}"
											checked />${genderName}
								</c:when>
									<c:otherwise>
										<input type="radio" name="gender" value="${genderName}" />${genderName}
								</c:otherwise>
								</c:choose>
							</c:forEach></td>
					</tr>
					<tr>
						<td>city :</td>
						<td><select name="city">
								<c:forEach var="cityName" items="${map.cityList}">
									<c:choose>
										<c:when test="${cityName eq map.user.city }">
											<option value="${cityName}" selected>${cityName}</option>
										</c:when>
										<c:otherwise>
											<option value="${cityName}">${cityName}</option>
										</c:otherwise>
									</c:choose>
								</c:forEach>
						</select></td>
					</tr>
					<tr>
						<td colspan="2"><input type="submit" value="update" /></td>
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