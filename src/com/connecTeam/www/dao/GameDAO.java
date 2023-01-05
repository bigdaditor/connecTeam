package com.connecTeam.www.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.connecTeam.www.dto.CsBoardDTO;
import com.connecTeam.www.dto.GameDTO;
import com.mysql.cj.xdevapi.Result;

public class GameDAO {
	private DataSource dataSource;
	private String connectionName = "jdbc/connecteam";
	
//	sql = "select * from game where no =?";
//	sql = "insert into game (no, gameNo, title, contents, wTime, hit, like, dislike, score) values (?, ?, ?, ?, ?, ?, ?, ?, ?)";
//	sql = "update game set no=?, gameNo=?, title=?, contents=?, wTime=?, hit=?, like=?, dislike=?, score=? where no=?";
//	sql = "delete from game where no =?";
	
	public Connection getConnection() {
		Connection conn = null;
		try {
			Context context = new InitialContext();
			dataSource = (DataSource)context.lookup("java:comp/env/" + connectionName);
			conn = dataSource.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	public void close(Connection conn, ResultSet rs, PreparedStatement pstmt) {
		try {
			conn.close();
			rs.close();
			pstmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void close(Connection conn, PreparedStatement pstmt) {
		try {
			conn.close();
			pstmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<GameDTO> selectGameList(){
		Connection conn = getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from game";
		ArrayList<GameDTO> list = new ArrayList<GameDTO>();
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				GameDTO dto = new GameDTO();
				dto.setNo(rs.getInt("no"));
				dto.setImg(rs.getString("img"));
				dto.setTitle(rs.getString("title"));
				dto.setGenre(rs.getString("genre"));
				dto.setDev(rs.getString("dev"));
				dto.setDistributor(rs.getString("distributor"));
				dto.setLang(rs.getString("lang"));
				dto.setReleaseDate(rs.getString("releaseDate"));
				dto.setContents(rs.getString("contents"));
				dto.setPrice(rs.getInt("price"));
				dto.setScore(rs.getInt("score"));
				list.add(dto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public ArrayList<GameDTO> selectGameRank(){
		Connection conn = getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from game order by score desc limit 10";
		ArrayList<GameDTO> list = new ArrayList<GameDTO>();
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				GameDTO dto = new GameDTO();
				dto.setNo(rs.getInt("no"));
				dto.setImg(rs.getString("img"));
				dto.setTitle(rs.getString("title"));
				dto.setGenre(rs.getString("genre"));
				dto.setDev(rs.getString("dev"));
				dto.setDistributor(rs.getString("distributor"));
				dto.setLang(rs.getString("lang"));
				dto.setReleaseDate(rs.getString("releaseDate"));
				dto.setContents(rs.getString("contents"));
				dto.setPrice(rs.getInt("price"));
				dto.setScore(rs.getInt("score"));
				list.add(dto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public ArrayList<GameDTO> selectGameGenre(String genre){
		Connection conn = getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from game where genre like ?";
		ArrayList<GameDTO> list = new ArrayList<GameDTO>();
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, genre);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				GameDTO dto = new GameDTO();
				dto.setNo(rs.getInt("no"));
				dto.setImg(rs.getString("img"));
				dto.setTitle(rs.getString("title"));
				dto.setGenre(rs.getString("genre"));
				dto.setDev(rs.getString("dev"));
				dto.setDistributor(rs.getString("distributor"));
				dto.setLang(rs.getString("lang"));
				dto.setReleaseDate(rs.getString("releaseDate"));
				dto.setContents(rs.getString("contents"));
				dto.setPrice(rs.getInt("price"));
				dto.setScore(rs.getInt("score"));
				list.add(dto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public ArrayList<GameDTO> selectSearchGame(String keyword){
		Connection conn = getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from game where title like ?";
		ArrayList<GameDTO> list = new ArrayList<GameDTO>();
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%"+ keyword +"%");
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				GameDTO dto = new GameDTO();
				dto.setNo(rs.getInt("no"));
				dto.setImg(rs.getString("img"));
				dto.setTitle(rs.getString("title"));
				dto.setGenre(rs.getString("genre"));
				dto.setDev(rs.getString("dev"));
				dto.setDistributor(rs.getString("distributor"));
				dto.setLang(rs.getString("lang"));
				dto.setReleaseDate(rs.getString("releaseDate"));
				dto.setContents(rs.getString("contents"));
				dto.setPrice(rs.getInt("price"));
				dto.setScore(rs.getInt("score"));
				list.add(dto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public String selectGameTitle(long no) {
		Connection conn = getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		GameDTO dto = new GameDTO();
		String sql = "select title from game where no=?";
		String title = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setLong(1, no);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				title = rs.getString("title");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return title;
	}
	
	public GameDTO selectGameExplain(int no) {
		Connection conn = getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		GameDTO dto = new GameDTO();
		String sql = "select * from game where no=?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, no);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				dto.setNo(rs.getInt("no"));
				dto.setImg(rs.getString("img"));
				dto.setTitle(rs.getString("title"));
				dto.setGenre(rs.getString("genre"));
				dto.setDev(rs.getString("dev"));
				dto.setDistributor(rs.getString("distributor"));
				dto.setLang(rs.getString("lang"));
				dto.setReleaseDate(rs.getString("releaseDate"));
				dto.setContents(rs.getString("contents"));
				dto.setPrice(rs.getInt("price"));
				dto.setScore(rs.getInt("score"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return dto;
	}
}
