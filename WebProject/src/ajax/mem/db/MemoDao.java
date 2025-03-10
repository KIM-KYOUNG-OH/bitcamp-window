package ajax.mem.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import oracle.db.OracleConnect;

public class MemoDao {

	OracleConnect db;
	public MemoDao() {
		db = OracleConnect.getInstance();	
	}
	
	// insert
	public void memoInsert(MemoDto dto) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "insert into memo (num, nickname, content, avata, writeday) "
				+"values (seq1.nextval, ?,?,?,sysdate)";
		conn = db.getConnection();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getNickname());
			pstmt.setString(2, dto.getContent());
			pstmt.setString(3, dto.getAvata());
			
			pstmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.dbClose(pstmt, conn);
		}
	}
	// 전체 데이터 반환하는 메서드
	public Vector<MemoDto> getAllDatas(){
		Vector<MemoDto> list = new Vector<MemoDto>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql="select * from memo order by num desc";
		conn = db.getConnection();
		try {
			pstmt = conn.prepareStatement(sql);
			// 실행
			rs = pstmt.executeQuery();
			while(rs.next()) {
				MemoDto dto = new MemoDto();
				dto.setNum(rs.getString("num"));
				dto.setNickname(rs.getString("nickname"));
				dto.setContent(rs.getString("content"));
				dto.setAvata(rs.getString("avata"));
				dto.setLikes(rs.getInt("likes"));
				dto.setWriteday(rs.getTimestamp("writeday"));
				
				list.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.dbClose(rs, pstmt, conn);
		}
		
		return list;
	}
	
	public void memoDelete(String num){
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "delete from memo where num=?";
		conn = db.getConnection();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, num);
			pstmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.dbClose(pstmt, conn);
		}
	}
	
	//num 에 해당하는 데이터 보내기
	public MemoDto getData(String num) {
		MemoDto dto = new MemoDto();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from memo where num=?";
		
		conn = db.getConnection();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, num);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				dto.setNum(rs.getString("num"));
				dto.setNickname(rs.getString("nickname"));
				dto.setAvata(rs.getString("avata"));
				dto.setContent(rs.getString("content"));
				dto.setLikes(rs.getInt("likes"));
				dto.setWriteday(rs.getTimestamp("writeday"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.dbClose(rs, pstmt, conn);
		}
		return dto;
	}
	
	// 수정하기
	public void memoUpdate(MemoDto dto) {
		String sql = "update memo set nickname=?, content=?, avata=? where num=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		conn = db.getConnection();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getNickname());
			pstmt.setString(2, dto.getContent());
			pstmt.setString(3, dto.getAvata());
			pstmt.setString(4, dto.getNum());
			
			pstmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.dbClose(pstmt, conn);
		}
	}
	
	// 수정하기
	public void memoUpdateLikes(String num) {
		String sql = "update memo set likes=likes+1 where num=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		conn = db.getConnection();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, num);
			pstmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.dbClose(pstmt, conn);
		}
	}
}


























