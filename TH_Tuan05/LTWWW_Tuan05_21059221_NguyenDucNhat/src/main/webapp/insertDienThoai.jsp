<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Thêm Điện Thoại Mới</title>
<link rel="stylesheet" href="css/style.css">
</head>
<body>
	<h2>Thêm Sản Phẩm Mới</h2>
	<form action="InsertDienThoaiServlet" method="post"
		enctype="multipart/form-data">
		Mã điện thoại: <input type="text" name="maDT" required><br>
		Tên điện thoại: <input type="text" name="tenDT" required><br>
		Năm sản xuất: <input type="number" name="namSanXuat" required><br>
		Cấu hình: <input type="text" name="cauHinh" required><br>
		Mã nhà cung cấp: <input type="text" name="maNCC" required><br>
		Hình ảnh: <input type="file" name="hinhAnh" required><br>
		<input type="submit" value="Thêm">
	</form>
</body>
</html>
