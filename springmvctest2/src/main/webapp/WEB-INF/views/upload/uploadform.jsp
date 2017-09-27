 <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<meta charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
   <form action=<%=request.getContextPath() +  "/upload.file" %> method="post" enctype="multipart/form-data" >
      전송한 사람 : <input type="text" name="name" value="사람" /> <br>
     설명:<input type="text" name="description" value="설명을쓰세요" /> <br>
      전송하는 파일1 : <input type="file" name="file1" /> <br>
       전송하는 파일2 : <input type="file" name="file2" /> <br>
      <input type="submit" value="전송" />
   </form>
</body>
</html>