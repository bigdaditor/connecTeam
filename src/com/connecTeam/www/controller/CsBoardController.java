package com.connecTeam.www.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.connecTeam.www.command.Command;
import com.connecTeam.www.command.csBoard.CsBoardCommand;
import com.connecTeam.www.command.csBoard.CsDeleteCommand;
import com.connecTeam.www.command.csBoard.CsModifyCommand;
import com.connecTeam.www.command.csBoard.CsModifyOKCommand;
import com.connecTeam.www.command.csBoard.CsWriteOKCommand;
import com.connecTeam.www.command.csBoard.CsWriteResultCommand;

public class CsBoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public CsBoardController() {
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
		
		int flag=0;
		
		if(commandName.equals("/csBoard/csBoard.do")) {
			command = new CsBoardCommand();
			command.execute(request, response);
			viewPage = "/WEB-INF/csBoard/csBoard.jsp"; // 고객센터 버튼 클릭 시 고객센터 리스트로 이동
			
		} else if(commandName.equals("/csBoard/csWrite.do")) {
			viewPage = "/WEB-INF/csBoard/csWrite.jsp"; // 글쓰기 버튼 클릭 시 글쓰기뷰로 이동
			
		} else if(commandName.equals("/csBoard/csWriteOK.do")){
			command = new CsWriteOKCommand();         
			command.execute(request, response);
			viewPage = "/csBoard/csBoard.do";
			flag = 1;
			
		} else if(commandName.equals("/csBoard/csModify.do")) {
			command = new CsModifyCommand();         
			command.execute(request, response);
			viewPage = "/WEB-INF/csBoard/csModify.jsp";
			
		} else if(commandName.equals("/csBoard/csModifyOK.do")) {
			command = new CsModifyOKCommand();           
			command.execute(request, response);
			viewPage = "/csBoard/csBoard.do"; // 수정내용저장하기 클릭 시 기존 게시판 리스트로 이동 
			flag = 1;
			
		} else if(commandName.equals("/csBoard/csWriteResult.do")) {
			command = new CsWriteResultCommand();           
			command.execute(request, response);
			viewPage = "/WEB-INF/csBoard/csWriteResult.jsp";
			
		} else if(commandName.equals("/csBoard/csDelete.do")) {
			command = new CsDeleteCommand();
			command.execute(request, response);
			viewPage = "/csBoard/csBoard.do";
			flag = 1;
		}
		
		if(flag == 0) {
			RequestDispatcher dispather = request.getRequestDispatcher(viewPage);
			dispather.forward(request, response);
		} else {
			response.sendRedirect(viewPage);
		}
	}
}