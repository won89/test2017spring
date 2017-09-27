<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<meta charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
컨트롤러 리뷰<br>
<a href="<%=request.getContextPath() %>/review/doA">/review/doA</a> ; MODEL <br>
<a href="<%=request.getContextPath() %>/review/doB">/review/doB</a> ; 단순호출 <br>
<a href="<%=request.getContextPath() %>/review/doC">/review/doC</a> ; modelANDVIEW <br>
<a href="<%=request.getContextPath() %>/review/doD">/review/doD</a> ; REDIRECT <br>
</body>
</html>