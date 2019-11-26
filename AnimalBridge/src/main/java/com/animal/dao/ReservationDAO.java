package com.animal.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
	
	
}
