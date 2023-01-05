package com.connecTeam.www.command.game;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.connecTeam.www.command.Command;
import com.connecTeam.www.dao.GameDAO;
import com.connecTeam.www.dto.GameDTO;

public class GameSearchCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		GameDAO dao = new GameDAO();
		String keyword = request.getParameter("keyword");
		ArrayList<GameDTO> list = dao.selectSearchGame(keyword);
	
		request.setAttribute("list", list);
	}
}
