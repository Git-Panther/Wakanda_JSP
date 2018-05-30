<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.Date, java.util.ArrayList, java.util.Locale"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Today's Fortune</title>
<%
	//Date date = new Date();
	//String dateinfo  = String.format(Locale.US, "%tY.%tm.%td %tA", date, date, date, date);
%>
</head>
<body>
	<!-- ????년 ??월 ??일 오늘의 운세 -->
	<select>
		<option value="1">Rat</option>
		<option value="2">Ox</option>
		<option value="3">Tiger</option>
		<option value="4">Rabbit</option>
		<option value="5">Dragon</option>
		<option value="6">Snake</option>
		<option value="7">Horse</option>
		<option value="8">Goat</option>
		<option value="9">Monkey</option>
		<option value="10">Cock</option>
		<option value="11">Dog</option>
		<option value="12">Pig</option>
	</select>
	<hr>
	<!-- 현재 페이지에 해당 파일(서블릿)을 추가. 스크립플릿, 선언문에서 변수 및 메소드 중복 선언 불가 -->
	<%@ include file="2.today.jsp" %>
</body>
</html>