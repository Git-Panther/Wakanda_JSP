<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
<style>
	.wrap{
		background:black;
		width:100%;
		height:50px;
	}
	
	.menu{
		background:black;
		color:white;
		width:150px;
		height:50px;
		vertical-align:middle;
		text-align:center;
		text-align:cnter;
		display:table-cell;	
	}
	
	.nav{
		width:600px;
		margin-left:auto;
		margin-right:auto;
		
	}
	
	.menu:hover{
		background:gray;
		color:red;
		font-weight:bold;
		cursor:pointer;
	}
</style>
<script>
	function mainPage(){
		location.href = "/uwp/index.jsp";
	}
</script>
</head>
<body>
	<br/>
	<br/>
	<br/>
	<br/>
	<br/>
	<div class="wrap">
		<div class="nav">
			<div class="menu" onclick="mainPage();">Home</div>
			<div class="menu">Notice</div>
			<div class="menu">Gallery</div>
			<div class="menu">Photo</div>
		</div>		
	</div>
</body>
</html>