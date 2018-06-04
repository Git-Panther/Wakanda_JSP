<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../common/header.jsp" %>
<%@ include file="../common/menu.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit My Information</title>
<!--autoload=false 파라미터를 이용하여 자동으로 로딩되는 것을 막습니다.-->
<script src="https://ssl.daumcdn.net/dmaps/map_js_init/postcode.v2.js?autoload=false"></script>
<script>
	function validate(){
		if($("#userpw").val() != $("#userpwc").val()){
			alert("Password Wrong!");
			$("#userpwc").val("").focus();
			return false;
		} else if(!($("#male").prop("checked")) && !($("#female").prop("checked"))){
			alert("Sex Wrong!");
			return false;
		} else{
			return true;
		}	
	}
	
	function checkPassword(){ // 비밀번호 입력했는지 체크
		if($("#userpw").val().length >= 1) {
			if($("#userpw").val() != $("#userpwc").val()){
				$("#pwCheckSpan").text("Invalid Password.");
			} else {
				$("#pwCheckSpan").text("Correct Password.");
			}	
		} else{
			$("#pwCheckSpan").text("");
		}
	}
	
	$(function(){	
		$("#userpw").keyup(function(){
			checkPassword();
		});
		
		$("#userpwc").keyup(function(){
			checkPassword();
		});
		
		$("input:radio").each(function(){
			if($(this).val() == '<%=member.getGender()%>'){
				$(this).prop("checked", true);
			}
		});
		
		var phones = '<%=member.getPhone()%>'.split('-');
		$("input[name^=phone]").each(function(index){
			$(this).val(phones[index]);
		});
		
		var hobbies = '<%=member.getAllHobby()%>'.split('');
		$("input[name^=phone]").each(function(index){
			$(this).val(phones[index]);
		});
		
		var addr = '<%=member.getAddress()%>'.split(', ');
		$("#zipcode").val(addr[0]);
		$("#address1").val(addr[1]);
		$("#address2").val(addr[2]);
		
		var email = '<%=member.getEmail()%>'.split('@');
		$("input:email").val(email[0]);
		
		$("#domain option").each(function(index){
			if($(this).val() == email[1]){
				$(this).prop("selected", true);
				break;
			}
		});
	});
	
	function edit(){
		$("#editForm").submit();
	}
	
	function goMain(){
		location.href = "/uwp/index.jsp";
	}
	
	function searchAddr(){
		new daum.Postcode({
            oncomplete: function(data) {
                // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

                // 각 주소의 노출 규칙에 따라 주소를 조합한다.
                // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
                var fullAddr = ''; // 최종 주소 변수
                var extraAddr = ''; // 조합형 주소 변수

                // 사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
                if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
                    fullAddr = data.roadAddress;

                } else { // 사용자가 지번 주소를 선택했을 경우(J)
                    fullAddr = data.jibunAddress;
                }

                // 사용자가 선택한 주소가 도로명 타입일때 조합한다.
                if(data.userSelectedType === 'R'){
                    //법정동명이 있을 경우 추가한다.
                    if(data.bname !== ''){
                        extraAddr += data.bname;
                    }
                    // 건물명이 있을 경우 추가한다.
                    if(data.buildingName !== ''){
                        extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                    }
                    // 조합형주소의 유무에 따라 양쪽에 괄호를 추가하여 최종 주소를 만든다.
                    fullAddr += (extraAddr !== '' ? ' ('+ extraAddr +')' : '');
                }

                // 우편번호와 주소 정보를 해당 필드에 넣는다.
                $("#zipcode").val(data.zonecode);
                $("#address").val(fullAddr);

                // 커서를 상세주소 필드로 이동한다.
                $("#address2").focus();
            }
        }).open();
	}
</script>
</head>
<body>
<div class="outer">
		<h2 align="center">Edit</h2>
		<form id="editForm" method="post" action="/edit.do" onsubmit="return validate();">
			<table>
				<tr>
					<td><span class="import"></span>ID : </td>
					<td><%=member.getUserid()%></td>
					<td></td>
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
					<td><input type="text" name="username" id="username" value="<%=member.getUsername()%>" required></td>
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
					<td><input type="number" name="age" min="0" max="150" value="<%=member.getAge()%>" required></td>
					<td></td>
				</tr>
				<tr>
					<td><span class="import"></span>Email : </td>
					<td>
						<input type="email" name="email">
						@
						<select name="domain" id="domain">
							<option value="naver.com">naver.com</option>
							<option value="hanmail.net">hanmail.net</option>
							<option value="gmail.com">gmail.com</option>
						</select>
					</td>
					<td></td>
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
					<td></td>
				</tr>
				<tr>
					<td><span class="import"></span>Address : </td>
					<td><input type="text" name="address1" id="address1" readonly></td>
					<td><div class="searchBtn" id="addrBtn" onclick="searchAddr();">Search</div></td>
				</tr>
				<tr>
					<td><span class="import"></span>Detail Address : </td>
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
				<div id="editBtn" onclick="edit();">Sign up</div>
			</div>
		</form>
	</div>
	<%@include file="../common/footer.jsp" %>
</body>
</html>