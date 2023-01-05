<%@ include file="/header.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>connecTeam, 즐거움을 연결하라 - 게임리스트</title>
<link rel="stylesheet" type="text/css" href="/css/game/gameList.css">
</head>
<body>
<h2 class="text-center mt-5"># ConnecTeam 전체 게임 리스트</h2><br>
<c:set var="i" value="0" />
<c:set var="j" value="4" />
<c:forEach items="${list}" var="list" varStatus="idx">
	<c:if test="${i%j == 0}">
		<div class="row text-center">
	</c:if>
		<div class="col-lg-3 col-md-6 mb-4">
        <div class="card h-100">
          <img class="card-img-top" src="/resources/img/game/${list.genre}/${list.img}" alt="">
          <div class="card-body">
            <h5 class="card-title">${list.title}</h5>
            <p class="card-text">가격 : ${list.price}원</p>
            <p class="card-text">평점 : 
             <span class="star-rating30 text-left">
      			<span style ="width:${list.score * 20}%"></span>
			</span>
            </p>
            <p class="card-text">출시일 : ${list.releaseDate}</p>
          </div>
          <div class="card-footer">
            <a href="/game/gameExplain.do?no=${list.no}" class="btn btn-primary">게임 상세 정보</a>
          </div>
        </div>
      </div>
	<c:if test="${i%j == j-1 }"></div>
	</c:if> 
	<c:set var="i" value="${i+1 }" />
</c:forEach>
</body>
</html>
<%@ include file="/footer.jsp" %>