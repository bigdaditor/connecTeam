package com.connecTeam.www.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AdminController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AdminController() {
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

		int flag=0;

		if(commandName.equals("/admin/adminDashboard.do")) {
			viewPage = "/WEB-INF/admin/adminDashboard.jsp";

		}

			if(flag == 0) {
				RequestDispatcher dispather = request.getRequestDispatcher(viewPage);
				dispather.forward(request, response);
			} else {
				response.sendRedirect(viewPage);
			}
		}
	}		 