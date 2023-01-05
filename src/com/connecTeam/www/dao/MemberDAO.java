package com.connecTeam.www.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.connecTeam.www.dto.MemberDTO;

public class MemberDAO {
	private String connectionName = "jdbc/connecteam";
	private DataSource dataSource;
	
	public MemberDAO() {
		try {
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
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
		
		try {
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			String sql = "select max(no) as no from member";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				result = rs.getInt("no");
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	public void insertMember(MemberDTO dto) {
		Connection conn = getConnection();
		PreparedStatement pstmt = null;
		int result = 0;
		String sql = "insert into member (no, memberName, memberId, memberPw, birthday, email, mobileCarrier, phoneNumber, gender, role) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, dto.getNo());
			pstmt.setString(2, dto.getMemberName());
			pstmt.setString(3, dto.getMemberId());
			pstmt.setString(4, dto.getMemberPw());
			pstmt.setString(5, dto.getBirthday());
			pstmt.setString(6, dto.getEmail());
			pstmt.setString(7, dto.getMobileCarrier());
			pstmt.setString(8, dto.getPhoneNumber());
			pstmt.setString(9, dto.getGender());
			pstmt.setString(10, dto.getRole());
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void updateMember(MemberDTO dto) {
		Connection conn = getConnection();
		PreparedStatement pstmt = null;
		int result = 0;
		String sql = "update member set  memberName = ?, memberId = ?, memberPw = ?, birthday = ?, email = ?, mobileCarrier = ?, phoneNumber = ?, gender = ? where no = ?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getMemberName());
			pstmt.setString(2, dto.getMemberId());
			pstmt.setString(3, dto.getMemberPw());
			pstmt.setString(4, dto.getBirthday());
			pstmt.setString(5, dto.getEmail());
			pstmt.setString(6, dto.getMobileCarrier());
			pstmt.setString(7, dto.getPhoneNumber());
			pstmt.setString(8, dto.getGender());
			pstmt.setInt(9, dto.getNo());
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public String selectMemberUser(String memberId, String memberPw) {
		Connection conn = getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String result = null;
		String sql = "select memberId from member where memberId = ? AND memberPw = ? AND role='user'";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memberId);
			pstmt.setString(2, memberPw);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				result = "success";
			} else {
				result = "failed";
			}
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	public String selectMemberUser(String memberId) {
		Connection conn = getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String result = null;
		String sql = "select memberId from member where memberId = ? AND role='user'";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memberId);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				result = "success";
			} else {
				result = "failed";
			}
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	public int selectMemberNo(String memberId) {
		Connection conn = getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int result = 0;
		String sql = "select no from member where memberId = ? AND role='user'";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memberId);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				result = rs.getInt("no");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public MemberDTO selectMember(String memberId) {
		Connection conn = getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int result = 0;
		String sql = "select * from member where memberId = ? AND role='user'";
		MemberDTO dto = new MemberDTO();
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memberId);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				dto.setNo(rs.getInt("no"));
				dto.setMemberName(rs.getString("memberName"));
				dto.setMemberId(rs.getString("memberId"));
				dto.setMemberPw(rs.getString("memberPw"));
				dto.setBirthday(rs.getString("birthday"));
				dto.setEmail(rs.getString("email"));
				dto.setMobileCarrier(rs.getString("mobileCarrier"));
				dto.setPhoneNumber(rs.getString("phoneNumber"));
				dto.setGender(rs.getString("gender"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(conn, rs, pstmt);
		}
		return dto;
	}
}