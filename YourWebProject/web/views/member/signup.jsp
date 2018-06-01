<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ include file="../common/header.jsp" %>
<%@ include file="../common/menu.jsp" %>
<html>
<head>
<meta charset="UTF-8">
<title>Sign Up</title>
<style>
	body{
		background:url("/uwp/images/asiangames2018_lol.jpg") no-repeat center;
		backgroun-size:cover;
	}
	
	.signinArea > #signinForm{
		float:right;
	}
	
	.signinArea td{
		color:white;
		font-weight:bold;
	}
	
	.btns div{
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
	
	.searchBtn{
		background:skyblue;
		border-radius:5px;
		width:100px;
		height:25px;
		text-align:center;
		color:blue;
		cursor:pointer;
	}
</style>
<script>
	function validate(){
		if($("#userpw").val() != $("userpwc").val()){
			$("#pwCheckSpan").text("Invalid Password. Write the password to check.");
			return false;
		}
		
		return true;
	}
	
	$(function(){
		$("#userpw").keyup(function(){
			if($("userpwc").val().length >= 1) {
				if($("#userpw").val() != $("userpwc").val()){
					$("#pwCheckSpan").text("Invalid Password. Write the password to check.");
				} else {
					$("#pwCheckSpan").text("PASS");
				}	
			}		
		});
		
		$("#userpwc").keyup(function(){
			if($("#userpw").val() != $("userpwc").val()){
				$("#pwCheckSpan").text("Invalid Password. Write the password to check.");
			} else {
				$("#pwCheckSpan").text("PASS");
			}
		});
	});
	
	function signup(){
		$("form").onsubmit();
	}
</script>
</head>
<body>
	<div class="outer">
		<h2 align="center">Sign up</h2>
		<form method="post" action="/signup.do" onsubmit="validate();">
			<table>
				<tr>
					<td><span class="import"></span>ID : </td>
					<td><input type="text" name="userid" id="userid" required></td>
					<td><div class="searchBtn" id="idCheckBtn" onclick="checkId();">Check</div></td>
				</tr>
				<tr>
					<td><span class="import"></span>Password : </td>
					<td><input type="password" name="userpw" id="userpw" required></td>
					<td></td>
				</tr>
				<tr>
					<td><span class="import"></span>Check Password : </td>
					<td><input type="password" name="userpwc" id="userpwc" required></td>
					<td><span id="pwCheckSpan"></span></td>
				</tr>
				<tr>
					<td><span class="import"></span>Name : </td>
					<td><input type="text" name="username" id="username" required></td>
					<td></td>
				</tr>
				<tr>
					<td><span class="import"></span>Gender : </td>
					<td>
						<input type="radio" name="gender" value="M" id="male"/> <label for="male">Male</label>
						<input type="radio" name="gender" value="F" id="female"/> <label for="female">Female</label>
					</td>
					<td></td>
				</tr>
				<tr>
					<td><span class="import"></span>Age : </td>
					<td><input type="number" name="age" min="0" max="150" required></td>
					<td></td>
				</tr>
				<tr>
					<td><span class="import"></span>Email : </td>
					<td><input type="email" name="email"></td>
					<td><div class="searchBtn" id="emailBtn" onclick="searchEmail();">Search</div></td>
				</tr>
				<tr>
					<td><span class="import"></span>Cell Phone : </td>
					<td>
						<select name="phone1">
							<option value="010">010</option>
							<option value="011">011</option>
						</select>
						- <input type="text" name="phone2" maxlength="4" size="4"/>
						- <input type="text" name="phone3" maxlength="4" size="4"/>
					</td>
					<td><!--<div class="btn" id="phoneBtn" onclick="searchPhone();">Search</div>--></td>
				</tr>
				<tr>
					<td><span class="import"></span>Address Number : </td>
					<td><input type="text" name="zipcode" id="zipcode" readonly></td>
					<td><div class="searchBtn" id="zipcodeBtn" onclick="searchZipCode();">Search</div></td>
				</tr>
				<tr>
					<td><span class="import"></span>Address : </td>
					<td><input type="text" name="address1" id="address1" readonly></td>
					<td><div class="searchBtn" id="addrBtn" onclick="searchAddr();">Search</div></td>
				</tr>
				<tr>
					<td><span class="import"></span>Detail address : </td>
					<td><input type="text" name="address2" id="address2"></td>
					<td></td>
				</tr>
				<tr>
					<td>Hobby : </td>
					<td>
						<input type="checkbox" id="videogame" name="hobby" value="videogame"/>
						<label for="videogame">Video Game</label>
						<input type="checkbox" id="hiking" name="hobby" value="hiking"/>
						<label for="hiking">Hiking</label>
						<input type="checkbox" id="singing" name="hobby" value="singing"/>
						<label for="singing">Singing</label>
						<input type="checkbox" id="novel" name="hobby" value="novel"/>
						<label for="novel">Reading Novel</label>
						<input type="checkbox" id="cooking" name="hobby" value="cooking"/>
						<label for="cooking">Cooking</label>
						<input type="checkbox" id="funcking" name="hobby" value="funcking"/>
						<label for="funcking">F-word</label>
					</td>
					<td></td>
				</tr>
			</table>
			<div class="btns">
				<div id="mainBtn" onclick="goMain();">Main</div>
				<div id="signupBtn" onclick="signup();">Sign up</div>
			</div>
		</form>
	</div>
	<%@include file="../common/footer.jsp" %>
</body>
</html>