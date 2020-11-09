package data.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import data.dto.GuestDto;
import oracle.db.DbConnect;

public class GuestDao {
	DbConnect db = new DbConnect();
	
	public void insertGuest(GuestDto dto) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "insert into guest values(seq_mini.nextval,?,?,?,sysdate)";
		conn = db.getMyConnection();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getMyid());
			pstmt.setString(2, dto.getPhoto());
			pstmt.setString(3, dto.getContent());
			
			pstmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.dbClose(conn, pstmt);
		}
	}
	
	public int getTotalCount(){
		int count = 0;
		Connection conn = null;
		PreparedStatement pstmt= null;
		ResultSet rs = null;
		String sql = "select count(*) from guest";
		conn = db.getMyConnection();
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				count = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.dbClose(conn, pstmt, rs);
		}
		return count;
	}
}
