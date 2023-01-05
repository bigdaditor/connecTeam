<%@ include file="/header.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>connecTeam, 즐거움을 연결하라 - 고객센터</title>
<link rel="stylesheet" type="text/css" href="/css/csBoard/csModify.css">
</head>
<body>
	<h4 class="text-center mt-5 mb-3"># 작성내용 수정하기</h4>
	<div id="section" class="mt-5 text-center">
		<div id="csWriteTable" class="text-center col-md-6" style="margin:0 auto;">
			<form method="post" action="/csBoard/csModifyOK.do">
				<input type="hidden" name="no" value="${dto.no}">
				<table class="table table-borderless" style="margin: 0 auto;">
					<thead>
						<tr>
							<th scope="col" style="width: 100px;">제목</th>
							<td scope="col" style="width: 500px;"><input type="text"
								name="title" value="${dto.title}" style="width: 500px;">
							</td>
						</tr>
					</thead>
					<tbody>
						<tr>
							<th scope="col">문의내용</th>
							<td><textarea name="contents" rows="15" cols="68"
									style="resize: none, width=500px;">${dto.contents}
								</textarea></td>
						</tr>
						<tr>
							<td colspan="2"><input type="submit" value="수정완료"
								class="btn btn-primary text-center"></td>
						</tr>
				</table>
			</form>
		</div>
	</div>
</body>
</html>
<%@ include file="/footer.jsp"%>