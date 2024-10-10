<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<%@ taglib uri="jakarta.tags.fmt" prefix="fmt" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
    <title>Multiple Languages</title>
    <style>
        .wrapper {
            padding: 10px;
            margin: auto;
            width: 60%;
            margin-top: 50px;
            border-radius: 10px;
            box-shadow: 3px 3px 3px rgba(0, 0, 0, 0.1), 
            -3px -3px 3px rgba(0, 0, 0, 0.1), 
            3px -3px 3px rgba(0, 0, 0, 0.1), 
            -3px 3px 3px rgba(0, 0, 0, 0.1);
            font-size: 20px;
        }
    </style>
</head>
<body>
	<c:set var="languageCode" value="${param.rdlanguage}"></c:set>
	<c:if test="${not empty languageCode}">
		<fmt:setLocale value="${languageCode}" scope="session"/>
	</c:if>
	<fmt:setBundle basename="resource" scope="session"/>
    <form class="wrapper border" action="index.jsp" method="post">
        <div class="row" style="padding: 20px; border-bottom: 2px solid gray;">
            <div class="col-sm-3 d-flex justify-content-center align-items-center">
                <fmt:message key="languageMessage"></fmt:message>
            </div>
            <div class="col-sm-3 d-flex justify-content-center align-items-center">
                <input type="radio" name="rdlanguage" value="vi" class="mx-2" 
    				<c:if test="${languageCode == 'vi'}">checked</c:if> />
                <fmt:message key="vn"></fmt:message>
            </div>
            <div class="col-sm-3 d-flex justify-content-center align-items-center">
                <input type="radio" name="rdlanguage" value="en" class="mx-2" 
    				<c:if test="${languageCode == 'en'}">checked</c:if> />
                <fmt:message key="en"></fmt:message>
            </div>
            <div class="col-sm-3 d-flex justify-content-center align-items-center">
                <input class="btn btn-secondary" type="submit" 
                value='<fmt:message key="chooseButton"></fmt:message>'/>
            </div>
        </div>
        <div class="row mt-4">
            <div class="col-sm-3 d-flex justify-content-center align-items-center">
                <fmt:message key="userName"></fmt:message>
            </div>
            <div class="col-sm-4 d-flex justify-content-center align-items-center">
                <input type="text" name="username" class="form-control">
            </div>
        </div>
        <div class="row mt-4">
            <div class="col-sm-3 d-flex justify-content-center align-items-center">
                <fmt:message key="pass"></fmt:message>
            </div>
            <div class="col-sm-4 d-flex justify-content-center align-items-center">
                <input type="password" name="password" class="form-control">
            </div>
        </div>
        <div class="row mt-4">
            <div class="col-sm-3 d-flex justify-content-center align-items-center">
            </div>
            <div class="col-sm-4">
                <input class="py-1 px-4 btn btn-secondary" type="submit" name="submit" 
    				value="<fmt:message key='login'/>" />
            </div>
        </div>
    </form>
</body>
</html>
