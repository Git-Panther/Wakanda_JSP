<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Menu</title>
</head>
<body>
	<h1>Select a Champion on the menu</h1>
	<form action="/jsp1/selectMenu.do" method="get">
		<select name="menu">
			<option value="champion1">Master Yi</option>
			<option value="champion2">Taric</option>
			<option value="champion3">Irelia</option>
			<option value="champion4">Kai'Sa</option>
			<option value="champion5">Pyke</option>
			<option value="champion6">Vladimir</option>
		</select>
		<input type="submit" value="Submit"/>
	</form>
</body>
</html>