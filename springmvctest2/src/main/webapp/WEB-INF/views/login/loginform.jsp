<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<meta charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%=request.getContextPath() %>
<form action=<%=request.getContextPath() +"/login"%> method="post">
<input type="text" name="id" value="${loginVO.id}"/>
<input type="text" name="pw" />
<input type="submit" value="로그인"/>
</form>
</body>
</html>