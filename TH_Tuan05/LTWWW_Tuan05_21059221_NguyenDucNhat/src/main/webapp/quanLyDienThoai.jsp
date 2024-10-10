<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="lab5.model.DienThoai"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/style.css">
<title>Quan ly dien thoai</title>
</head>
<body>
	<h2>Quản lý điện thoại</h2>
	<h4>
		<a href="ddanhSachDienThoai">Danh sách điện thoại</a> | 
		<a href="insertDienThoai.jsp">Thêm mới</a> | 
		<a href="quanLyDienThoai">Quản lý điện thoại</a>
	</h4>
	<table border="1" width="100%">
		<tr>
			<th>Ma DT</th>
			<th>Ten DT</th>
			<th>Nam san xuat</th>
			<th>Cau hinh</th>
			<th>Ma NCC</th>
			<th>Hinh anh</th>
		</tr>
		<%
		List<DienThoai> dienThoaiList = (List<DienThoai>) request.getAttribute("dienThoaiList");
		if (dienThoaiList != null && !dienThoaiList.isEmpty()) {
			for (DienThoai dienThoai : dienThoaiList) {
		%>
		<tr>
			<td><%=dienThoai.getMaDT()%></td>
			<td><%=dienThoai.getTenDT()%></td>
			<td><%=dienThoai.getNamSanXuat()%></td>
			<td><%=dienThoai.getCauHinh()%></td>
			<td><%=dienThoai.getMaNCC()%></td>
			<td><img src="<%=request.getContextPath()%>/<%=dienThoai.getHinhAnh()%>"width="100"></td>
			<td>
				<form action="xoaDienThoai" method="post">
					<input type="hidden" name="maDT" value="<%=dienThoai.getMaDT()%>">
					<input type="submit" value="Xóa">
				</form>
				<form action="capNhatDienThoai" method="post">
					<input type="hidden" name="maDT" value="<%=dienThoai.getMaDT()%>">
					<input type="submit" value="Cập nhật">
				</form>
			</td>
		</tr>
		<%
		}
		} else {
		%>
		<tr>
			<td colspan="4">Khong co dien thoai de quan ly</td>
		</tr>
		<%
		}
		%>
	</table>
</body>
</html>