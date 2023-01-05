package com.connecTeam.www.command.game;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.connecTeam.www.command.Command;
import com.connecTeam.www.dao.GameDAO;
import com.connecTeam.www.dao.ReviewDAO;
import com.connecTeam.www.dto.GameDTO;
import com.connecTeam.www.dto.ReviewDTO;

public class GameExplainCommand implements Command{
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		GameDAO dao = new GameDAO();
		GameDTO dto = new GameDTO();
		ReviewDAO reviewDao = new ReviewDAO();
		int no  = Integer.parseInt(request.getParameter("no"));
		dto = dao.selectGameExplain(no);
		
	    ArrayList<ReviewDTO> list = reviewDao.selectReview(Integer.parseInt(request.getParameter("no")));
		request.setAttribute("reviewList", list);
		request.setAttribute("dto", dto);
	}
}
