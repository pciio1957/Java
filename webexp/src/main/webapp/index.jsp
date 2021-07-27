<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR" import="Java.z01_vo.Food"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<style type="text/css"> </style>
<title>Insert title here</title>
</head>
<%
	// java + html => 최종적으로 html 파일을 만들어 
	// Clien(브라우저) Stream을 이용하여 전달한다
	Food f = new Food("사과", 2000, "청과물가게");
%>
<%--
화면단(front end)
html/css
javascript => jquery

------- front와 back의 중간
ajax(비동기 프로그램) : front end와 back end 연결

내부처리프로그램(back end)
java
DB
jsp
Spring Framework
--%>
<body>
	<h2>웹 프로그램 시작</h2>
	<h3>물건명: <%= f.getfname() %></h3>
	<h3>물건명: <%= f.getfprice() %></h3>
	<h3>물건명: <%= f.getfLoc() %></h3>
</body>
<script type = "text/javascript">
var h2 = document.querySelector("h2");
h2.onclick = function() {
	alert("클릭했습니다");
	this.style.color = "orange";
}</script>
</html>