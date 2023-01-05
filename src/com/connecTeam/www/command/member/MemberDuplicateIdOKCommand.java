package com.connecTeam.www.command.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.connecTeam.www.command.Command;
import com.connecTeam.www.dao.MemberDAO;

public class MemberDuplicateIdOKCommand implements Command{
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MemberDAO dao = new MemberDAO();
		HttpSession session = request.getSession();
		String memberId = request.getParameter("memberId");
		if(!memberId.equals("")) {
			if(dao.selectMemberUser(request.getParameter("memberId")).equals("success")) {
				session.setAttribute("duplicateMsg", "failed"); 
			} else {
				session.setAttribute("duplicateId", request.getParameter("memberId"));
				session.setAttribute("check", "1");
				session.setAttribute("duplicateMsg", "success");
			}
		} else {
			session.setAttribute("duplicateMsg", "empty"); 
		}
	}
}