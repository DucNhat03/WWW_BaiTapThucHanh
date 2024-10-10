<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Error</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f2f2f2;
            text-align: center;
            padding-top: 50px;
        }
        .error-container {
            width: 50%;
            margin: 0 auto;
            padding: 20px;
            background-color: white;
            border: 1px solid #ccc;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }
        h1 {
            color: red;
        }
        p {
            font-size: 16px;
        }
        a {
            color: blue;
            text-decoration: none;
            font-weight: bold;
        }
        a:hover {
            text-decoration: underline;
        }
    </style>
</head>
<body>
    <div class="error-container">
        <h1>Da xay ra loi</h1>
        <p><%= request.getAttribute("message") != null ? request.getAttribute("message") : "Co loi!" %></p>
        <p><a href="index.jsp">Quay lai trang chu</a></p>
    </div>
</body>
</html>
