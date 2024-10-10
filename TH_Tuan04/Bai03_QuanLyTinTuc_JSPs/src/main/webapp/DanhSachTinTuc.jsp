<%@ include file="header.jsp"%>

<%@ page import="java.util.List"%>
<%@ page import="model.TinTuc"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Danh Sach Tin Tuc</title>
<link rel="stylesheet" href="css/style.css">
</head>
<body>
	<h2>Danh sach tin tuc</h2>
	<table border="1" width="100%">
		<tr>
			<th>Tieu de</th>
			<th>Noi dung</th>
			<th>Lien ket</th>
			<th>Danh muc</th>
		</tr>
		<%
		List<TinTuc> tinTucList = (List<TinTuc>) request.getAttribute("tinTucList");
		if (tinTucList != null && !tinTucList.isEmpty()) {
			for (TinTuc tinTuc : tinTucList) {
		%>
		<tr>
			<td><%=tinTuc.getTieuDe()%></td>
			<td><%=tinTuc.getNoiDungTT()%></td>
			<td><a href="<%=tinTuc.getLienKet()%>"><%=tinTuc.getLienKet()%></a></td>
			<td><%=tinTuc.getMaDM()%></td>
		</tr>
		<%
		}
		} else {
		%>
		<tr>
			<td colspan="4">Khong co tin tuc nao de hien thi</td>
		</tr>
		<%
		}
		%>
	</table>
</body>
</html>
