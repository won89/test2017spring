<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@taglib prefix="c" 
uri="http://java.sun.com/jsp/jstl/core" %>  
  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>mybatis</title>
</head>
<body>
<h1>검색된 사원은 다음과 같습니다.</h1>
<c:forEach items="${allemplist }" var="empvo">
 <h3>
 ${empvo.employee_id }:${empvo.first_name }:
 ${empvo.phone }
 </h3>
</c:forEach>
</body>
</html>







