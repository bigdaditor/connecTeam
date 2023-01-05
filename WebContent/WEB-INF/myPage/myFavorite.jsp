<%@ include file="/header.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>connecTeam, 즐거움을 연결하라 - 즐겨찾기</title>
</head>
<body style="height:1000px;">
	<h4 class="mt-5 mb-5 text-center"># 나의 즐겨찾기 리스트</h4>
	<form method="post">
		<table class="table text-center col-md-6 mb-5" style="margin:0 auto;">
			  <thead class="thead-dark">
				<tr>
					<th scope="col">번호</th>
					<th scope="col">게임이름</th>
					<th scope="col">가격</th>
					<th scope="col">리뷰평점</th>
					<th scope="col">목록삭제</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${list}" var="list" varStatus="idx">
				<tr>
					<td scope="row">${idx.index+1}</td>
					<td>${list.title}</td>
					<td>${list.price}</td>
					<td>${list.score}</td>
					<td>
						<button type="button" class="btn btn-warning btn-sm">즐겨찾기삭제</button>
					</td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
	</form>
</body>
</html>
<%@ include file="/footer.jsp"%>