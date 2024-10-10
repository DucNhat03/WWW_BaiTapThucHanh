<%@ include file="header.jsp"%>
<%@ page import="java.util.List"%>
<%@ page import="model.TinTuc"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Quan Ly Tin Tuc</title>
<link rel="stylesheet" href="css/style.css">
</head>
<body>
	<h2>Quan ly tin tuc</h2>
	<table border="1" width="100%">
		<tr>
			<th>Tieu de</th>
			<th>Noi dung</th>
			<th>Lien ket</th>
			<th>Chuc nang</th>
		</tr>
		<%
		List<TinTuc> tinTucList = (List<TinTuc>) request.getAttribute("tinTucListt");
		if (tinTucList != null && !tinTucList.isEmpty()) {
			for (TinTuc tinTuc : tinTucList) {
		%>
		<tr>
			<td><%=tinTuc.getTieuDe()%></td>
			<td><%=tinTuc.getNoiDungTT()%></td>
			<td><a href="<%=tinTuc.getLienKet()%>"><%=tinTuc.getLienKet()%></a></td>
			<td>
				<form action="xoaTinTuc" method="post">
					<input type="hidden" name="maTT" value="<%=tinTuc.getMaTT()%>">
					<input type="submit" value="Xoa">
				</form>
			</td>
		</tr>
		<%
		}
		} else {
		%>
		<tr>
			<td colspan="4">Khong co tin tuc de quan ly</td>
		</tr>
		<%
		}
		%>
	</table>
</body>
</html>
