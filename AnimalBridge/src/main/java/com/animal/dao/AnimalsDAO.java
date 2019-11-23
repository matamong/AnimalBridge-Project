package com.animal.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

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
}
