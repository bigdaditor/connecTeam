package com.connecTeam.www.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.connecTeam.www.dto.CartDTO;
import com.connecTeam.www.dto.PaymentDTO;
import com.connecTeam.www.dto.ReviewDTO;

public class CartDAO {
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
	
	public static String arrayJoin(String glue, String array[]) {
		String result = "";
	    for (int i = 0; i < array.length; i++) {
	      result += array[i];
	      if (i < array.length - 1) result += glue;
	    }
	    return result;
	}
	
	public int maxNo() {
		Connection conn = getConnection();
		int result = 0;
		
		try {
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			String sql = "select max(no) as no from cart";
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
	
	public void insertCart(int memberNo, String[] gameListArr, int no) {
		Connection conn = getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "insert into cart(no, memberNo, gameList, status) values(?, ?, ?, ?)";
		String gameList = null;
		int result = 0;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, no);
			pstmt.setInt(2, memberNo);
			gameList = arrayJoin(",",gameListArr);
			pstmt.setString(3, gameList);
			pstmt.setString(4, "Y");
			result = pstmt.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			close(conn, pstmt);
		}
	}
	
	public ArrayList<CartDTO> selectPaymentGameList(int memberNo){
		Connection conn = getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from cart where memberNo = ?";
		ArrayList<CartDTO> list = new ArrayList<CartDTO>();
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, memberNo);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				CartDTO dto = new CartDTO();
				dto.setNo(rs.getInt("no"));
				dto.setGameList(rs.getString("gameList"));
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