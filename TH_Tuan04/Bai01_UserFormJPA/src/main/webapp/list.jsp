<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>List User</title>
</head>
<style>
.wrapper {
	margin: auto;
	width: 80%;
	margin-top: 100px;
	border-radius: 10px;
	box-shadow: 3px 3px 3px rgba(0, 0, 0, 0.1), -3px -3px 3px
		rgba(0, 0, 0, 0.1), 3px -3px 3px rgba(0, 0, 0, 0.1), -3px 3px 3px
		rgba(0, 0, 0, 0.1);
}

table {
	width: 100%;
	border-collapse: collapse;
	margin-top: 10px;
}

table, th, td {
	border: 1px solid #ddd;
}

th, td {
	padding: 12px;
	text-align: center;
}

th {
	background-color: #f2f2f2;
}

tr:hover {
	background-color: #f5f5f5;
}

h2 {
	color: 'blue';
}
</style>

<div align="center" class="wrapper border p-2">
	<h1>List User</h1>
	<h2 align="center">
		<a href="${pageContext.request.contextPath}/form.jsp">Add New User</a>
	</h2>
	<table border="1">
		<tr align="center">
			<th>First Name</th>
			<th>Last Name</th>
			<th>Email</th>
			<th>Password</th>
			<th>Birthday</th>
			<th>Gender</th>
		</tr>
		<c:forEach var="user" items="${listUser}">
			<tr>
				<td><c:out value="${user.firstName}" /></td>
				<td><c:out value="${user.lastName}" /></td>
				<td><c:out value="${user.email}" /></td>
				<td><c:out value="${user.passWord}" /></td>
				<td><c:out value="${user.birthDay}" /></td>
				<td><c:out value="${user.gioiTinh}" /></td>
			</tr>
		</c:forEach>
	</table>
</div>
</body>

</html>