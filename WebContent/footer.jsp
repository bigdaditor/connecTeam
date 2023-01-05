<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	<footer>
		<div class="row">
	        <div id="footer_content" class="col-md-6 text-left">
	            <br>
	       		<h4>ConnecTeam</h4>
	            <p>Copyright &copy; www.connecTeam.or.kr</p>
            	<p> Designed and Built by bigdaditor </p>
			</div>
        	<div id="footerLink" class="col-md-6 text-right">
        		<a href="/etc/introCompany.do">ConnecTeam 소개</a><br>
        		<a href="/admin/adminDashboard.do">관리자페이지</a><br>
       		 	<c:if test="${sessionScope.memberId ne '' && sessionScope.memberId ne null}">    
        			<a href="/csBoard/csBoard.do" onclick="csLogin('login')">고객센터</a>
        		</c:if>
        		<c:if test="${sessionScope.memberId eq '' || sessionScope.memberId eq null}">
        			<a href="#" onclick="csLogin('logout')">고객센터</a>
        		</c:if>
        	</div>
    	</div>
	</footer>
<script>
function csLogin(status) {
	if(status == 'logout') {
		alert("로그인한 이용자만 이용가능합니다.");
	} 
}
</script>	
</body>
</html>   