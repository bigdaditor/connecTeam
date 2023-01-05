<%@ include file="/header.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
    <meta charset="utf-8">
    <title>connecTeam, 즐거움을 연결하라 - 로그인</title>
    <link rel="stylesheet" type="text/css" href="/resources/css/member/memberLogin.css">
		<div style="height:800px;" class="container custom-vertical-center mt-5"> 
		   	<div class="row text-center align-items-center">
		    	<div class="col-lg-6 mr-5 mt-5">
		    		<img src="/resources/img/loginLogo.jpg" class="img-fluid mx-auto"> 
		    	</div>
		    	<div class="col-lg-4 ml-5">
			   		<div class="box">
			   			<h4># 로그인</h4><br>
				   		<form class="form" method="post" action="/member/memberLoginOK.do">
							<label for="memberId" class="sr-only">아이디</label>
							<input type="text" id="memberId" name="memberId" class="form-control" placeholder="아이디" required autofocus>
							<label for="memberPw" class="sr-only">비밀번호</label>
							<input type="password" id="memberPw" name="memberPw" class="form-control" placeholder="비밀번호" required>
							<button type="submit" id="loginSubmit" class="btn btn-lg btn-primary btn-block">로그인</button><br>
							<a href="memberRegister.do" id="linkRegister">회원가입</a>
						</form>
					</div>
		   		</div>
		   	</div>
		</div>
	</div>
<%@ include file="/footer.jsp"%>

