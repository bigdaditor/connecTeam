package com.connecTeam.www.command.myPage;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.connecTeam.www.command.Command;
import com.connecTeam.www.controller.MyPageController;
import com.connecTeam.www.dao.MemberDAO;
import com.connecTeam.www.dto.MemberDTO;

public class MyMemberModifyCommand implements Command{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MemberDTO dto = new MemberDTO();
		MemberDAO dao = new MemberDAO();
		HttpSession session = request.getSession();
		dto = dao.selectMember((String)session.getAttribute("memberId"));
		request.setAttribute("dto", dto);
		String phoneNumber = dto.getPhoneNumber();
		String phoneNumber1 = phoneNumber.substring(0, 3);
 		String phoneNumber2 = phoneNumber.substring(3, 7);
		String phoneNumber3 = phoneNumber.substring(7);
		request.setAttribute("phoneNumber1", phoneNumber1);
		request.setAttribute("phoneNumber2", phoneNumber2);
		request.setAttribute("phoneNumber3", phoneNumber3);
	}	
}