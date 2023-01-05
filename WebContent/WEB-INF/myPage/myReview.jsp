<%@ include file="/header.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<meta charset="UTF-8">
<title>connecTeam, 즐거움을 연결하라 - 게임리뷰내역</title>
<link rel="stylesheet" type="text/css" href="/css/myPage/myReview.css">
</head>
<body>
	<h4 class="text-center mt-5 mb-5"># 나의 리뷰 리스트</h4>
	<form method="post">
		<table class="table text-center col-md-6 mb-5" style="margin:0 auto;">
			<thead class="thead-dark">
				<tr>
					<th>번호</th>
					<th>게임이름</th>
					<th>리뷰상세내용</th>
					<th>리뷰평점</th>
					<th>작성일</th>
					<th>리뷰삭제</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${list}" var="list" varStatus="idx">
				<tr>
					<td>${idx.index+1}</td>
					<td>${list.gameTitle }</td>
					<td>${list.contents }</td>
					<td>${list.score }</td>
					<td>${list.wTime }</td>
					<td>
						<input type="submit" class="btn btn-warning btn-sm" value="작성리뷰삭제">
					</td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
	</form>
</body>
</html>
<%@ include file="/footer.jsp"%>