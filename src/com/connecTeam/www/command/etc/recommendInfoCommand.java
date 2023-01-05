package com.connecTeam.www.command.etc;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.connecTeam.www.command.Command;
import com.connecTeam.www.dao.RecommendInfoDAO;
import com.connecTeam.www.dto.RecommendInfoDTO;

public class recommendInfoCommand implements Command{
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RecommendInfoDAO dao = new RecommendInfoDAO();
		ArrayList<RecommendInfoDTO> list = dao.selectRecommandInfo();
		request.setAttribute("list", list);
	}
}
