<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="lab5.model.DienThoai"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Danh Sách Điện Thoại</title>
<link rel="stylesheet" href="css/style.css">
</head>
<body>
	<h2>Danh Sách Điện Thoại</h2>
	<h4><a href="ddanhSachDienThoai">Danh sách điện thoại</a> | 
		<a href="insertDienThoai.jsp">Thêm mới điện thoại</a> | 
		<a href="quanLyDienThoai">Quản lý điện thoại</a> 
	</h4>
	<table border="1">
		<tr>
			<th>Mã ĐT</th>
			<th>Tên ĐT</th>
			<th>Năm Sản Xuất</th>
			<th>Cấu Hình</th>
			<th>Mã NCC</th>
			<th>Hình Ảnh</th>
		</tr>
		<%
		List<DienThoai> dsDienThoai = (List<DienThoai>) request.getAttribute("dsDienThoai");
		if (dsDienThoai != null && !dsDienThoai.isEmpty()) {
			for (DienThoai dt : dsDienThoai) {
		%>
		<tr>
			<td><%=dt.getMaDT()%></td>
			<td><%=dt.getTenDT()%></td>
			<td><%=dt.getNamSanXuat()%></td>
			<td><%=dt.getCauHinh()%></td>
			<td><%=dt.getMaNCC()%></td>
			<td>
				<img src="<%=request.getContextPath()%>/<%=dt.getHinhAnh()%>"width="100">
			</td>
		</tr>
		<%
		}
		} else {
		%>
		<tr>
			<td colspan="6">Không có sản phẩm nào.</td>
		</tr>
		<%
		}
		%>
	</table>
</body>
</html>
