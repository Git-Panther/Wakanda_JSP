<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.kh.java.member.model.vo.MemberVo"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script
  src="https://code.jquery.com/jquery-3.3.1.js"
  integrity="sha256-2Kok7MbOyxpgUVvAk/HJ2jigOSYS2auK4Pfzbm7uH60="
  crossorigin="anonymous"></script>
<script
  src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"
  integrity="sha256-T0Vest3yCU7pafRw9r+settMBX6JkKN06dqBnpQ8d30="
  crossorigin="anonymous"></script>
<script
  src="https://code.jquery.com/color/jquery.color-2.1.2.js"
  integrity="sha256-1Cn7TdfHiMcEbTuku97ZRSGt2b3SvZftEIn68UMgHC8="
  crossorigin="anonymous"></script>
<script type="text/javascript" src="/uwp/js/jquery-3.3.1.min.js"></script>
<style>
	body{
		background:url("/uwp/images/Asian_Games_2018_small.jpg") no-repeat center;
		backgroun-size:cover;
	}
	
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
	
	.signinArea > #signinForm{
		float:right;
	}
	
	#signinBtn, #signupBtn{
		display:inline-block;
		vertical-align:middle;
		text-align:center;
		cursor:pointer;
		width:103px;
		height:25px;
		border-radius:5px;
		background:orangered;
		color:white;
	}
	
	.tile{
		width:150px;
		height:150px;
		background:black;
		display:inline-block;
	}
	
	.first-line{
		margin-top:10%;
	}
	
	.tile-menu:hover{
		background:skyblue;
		cursor:pointer;
		color:white;
	}
	
	.notile{
		visibility:hidden;
	}
	
	.tile1{
		background:gray;
	}
	
	.footer{
		position:fixed;
		left:0;
		bottom:0;
		background:brown;
		color:white;
		text-align:center;
		width:100%;
	}
	
	.userArea{
		float:right;
		font-weight:bold;
		font-size:20px;
		color:blue;
	}
</style>
<script>
	function signin(){
		$("#signinForm").submit();
	}
</script>
<%
	MemberVo member = (MemberVo)request.getSession().getAttribute("user"); // Object 반환이라 Type Casting
%>
</head>
<body>
	<h1 align="center">Welcome to the Web Project!</h1>	
	<div class="signinArea">
		<%if(member == null){%>
			<form id="signinForm" action="signin.do" method="post">
				<table>
					<tr>
						<td>ID : </td>
						<td><input type="text" name="userid"/></td>
					</tr>
					<tr>
						<td>PW : </td>
						<td><input type="password" name="userpw"/></td>
					</tr>
					<tr>
						<td colspan="2"><!-- form 내 button은 submit 취급 -->
							<div id="signinBtn" onclick="signin();">Sign in</div> 
							<div id="signupBtn" onclick="signup();">Sign up</div>
						</td>
					</tr>
				</table>
			</form>
		<%}else{%>
			<div class="userArea">
				<%=member.getUsername()%>, Welcome to the JDBC. 
			</div>
		<%}%>
	</div>
	<br/>
	<br/>
	<br/>
	<br/>
	<br/>
	<div class="wrap">
		<div class="nav">
			<div class="menu">Home</div>
			<div class="menu">Notice</div>
			<div class="menu">Gallery</div>
			<div class="menu">Photo</div>
		</div>		
	</div>
</body>
</html>