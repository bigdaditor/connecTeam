package com.connecTeam.www.command.csBoard;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.connecTeam.www.command.Command;
import com.connecTeam.www.dao.CsBoardDAO;
import com.connecTeam.www.dto.CsBoardDTO;

public class CsModifyOKCommand implements Command{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CsBoardDTO dto = new CsBoardDTO();
		CsBoardDAO dao = new CsBoardDAO();
		
		dto.setTitle(request.getParameter("title"));
		dto.setContents(request.getParameter("contents"));
		dto.setNo(Integer.parseInt(request.getParameter("no")));
		dao.updateCsBoard(dto);
	}
	
}
