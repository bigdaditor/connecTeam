package com.connecTeam.www.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.connecTeam.www.command.Command;
import com.connecTeam.www.command.myPage.MyFavoriteCommand;
import com.connecTeam.www.command.myPage.MyFavoriteListCommand;
import com.connecTeam.www.command.myPage.MyMemberModifyCommand;
import com.connecTeam.www.command.myPage.MyMemberModifyOKCommand;
import com.connecTeam.www.command.myPage.MyPurchaseCommand;
import com.connecTeam.www.command.myPage.MyReviewCommand;

public class MyPageController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MyPageController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doAction(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doAction(request, response);
	}
	
	protected void doAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String commandName = request.getServletPath();
		String viewPage = null;
		Command command = null;
		int flag = 0;
	
		if(commandName.equals("/myPage/myPage.do")) {
			viewPage = "/WEB-INF/myPage/myPage.jsp";
			
		} else if(commandName.equals("/myPage/myFavorite.do")) {
			command = new MyFavoriteCommand();
			command.execute(request, response);
			String parameter = (String)request.getAttribute("no");
			viewPage = "/game/gameExplain.do?no="+parameter; // 즐겨찾기 버튼 클릭 시 즐겨찾기뷰로 이동
			
		} else if(commandName.equals("/myPage/myFavoriteList.do")) {
			command = new MyFavoriteListCommand();
			command.execute(request, response);
			viewPage = "/WEB-INF/myPage/myFavorite.jsp"; // 즐겨찾기 버튼 클릭 시 즐겨찾기뷰로 이동
			
		} else if(commandName.equals("/myPage/myPurchaseList.do")) {
			command = new MyPurchaseCommand();
			command.execute(request, response);
			viewPage = "/WEB-INF/myPage/myPurchaseList.jsp"; // 구매내역 버튼 클릭 시 구매내역뷰로 이동
			
		} else if(commandName.equals("/myPage/myMemberModify.do")) {        
			command = new MyMemberModifyCommand();
			command.execute(request, response);
			viewPage = "/WEB-INF/myPage/myMemberModify.jsp"; // 회원수정 버튼 클릭 시 회원수정뷰로 이동
			
		} else if(commandName.equals("/myPage/myMemberModifyOK.do")) {
			command = new MyMemberModifyOKCommand();       // 회원수정 내용 제출 시
			command.execute(request, response);
			viewPage = "/myPage/myMemberModify.do"; // 회원수정 후 메인화면 돌아가기
			flag = 1;
			
		} else if(commandName.equals("/myPage/myReview.do")) {
			command = new MyReviewCommand();       // 회원수정 내용 제출 시
			command.execute(request, response);
			viewPage = "/WEB-INF/myPage/myReview.jsp"; // 리뷰내역 버튼 클릭 시 리뷰내역뷰로 이동
			
		} 
		
		if(flag == 0) {
			RequestDispatcher dispather = request.getRequestDispatcher(viewPage);
			dispather.forward(request, response);
		} else {
			response.sendRedirect(viewPage);
		}
	}
}