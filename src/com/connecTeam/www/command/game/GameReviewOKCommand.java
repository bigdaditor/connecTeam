package com.connecTeam.www.command.game;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.connecTeam.www.command.Command;
import com.connecTeam.www.dao.ReviewDAO;
import com.connecTeam.www.dto.ReviewDTO;

public class GameReviewOKCommand implements Command{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ReviewDTO dto = new ReviewDTO();
		ReviewDAO dao = new ReviewDAO();
		HttpSession session = request.getSession();
		int result = 0;
		dto.setNo(dao.maxNo()+1);
		dto.setContents(request.getParameter("contents"));
		dto.setMemberId(request.getParameter("memberId"));
		dto.setGameNo(Long.parseLong(request.getParameter("gameNo")));
		dto.setScore(Integer.parseInt(request.getParameter("score")));
		dao.insertReview(dto);
		dao.updateScore(dto.getGameNo());
		request.setAttribute("no", Integer.parseInt(request.getParameter("gameNo")));
	}
}
