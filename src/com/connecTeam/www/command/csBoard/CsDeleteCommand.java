package com.connecTeam.www.command.csBoard;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.connecTeam.www.command.Command;
import com.connecTeam.www.dao.CsBoardDAO;

public class CsDeleteCommand implements Command{
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CsBoardDAO dao = new CsBoardDAO();
		dao.deleteCsBoard(Integer.parseInt(request.getParameter("no")));
	}
}
