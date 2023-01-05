<%@ include file="/header.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>connecTeam, 즐거움을 연결하라 - 고객센터</title>
</head>
<body>
	<h4 class="text-center mt-5 mb-3"># 게시물 상세 내용</h4>
	<div id="section" class="mt-5 text-center">
		<div id="csWriteTable" class="text-center col-md-6" style="margin:0 auto;">
			<form method="post" action="/csBoard/csBoard.do">
				<table class="table table-borderless">
					<thead>
						<tr>
							<th scope="col" style="width: 100px;">제목</th>
							<td scope="col" style="width: 500px;"><input type="text"
								name="title" value="${dto.title}" style="width: 500px;" readonly>
							</td>
						</tr>
					</thead>
					<tbody>
						<tr>
							<th scope="col">아이디</th>
							<td><input type="text" name="memberId"
								value="${dto.memberId}" style="width: 500px;" readonly>
							</td>
						</tr>
						<tr>
							<th scope="col">문의내용</th>
							<td><textarea name="contents" rows="15" cols="68"
									style="resize: none, width=500px;" readonly>${dto.contents}</textarea></td>
						</tr>
						<tr>
							<td colspan="2">
								<a href="/csBoard/csBoard.do">
									<button type="button" class="btn btn-primary ml-5 mr-2">목록</button>
							</a> <a href="/csBoard/csModify.do?no=${dto.no}">
									<button type="button" class="btn btn-warning mr-2"
										onclick="onlyMember()">수정</button>
							</a> <a href="/csBoard/csDelete.do?no=${dto.no}">
									<button type="button" class="btn btn-danger"
										onclick="onlyMember()">삭제</button>
							</a></td>
						</tr>
				</table>
			</form>
		</div>
	</div>
	<script type="text/javascript">
	function onlyMember() {
		if(){ // 로그인이 안되어 있을 때!
			alert("로그인된 회원만 이용이 가능합니다.");
			return;
		}
	}
</script>
</body>
</html>
<%@ include file="/footer.jsp"%>