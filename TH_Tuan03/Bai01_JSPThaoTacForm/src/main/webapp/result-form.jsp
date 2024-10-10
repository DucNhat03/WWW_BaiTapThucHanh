<%@page import="entities.Student"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Student Info</title>
<style>
    body {
        font-family: Arial, sans-serif;
        background-color: #f0f0f5;
        margin: 0;
        padding: 20px;
    }
    
    .container {
        max-width: 600px;
        margin: 0 auto;
        background-color: #fff;
        padding: 20px;
        border-radius: 10px;
        box-shadow: 0px 0px 15px rgba(0, 0, 0, 0.1);
    }
    
    h2 {
        text-align: center;
        color: #333;
    }
    
    .info {
        line-height: 1.8;
        color: #555;
    }
    
    .info strong {
        color: #000;
    }
</style>
</head>
<body>
    <div class="container">
        <h2>Student Information</h2>
        <div class="info">
            <%
                Student s = (Student) request.getAttribute("s");
                String gender = s.isGender() ? "Male" : "Female";
                out.println(
                    "<strong>First Name:</strong> " + s.getFirstName() + "<br/>" +
                    "<strong>Last Name:</strong> " + s.getLastName() + "<br/>" +
                    "<strong>Email:</strong> " + s.getEmail() + "<br/>" +
                    "<strong>Gender:</strong> " + gender + "<br/>" +
                    "<strong>Birthday:</strong> " + s.getBirthday()
                );
            %>
        </div>
    </div>
</body>
</html>
