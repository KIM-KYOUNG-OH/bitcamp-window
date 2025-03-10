package ajax.note.db;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import oracle.db.OracleConnect;

public class NoteDao {
	OracleConnect db;
	public NoteDao(){
		db = OracleConnect.getInstance();
	}
	
	// insert
	public void addData(NoteDto dto) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "insert into note (num,title,description,image,duedate) values (seq_note.nextval,?,?,?,?)";
		conn = db.getConnection();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getTitle());
			pstmt.setString(2, dto.getDescription());
			pstmt.setString(3, dto.getImage());
			pstmt.setString(4, dto.getDueDate());
			
			pstmt.execute();
		} catch (SQLException e) {
			System.out.println("sql오류 :" +e.getMessage());
		} finally {
			db.dbClose(pstmt, conn);
		}
	}
	
	// select
	public List<NoteDto> showDatas() {
		List<NoteDto> list = new ArrayList<NoteDto>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from note order by num asc";
		
		conn = db.getConnection();
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				NoteDto dto = new NoteDto();
				dto.setNum(rs.getInt("num"));
				dto.setTitle(rs.getString("title"));
				dto.setDescription(rs.getString("description"));
				dto.setCommention(rs.getString("commention"));
				dto.setImage(rs.getString("image"));
				dto.setDueDate(rs.getString("duedate"));
				
				list.add(dto);
			}
		} catch (SQLException e) {
			System.out.println("sql오류 :" +e.getMessage());
		} finally {
			db.dbClose(rs, pstmt, conn);
		}
		
		return list;
	}
	
	// getdata
	public NoteDto getData(int num) {
		NoteDto dto = new NoteDto();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from note where num=?";
		conn = db.getConnection();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();
			if(rs.next()){
				dto.setNum(rs.getInt("num"));
				dto.setTitle(rs.getString("title"));
				dto.setDescription(rs.getString("description"));
				dto.setCommention(rs.getString("commention"));
				dto.setImage(rs.getString("image"));
				dto.setDueDate(rs.getString("duedate"));
			}
		} catch (SQLException e) {
			System.out.println("sql오류 :" +e.getMessage());
		} finally {
			db.dbClose(rs, pstmt, conn);
		}
		return dto;
	}
	
	// update
	public void updateData(NoteDto dto) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "update note set title=?, description=?, commention=?, image=?, duedate=? where num=?";
		conn = db.getConnection();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getTitle());
			pstmt.setString(2, dto.getDescription());
			pstmt.setString(3, dto.getCommention());
			pstmt.setString(4, dto.getImage());
			pstmt.setString(5, dto.getDueDate());
			pstmt.setInt(6, dto.getNum());
			pstmt.execute();
		} catch (SQLException e) {
			System.out.println("sql오류 :" +e.getMessage());
		} finally {
			db.dbClose(pstmt, conn);
		}
	}
	
	// delete
	public void deleteData(int num) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "delete from note where num=?";
		conn = db.getConnection();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			
			pstmt.execute();
		} catch (SQLException e) {
			System.out.println("sql오류 :" +e.getMessage());
		} finally {
			db.dbClose(pstmt, conn);
		}
	}
	
	
}

















