<%@ include file="/header.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>connecTeam, 즐거움을 연결하라 - 추천정보</title>
</head>
<body>
	<h4 class="text-center mt-5"># 추천 유튜브 채널 리스트</h4>
	<h5 class="text-center mt-3 mb-5">- 다양한 게임 정보가 가득한 유튜버들을 소개합니다! -</h5>
	<form method="post">
		<table class="table text-center col-md-8 mt-5 mb-5" style="margin:0 auto;">
		<colgroup>
			<col width="5%">
			<col width="500px">
			<col width="15%">
			<col width="*">
		</colgroup>
		<thead class="thead-dark">
			<tr>
				<th>번호</th>
				<th>추천동영상</th>
				<th>유튜버이름</th>
				<th>채널설명</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${list}" var="list" varStatus="idx">
			<tr>
				<td>${idx.index}</td>
				<td>${list.video}</td>
				<td>${list.name}</td>
				<td>${list.contents}</td>
			</tr>		
			</c:forEach>
		</tbody>	
		</table>
	</form>
</body>
</html>
<%@ include file="/footer.jsp" %>