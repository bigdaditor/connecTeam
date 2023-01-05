<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="/resources/css/bootstrap/bootstrap.css">
</head>
<body class="text-center mt-5">
	<h4># 아이디 중복확인</h4>
	<c:if test="${sessionScope.duplicateMsg eq 'empty'}">
		<span>사용하실 아이디를 입력해주세요.</span>
		<br><br>
		<button id="success" type="button" onclick="duplicated('close')" class="btn btn-primary btn-sm">확인</button>
	</c:if>
	<c:if test="${sessionScope.duplicateMsg ne 'empty'}">
		<c:if test="${sessionScope.duplicateMsg eq 'success'}">
			<span>입력하신 아이디는 사용가능합니다.</span>
			<br><br>
			<button id="success" type="button" onclick="duplicated('success')" class="btn btn-primary btn-sm">확인</button>
		</c:if>
		<c:if test="${sessionScope.duplicateMsg eq 'failed'}">
			<span>이미 사용 중인 아이디입니다.</span>
			<br><br>
			<button id="failed" type="button" onclick="duplicated('failed')" class="btn btn-secondary btn-sm">확인</button>
		</c:if>	
	</c:if>
</body>
<script type="text/javascript">
	function duplicated(flag) {
		let parent = window.opener;
		let flagSuccess = "success";
		let flagFailed = "failed";
		
 		if(flag == flagSuccess) {
 			let checkSuccess = document.getElementById("success");
 			if(checkSuccess.getAttribute("id") == "success") {
 				parent.document.getElementById("check").value = "y";
 				window.close();
 			}	
 		} else if(flag == flagFailed) {
 			let checkFailed = document.getElementById("failed");
 			if(checkFailed.getAttribute("id") == "failed") {
 				parent.document.getElementById("check").value = "n";
 				window.close();
 			}
 		} else {
 			parent.document.getElementById("check").value = "";
 			window.close();
 		}
	}
</script>
</html>