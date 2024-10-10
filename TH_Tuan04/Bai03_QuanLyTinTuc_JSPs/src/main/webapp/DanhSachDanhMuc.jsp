<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@ include file="header.jsp"%>

	<%@ page import="java.util.List"%>
	<%@ page import="model.DanhMuc"%>

	<h2>Danh sách danh mục</h2>

	<table border="1" width="100%">
		<tr>
			<th>Ma danh muc</th>
			<th>Ten danh muc</th>
			<th>Nguoi quan ly</th>
			<th>Ghi chu</th>
		</tr>
		<%
		List<DanhMuc> danhMucList = (List<DanhMuc>) request.getAttribute("danhMucList");
		if (danhMucList != null && !danhMucList.isEmpty()) {
			for (DanhMuc danhMuc : danhMucList) {
		%>
		<tr>
			<td><%=danhMuc.getMaDM()%></td>
			<td><%=danhMuc.getTenDanhMuc()%></td>
			<td><%=danhMuc.getNguoiQuanLy()%></td>
			<td><%=danhMuc.getGhiChu()%></td>
		</tr>
		<%
		}
		} else {
		%>
		<tr>
			<td colspan="4">Khong co danh muc nao</td>
		</tr>
		<%
		}
		%>
	</table>

</body>
</html>