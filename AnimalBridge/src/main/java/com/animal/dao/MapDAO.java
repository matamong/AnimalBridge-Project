package com.animal.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.animal.dbConnection.DBCP;
import com.animal.vo.MapVO;

public class MapDAO {
	private static final MapDAO mapDao;

	private Connection conn;
	private PreparedStatement preStatement;
	private ResultSet resultSet;

	static {
		mapDao = new MapDAO();
	}

	private MapDAO() {
	}

	public static MapDAO getInstance() {
		return mapDao;
	}

	public ArrayList<MapVO> mapSelectAll() {

		PreparedStatement pstmt = null;
		ResultSet rs = null;

		ArrayList<MapVO> list = new ArrayList<MapVO>();

		String sql = "SELECT * FROM MAP";

		try {
			conn = DBCP.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				MapVO mapVO = new MapVO();
				mapVO.setEmail(rs.getString("email"));
				mapVO.setX(rs.getInt("x"));
				mapVO.setY(rs.getInt("y"));
				mapVO.setTitle(rs.getString("title"));
				mapVO.setSpecial(rs.getString("special"));
				mapVO.setMap_address(rs.getString("map_address"));
				list.add(mapVO);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (rs != null)
					rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}
}
