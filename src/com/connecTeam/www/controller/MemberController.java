package com.connecTeam.www.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.connecTeam.www.command.Command;
import com.connecTeam.www.command.member.LoginOKCommand;
import com.connecTeam.www.command.member.MemberDuplicateIdOKCommand;
import com.connecTeam.www.command.member.MemberLogoutCommand;
import com.connecTeam.www.command.member.MemberRegisterOKCommand;

public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    public MemberController() {
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
		HttpSession session = request.getSession();
		int flag=0;
		
		 if(commandName.equals("/member/memberLogin.do")) {
			viewPage = "/WEB-INF/member/memberLogin.jsp";
			
		} else if(commandName.equals("/member/memberLoginOK.do")) {
			command = new LoginOKCommand();           
			command.execute(request, response);
			
			if(((String)session.getAttribute("msg")).equals("success")) {
				viewPage = "/index.do";
			} else {
				viewPage = "/member/memberLoginFail.do"; 
			}
			flag = 1;
			
		} else if(commandName.equals("/member/memberLoginFail.do")) {
			viewPage = "/WEB-INF/member/memberLoginFail.jsp";
			
		} else if(commandName.equals("/member/memberLogout.do")) {
			command = new MemberLogoutCommand();
			command.execute(request, response);
			viewPage = "/index.do"; 
			flag = 1;
			
		} else if(commandName.equals("/member/memberRegister.do")) {
			viewPage = "/WEB-INF/member/memberRegister.jsp"; 
			
		} else if(commandName.equals("/member/memberRegisterOK.do")) {
			command = new MemberRegisterOKCommand(); 
			command.execute(request, response);
			viewPage = "/member/memberLogin.do"; 
			flag = 1;
			
		} else if(commandName.equals("/member/memberDuplicateId.do")) {
			command = new MemberDuplicateIdOKCommand(); 
			command.execute(request, response);
			viewPage = "/WEB-INF/member/memberDuplicateId.jsp";
			
		} 
		
		if(flag == 0) {
			RequestDispatcher dispather = request.getRequestDispatcher(viewPage);
			dispather.forward(request, response);
		} else {
			response.sendRedirect(viewPage);
		}
	}
}
