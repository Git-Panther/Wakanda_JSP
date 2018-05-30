<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Result of to select a menu</title>
<%
String name = (String)request.getAttribute("name");
String menu = (String)request.getAttribute("menu");
int score = (Integer)request.getAttribute("score");
%>
</head>
<body>
	<%if(score != 0){%>
	<h1>
		Chosen Campion : <%=name%>
		<br>Message : <%=menu%>
		<br>Score : <%=score%>
	</h1>
	<%}else{%>
		<h1>고인물</h1>
	<%}%>
	<!-- 위처럼 끊어서 코딩 가능 -->
</body>
</html>