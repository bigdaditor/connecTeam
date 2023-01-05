package com.connecTeam.www.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns={"/","*.do"})
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    public FrontController() {
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
		String[] controllerArr = commandName.split("/");
		String controllerName = null;
		
		if(controllerArr.length < 2) {
			controllerName = "/";
		} else  {
			controllerName = controllerArr[1];
		}
		
		String viewPage = null;
		int flag = 0;
		
		if(commandName.equals("/") || commandName.equals("/index.do")) {
			viewPage = "/index.jsp";
			flag =  2;
		} else if(controllerName.equals("member")) {
			MemberController memberController = new MemberController();
			memberController.doAction(request, response);
			
		} else if(controllerName.equals("game")) {
			GameController gameController = new GameController();
			gameController.doAction(request, response);
			
		} else if(controllerName.equals("myPage")) {
			MyPageController myPageController = new MyPageController();
			myPageController.doAction(request, response);
			
		} else if(controllerName.equals("csBoard")) {
			CsBoardController csBoardController = new CsBoardController();
			csBoardController.doAction(request, response);
			
		} else if(controllerName.equals("payment")) {
			PaymentController paymentController = new PaymentController();
			paymentController.doAction(request, response);
			
		} else if(controllerName.equals("etc")) {
			EtcController etcController = new EtcController();
			etcController.doAction(request, response);
		
		} else if(controllerName.equals("admin")) {
			AdminController adminController = new AdminController();
			adminController.doAction(request, response);
		}
		
		if(flag == 2) {
			RequestDispatcher dispather = request.getRequestDispatcher(viewPage);
			dispather.forward(request, response);
		}
	}
}