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
import com.connecTeam.www.dao.CartDAO;
import com.connecTeam.www.dto.CartDTO;
import com.connecTeam.www.dto.FavoriteDTO;
import com.connecTeam.www.dto.GameDTO;

public class MyFavoriteCommand implements Command{
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MyPageDAO dao = new MyPageDAO();
		FavoriteDTO dto = new FavoriteDTO();
		MemberDAO memberDao = new MemberDAO();
		HttpSession session = request.getSession();
		
		dto.setNo(dao.maxNoByFavorite()+1);
		dto.setMemberNo(memberDao.selectMemberNo((String)session.getAttribute("memberId")));
		dto.setGameNo(Long.parseLong(request.getParameter("gameNo")));
		request.setAttribute("no", request.getParameter("gameNo"));
		String result = dao.selectFavorite(dto);
		if(result.equals("failed")) {
			request.setAttribute("msg", "failed");
		} else if(result.equals("success")) {
			dao.insertFavorite(dto);
		}
	}	
}