<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action=
"<%=request.getContextPath() %>/searchemp.mybatis" 
method="post" >
	<input type=text name="word" />
	<select name="searchname" >
		<option value="employee_id"> 사번검색 </option>
		<option value="first_name"> 이름검색 </option>
		<option value="phone"> 전화번호검색 </option>
	</select>
	<input type=submit value="검색" />
</form>
</body>
</html>