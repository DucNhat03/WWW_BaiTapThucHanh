<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login Success Page</title>
</head>
<body>
	<%
	String userName = null;
	String sessionID = null;
	Cookie[] cookies = request.getCookies();
	if (cookies != null) {
		for (Cookie cookie : cookies) {
			if (cookie.getName().equals("userIdCookie")) {
				userName = cookie.getValue();
			}
		}
	}
	%>
	<h3>
		Hi <%=userName%>, do the checkout.
	</h3>
	<br>
	<form action="logout" method="post">
		<input type="submit" value="Logout">
	</form>
</body>
</html>