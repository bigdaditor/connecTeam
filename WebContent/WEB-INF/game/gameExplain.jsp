<%@ include file="/header.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>connecTeam, 즐거움을 연결하라 - 게임상세정보</title>
<link rel="stylesheet" type="text/css" href="/resources/css/game/gameExplain.css">
</head>
<body>
	<c:if test="${msg eq 'failed'}">
		<script type="text/javascript">
			alert("이미 즐겨찾기에 추가된 게임입니다");
			history.back();
		</script>
	</c:if>
	<div id="gameExplain" style="width: 1200px;" class="mt-5">
		<h4 class="text-center mb-5"># 게임 상세 정보</h4>
		<img src="/resources/img/game/${dto.genre}/${dto.img}" class="img-fluid" alt="Responsive image">
		<table class="table">
			<thead class="thead-dark">
				<tr>
					<th id="explainTitle" colspan="2" scope="col" class="h4">
						${dto.title} 	
						<div style="float:right;">
							<c:if test="${sessionScope.memberId ne '' && sessionScope.memberId ne null}">
								<a href="/payment/addGame.do?no=${dto.no}">
									<button type="button" class="btn btn-primary mr-2" onclick="loginCheck(login)">장바구니</button>
								</a>
								<a href="/payment/payment.do">
									<button type="button" class="btn btn-warning ml-2" onclick="loginCheck(login)">구매하기</button>
								</a>
								<a href="/myPage/myFavorite.do?gameNo=${dto.no}">
									<button type="button" class="btn btn-outline-info ml-2" onclick="loginCheck(login)">즐겨찾기</button>
								</a>
							</c:if>
							<c:if test="${sessionScope.memberId eq '' || sessionScope.memberId eq null}">
								<a href="/payment/addGame.do">
									<button type="button" class="btn btn-primary" onclick="loginCheck(logout)">장바구니</button>
								</a>
								<a href="/payment/payment.do">
									<button type="button" class="btn btn-warning" onclick="loginCheck(logout)">구매하기</button>
								</a>
								<a href="/myPage/myFavorite.do">
									<button type="button" class="btn btn-outline-info" onclick="loginCheck(logout)">즐겨찾기</button>
								</a>
							</c:if>
						</div>
					</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<th scope="row">장르 :</th>
					<td>${dto.genre}</td>
				</tr>
				<tr>
					<th scope="row">개발자 :</th>
					<td>${dto.dev}</td>
				</tr>
				<tr>
					<th scope="row">배급사 :</th>
					<td>${dto.distributor}</td>
				</tr>
				<tr>
					<th scope="row">언어 :</th>
					<td>${dto.lang}</td>
				</tr>
				<tr>
					<th scope="row">출시일 :</th>
					<td>${dto.releaseDate}</td>
				</tr>
				<tr>
					<th scope="row">상세소개 :</th>
					<td>${dto.contents}</td>
				</tr>
				<tr>
					<th scope="row">가격 :</th>
					<td>${dto.price}원</td>
				</tr>
				<tr>
					<th scope="row">평점 :</th>
					<td>
					 <div class='star-rating50'>
        				<span style ="width:${dto.score * 20}%"></span>
    				</div>
					</td>
				</tr>
			</tbody>
		</table>
	<div id="gameReviewWrite">
	<c:if test="${sessionScope.memberId ne '' && sessionScope.memberId ne null}">
    	<form method="post" action="/game/gameReviewOK.do" onsubmit="return loginCheck('login')">
     </c:if>
     <c:if test="${sessionScope.memberId eq '' || sessionScope.memberId eq null}">
     	<form method="post" action="/game/gameReviewOK.do" onsubmit="return loginCheck('logout')">
     </c:if>
    <input type="hidden" name="memberId" value="${sessionScope.memberId}"/>
    <input type="hidden" name="gameNo" value="${dto.no}"/>
    <div class="form-group">
	    <table class="w-100">
	    	<tr>
	    		<th id="explainTitle" colspan="4" scope="col" class="h5 bg-secondary pl-3 mb-3">
					Review
				</th>
	    	</tr>
	        <tr class="mt-3">
	            <th scope="row" style="width:50%">아이디 : ${sessionScope.memberId}</th>
	            <th scope="row" style="width:6%">평점 : </th>
	            <td style="width:44%"> 
		            <select name="score" class="form-control" style="color:#ffbb00">
						<option value="1">&starf;&star;&star;&star;&star;</option>
						<option value="2">&starf;&starf;&star;&star;&star;</option>
						<option value="3">&starf;&starf;&starf;&star;&star;</option>
						<option value="4">&starf;&starf;&starf;&starf;&star;</option>
						<option value="5">&starf;&starf;&starf;&starf;&starf;</option>            	
		            </select>
	            </td>
	        </tr>
	        <tr>
	            <td colspan="4">
	                <textarea name="contents" rows="4" style="width:100%; resize:none;" class="form-control"></textarea>
	            </td>
	        </tr>
	        <tr>
	            <td colspan="4" class="w-100">
	                <input type="submit" value="리뷰등록" class="form-control bg-primary text-white"/>
	            </td>
	        </tr>
	    </table>
	 </div>
    </form>
</div>
<div id="reviewBoard">
    <table class="table">
        <tr>
            <th>별점</th>
            <th>작성자</th>
            <th>리뷰내용</th>
        </tr>
       	<c:forEach items="${reviewList}" var="reviewList">
        <tr>
            <td>
			<div class='star-rating50'>
      			<span style ="width:${reviewList.score * 20}%"></span>
			</div>
            </td>
            <td>${reviewList.memberId}</td>
            <td>${reviewList.contents}</td>
        </tr>
        </c:forEach>
    </table>
</div>
</div>
<script>
function loginCheck(status) {
	if(status == 'logout') {
		alert("로그인한 이용자만 이용가능합니다.");
		return false;
	} 
}
</script>
</body>
</html>
<%@ include file="/footer.jsp"%>