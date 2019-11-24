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
import com.animal.vo.AnimalsVO;

public class AnimalsDAO {
	private static final AnimalsDAO dao;
	
	private Connection conn;
	private PreparedStatement preStatement;
	private ResultSet resultSet;
	
	static {
		dao = new AnimalsDAO();
	}
	
	public static AnimalsDAO getInstance() {
		return dao;
	}
	
	
	public int animalsWriter(AnimalsVO vo) {
		int result = 0;
		
		try {
			String sql = "INSERT INTO ANIMALS(CENTER_IDX, " +
											 "ANIMAL_TYPE, " +
											 "ANIMAL_SORT, " +
											 "ANIMAL_GENDER, " +
											 "ANIMAL_NEUTER, " +
											 "ANIMAL_INOCULATION, " +
											 "ANIMAL_FEATURE, " +
											 "ADOPTION_DATE, " +
											 "MEMBER_NICK_NAME, " +
											 "IMG_1, " +
											 "IMG_2, " +
											 "IMG_3, " +
											 "IMG_4, " +
											 "IMG_5, " +
											 "IMG_6) " +
									  "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			conn = DBCP.getConnection();
			
			preStatement = conn.prepareStatement(sql);
			preStatement.setInt(1, vo.getCenterIdx());
			preStatement.setString(2, vo.getAnimalType());
			preStatement.setString(3, vo.getAnimalSort());
			preStatement.setString(4, vo.getAnimalGender());
			preStatement.setString(5, vo.getAnimalNeuter());
			preStatement.setString(6, vo.getAnimalInoculation());
			preStatement.setString(7, vo.getAnimalFeature());
			preStatement.setDate(8, Date.valueOf(LocalDate.now()));
			preStatement.setString(9, vo.getMemberNickName());
			preStatement.setString(10, vo.getImg_1());
			preStatement.setString(11, vo.getImg_2());
			preStatement.setString(12, vo.getImg_3());
			preStatement.setString(13, vo.getImg_4());
			preStatement.setString(14, vo.getImg_5());
			preStatement.setString(15, vo.getImg_6());
			
			result = preStatement.executeUpdate();
			
		} catch(SQLException e) {
			System.out.println("AnimalsDAO - animalsWriter() 에러 : " + e.getMessage());
			
		} finally {
			DBCP.close(conn, preStatement);
		}
		
		return result;
	}
	
	
	public int getAnimalsWriterResultIdx(AnimalsVO vo) {
		int result = 0;
		
		try {
			String sql = "SELECT ANIMAL_IDX FROM ANIMALS WHERE " +
															   "CENTER_IDX=? AND " +
															   "ANIMAL_TYPE=? AND " +
															   "ANIMAL_SORT=? AND " +
															   "ANIMAL_GENDER=? AND " +
															   "ANIMAL_NEUTER=? AND " +
															   "ANIMAL_INOCULATION=? AND " +
															   "ANIMAL_FEATURE=? AND " +
															   "IMG_1=? AND " +
															   "IMG_2=? AND " +
															   "IMG_3=? AND " +
															   "IMG_4=? AND " +
															   "IMG_5=? AND " +
															   "IMG_6=?";
			conn = DBCP.getConnection();
			
			preStatement = conn.prepareStatement(sql);
			preStatement.setInt(1, vo.getCenterIdx());
			preStatement.setString(2, vo.getAnimalType());
			preStatement.setString(3, vo.getAnimalSort());
			preStatement.setString(4, vo.getAnimalGender());
			preStatement.setString(5, vo.getAnimalNeuter());
			preStatement.setString(6, vo.getAnimalInoculation());
			preStatement.setString(7, vo.getAnimalFeature());
			preStatement.setString(8, vo.getImg_1());
			preStatement.setString(9, vo.getImg_2());
			preStatement.setString(10, vo.getImg_3());
			preStatement.setString(11, vo.getImg_4());
			preStatement.setString(12, vo.getImg_5());
			preStatement.setString(13, vo.getImg_6());
			
			resultSet = preStatement.executeQuery();
			
			if(resultSet.next()) {
				result = resultSet.getInt("ANIMAL_IDX");
			}
			
		} catch(SQLException e) {
			System.out.println("AnimalsDAO - getAnimalsWriterResultIdx() 에러 : " + e.getMessage());
			
		} finally {
			DBCP.close(conn, preStatement, resultSet);
		}		
		
		return result;
	}
	
	
	public AnimalsVO getAnimalsViewByIdx(int idx) {
		AnimalsVO result = null;
		
		try {
			String sql = "SELECT * FROM ANIMALS WHERE ANIMAL_IDX=?";
			
			conn = DBCP.getConnection();
			preStatement = conn.prepareStatement(sql);
			preStatement.setInt(1, idx);
			resultSet = preStatement.executeQuery();
			
			if(resultSet.next()) {
				result = new AnimalsVO();
				result.setAnimalIdx(resultSet.getInt("ANIMAL_IDX"));
				result.setCenterIdx(resultSet.getInt("CENTER_IDX"));
				result.setAnimalType(resultSet.getString("ANIMAL_TYPE"));
				result.setAnimalSort(resultSet.getString("ANIMAL_SORT"));
				result.setAnimalGender(resultSet.getString("ANIMAL_GENDER"));
				result.setAnimalNeuter(resultSet.getString("ANIMAL_NEUTER"));
				result.setAnimalInoculation(resultSet.getString("ANIMAL_INOCULATION"));
				result.setAnimalFeature(resultSet.getString("ANIMAL_FEATURE"));
				result.setAdoptionDate(resultSet.getDate("ADOPTION_DATE").toString());
				result.setMemberNickName(resultSet.getString("MEMBER_NICK_NAME"));
				result.setImg_1(resultSet.getString("IMG_1"));
				result.setImg_2(resultSet.getString("IMG_2"));
				result.setImg_3(resultSet.getString("IMG_3"));
				result.setImg_4(resultSet.getString("IMG_4"));
				result.setImg_5(resultSet.getString("IMG_5"));
				result.setImg_6(resultSet.getString("IMG_6"));
			}
			
		} catch(SQLException e) {
			System.out.println("AnimalsDAO - getAnimalsViewByIdx() 에러 : " + e.getMessage());
			
		} finally {
			DBCP.close(conn, preStatement, resultSet);
		}
		
		return result;
	}
	
	
	public int getTotalAnimalsListCnt(String requestAnimalType) {
		int result = 0;
		
		try {
			String sql = "SELECT COUNT(*) FROM ANIMALS";
			conn = DBCP.getConnection();
			
			if(!requestAnimalType.equals("all")) {
				sql += " WHERE ANIMAL_TYPE=?";
				preStatement = conn.prepareStatement(sql);
				preStatement.setString(1, requestAnimalType);
				
			} else {
				preStatement = conn.prepareStatement(sql);
			}
			
			resultSet = preStatement.executeQuery();
			
			if(resultSet.next()) {
				result = resultSet.getInt(1);
			}
			
		} catch(SQLException e) {
			System.out.println("AnimalsDAO - getTotalAnimalsListCnt() 에러 : " + e.getMessage());
			
		} finally {
			DBCP.close(conn, preStatement, resultSet);
		}
		
		
		return result;
	}
	
	
	public List<AnimalsVO> getAnimalsList(int requestPage, int pageDivDegree, String requestAnimalType) {
		List<AnimalsVO> result = new ArrayList<AnimalsVO>();
		
		try {
			String sql = "SELECT * FROM ANIMALS ORDER BY ANIMAL_IDX DESC";
			conn = DBCP.getConnection();
			
			if(!requestAnimalType.equals("all")) {
				sql += " WHERE ANIMAL_TYPE=? LIMIT ? OFFSET ?";
				preStatement = conn.prepareStatement(sql);
				preStatement.setString(1, requestAnimalType);
				preStatement.setInt(2, pageDivDegree);
				preStatement.setInt(3, requestPage * pageDivDegree);
				
			} else {
				sql += " LIMIT ? OFFSET ?";
				preStatement = conn.prepareStatement(sql);
				preStatement.setInt(1, pageDivDegree);
				preStatement.setInt(2, requestPage * pageDivDegree);
			}
			
			resultSet = preStatement.executeQuery();
			
			while(resultSet.next()) {
				AnimalsVO vo = new AnimalsVO();
				vo.setAnimalIdx(resultSet.getInt("ANIMAL_IDX"));
				vo.setCenterIdx(resultSet.getInt("CENTER_IDX"));
				vo.setAnimalType(resultSet.getString("ANIMAL_TYPE"));
				vo.setAnimalSort(resultSet.getString("ANIMAL_SORT"));
				vo.setAnimalGender(resultSet.getString("ANIMAL_GENDER"));
				vo.setAnimalNeuter(resultSet.getString("ANIMAL_NEUTER"));
				vo.setAnimalInoculation(resultSet.getString("ANIMAL_INOCULATION"));
				vo.setAnimalFeature(resultSet.getString("ANIMAL_FEATURE"));
				vo.setAdoptionDate(resultSet.getDate("ADOPTION_DATE").toString());
				vo.setMemberNickName(resultSet.getString("MEMBER_NICK_NAME"));
				vo.setImg_1(resultSet.getString("IMG_1"));
				vo.setImg_2(resultSet.getString("IMG_2"));
				vo.setImg_3(resultSet.getString("IMG_3"));
				vo.setImg_4(resultSet.getString("IMG_4"));
				vo.setImg_5(resultSet.getString("IMG_5"));
				vo.setImg_6(resultSet.getString("IMG_6"));
				
				result.add(vo);
			}
			
		} catch(SQLException e) {
			System.out.println("AnimalsDAO - getAnimalsList() 에러 : " + e.getMessage());
			
		} finally {
			DBCP.close(conn, preStatement, resultSet);
		}
		
		
		return result;
	}
}
