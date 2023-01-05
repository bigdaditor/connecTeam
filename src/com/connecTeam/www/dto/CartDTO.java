package com.connecTeam.www.dto;

public class CartDTO {
	private int no;
	private String gameList;
	private String gameTitle;
	private int memberNo;
	private String cardCompany;
	
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getGameList() {
		return gameList;
	}
	public void setGameList(String gameList) {
		this.gameList = gameList;
	}
	public int getMemberNo() {
		return memberNo;
	}
	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}
	public String getCardCompany() {
		return cardCompany;
	}
	public void setCardCompany(String cardCompany) {
		this.cardCompany = cardCompany;
	}
}