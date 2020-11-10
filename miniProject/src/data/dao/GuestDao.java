package data.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
	
	// ����¡ ó���� ����Ʈ ��� ��ȯ
	public List<GuestDto> getList(int start, int end){
		List<GuestDto> list = new ArrayList<GuestDto>();
		String sql = "select a.* from (select ROWNUM as RNUM,b.* from"
				+ " (select * from guest order by num desc)b)a where a.RNUM>=? and a.RNUM<=?";
		Connection conn = null;
		PreparedStatement pstmt=null;
		ResultSet rs = null;
		conn = db.getMyConnection();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			rs = pstmt.executeQuery();
			while(rs.next()){
				GuestDto dto = new GuestDto();
				dto.setNum(rs.getString("num"));
				dto.setMyid(rs.getString("myid"));
				dto.setContent(rs.getString("content"));
				dto.setPhoto(rs.getString("photo"));
				dto.setWriteday(rs.getTimestamp("writeday"));
				
				list.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.dbClose(conn, pstmt, rs);
		}
		return list;
	}
	
	public GuestDto getData(String num) {
		GuestDto dto = new GuestDto();
		String sql = "select * from guest where num=?";
		Connection conn = null;
		PreparedStatement pstmt=null;
		ResultSet rs = null;
		conn = db.getMyConnection();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, Integer.parseInt(num));
			rs = pstmt.executeQuery();
			if(rs.next()){
				dto.setNum(rs.getString("num"));
				dto.setMyid(rs.getString("myid"));
				dto.setContent(rs.getString("content"));
				dto.setPhoto(rs.getString("photo"));
				dto.setWriteday(rs.getTimestamp("writeday"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.dbClose(conn, pstmt, rs);
		}
		return dto;
	}
	
	public void updateGuest(GuestDto dto) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		conn = db.getMyConnection();
		
		try {
			if(dto.getPhoto()==null) {
				String sql = "update guest set content=? where num=?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, dto.getContent());
				pstmt.setString(2, dto.getNum());
			}else {
				String sql = "update guest set photo=?,content=? where num=?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, dto.getPhoto());
				pstmt.setString(2, dto.getContent());
				pstmt.setString(3, dto.getNum());
			}
			pstmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.dbClose(conn, pstmt);
		}
	}
	
	// ����
	public void deleteGuest(String num) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql ="delete from guest where num=?";
		conn = db.getMyConnection();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, num);
			
			pstmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.dbClose(conn, pstmt);
		}
	}
}






























