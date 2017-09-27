<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="<%=request.getContextPath() %>/list.user">
<select name="condition">
<c:forEach items="${searchCondition}" var="search">
<option value="${search}">${search}</option>
</c:forEach>
</select>
<input type="text" name="searchword" value="검색어를 입력하세요.">
<input type="submit" value="검색">
</form>
</body>
</html>