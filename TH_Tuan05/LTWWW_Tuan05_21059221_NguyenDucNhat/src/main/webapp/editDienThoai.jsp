<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="lab5.model.DienThoai"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Sửa Thông Tin Điện Thoại</title>
<link rel="stylesheet" href="css/style.css">
</head>
<body>
	<h2>Sửa Thông Tin Điện Thoại</h2>

	<%
	DienThoai dt = (DienThoai) request.getAttribute("dienThoai");
	if (dt == null) {
		out.println("Không tìm thấy thông tin điện thoại để chỉnh sửa.");
	} else {
	%>

	<form action="UpdateDienThoaiServlet" method="post"
		>
		<input type="hidden" name="maDT" value="<%=dt.getMaDT()%>">
		Tên điện thoại: <input type="text" name="tenDT"
			value="<%=dt.getTenDT()%>" required><br> Năm sản xuất:
		<input type="number" name="namSanXuat"
			value="<%=dt.getNamSanXuat()%>" required><br> Cấu
		hình: <input type="text" name="cauHinh" value="<%=dt.getCauHinh()%>"
			required><br> Mã nhà cung cấp: <input type="text"
			name="maNCC" value="<%=dt.getMaNCC()%>" required><br>
		Hình ảnh hiện tại: <img
			src="<%=request.getContextPath()%>/<%=dt.getHinhAnh()%>"
			width="100"><br> Hình ảnh mới: <input type="file"
			name="hinhAnh"><br> <input type="submit"
			value="Cập nhật">
	</form>

	<%
	}
	%>
</body>
</html>
