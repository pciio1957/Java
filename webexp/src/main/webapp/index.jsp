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
	// java + html => ���������� html ������ ����� 
	// Clien(������) Stream�� �̿��Ͽ� �����Ѵ�
	Food f = new Food("���", 2000, "û��������");
%>
<%--
ȭ���(front end)
html/css
javascript => jquery

------- front�� back�� �߰�
ajax(�񵿱� ���α׷�) : front end�� back end ����

����ó�����α׷�(back end)
java
DB
jsp
Spring Framework
--%>
<body>
	<h2>�� ���α׷� ����</h2>
	<h3>���Ǹ�: <%= f.getfname() %></h3>
	<h3>���Ǹ�: <%= f.getfprice() %></h3>
	<h3>���Ǹ�: <%= f.getfLoc() %></h3>
</body>
<script type = "text/javascript">
var h2 = document.querySelector("h2");
h2.onclick = function() {
	alert("Ŭ���߽��ϴ�");
	this.style.color = "orange";
}</script>
</html>