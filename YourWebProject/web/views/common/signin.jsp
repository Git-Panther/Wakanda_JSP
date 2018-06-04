<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
	String msg1 = (String)request.getAttribute("msg1");
	String msg2 = (String)request.getAttribute("msg2");
%>
<html>
<head>
<meta charset="UTF-8">
<title>Sign in</title>
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
		background:url("/uwp/images/Asian_Games_2018_LOL.jpg") no-repeat center;
		backgroun-size:cover;
	}
	
	.signinArea > #signinForm{
		float:right;
	}
	
	.signinArea td{
		color:white;
		font-weight:bold;
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
	
	.outer{
		width:600px;
		height:500px;
		vertical-align:middle;
		margin-left:auto;
		margin-right:auto;
		padding:20px;
		border:1px solid white;
	}
	
	.outer > h1{
		color:red;
		font-weight:bold;
		text-align:center;
	}
</style>
<script>
	function signin(){
		$("#signinForm").submit();
	}
	
	function signup(){
		location.href = "/uwp/views/member/signup.jsp";
	}
</script>
</head>
<body>
	<%@ include file="menu.jsp" %>
	<div class="outer">
		<h1><%=msg1%><br><%=msg2%></h1>
		<div class="signinArea">
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
		</div>
	</div>	
</body>
</html>