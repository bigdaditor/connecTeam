package com.connecTeam.www.command.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.connecTeam.www.command.Command;
import com.connecTeam.www.dao.MemberDAO;
import com.connecTeam.www.dto.MemberDTO;

public class MemberRegisterOKCommand implements Command{
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MemberDTO dto = new MemberDTO();
		MemberDAO dao = new MemberDAO();
		
		dto.setNo(dao.maxNo() + 1);
		dto.setMemberName((String)request.getParameter("memberName"));
		dto.setMemberId((String)request.getParameter("memberId"));
		dto.setMemberPw((String)request.getParameter("memberPw"));
		dto.setEmail((String)request.getParameter("email"));
		dto.setBirthday((String)request.getParameter("birthday"));
		dto.setMobileCarrier((String)request.getParameter("mobileCarrier"));
		
		String phoneNumber1 = (String)request.getParameter("phoneNumber1");
		String phoneNumber2 = (String)request.getParameter("phoneNumber2");
		String phoneNumber3 = (String)request.getParameter("phoneNumber3");
		String phoneNumber = phoneNumber1 + phoneNumber2 + phoneNumber3;
		dto.setPhoneNumber(phoneNumber);
		
		dto.setGender((String)request.getParameter("gender"));
		dto.setRole("user");
		dao.insertMember(dto);
	}
}