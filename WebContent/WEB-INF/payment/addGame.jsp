<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
</head>
<body>
<%
request.setCharacterEncoding("UTF-8");
int gameNo = Integer.parseInt(request.getParameter("no"));
ArrayList list = (ArrayList)session.getAttribute("cartList");
if(list == null) {
	list = new ArrayList();
}
list.add(gameNo);
session.setAttribute("cartList", list);
%>
<script>
	alert("상품이 추가 되었습니다.");
	history.back();
</script>
</body>
</html>