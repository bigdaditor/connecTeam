package com.connecTeam.www.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.connecTeam.www.dto.GameDTO;
import com.connecTeam.www.dto.MemberDTO;
import com.connecTeam.www.dto.ReviewDTO;

public class ReviewDAO {
	private String connectionName = "jdbc/connecteam";
	private DataSource dataSource;
	
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
	
	public int maxNo() {
		Connection conn = getConnection();
		int result = 0;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		
		try {
			String sql = "select max(no) as no from review";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				result = rs.getInt("no");
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			close(conn, rs, pstmt);
		}
		
		return result;
	}
	
	public void insertReview(ReviewDTO dto) {
		Connection conn = getConnection();
		PreparedStatement pstmt = null;
		int result = 0;
		String sql = "insert into review (no, gameNo, memberId, contents, score, wTime) values (?, ?, ?, ?, ?, now())";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, dto.getNo());
			pstmt.setFloat(2, dto.getGameNo());
			pstmt.setString(3, dto.getMemberId());
			pstmt.setString(4, dto.getContents());
			pstmt.setInt(5, dto.getScore());
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(conn, pstmt);
		}
	}
	
	public void updateScore(long gameNo) {
		Connection conn = getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select avg(score) as avg from review where gameNo = ?";
		String sql2 = "update game set score = ? where no = ?";
		int result = 0;
		int avg = 0;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setLong(1, gameNo);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				avg = rs.getInt("avg");
			}
			
			pstmt = conn.prepareStatement(sql2);
			pstmt.setInt(1, avg);
			pstmt.setLong(2, gameNo);
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(conn, rs, pstmt);
		}
		
	}
	
	public ArrayList<ReviewDTO> selectReview(int no){
		Connection conn = getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from review where gameNo = ?";
		ArrayList<ReviewDTO> list = new ArrayList<ReviewDTO>();
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, no);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				ReviewDTO dto = new ReviewDTO();
				dto.setNo(rs.getInt("no"));
				dto.setContents(rs.getString("contents"));
				dto.setMemberId(rs.getString("memberId"));
				dto.setGameNo(rs.getInt("gameNo"));
				dto.setScore(rs.getInt("score"));
				list.add(dto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(conn, rs, pstmt);
		}
		
		return list;
	}
	
	public ArrayList<ReviewDTO> selectReviewByMember(String memberId){
		Connection conn = getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from review where memberId like ?";
		ArrayList<ReviewDTO> list = new ArrayList<ReviewDTO>();
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memberId);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				ReviewDTO dto = new ReviewDTO();
				dto.setNo(rs.getInt("no"));
				dto.setContents(rs.getString("contents"));
				dto.setGameNo(rs.getInt("gameNo"));
				dto.setScore(rs.getInt("score"));
				dto.setwTime(rs.getString("wTime"));
				list.add(dto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(conn, rs, pstmt);
		}
		
		return list;
	}
}
