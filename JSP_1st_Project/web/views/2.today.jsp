<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.Date, java.util.ArrayList, java.util.Locale"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>What time is it now?</title>
<%
	Date date = new Date();
	String str1 = String.format("%tF", date); // 기본 양식으로 문자열 저장
	String str2 = String.format("%tp %tT", date, date); // String.format()이 뭐하는 놈인지 api 뒤지면 나온다.
	String str3 = String.format(Locale.US, "%tY.%tm.%td %tA", date, date, date, date);
%>
</head>
<body>
	<ul>
		<li>Today's Date : <%=str1%></li>
		<li>Time at this time : <%=str2%></li>
		<li>Today is <%=str3%>.</li>
	</ul>
</body>
</html>