<%@ include file="/header.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>connecTeam, 즐거움을 연결하라 - 로그인</title>
<script>
window.onload = function () {
	alert("존재하지 않는 아이디이거나 비밀번호가 틀렸습니다.\n다시 로그인 해주세요.");
	location.href="/member/memberLogin.do";
}
</script>
</body>
</html>
<%@ include file="/footer.jsp" %>