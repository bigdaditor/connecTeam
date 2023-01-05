<%@ include file="/header.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<meta charset="UTF-8">
<title>connecTeam, 즐거움을 연결하라 - 게임구매내역</title>
<link rel="stylesheet" type="text/css" href="/css/myPage/myReview.css">
</head>
<body>
	<h4 class="text-center mt-5 mb-3"># 나의 구매내역</h4>
	<form method="post">
		<table class="table text-center col-md-6 mb-5" style="margin:0 auto;">
			<thead class="thead-dark">
				<tr>
					<th>번호</th>
					<th>게임이름</th>
					<th>가격</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${list}" var="list" varStatus="idx">
				<tr>
					<td>${idx.index+1}</td>
					<td>${list.title }</td>
					<td>${list.price }원</td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
	</form>
</body>
</html>
<%@ include file="/footer.jsp"%>