package com.connecTeam.www.command.game;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.connecTeam.www.command.Command;
import com.connecTeam.www.dao.GameDAO;
import com.connecTeam.www.dto.GameDTO;

public class GameGenreCommand implements Command {
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		GameDAO dao = new GameDAO();
		ArrayList<GameDTO> list =  dao.selectGameGenre(request.getParameter("genre"));
		request.setAttribute("list", list);
	}
}
