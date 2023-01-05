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

public class deleteCartCommand implements Command{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		ArrayList<Integer> list = (ArrayList<Integer>)session.getAttribute("cartList");
		if(list != null) {
			try {
				int idx = Integer.parseInt(request.getParameter("idx"));
				list.remove(idx-1);
			} catch (Exception e) {
				e.printStackTrace();
			}
			session.setAttribute("cartList", list);
		}
	}
}
