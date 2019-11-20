package com.animal.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

import com.animal.dbConnection.DBCP;
import com.animal.vo.VoluntenVO;

public class VoluntenDAO {

private static final VoluntenDAO dao;
	
	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;
	
	static {
		dao = new VoluntenDAO();
	}
	
	private VoluntenDAO() { }
	
	public static VoluntenDAO getInstance() {
		return dao;
	}
	
	public int voluntenInsert(VoluntenVO vo) {
		
		int result = 0;
		
		try {
			
			String sql = "INSERT INTO volunten (v_title, v_recruit, v_require, v_noshow, v_cidx, v_context, v_regdate, v_enddate, v_expdate) VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
			
			con = DBCP.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, vo.getV_title());
			ps.setInt(2, vo.getV_recruit());
			ps.setString(3, vo.getV_require());
			ps.setInt(4, vo.getV_noshow());
			ps.setInt(5, vo.getV_cidx());
			ps.setString(6, vo.getV_context());
			ps.setTimestamp(7, vo.getV_regdate());
			ps.setTimestamp(8, vo.getV_enddate());
			ps.setTimestamp(9, vo.getV_expdate());
			
			result = ps.executeUpdate();
			
		} catch(SQLException e) {
			
			System.out.println("VoluntenDAO - voluntenInsert() 에러 : " + e.getMessage());
			
		} finally {
			
			DBCP.close(con, ps);
			
		}
		
		return result;
		
	}
	
	public VoluntenVO voluntenSelect(int v_no) {
		
		VoluntenVO vo = null;
		
		try {
			
			String sql = "SELECT * FROM volunten WHERE v_no = ?";
			con = DBCP.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, v_no);
			rs = ps.executeQuery();
			
			if(rs.next()) {
				
				vo = new VoluntenVO (
						
					rs.getInt("v_no"),
					rs.getString("v_title"),
					rs.getInt("v_recruit"),
					rs.getString("v_require"),
					rs.getInt("v_noshow"),
					rs.getInt("v_cidx"),
					rs.getString("v_context"),
					rs.getTimestamp("v_regdate"),
					rs.getTimestamp("v_enddate"),
					rs.getTimestamp("v_expdate")
				
				);
				
			}
			
		} catch(SQLException e) {
			
			System.out.println("VoluntenDAO - voluntenSelect() 에러 : " + e.getMessage());
			
		} finally {
			
			DBCP.close(con, ps, rs);
			
		}
		
		return vo;
		
	}
	
	public ArrayList<VoluntenVO> voluntenList() {
		
		ArrayList<VoluntenVO> volList = new ArrayList<VoluntenVO>();
		String sql = "SELECT * FROM volunten ORDER BY v_no DESC";
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			
			con = DBCP.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				
				VoluntenVO vo = new VoluntenVO();
				vo.setV_no(rs.getInt("v_no"));
				vo.setV_title(rs.getString("v_title"));
				vo.setV_recruit(rs.getInt("v_recruit"));
				vo.setV_require(rs.getString("v_require"));
				vo.setV_noshow(rs.getInt("v_noshow"));
				vo.setV_cidx(rs.getInt("v_cidx"));
				vo.setV_context(rs.getString("v_context"));
				vo.setV_regdate(rs.getTimestamp("v_regdate"));
				vo.setV_enddate(rs.getTimestamp("v_enddate"));
				vo.setV_expdate(rs.getTimestamp("v_expdate"));
				
				volList.add(vo);
			
			}
		
		} catch (Exception e) {
			
			System.out.println("VoluntenDAO - voluntenList() 에러 : " + e.getMessage());
			
		} finally {
			
			DBCP.close(con, ps, rs);
			
		}
		
		return volList;
		
	}
	
	public int voluntenDelete(int v_no) {
		
		String sql = "DELETE FROM volunten WHERE v_no = ?";
		
		int result = 0;
		
		try {
			
			con = DBCP.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, v_no);
			
			result = ps.executeUpdate();
			
		} catch(SQLException e) {
			
			System.out.println("VoluntenDAO - voluntenDelete() 에러 : " + e.getMessage());
			
		} finally {
			
			DBCP.close(con, ps);
			
		}
		
		return result;
	}
	
	public int voluntenUpdate(String v_requite, int v_noshow, String v_context, Timestamp v_enddate, int v_no) {
		
		String sql = "UPDATE volunten SET v_require = ?, v_noshow = ?, v_context = ?, v_enddate = ? WHERE v_no = ?";
		int result = 0;
		
		try {
			
			con = DBCP.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, v_requite);
			ps.setInt(2, v_noshow);
			ps.setString(3, v_context);
			ps.setTimestamp(4, v_enddate);
			ps.setInt(5, v_no);
			
			result = ps.executeUpdate();
			
		} catch(SQLException e) {
			
			System.out.println("VoluntenDAO - voluntenUpdate() 에러 : " + e.getMessage());
			
		} finally {
			
			DBCP.close(con, ps);
			
		}
		
		return result;
		
	}
	
}
