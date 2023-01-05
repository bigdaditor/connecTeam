package com.connecTeam.www.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.connecTeam.www.command.Command;
import com.connecTeam.www.command.etc.recommendInfoCommand;

public class EtcController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	int flag = 0;
       
    public EtcController() {
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
		
		if(commandName.equals("/etc/introCompany.do")) {
			viewPage = "/WEB-INF/etc/introCompany.jsp";
			
		} else if(commandName.equals("/etc/recommendInfo.do")) {
			command = new recommendInfoCommand();
			command.execute(request, response);
			viewPage = "/WEB-INF/etc/recommendInfo.jsp";
		}
		
		if(flag == 0) {
			RequestDispatcher dispather = request.getRequestDispatcher(viewPage);
			dispather.forward(request, response);
		} else {
			response.sendRedirect(viewPage);
		}
	}
}