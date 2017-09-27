<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<meta charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
${id} 님 로그아웃하셨습니다. 
<br>
<a href=<%=request.getContextPath()+"/login?id=" %>${id }>re로그인 하러가기</a>
</body>
</html>