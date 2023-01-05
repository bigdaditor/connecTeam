<%@ include file="/header.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>connecTeam, 즐거움을 연결하라 - 장바구니</title>
<link rel="stylesheet" type="text/css" href="/css/payment/cart.css">
</head>
<body>
<c:if test="${msg eq 'empty'}">
<script>
alert("장바구니가 비었습니다.");
history.back();
</script>
</c:if>
<div class="container-fluid text-center mt-5">
	<h4># 장바구니</h4>
	<form name="paymentOK" method="post" action="/payment/paymentOK.do">
		<table class="table">
			<thead class="thead-dark">
				<tr>
					<th scope="col">번호</th>
					<th scope="col">게임이름</th>
					<th scope="col">가격</th>
					<th scope="col">상품삭제</th>
				</tr>
			</thead>
			<tbody>
					<c:forEach items="${gameList}" var="gameList" varStatus="idx">
					<input type="hidden" name="gameNo" value="${gameList.no}">
					<tr id="cartList">
						<td>${idx.index+1}</td>
						<td>${gameList.title }</td>
						<td>${gameList.price} 원</td>
						<td>
							<button type="button" class="btn btn-outline-danger" onclick="deleteCart(this)">삭제하기</button>
						</td>
					</tr>
					<c:set var="sum" value="${sum + gameList.price}"/>
					</c:forEach>
				<tr>
					<td>총 결제금액</td>
					<td></td>
					<td><c:out value="${sum}" />원</td>  <!-- 수정 필요 -->
					<td></td>
				</tr>
				<tr>
					<td colspan="4">
						<a href="/payment/payment">
							<input type="submit" value="결제하기" class="btn btn-primary btn-lg"/>
						</a>
					</td>
				</tr>
			</tbody>
		</table>
	</form>
</div>
<script>
function deleteCart(num) {
	let frm = document.paymentOK;
	let rowIdx = num.parentElement.parentElement.rowIndex;
	let gameNo = '';
	if(document.paymentOK.length > 3) {
		gameNo = document.paymentOK.gameNo[rowIdx-1].value;
	} else{
		gameNo = document.paymentOK.gameNo.value;	
	}
	frm.method = "post";
	frm.action = "/payment/deleteCart.do?idx="+rowIdx;
	frm.submit();
}
</script>
<%@ include file="/footer.jsp"%>