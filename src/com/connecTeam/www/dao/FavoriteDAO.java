package com.connecTeam.www.dao;

import java.sql.Connection;

import javax.sql.DataSource;

public class FavoriteDAO {
	private static FavoriteDAO favoriteDAO = new FavoriteDAO();
	private DataSource dataSource;
	
	private FavoriteDAO() {
		try {
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static FavoriteDAO getFavoriteDAO() {
		return favoriteDAO;
	}
	
	public Connection getConnection() {
		Connection conn = null;
		try {
			conn = dataSource.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
}