<%@ include file="/header.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<title>connecTeam, 즐거움을 연결하라 - 마이페이지</title>
<link rel="stylesheet" type="text/css" href="/resources/css/myPage/myPage.css">
<body>
	<h4 class="text-center mt-5"># 마이페이지</h4>
	<div class="container">
		<form method="post">
			<table style="margin:0 auto">
				<tr>
					<td>
						<a href="/myPage/myMemberModify.do"> 
							<img src="/resources/img/myPage/myMemberModify.png">
						</a>
					</td>
					<td>
						<a href="/myPage/myPurchaseList.do">
							<img src="/resources/img/myPage/myPurchaseList.png">
						</a>
					</td>
				</tr>
				<tr>
					<td>
						<a href="/myPage/myReview.do"> 
							<img src="/resources/img/myPage/myReviewList.png">
						</a>
					</td>
					<td>
						<a href="/myPage/myFavoriteList.do"> 
							<img src="/resources/img/myPage/myLikeList.png">
						</a>
					</td>
				</tr>
				<tr>
					<td></td>
					<td style="float:right;">
						<a href="deleteMember.do">
							<button type="button" class="btn btn-danger">회원탈퇴</button>
						</a>
					</td>
				</tr>
			</table>
		</form>
	</div>
<%@ include file="/footer.jsp"%>