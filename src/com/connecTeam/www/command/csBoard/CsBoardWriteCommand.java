package com.connecTeam.www.command.csBoard;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.connecTeam.www.command.Command;
import com.connecTeam.www.dao.MemberDAO;
import com.connecTeam.www.dto.MemberDTO;

public class CsBoardWriteCommand implements Command{
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MemberDAO dao = new MemberDAO();
		MemberDTO dto = new MemberDTO();
		HttpSession session = request.getSession();
		dto.setMemberId((String)session.getAttribute("memberId"));
	}
}
