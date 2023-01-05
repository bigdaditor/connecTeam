<%@ include file="/header.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<meta charset="UTF-8">
<title>connecTeam, 즐거움을 연결하라 - 회원정보수정</title>
<link rel="stylesheet" type="text/css" href="/resources/css/myPage/myMemberModify.css">
</head>
<body>
	<h4 class="text-center mt-5"># 회원정보 수정</h4>
	<form action="/myPage/myMemberModifyOK.do" method="post" name="register" class="mt-3 justify-content-md-center">
		<input type="hidden" name="no" value="${dto.no}">
		<table>
			<tbody><tr>
				<td>이름</td>
				<td>
					<input type="text" name="memberName" style="width:300px;" value="${dto.memberName}">
				</td>
			</tr>
			<tr>
				<td>아이디</td>	
				<td>
					<input type="text" id="memberId" name="memberId" value="${dto.memberId}" style="width:300px;">
				</td>
			</tr>
			<tr>
				<td>비밀번호</td>
				<td>
					<input type="password" name="memberPw" style="width:300px;" value="${dto.memberPw}">
				</td>
			</tr>
			<tr>
				<td>생년월일</td>
				<td>
					<input type="text" name="birthday" style="width:300px;" value="${dto.birthday}">
				</td>
			</tr>
			<tr>
				<td>E-mail</td>
				<td>
					<input type="email" name="email" style="width:300px;" value="${dto.email}">
				</td>
			</tr>
			<tr>
				<td>휴대폰번호</td>
				<td>
					<select name="mobileCarrier">
						<option value="skt" <c:if test="${dto.mobileCarrier eq 'skt'}">selected</c:if>>SKT</option>
						<option value="kt" <c:if test="${dto.mobileCarrier eq 'kt'}">selected</c:if>>KT</option>
						<option value="lgu" <c:if test="${dto.mobileCarrier eq 'lgu'}">selected</c:if>>LGU+</option>
					</select>
					<input type="text" name="phoneNumber1" maxlength="3" style="width:100px;" value="${phoneNumber1}">
					<input type="text" name="phoneNumber2" maxlength="4" style="width:120px;" value="${phoneNumber2}">
					<input type="text" name="phoneNumber3" maxlength="4" style="width:120px;" value="${phoneNumber3}">
				</td>
			</tr>
			<tr>
				<td>성별</td>
				<td>
					<input type="radio" name="gender" id="male" value="male" <c:if test="${dto.gender eq 'male'}">checked</c:if>> 남  
					<input type="radio" name="gender" id="female" value="female" <c:if test="${dto.gender eq 'female'}">checked</c:if>> 여
				</td>
			</tr>
			<tr>
				<td colspan="2" class="text-center">
					<input type="submit" value="회원정보 수정" class="btn btn-primary">
				</td>
			</tr>
		</tbody></table>
	</form>
</body>
</html>
<%@ include file="/footer.jsp" %>