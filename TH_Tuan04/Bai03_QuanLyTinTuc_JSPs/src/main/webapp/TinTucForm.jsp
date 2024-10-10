<%@ page import="java.util.List"%>
<%@ page import="model.DanhMuc"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Them Tin Tuc</title>
<link rel="stylesheet" href="css/style.css">
<style>
form {
	display: flex;
	flex-direction: column; width : 30%;
	height: 400px;
	margin: 0 auto;
	align-items: center;
	justify-content: space-between;
	border: 1px solid #ccc;
	padding: 20px;
	width: 30%;
	background-color: #ECDFCC;;
}

,
label {
	display: inline-block;
	width: 100px;
}

,
intput {
	width: 200px;
	height: 30px;
}

#themBtn {
	width: 100px;
	height: 30px;
	background-color: #4CAF50;
	color: white;
	border: none;
	
}
</style>
</head>
<body>
	
	<form action="themTinTuc" method="post">
		<h2>Them tin tuc moi</h2>
		<label for="tieuDe">Tieu de:</label>
		<input type="text" name="tieuDe"
			required><br> 
		<label for="noiDungTT">Noi dung:</label>
		<textarea name="noiDungTT" required></textarea>
		<br> 
		<label for="lienKet">Lien ket:</label> 
		<input type="url" name="lienKet" pattern="http://.*" required><br> 
		<label for="maDM">Danh muc:</label> 
		<select name="maDM">
			<%
			List<DanhMuc> danhMucList = (List<DanhMuc>) request.getAttribute("danhMucList");
			if (danhMucList != null && !danhMucList.isEmpty()) {
				for (DanhMuc danhMuc : danhMucList) {
			%>
			<option value="<%=danhMuc.getMaDM()%>"><%=danhMuc.getTenDanhMuc()%></option>
			<%
			}
			} else {
			%>
			<option>Khong co danh muc nao</option>
			<%
			}
			%>
		</select><br> 
		<input type="submit" value="Them" id="themBtn">
	</form>
</body>
</html>