<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<meta charset=UTF-8">
<title>Insert title here</title>
<script src="resources/jquery-3.2.1.min.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	$("#ajaxbtn").on("click", function(){
		doAjax($("#ajaxname").val());
	});
});

function doAjax(name){
	$.ajax({
		type:"post",
		url:"<%=request.getContextPath()%>/ajax",
		data: {"name":name} , //서버측 전달데이터 
		success:function(result){
				console.log(result);
				$("#here").html
				(result.id + " : " + result.name + " : " + result.email + " : " + result.pw);
		}
	});
}

</script>
</head>
<body>
<a href="javascript:doAjax()">doAjax요청:json응답</a>
<div id="here">여기에 결과를 출력합니다.</div>
<br>
<input type="text" id="ajaxname">
<input type="button" id="ajaxbtn" value="사용자정보요청"> 
</body>
</html>