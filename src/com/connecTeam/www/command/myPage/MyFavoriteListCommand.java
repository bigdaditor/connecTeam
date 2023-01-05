package com.connecTeam.www.command.myPage;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.connecTeam.www.command.Command;
import com.connecTeam.www.dao.GameDAO;
import com.connecTeam.www.dao.MemberDAO;
import com.connecTeam.www.dao.MyPageDAO;
import com.connecTeam.www.dto.GameDTO;

public class MyFavoriteListCommand implements Command{
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MyPageDAO dao = new MyPageDAO();
		MemberDAO memberDao = new MemberDAO();
		GameDAO gameDAO = new GameDAO();
		HttpSession session = request.getSession();
		ArrayList<GameDTO> list = new ArrayList<GameDTO>();
		
		int memberNo = memberDao.selectMemberNo((String)session.getAttribute("memberId"));
		ArrayList<Integer> gameNoList = dao.selectFavoriteList(memberNo);
		
		for(int gameNo : gameNoList) {
			GameDTO gameDto = new GameDTO();
			gameDto = gameDAO.selectGameExplain(gameNo);
			list.add(gameDto);
		}
		
		request.setAttribute("list", list);
	}	
}