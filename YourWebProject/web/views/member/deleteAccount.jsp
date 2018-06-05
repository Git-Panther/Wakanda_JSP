<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../common/header.jsp" %>
<%@ include file="../common/menu.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Delete your Account</title>
<style>
	.decision{
		background-color:lime;
		color:green;
		vertical-align: middle;
	}
</style>
<script>
	function deleteAccount(){
		$("#deleteForm").submit();
	}
</script>
</head>
<body>
	<form id="deleteForm" action="/uwp/delete.do" method="post">
		<div class="background" align="center">
			<div class="first-line">
				<div>Your Account will be deleted. Will you delete your Account?</div>
			</div>
			<div class="second-line">
				<div id="deleteAccountBtn" class="tile tile-menu decision" onclick="deleteAccount();">Yes</div>
				<div id="goHomeBtn" class="tile tile-menu decision" onclick="goHome();">No</div>
			</div>
		</div>
	</form>
	<%@ include file="../common/footer.jsp" %>
</body>
</html>