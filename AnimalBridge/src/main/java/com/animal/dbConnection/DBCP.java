package com.animal.dbConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class DBCP {
	private static final DataSource dataSource;
	
	static {
		dataSource = initDataSource();
	}
	
	
// init DataSource
	private static DataSource initDataSource() {
		DataSource ds = null;
		
		try {
			InitialContext initContext = new InitialContext();
			ds = (DataSource)initContext.lookup("java:comp/env/jdbc/animalBridge/dbcp");
			
		} catch(NamingException e) {
			System.out.println("DataSource 에러 : " + e.getMessage());
		}
		
		return ds;
	}
	
	
// getter Connection
	public static Connection getConnection() {
		Connection conn = null;
		
		try {
			conn = dataSource.getConnection();
			
		} catch (SQLException e) {
			System.out.println("getConnection() 에러 : " + e.getMessage());
		}
		
		return conn;
	}
	
	
// close Resource
	public static void close(Connection conn, PreparedStatement preStatement, ResultSet resultSet) {
		try {
			if(resultSet != null) {
				resultSet.close();
			}
			
			close(conn, preStatement);
			
		} catch(SQLException e) {
			System.out.println("DBCP close() - ResultSet 에러 : " + e.getMessage());
		}
	}
	
	public static void close(Connection conn, PreparedStatement preStatement) {
		try {
			if(preStatement != null) {
				preStatement.close();
			}
			
			close(conn);
			
		} catch(SQLException e) {
			System.out.println("DBCP close() - PreparedStatement 에러 : " + e.getMessage());
		}
	}
	
	public static void close(Connection conn) {
		try {
			if(conn != null) {
				conn.close();
			}
			
		} catch(SQLException e) {
			System.out.println("DBCP close() - Connection 에러 : " + e.getMessage());
		}
	}
}
