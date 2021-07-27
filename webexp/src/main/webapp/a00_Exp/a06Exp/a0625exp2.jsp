<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<!--  
a0625exp2.jsp?id=himan&pass=7777
ex) form이 아닌 데이터 전송의 다른 방법
	1) location.href = "a0625exp2.jsp?id=himan&pass=7777"; 로 처리도 됨
	2) <a href="a0625exp2.jsp?id=himan&pass=7777"> 이동처리(데이터전송)</a>
-->
<h2> 로그인 결과 </h2>
<b> 	  ID :</b> ${param.id} <br>
<b> PASSWORD :</b> ${param.pass} <br>

</body>
</html>