<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:forEach var="user" items="${userlist }">
<c:if test="${user.id == param.id}">
선택한 아이디는 ${user.id} 입니다. <br>
</c:if>
</c:forEach>

</body>
</html>