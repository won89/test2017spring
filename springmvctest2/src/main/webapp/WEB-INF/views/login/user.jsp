<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<meta charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
${loginVO.id } 회원
<br>
<a href=<%=request.getContextPath() +"/logout?id="%>${loginVO.id}> 로그아웃하기 </a>
</body>
</html>