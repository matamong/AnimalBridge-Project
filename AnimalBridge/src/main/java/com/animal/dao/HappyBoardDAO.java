package com.animal.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.animal.dbConnection.DBCP;
import com.animal.vo.HappyBoardVO;

public class HappyBoardDAO {
	private static final HappyBoardDAO dao;
	
	private Connection conn;
	private PreparedStatement preStatement;
	private ResultSet resultSet;
	
	static {
		dao = new HappyBoardDAO();
	}
	
	private HappyBoardDAO() { }
	
	public static HappyBoardDAO getInstance() {
		return dao;
	}
	
	
	public int happyBoardWrite(HappyBoardVO vo) {
		int result = 0;
		
		try {
			String sql = "INSERT INTO HAPPY_BOARD(NICK_NAME, " +
												 "TITLE, " +
												 "CONTENT, " +
												 "REG_DATE, " +
												 "IMG_1, " +
												 "IMG_2, " +
												 "IMG_3)" +
						 "VALUES(?, ?, ?, ?, ?, ?, ?)";
			conn = DBCP.getConnection();
			preStatement = conn.prepareStatement(sql);
			preStatement.setString(1, vo.getNickName());
			preStatement.setString(2, vo.getTitle());
			preStatement.setString(3, vo.getContent());
			preStatement.setDate(4, Date.valueOf(LocalDate.now()));
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
	
	
	public int getHappyBoardWriterResultIdx(HappyBoardVO vo) {
		int result = 0;
		
		try {
			String sql = "SELECT IDX FROM HAPPY_BOARD WHERE " +
															"NICK_NAME=? AND " +
															"TITLE=? AND " +
															"CONTENT=? AND " +
															"IMG_1=? AND " +
															"IMG_2=? AND " +
															"IMG_3=?";
			conn = DBCP.getConnection();
			preStatement = conn.prepareStatement(sql);
			preStatement.setString(1, vo.getNickName());
			preStatement.setString(2, vo.getTitle());
			preStatement.setString(3, vo.getContent());
			preStatement.setString(4, vo.getImg_1());
			preStatement.setString(5, vo.getImg_2());
			preStatement.setString(6, vo.getImg_3());
			
			resultSet = preStatement.executeQuery();
			
			if(resultSet.next()) {
				result = resultSet.getInt("IDX");
			}
			
		} catch(SQLException e) {
			System.out.println("HappyBoardDAO - getHappyBoardWriterResultIdx() 에러 : " + e.getStackTrace());
			
		} finally {
			DBCP.close(conn, preStatement, resultSet);
		}
		
		
		return result;
	}
	
	
	public HappyBoardVO getHappyBoardViewByIdx(int idx) {
		HappyBoardVO resultVO = null;
		
		try {
			String sql = "SELECT * FROM HAPPY_BOARD WHERE IDX=?";
			
			conn = DBCP.getConnection();
			preStatement = conn.prepareStatement(sql);
			preStatement.setInt(1, idx);
			
			resultSet = preStatement.executeQuery();
			
			if(resultSet.next()) {
				resultVO = new HappyBoardVO();
				resultVO.setIdx(resultSet.getInt("IDX"));
				resultVO.setNickName(resultSet.getString("NICK_NAME"));
				resultVO.setTitle(resultSet.getString("TITLE"));
				resultVO.setContent(resultSet.getString("CONTENT"));
				resultVO.setRegDate(resultSet.getString("REG_DATE"));
				resultVO.setWatch(resultSet.getInt("WATCH"));
				resultVO.setHit(resultSet.getInt("HIT"));
				resultVO.setImg_1(resultSet.getString("IMG_1"));
				resultVO.setImg_2(resultSet.getString("IMG_2"));
				resultVO.setImg_3(resultSet.getString("IMG_3"));
			}
			
		} catch(SQLException e ) {
			System.out.println("HappyBoardDAO - getHappyBoardViewByIdx() 에러 : " + e.getStackTrace());
			
		} finally {
			DBCP.close(conn, preStatement, resultSet);
		}
		
		return resultVO;
	}
	
	
	public int getHappyBoardViewTotalCnt() {
		int result = 0;
		
		try {
			String sql = "SELECT COUNT(*) FROM HAPPY_BOARD";
			
			conn = DBCP.getConnection();
			preStatement = conn.prepareStatement(sql);
			resultSet = preStatement.executeQuery();
			
			if(resultSet.next()) {
				result = resultSet.getInt(1);
			}
			
		} catch(SQLException e) {
			System.out.println("HappyBoardDAO - getHappyBoardViewTotalCnt() 에러 : " + e.getStackTrace());
			
		} finally {
			DBCP.close(conn, preStatement, resultSet);
		}
		
		return result;
	}
	
	
	public List<HappyBoardVO> getHappyBoardViewList(int requestPage, int pageDivDegree) {
		List<HappyBoardVO> result = new ArrayList<HappyBoardVO>();
		
		try {
			String sql = "SELECT * FROM HAPPY_BOARD ORDER BY IDX LIMIT ? OFFSET ?";
			
			conn = DBCP.getConnection();
			preStatement = conn.prepareStatement(sql);
			preStatement.setInt(1, pageDivDegree);
			preStatement.setInt(2, requestPage * pageDivDegree);
			resultSet = preStatement.executeQuery();
			
			while(resultSet.next()) {
				HappyBoardVO vo = new HappyBoardVO();
				vo.setIdx(resultSet.getInt("IDX"));
				vo.setNickName(resultSet.getString("NICK_NAME"));
				vo.setTitle(resultSet.getString("TITLE"));
				vo.setContent(resultSet.getString("CONTENT"));
				vo.setRegDate(resultSet.getDate("REG_DATE").toString());
				vo.setWatch(resultSet.getInt("WATCH"));
				vo.setHit(resultSet.getInt("HIT"));
				vo.setImg_1(resultSet.getString("IMG_1"));
				vo.setImg_2(resultSet.getString("IMG_2"));
				vo.setImg_3(resultSet.getString("IMG_3"));
				
				result.add(vo);
			}
			
		} catch(SQLException e) {
			System.out.println("HappyBoardDAO - getHappyBoardViewList() 에러 : " + e.getStackTrace());
			
		} finally {
			DBCP.close(conn, preStatement, resultSet);
		}
		
		return result;
	}
}
