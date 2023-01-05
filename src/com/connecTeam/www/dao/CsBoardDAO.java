package com.connecTeam.www.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.connecTeam.www.dto.CsBoardDTO;

public class CsBoardDAO {
	private DataSource dataSource;
	private String connectionName = "jdbc/connecteam";
	
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
	
	public ArrayList<CsBoardDTO> selectCsBoard() {
		Connection conn = getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select a.no as no, a.title as title, a.contents as contents, a.wTime as wTime, b.memberId as memberId from csBoard a join member b on a.memberNo = b.no ";
		ArrayList<CsBoardDTO> list = new ArrayList<CsBoardDTO>();
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				CsBoardDTO dto = new CsBoardDTO();
				dto.setNo(rs.getInt("no"));
				dto.setTitle(rs.getString("title"));
				dto.setContents(rs.getString("contents"));
				dto.setwTime(rs.getString("wTime"));
				dto.setMemberId(rs.getString("memberId"));
				list.add(dto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public int maxNo() {
		Connection conn = getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select max(no) as no from csBoard";
		int result = 0;
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				result = rs.getInt("no");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(conn, rs, pstmt);
		}
		
		return result;
	}
	
	public int selectMemberNo(String memberId) {
		Connection conn = getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select no from member where memberId like ?";
		int result = 0;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memberId);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				result = rs.getInt("no"); 
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(conn, rs, pstmt);
		} 
		return result; 
	}
	
	public CsBoardDTO selectCsBoardContents(int no) {
		CsBoardDTO dto = new CsBoardDTO();
		Connection conn = getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select a.no as no, a.title as title, a.contents as contents, a.wTime as wTime, b.memberId as memberId from csBoard a join member b on a.memberNo = b.no where a.no = ?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, no);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				dto.setNo(rs.getInt("no"));
				dto.setTitle(rs.getString("title"));
				dto.setContents(rs.getString("contents"));
				dto.setMemberId(rs.getString("memberId"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(conn, pstmt);
		}
		
		return dto;
	}
	
	public int insertCsBoard(CsBoardDTO dto) {
		Connection conn = getConnection();
		PreparedStatement pstmt = null;
		String sql = "insert into csBoard (no, memberNo, title, contents, wTime) values (?, ?, ?, ?, now())";
		int result = 0;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, dto.getNo());
			pstmt.setInt(2, dto.getMemberNo());
			pstmt.setString(3, dto.getTitle());
			pstmt.setString(4, dto.getContents());
			result = pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(conn, pstmt);
		}
		return result;
	} 
	
	public int updateCsBoard(CsBoardDTO dto) {
		Connection conn = getConnection();
		PreparedStatement pstmt = null;
		String sql = "update csBoard set title=?, contents=? where no=?";
		int result = 0;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getTitle());
			pstmt.setString(2, dto.getContents());
			pstmt.setInt(3, dto.getNo());
			result= pstmt.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			close(conn, pstmt);
		}
		return result;
	}
	
	public int deleteCsBoard(int no) {
		Connection conn = getConnection();
		PreparedStatement pstmt = null;
		String sql = "delete from csBoard where no=?";
		int result = 0;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, no);
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(conn, pstmt);
		}
		return result;
	}
}