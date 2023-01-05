package com.connecTeam.www.command.payment;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.connecTeam.www.command.Command;
import com.connecTeam.www.dao.GameDAO;
import com.connecTeam.www.dao.CartDAO;
import com.connecTeam.www.dto.GameDTO;

public class PaymentCommand implements Command{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CartDAO dao = new CartDAO();
		GameDAO gameDao = new GameDAO();
		HttpSession session = request.getSession();
		ArrayList<Integer> cartList = (ArrayList<Integer>)session.getAttribute("cartList");
		if(cartList != null) {
			ArrayList<GameDTO> gameList = new ArrayList<GameDTO>();
			
			for(int i : cartList) {
				GameDTO gameDto = new GameDTO();
				gameDto = gameDao.selectGameExplain(i);
				gameList.add(gameDto);
			}
			
			request.setAttribute("gameList", gameList);
		} else {
			request.setAttribute("msg", "empty");
		}
	}
}
