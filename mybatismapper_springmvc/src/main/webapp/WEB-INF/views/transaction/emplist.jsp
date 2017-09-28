<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@taglib prefix="c" 
uri="http://java.sun.com/jsp/jstl/core" %>
<c:forEach items="${list }" var="vo">
<h3>
${vo.employee_id } : ${vo.first_name } : ${vo.salary }
</h3>
</c:forEach>
</body>
</html>







