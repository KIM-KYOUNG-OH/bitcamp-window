package data.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import data.dto.DataBoardDto;
import oracle.db.DbConnect;

public class DataBoardDao {
	DbConnect db = new DbConnect();
	
	// ���� ��ȯ
	// key : all : ��ü����
	// 			myid : �ش� ���̵� ����
	// 			subject : ���񿡼� �˻��� ����
	//			content : ���뿡�� �˻��� ����
	public int getTotalCount(String key,String value) {
		//System.out.println(key+":"+value);
		int total = 0;
		String sql = "";
		if(key!=null) {
			if(key.equals("all")) {
				sql = "select count(*) from databoard";
			}else if(key.equals("myid")) {
				sql = "select count(*) from databoard where myid='"+value+"'";
			}else if(key.equals("subject")) {
				sql = "select count(*) from databoard where subject like '%"+value+"%'";
			}else if(key.equals("content")) {
				sql = "select count(*) from databoard where content like '%"+value+"%'";
			}
		}else {
			return total;
		}
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		conn = db.getGangsaConnection();
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			if(rs.next()) {
				total = rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.dbClose(conn, stmt, rs);
		}
		return total;
	}
	
	//insert
	public void insertBoard(DataBoardDto dto) {
		String sql = "insert into databoard values (seq_mini.nextval,?,?,?,?,0,sysdate)";
		Connection conn = null;
		PreparedStatement pstmt = null;
		conn = db.getGangsaConnection();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getMyid());
			pstmt.setString(2, dto.getSubject());
			pstmt.setString(3, dto.getFiles());
			pstmt.setString(4, dto.getContent());
			
			pstmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.dbClose(conn, pstmt);
		}
	}
	
	// �˻� �������Ʈ�� ������������ �ʿ��Ѹ�ŭ ��ȯ�ϱ�
	public List<DataBoardDto> getSearchList(String key, String value,int start,int end){
		List<DataBoardDto> list = new ArrayList<DataBoardDto>();
		String s = "";
		if(key!=null) {
			if(key.equals("myid"))
				s="where myid='"+value+"'";
			else if(key.equals("subject"))
				s="where subject like '%"+value+"%'";
			else if(key.equals("content"))
				s="where content like '%"+value+"%'";   
		}
		String sql="select a.* from (select ROWNUM as RNUM,b.* from "+
				"(select * from databoard "+s+" order by num desc)b)a " + 
				"where a.RNUM>=? and a.RNUM<=?";
		Connection conn = null;
		PreparedStatement pstmt=null;
		ResultSet rs = null;
		conn = db.getGangsaConnection();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,start);
			pstmt.setInt(2,end);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				DataBoardDto dto = new DataBoardDto();
				dto.setNum(rs.getString("num"));
				dto.setMyid(rs.getString("myid"));
				dto.setSubject(rs.getString("subject"));
				dto.setContent(rs.getString("content"));
				dto.setFiles(rs.getString("files"));
				dto.setWriteday(rs.getTimestamp("writeday"));
				
				list.add(dto);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.dbClose(conn, pstmt, rs);
		}
		return list;
	}
}
































