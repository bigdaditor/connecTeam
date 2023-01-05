package com.connecTeam.www.command.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.connecTeam.www.command.Command;
import com.connecTeam.www.dao.MemberDAO;

public class LoginOKCommand implements Command{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String memberId = request.getParameter("memberId");
		String memberPw = request.getParameter("memberPw");
		MemberDAO dao = new MemberDAO();
		
		if(dao.selectMemberUser(memberId, memberPw).equals("success")) {
			session.setAttribute("memberId", request.getParameter("memberId"));
			session.setAttribute("memberPw", request.getParameter("memberPw"));
			session.setAttribute("memberNo", dao.selectMemberNo(request.getParameter("memberId")));
			session.setAttribute("msg", "success");
		} else {
			session.setAttribute("msg", "failed");
		}
	}
}
