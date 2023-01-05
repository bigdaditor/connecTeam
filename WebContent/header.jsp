<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta content="width=device-width, initial-scale=1.0" name="viewport">
<link rel="stylesheet" type="text/css" href="/resources/css/etc/header.css">
<link rel="stylesheet" type="text/css" href="/resources/css/etc/stars.css">
<link rel="stylesheet" type="text/css" href="/resources/css/etc/footer.css">
<link rel="stylesheet" type="text/css" href="/resources/css/bootstrap/bootstrap.min.css">
<script src="/resources/js/jquery/jquery-3.5.1.min.js"></script>
<script src="/resources/js/bootstrap/bootstrap.bundle.min.js"></script>
<link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@300&display=swap" rel="stylesheet">
</head>
<body>
<nav class="navbar navbar-dark navbar-expand-lg">
	<a href="/index.do" class="navbar-brand">
     	<img src="/resources/img/logo.png" style="width:300px;">
     </a>
	<button style="border-color: rgba(255,255,255,0.3);" data-toggle="collapse" data-target="#navbar-content" aria-controls="navbar-content" aria-expanded="false" aria-label="Toggle navigation" class="navbar-toggler" >
		<span class="navbar-toggler-icon"></span>
	</button>
	<div id="navbar-content" class="collapse navbar-collapse">
		<ul class="navbar-nav mr-auto">
			<li class="nav-item dropdown">
				<a href="/game/gameGenre.do" id="submenu" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false" class="nav-link text-white dropdown-toggle">
					장르별게임
				</a>
				<div class="dropdown-menu" aria-labelledby="submenu">
					<a class="dropdown-item" href="/game/gameList.do">전체보기</a>
					<a class="dropdown-item" href="/game/gameGenre.do?genre=racing">레이싱</a>
					<a class="dropdown-item" href="/game/gameGenre.do?genre=roleplaying">롤플레이</a>
					<a class="dropdown-item" href="/game/gameGenre.do?genre=sports">스포츠</a>
					<a class="dropdown-item" href="/game/gameGenre.do?genre=simulation">시뮬레이션</a>
					<a class="dropdown-item" href="/game/gameGenre.do?genre=action">액션</a>
					<a class="dropdown-item" href="/game/gameGenre.do?genre=adventure">어드벤쳐</a>
					<a class="dropdown-item" href="/game/gameGenre.do?genre=strategy">전략</a>
					<a class="dropdown-item" href="/game/gameGenre.do?genre=casual">캐주얼</a>
					<a class="dropdown-item" href="/game/gameGenre.do?genre=indi">인디게임</a>
				</div>
			<li class="nav-item">
				<a class="nav-link text-white" href="/game/gameRank.do">인기게임</a>
			</li>
			<li class="nav-item">
				<a class="nav-link text-white" href="/etc/recommendInfo.do">추천정보</a>
			</li>
		</ul>
	    <ul class="navbar-nav ml-auto">
		<c:if test="${sessionScope.memberId eq '' || sessionScope.memberId eq null}">        
      		<li class="nav-item">
	        	<a href="/member/memberLogin.do" class="nav-link text-white">
	        	  로그인
	        	</a>
	     	</li>
        </c:if>
        <c:if test="${sessionScope.memberId ne '' && sessionScope.memberId ne null}">        
      		<li class="nav-item" style="padding: 10px;">
	        	<span class="text-white">
	        		게이머 <span class="text-primary">${sessionScope.memberId }</span> 님 환영합니다.
	        	</span>
	      	</li>
	      	<li class="nav-item">
     			<a href="/member/memberLogout.do" class="nav-link text-white">
      				로그아웃
	        	</a>
       		</li>
        </c:if>
	      <li class="nav-item">
	        <a href="/member/memberRegister.do" class="nav-link text-white">
	          회원가입
	         </a>
	      </li>
	      <li class="nav-item">
	      <c:if test="${sessionScope.memberId ne '' && sessionScope.memberId ne null}">    
        			<a href="/myPage/myPage.do" class="nav-link text-white" onclick="myLogin('login')">마이페이지</a>
        		</c:if>
        		<c:if test="${sessionScope.memberId eq '' || sessionScope.memberId eq null}">
        			<a href="#" class="nav-link text-white" onclick="myLogin('logout')">마이페이지</a>
        		</c:if>
	      </li>
	      <li class="nav-item">
	        <a href="/payment/cart.do" class="nav-link text-white">
	          장바구니
	      	</a>
	      </li>
	    </ul>
	    <form method="post" action="/game/gameSearch.do" class="form-inline my-2 my-lg-0">
      		<input name="keyword" class="form-control mr-sm-2" type="search" placeholder="검색..." aria-label="Search">
      		<button id="search-btn" class="btn my-2 my-sm-0" type="submit">검색</button>
    	</form>
	</div>
</nav>
<script>
function myLogin(status) {
	if(status == 'logout') {
		alert("로그인한 이용자만 이용가능합니다.");
	} 
}
</script>	
