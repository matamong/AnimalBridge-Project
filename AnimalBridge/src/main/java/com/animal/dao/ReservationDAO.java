package com.animal.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.animal.dbConnection.DBCP;
import com.animal.vo.ReservationVO;

public class ReservationDAO {
	private static final ReservationDAO dao;
		
		private Connection conn;
		private PreparedStatement preStatement;
		private ResultSet resultSet;
		
		static {
			dao = new ReservationDAO();
		}
		
		private ReservationDAO() { }
		
		public static ReservationDAO getInstance() {
			return dao;
		}

		
		public ArrayList<ReservationVO> reservationCheckAll(int year, int month, int lastday) {
			
			ArrayList<ReservationVO> revList = new ArrayList<ReservationVO>();
			
			String thismonth = null;
			if(month>9) {
				thismonth = (month+1)+"";
			}else {
				thismonth = "0"+(month+1);
			}
			String date1 = year + "-" + thismonth + "-" + "0" + "1";
			String date2 = year + "-" + thismonth + "-" + lastday;
			
			try {
				String sql = "SELECT * FROM reservation "
							+ "WHERE rev_date IN (SELECT DATE_FORMAT(rev_date, '%y-%m-%d') "
							+ "FROM reservation WHERE rev_date BETWEEN ? AND ?)";         
				conn = DBCP.getConnection();
				preStatement = conn.prepareStatement(sql);
				preStatement.setString(1, date1);
			 	preStatement.setString(2, date2);
				resultSet = preStatement.executeQuery();
		
				
				while(resultSet.next()) {
					ReservationVO vo = new ReservationVO();
					vo.setRev_number(resultSet.getInt(1));
					vo.setRev_date(resultSet.getString(2));
					vo.setRev_time(resultSet.getString(3));
					vo.setAnimal_IDX(resultSet.getInt(4));
					vo.setCenter_IDX(resultSet.getInt(5));
					vo.setNick_name(resultSet.getString(6));
					vo.setPhone(resultSet.getString(7));
					revList.add(vo);
				}
				
			} catch(SQLException e) {
				System.out.println("ReservationDAO - reservationCheckAll() 에러 : " + e.getMessage());
				
			} finally {
				DBCP.close(conn, preStatement, resultSet);
			}
			
			return revList;
		}
	
	
}
