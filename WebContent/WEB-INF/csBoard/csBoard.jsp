<%@ include file="/header.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>connecTeam, 즐거움을 연결하라 - 고객센터</title>
<link rel="stylesheet" type="text/css" href="../resources/css/csBoard/csBoardList.css">
<link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@300&display=swap" rel="stylesheet">
</head>
<body>
<div id="section">
	<div id="csBoard">
	<h2># 1 : 1 고객문의 게시판</h2>
	<h5> - ConnecTeam에게 물어보세요 - </h5><br>
	</div>
	<div id="tableList">
	<table class="table">
		<thead class="thead-dark" id="csBoardTitle">
			<tr>	
				<th scope="col">번호</th>
				<th scope="col">제목</th>
				<th scope="col">아이디</th>
				<th scope="col">작성일시</th>
			</tr>
		</thead>
		<c:forEach items="${list}" var="list" varStatus="idx">
			<tr id="contentsList">
				<td>${idx.index+1}</td>
				<td>
					<a href="/csBoard/csWriteResult.do?no=${list.no}" id="csBoardLink">
						${list.title}
					</a>
				</td>
				<td>${list.memberId}</td>
				<td>${list.wTime}</td>
			</tr>
		</c:forEach>
			<tr>
				<td colspan="4">
					<br><br>
					<a href="/csBoard/csWrite.do">
						<button class="btn-success" type="button">글쓰기</button>
					</a>
				</td>	
			</tr>
	</table>
	</div>
</div>
</body>
</html>
<%@ include file="/footer.jsp" %>