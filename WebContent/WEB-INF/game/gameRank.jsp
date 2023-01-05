<%@ include file="/header.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>connecTeam, 즐거움을 연결하라 - 인기게임</title>
</head>
<body>
	<h4 class="text-center mt-5 mb-5"># ConnecTeam Top 10 인기게임 리스트</h4>
	<div id="slide" class="carousel slide" data-ride="carousel">
		<div class="carousel-inner">
			<div class="carousel-item active" data-interval="3000">
				<img class="d-block w-50" style="margin: 0 auto;"
					src="/resources/img/game/roleplaying/1(The Witcher3).jpg">
			</div>
			<div class="carousel-item" data-interval="3000">
				<img class="d-block w-50" style="margin: 0 auto;"
					src="/resources/img/game/casual/1(Among Us).jpg">
			</div>
			<div class="carousel-item" data-interval="3000">
				<img class="d-block w-50" style="margin: 0 auto;"
					src="/resources/img/game/Strategy/1(Sid Meier’s Civilization VI).jpg">
			</div>
			<div class="carousel-item" data-interval="3000">
				<img class="d-block w-50" style="margin: 0 auto;"
					src="/resources/img/game/action/5(Eternal Return Black Servival).jpg">
			</div>
		</div>
		<a class="carousel-control-prev" href="#slide" role="button"
			data-slide="prev"> <span class="carousel-control-prev-icon"
			aria-hidden="true"></span> <span class="sr-only">Previous</span>
		</a> <a class="carousel-control-next" href="#slide" role="button"
			data-slide="next"> 
			<span class="carousel-control-next-icon" 
			aria-hidden="true"></span> <span class="sr-only">Next</span>
		</a>
	</div>
	<div id="rankBoard">
		<div id="gameProduct">
			<form>
				<table class="table text-center col-md-8 mt-5 mb-5" style="margin:0 auto;">
					<thead class="thead-dark">
						<tr>
							<th>순위</th>
							<th>게임이미지</th>
							<th>게임이름</th>
							<th>평점</th>
							<th>가격</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${list}" var="list" varStatus="idx">
						<tr>
							<td>${idx.index+1}</td>
							<td>
								<a href="/game/gameExplain?no=?">
									<img src="/resources/img/game/${list.genre}/${list.img}" alt="">
								</a>
							</td>
							<td><a href="/game/gameExplain.do?no=${list.no}"> ${list.title} </a></td>
							<td>${list.score}</td>
							<td>${list.price}원</td>
						</tr>
						</c:forEach>
					</tbody>
				</table>
			</form>
		</div>
	</div>
</body>
</html>
<%@ include file="/footer.jsp"%>