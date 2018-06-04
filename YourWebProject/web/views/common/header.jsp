<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.kh.java.member.model.vo.MemberVo"%>
<%
	MemberVo member = (MemberVo)request.getSession().getAttribute("user"); // Object 반환이라 Type Casting
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
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
	
	.signinArea > #signinForm, .userInfo{
		float:right;
	}
	
	#signinBtn, #gotoSignupBtn , #gotoEditInfoBtn, #signoutBtn{
		display:inline-block;
		vertical-align:middle;
		text-align:center;
		cursor:pointer;
		width:103px;
		height:25px;
		border-radius:5px;
		background:orangered;
		color:white;
		font-weight:bold;
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
	
	.userInfo{
		font-weight:bold;
		font-size:20px;
		color:blue;
		
	}
</style>
<script>
	function signin(){
		$("#signinForm").submit();
	}
	
	function signout(){
		location.href = "/uwp/signout.do";
	}
	
	function gotoSignup(){
		location.href = "/uwp/views/member/signup.jsp";
	}
	
	function gotoEditInfo(){
		location.href = "/uwp/views/member/editMyInfo.jsp";
	}
</script>
</head>
<body>
	<h1 align="center">Welcome to the Web Project!</h1>	
	<div class="signinArea">
		<%if(member == null){%>
			<form id="signinForm" action="/uwp/signin.do" method="post">
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
							<div id="gotoSignupBtn" onclick="gotoSignup();">Sign up</div>
						</td>
					</tr>
				</table>
			</form>
		<%}else{%>
			<div class="userInfo">
				<table>
					<tr>
						<td><p><%=member.getUsername()%>, Welcome to the Web Project.</p></td>
					</tr>
					<tr>
						<td>
							<div id="gotoEditInfoBtn" onclick="gotoEditInfo();">Edit Info</div>
							<div id="signoutBtn" onclick="signout();">Sign out</div>
						</td>
					</tr>
				</table>		
			</div>
		<%}%>
	</div>
</body>
</html>