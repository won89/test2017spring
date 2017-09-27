<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
사용자 리스트는 다음과 같습니다.<br>
${param.condition }<br>
${param.searchword }<br>
<c:forEach var="list" items="${userlist}">
<c:if test="${param.condition == \"id검색\" && list.id.contains(param.searchword) }">
<h1><a href="<%=request.getContextPath()%>/getId.user?id=${list.id}">${list.id }</a></h1><br>
</c:if>
</c:forEach>


</body>
</html>