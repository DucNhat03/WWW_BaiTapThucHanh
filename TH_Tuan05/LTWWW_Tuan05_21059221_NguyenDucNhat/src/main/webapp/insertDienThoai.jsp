<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Thêm Điện Thoại Mới</title>
<link rel="stylesheet" href="css/style.css">
<style>
    body {
    font-family: Arial, sans-serif;
    display: flex;
    justify-content: center;
    align-items: center;
    height: 100vh;
    margin: 0;
    background-color: #f4f4f4;
}

h2, h4 {
    text-align: center;
}

form {
    background-color: #fff;
    padding: 20px;
    border-radius: 10px;
    box-shadow: 0 0 15px rgba(0, 0, 0, 0.1);
    width: 400px;
    display: flex;
    flex-direction: column;
}

input[type="text"],
input[type="number"],
select,
input[type="file"] {
    padding: 10px;
    margin-bottom: 15px;
    border: 1px solid #ccc;
    border-radius: 5px;
    width: 100%;
}

input[type="submit"] {
    padding: 10px;
    background-color: #28a745;
    color: white;
    border: none;
    border-radius: 5px;
    cursor: pointer;
}

input[type="submit"]:hover {
    background-color: #218838;
}

h4 {
    margin-bottom: 20px;
}

 </style>
</head>
<body>
	
	<form action="InsertDienThoaiServlet" method="post" enctype="multipart/form-data">
	<h2>Thêm Sản Phẩm Mới</h2>
		Mã điện thoại: 
		<input type="text" name="maDT" required><br>Tên điện thoại: 
		<input type="text" name="tenDT" required><br>Năm sản xuất: 
		<input type="number" name="namSanXuat" required><br>Cấu hình: 
		<input type="text" name="cauHinh" required><br>Nhà cung cấp:
		<select name="maNCC" required>
			<option value="">Chọn mã nhà cung cấp</option>
			<option value="NCC001">NCC001</option>
			<option value="NCC002">NCC002</option>
			<option value="NCC003">NCC003</option>
			<option value="NCC004">NCC004</option>
			<option value="NCC005">NCC005</option>
		</select><br>
		Hình ảnh: <input type="file" name="hinhAnh" required><br>
		<input type="submit" value="Thêm">
		<h4><a href="ddanhSachDienThoai">Quay lại trang chủ</a> </h4>
	</form>
</body>
</html>
