package com.animal.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.animal.dbConnection.DBCP;
import com.animal.vo.RecruitVO;

public class RecruitDAO {

private static final RecruitDAO dao;
	
	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;
	
	static {
		
		dao = new RecruitDAO();
		
	}
	
	private RecruitDAO() { }
	
	public static RecruitDAO getInstance() {
		
		return dao;
		
	}
	
	public int recruitInsert(RecruitVO vo) {
		
		int result = 0;
		
		try {
			
			String sql = "INSERT INTO recruit (r_vno,  r_cnt, r_nick, r_type) VALUES(?, ?, ?, ?)";
			
			con = DBCP.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, vo.getR_vno());
			ps.setInt(2, vo.getR_cnt());
			ps.setString(3, vo.getR_nick());
			ps.setInt(4, vo.getR_type());
			
			result = ps.executeUpdate();
			
		} catch(SQLException e) {
			
			System.out.println("RecruitDAO - recruitInsert() 에러 : " + e.getMessage());
			
		} finally {
			
			DBCP.close(con, ps);
			
		}
		
		return result;
		
	}
	
	public RecruitVO recruitSelect(int r_no) {
		
		RecruitVO vo = null;
		
		try {
			
			String sql = "SELECT * FROM recruit WHERE r_no = ?";
			con = DBCP.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, r_no);
			rs = ps.executeQuery();
			
			if(rs.next()) {
				
				vo = new RecruitVO (
						
					rs.getInt("r_no"),
					rs.getInt("r_vno"),
					rs.getInt("r_cnt"),
					rs.getString("r_nick"),
					rs.getInt("r_type")
				
				);
				
			}
			
		} catch(SQLException e) {
			
			System.out.println("RecruitDAO - recruitSelect() 에러 : " + e.getMessage());
			
		} finally {
			
			DBCP.close(con, ps, rs);
			
		}
		
		return vo;
		
	}
	
	public ArrayList<RecruitVO> recruitList() {
		
		ArrayList<RecruitVO> recList = new ArrayList<RecruitVO>();
		String sql = "SELECT * FROM recruit ORDER BY r_no DESC";
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			
			con = DBCP.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				
				RecruitVO vo = new RecruitVO();
				vo.setR_no(rs.getInt("r_no"));
				vo.setR_vno(rs.getInt("r_vno"));
				vo.setR_cnt(rs.getInt("r_cnt"));
				vo.setR_nick(rs.getString("r_nick"));
				vo.setR_type(rs.getInt("r_type"));
				
				recList.add(vo);
			
			}
		
		} catch (Exception e) {
			
			System.out.println("RecruitDAO - recruitList() 에러 : " + e.getMessage());
			
		} finally {
			
			DBCP.close(con, ps, rs);
			
		}
		
		return recList;
		
	}
	
	public int recruitDelete(int r_no) {
		
		String sql = "DELETE FROM recruit WHERE r_no = ?";
		
		int result = 0;
		
		try {
			
			con = DBCP.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, r_no);
			
			result = ps.executeUpdate();
			
		} catch(SQLException e) {
			
			System.out.println("RecruitDAO - recruitDelete() 에러 : " + e.getMessage());
			
		} finally {
			
			DBCP.close(con, ps);
			
		}
		
		return result;
	}
	
	public int recruitUpdate(int r_cnt, int r_type, int r_no) {
		
		String sql = "UPDATE recruit SET r_cnt = ?, r_type = ? WHERE r_no = ?";
		
		int result = 0;
		
		try {
			
			con = DBCP.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, r_cnt);
			ps.setInt(2, r_type);
			ps.setInt(3, r_no);
			
			result = ps.executeUpdate();
			
		} catch(SQLException e) {
			
			System.out.println("RecruitDAO - recruitUpdate() 에러 : " + e.getMessage());
			
		} finally {
			
			DBCP.close(con, ps);
			
		}
		
		return result;
		
	}
	
	public int getNoshowCount(String nick_name) {
		
		String sql = "SELECT noshow FROM member WHERE nick_name = ?";
		
		int noshow = 0;
		
		try {
			
			con = DBCP.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, nick_name);
			rs = ps.executeQuery();
			
			if(rs.next()) {
				
				noshow = rs.getInt("noshow");
			
			}
				
		} catch(SQLException e) {
			
			System.out.println("RecruitDAO - getNoshowCount() 에러 : " + e.getMessage());
			
		} finally {
			
			DBCP.close(con, ps);
			
		}
		
		return noshow;
		
	}
	
	public int noshowUpdate(String nick_name, int noshow) {
		
		String sql = "UPDATE member SET noshow = ? WHERE nick_name = ?";
		int result = 0;
		
		try {
			
			con = DBCP.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, nick_name);
			ps.setInt(2, noshow);
			
			result = ps.executeUpdate();
			
		} catch(SQLException e) {
			
			System.out.println("RecruitDAO - noshowUpdate() 에러 : " + e.getMessage());
			
		} finally {
			
			DBCP.close(con, ps);
			
		}
		
		return result;
		
	}
	
}
