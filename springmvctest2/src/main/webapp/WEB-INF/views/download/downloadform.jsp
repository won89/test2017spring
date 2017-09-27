<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>      
<html>
<head>
<meta charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- c:/uplaod 폴더 파일들 String[] 으로 생성하여 a 태그 -->
다운로드
${filelist[0] }
<c:forEach var="list" items="${filelist }"> 
 파일은 : <a href="downloadprocess.file?filename=${list }">${list}</a><br>
</c:forEach>
</body>
</html>