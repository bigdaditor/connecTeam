<%@ include file="/header.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>connecTeam, 즐거움을 연결하라 - 고객센터</title>
</head>
<body>
	<div id="section">
		<div id="csWriteForm" class="text-center mt-5">
		<h2># 고객센터 게시판 글쓰기</h2>
		<h5>- 문의사항을 작성해주세요 -</h5><br>
		</div>
		<div id="csWriteTable" class="text-center col-md-6" style="margin:0 auto;">
		<form method="post" action="/csBoard/csWriteOK.do">
			<table class="table table-borderless">
				<thead>
					<tr>
						<th scope="col" style="width:100px;">제목</th>
						<td scope="col" style="width:500px;">
							<input type="text" name="title" style="width:500px;">
						</td>
					</tr>
				</thead>
				<tbody>
					<tr>
						<th scope="col">아이디</th>
						<td>
							<input type="text" name="memberId" value="${sessionScope.memberId}" style="width:500px;" readonly>
						</td>
					</tr>
					<tr>
						<th scope="col">문의내용</th>
						<td>
							<textarea name="contents" rows="15" cols="68" style="resize: none, width=500px;"></textarea>
						</td>
					</tr>
					<tr>
						<td colspan="2">
							<br><br>
							<input id="submit" class="btn btn-primary" type="submit" value="글쓰기">
						</td>
					</tr>
				</tbody>
			</table>	
		</form>
		</div>
	</div>	
</body>
</html>
<%@ include file="/footer.jsp" %>