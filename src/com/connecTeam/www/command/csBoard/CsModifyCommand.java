package com.connecTeam.www.command.csBoard;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.connecTeam.www.command.Command;
import com.connecTeam.www.dao.CsBoardDAO;
import com.connecTeam.www.dto.CsBoardDTO;

public class CsModifyCommand implements Command{
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CsBoardDAO dao = new CsBoardDAO();
		CsBoardDTO dto = new CsBoardDTO();
		
		dto = dao.selectCsBoardContents(Integer.parseInt(request.getParameter("no")));
		request.setAttribute("dto", dto);
	}
}