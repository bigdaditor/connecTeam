<%@ include file="/header.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>connecTeam, 즐거움을 연결하라 - 회원가입</title>
<link rel="stylesheet" type="text/css" href="/resources/css/member/memberRegister.css">
</head>
<body>
	<h4 class="text-center mt-5"># 회원가입</h4>
	<h6 class="text-center">아래의 양식에 맞춰 내용을 입력해주세요</h6>
	<form action="/member/memberRegisterOK.do" onsubmit="return validate(check)" method="post" name="register" class="mt-3 justify-content-md-center">
		<input id="check" type="hidden" name="check" value="">
		<table>
			<tr>
				<td>이름</td>
				<td>
					<input type="text" name="memberName" style="width:300px;">
				</td>
			</tr>
			<tr>
				<td>아이디</td>	
				<td>
					<input type="text" id="memberId" name="memberId" value="" style="width:300px;">
					<button type="button" class="btn btn-outline-primary btn-sm" onclick="popDuplicateId()">아이디중복확인</button>
				</td>
			</tr>
			<tr>
				<td>비밀번호</td>
				<td>
					<input type="password" name="memberPw" style="width:300px;">
				</td>
			</tr>
			<tr>
				<td>비밀번호확인</td>
				<td>
					<input type="password" name="rePw" onchange="checkPw()" style="width:300px;">
					<br>
					<span id="checkMsg"></span>
				</td>
			</tr>
			<tr>
				<td>생년월일</td>
				<td>
					<input type="text" name="birthday" style="width:300px;">
				</td>
			</tr>
			<tr>
				<td>E-mail</td>
				<td>
					<input type="email" name="email" style="width:300px;">
				</td>
			</tr>
			<tr>
				<td>휴대폰번호</td>
				<td>
					<select name="mobileCarrier">
						<option value="skt" selected>SKT</option>
						<option value="kt">KT</option>
						<option value="lgu">LGU+</option>
					</select>
					<input type="text" name="phoneNumber1" maxlength="3" style="width:100px;">
					<input type="text" name="phoneNumber2" maxlength="4" style="width:120px;">
					<input type="text" name="phoneNumber3" maxlength="4" style="width:120px;">
				</td>
			</tr>
			<tr>
				<td>성별</td>
				<td>
					<input type="radio" name="gender" id="male" value="male" checked> 남  
					<input type="radio" name="gender" id="female" value="female"> 여
				</td>
			</tr>
			<tr>
				<td colspan="2" class="text-center">
					<input type="submit" value="회원가입" class="btn btn-primary">
				</td>
			</tr>
		</table>
	</form>

<script type="text/javascript">
	
	function popDuplicateId(){
		let memberId = document.getElementById("memberId").value;
		window.open("memberDuplicateId.do?memberId="+ memberId, "idDuplicate", "width=400, height=300", "true");
	}
	
	function validate(check) {
		let registerFrm = document.register;
		if(registerFrm.memberName.value == ''){
			alert("이름을 입력해주세요.");
			return false;
		}
		
		if(registerFrm.memberId.value == '') {
			alert("아이디를 입력해주세요");
			return false;
		} else {
			if(registerFrm.check.value == '' || registerFrm.check.value == 'n'){
				alert("아이디 중복검사를 하지 않았습니다. 다시 입력해주세요.");
				return false;	
			} 
		}
		 
		if(registerFrm.memberPw.value == ''){
			alert("비밀번호를 입력해주세요.");
			return false;
		}
		
		if(registerFrm.rePw.value == ''){
			alert("비밀번호 확인을 입력해주세요.");
			return false;
		} 
		if(registerFrm.birthday.value == ''){
			alert("생년월일을 입력해주세요.");
			return false;
		} 
		
		if(registerFrm.email.value == ''){
			alert("이메일을 입력해주세요.");
			return false;
		} 
		
		
		if(registerFrm.phoneNumber1.value == '' || registerFrm.phoneNumber2.value == '' || registerFrm.phoneNumber3.value == ''){
			alert("휴대폰번호를 모두 입력해주세요.");
			return false;
		}
	}
	
	function checkPw() {
		let registerFrm = document.register;
		let memberPw = registerFrm.memberPw;
		let rePw = registerFrm.rePw;
		
		if(memberPw.value != rePw.value){
			document.getElementById("checkMsg").innerHTML = "비밀번호가 일치하지 않습니다.";
			document.getElementById("checkMsg").style.color = "#f94e3f";
		} else{
			document.getElementById("checkMsg").innerHTML = "비밀번호가 일치합니다.";
			document.getElementById("checkMsg").style.color = "#0080ff";
		}
			
	}
</script>
</body>
</html>
<%@ include file="/footer.jsp" %>