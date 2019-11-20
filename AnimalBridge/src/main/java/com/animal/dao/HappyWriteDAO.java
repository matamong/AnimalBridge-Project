package com.animal.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.animal.dbConnection.DBCP;
import com.animal.vo.HappyBoardVO;

public class HappyWriteDAO {
	private static final HappyWriteDAO dao;
	
	private Connection conn;
	private PreparedStatement preStatement;
	private ResultSet resultSet;
	
	static {
		dao = new HappyWriteDAO();
	}
	
	private HappyWriteDAO() { }
	
	public static HappyWriteDAO getInstance() {
		return dao;
	}
	
	
	public int happyBoardWrite(HappyBoardVO vo) {
		int result = 0;
		
		try {
			String sql = "INSERT INTO HAPPY_BOARD(IDX, " +
												 "NICK_NAME, " +
												 "TITLE, " +
												 "CONTENT, " +
												 "IMG_1, " +
												 "IMG_2, " +
												 "IMG_3)" +
						 "VALUES(?, ?, ?, ?, ?, ?, ?)";
			conn = DBCP.getConnection();
			preStatement = conn.prepareStatement(sql);
			preStatement.setInt(1, 1);
			preStatement.setString(2, vo.getNickName());
			preStatement.setString(3, vo.getTitle());
			preStatement.setString(4, vo.getContent());
			preStatement.setString(5, vo.getImg_1());
			preStatement.setString(6, vo.getImg_2());
			preStatement.setString(7, vo.getImg_3());
			
			result = preStatement.executeUpdate();
			
			
		} catch(SQLException e) {
			System.out.println("HappyBoardDAO - happyBoardWrite() 에러 : " + e.getMessage());
			
		} finally {
			DBCP.close(conn, preStatement);
		}
		
		return result;
	}
}
