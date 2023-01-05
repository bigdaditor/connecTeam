package com.connecTeam.www.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.connecTeam.www.command.Command;
import com.connecTeam.www.command.payment.PaymentCommand;
import com.connecTeam.www.command.payment.PaymentOKCommand;
import com.connecTeam.www.command.payment.deleteCartCommand;

public class PaymentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public PaymentController() {
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
		
		if(commandName.equals("/payment/addGame.do")) {
			viewPage = "/WEB-INF/payment/addGame.jsp";
			
		} else if(commandName.equals("/payment/payment.do")) {
			command = new PaymentCommand();
			command.execute(request, response);
			viewPage = "/WEB-INF/payment/payment.jsp";
			
		} else if(commandName.equals("/payment/paymentOK.do")) {
			command = new PaymentOKCommand();
			command.execute(request, response);
			viewPage = "/WEB-INF/payment/paymentResult.jsp";
			
		} else if(commandName.equals("/payment/deleteCart.do")) {
			command = new deleteCartCommand();
			command.execute(request, response);
			viewPage = "/payment/cart.do";
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