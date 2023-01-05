package com.connecTeam.www.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.connecTeam.www.command.Command;
import com.connecTeam.www.command.game.GameExplainCommand;
import com.connecTeam.www.command.game.GameGenreCommand;
import com.connecTeam.www.command.game.GameListCommand;
import com.connecTeam.www.command.game.GameRankCommand;
import com.connecTeam.www.command.game.GameReviewOKCommand;
import com.connecTeam.www.command.game.GameSearchCommand;

public class GameController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public GameController() {
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
		
		if(commandName.equals("/game/gameList.do")) {
			command = new GameListCommand();
			command.execute(request, response);
			viewPage = "/WEB-INF/game/gameList.jsp";
			
		} else if(commandName.equals("/game/gameGenre.do")) {
			command = new GameGenreCommand();
			command.execute(request, response);
			viewPage = "/WEB-INF/game/gameGenre.jsp"; 
			
		} else if(commandName.equals("/game/gameExplain.do")) {
			command = new GameExplainCommand();
			command.execute(request, response);
			viewPage = "/WEB-INF/game/gameExplain.jsp"; 
			
		} else if(commandName.equals("/game/gameReviewOK.do")) {
			command = new GameReviewOKCommand();
			command.execute(request, response);
			String parameter = "" + request.getAttribute("no");
			viewPage = "/game/gameExplain.do?no="+parameter;
			flag = 1;
			
		} else if(commandName.equals("/game/gameSearch.do")) {
			command = new GameSearchCommand();
			command.execute(request, response);
			viewPage = "/WEB-INF/game/gameSearch.jsp"; 
		
		} else if(commandName.equals("/game/gameRank.do")) {
			command = new GameRankCommand();
			command.execute(request, response);
			viewPage = "/WEB-INF/game/gameRank.jsp";
	
		} 
		
		if(flag == 0) {
			RequestDispatcher dispather = request.getRequestDispatcher(viewPage);
			dispather.forward(request, response);
		} else {
			response.sendRedirect(viewPage);
		}
	}
}