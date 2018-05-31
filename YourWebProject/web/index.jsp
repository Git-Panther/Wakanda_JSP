<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Start of Web Project</title>
</head>
<body>
	<%@ include file="views/common/header.jsp" %>
	<div class="background" align="center">
		<div class="first-line">
			<div class="tile tile-menu"></div>
			<div class="tile tile1"></div>
			<div class="tile tile-menu"></div>
			<div class="tile tile1"></div>
			<div class="tile notile"></div>
		</div>
		<div class="second-line">
			<div class="tile notile"></div>
			<div class="tile tile1"></div>
			<div class="tile notile"></div>
			<div class="tile tile1"></div>
			<div class="tile tile-menu"></div>
		</div>
	</div>
	<%@ include file="views/common/footer.jsp" %>
</body>
</html>