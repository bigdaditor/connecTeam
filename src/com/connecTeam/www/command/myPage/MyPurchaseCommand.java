package com.connecTeam.www.command.myPage;

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
import com.connecTeam.www.dto.CartDTO;
import com.connecTeam.www.dto.GameDTO;

public class MyPurchaseCommand implements Command{
	public static String arrayJoin(String glue, String array[]) {
		String result = "";
	    for (int i = 0; i < array.length; i++) {
	      result += array[i];
	      if (i < array.length - 1) result += glue;
	    }
	    return result;
	}
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CartDAO dao = new CartDAO();
		GameDAO gameDao = new GameDAO();
		MemberDAO memberDao = new MemberDAO();
		ArrayList<GameDTO> gameArrList = new ArrayList<GameDTO>();
		ArrayList<String> gameNoList = new ArrayList<String>();
		String gameNo = "";
		HttpSession session = request.getSession();
		
		ArrayList<CartDTO> list = dao.selectPaymentGameList(memberDao.selectMemberNo((String)session.getAttribute("memberId")));
		if(list != null) {
			try {
				for(int i=0;i<list.size();i++) {
					gameNoList.add(list.get(i).getGameList());
					gameNo = gameNo.concat(gameNoList.get(i)+",");
				}
				
				String[] gameNoArr = gameNo.split(",");
				
				for(int i=0;i<gameNoArr.length;i++) {
					GameDTO gameDto = new GameDTO();
					gameDto = gameDao.selectGameExplain(Integer.parseInt(gameNoArr[i]));
					gameArrList.add(gameDto);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		request.setAttribute("list", gameArrList);
	}	
}