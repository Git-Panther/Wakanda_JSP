<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Result of Addition</title>
<%-- <% %> : Java 소스를 기술하는 영역 --%>
<%
	// 주석 잘 작동함
	int total = 0;
	for(int i = 1; i <= 10; i++){
		total += i;
	}
	
	//int a = 10 / 0;
%>
</head>
<body>
<h4>1부터 10까지의 합계는 <%=total%>.</h4>
<h4>1부터 10까지의 합계는 <%out.println(total);%>.</h4>
<h4></h4>
</body>
</html>