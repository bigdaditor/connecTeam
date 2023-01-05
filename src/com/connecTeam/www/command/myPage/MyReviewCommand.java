package com.connecTeam.www.command.myPage;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.connecTeam.www.command.Command;
import com.connecTeam.www.dao.GameDAO;
import com.connecTeam.www.dao.ReviewDAO;
import com.connecTeam.www.dto.ReviewDTO;

public class MyReviewCommand implements Command{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ReviewDAO dao = new ReviewDAO();
		GameDAO gameDao = new GameDAO();
		
		HttpSession session = request.getSession();
		ArrayList<ReviewDTO> list = dao.selectReviewByMember((String)session.getAttribute("memberId"));
		
		for(int i=0;i<list.size();i++) {
			list.get(i).setGameTitle(gameDao.selectGameTitle(list.get(i).getGameNo()));
		}
		request.setAttribute("list", list);
	}	
}