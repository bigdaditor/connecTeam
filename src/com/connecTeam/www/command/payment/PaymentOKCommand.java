package com.connecTeam.www.command.payment;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.connecTeam.www.command.Command;
import com.connecTeam.www.dao.GameDAO;
import com.connecTeam.www.dao.MemberDAO;
import com.connecTeam.www.dao.CartDAO;
import com.connecTeam.www.dto.GameDTO;

public class PaymentOKCommand implements Command{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String[] gameNoArr = request.getParameterValues("gameNo");
		MemberDAO memberDao = new MemberDAO();
		CartDAO dao = new CartDAO();
		HttpSession session = request.getSession(); 
		String memberId = (String)session.getAttribute("memberId");
		int memberNo = memberDao.selectMemberNo(memberId);
		dao.insertCart(memberNo, gameNoArr, dao.maxNo()+1);
		session.removeAttribute("gameList");
	}
}
