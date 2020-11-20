package data.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import data.dto.BoardDto;
import mysql.db.MysqlConnect;

public class BoardDao {
	MysqlConnect db = new MysqlConnect();
	
	// num�� max�� ���ؼ� ����(null�� ��� 0 ����)
	public int getMaxNum() {
		int max = 0;
		String sql = "select ifnull(max(num),0) max from board";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		conn = db.getGangsaConnection();
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				max = rs.getInt("max");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.dbClose(conn, pstmt, rs);
		}
		return max;
	}
	
	// ������ �߰��� ���� �׷��� ���޹��� step���� ū���� ����
	// �����͵��� restep�� ������ +1�� �Ѵ�
	public void updateRestep(int regroup, int restep) {
		String sql = "update board set restep = restep + 1 where regroup=? and restep>?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		conn = db.getGangsaConnection();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, regroup);
			pstmt.setInt(2, restep);
			
			pstmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.dbClose(conn, pstmt);
		}
	}
	
	// insert: ���� �߿��� �� ���� ���۷� �߰��� �Ұ�����,
	// ��۷� �߰��� �Ұ������̴�
	// �׷��� �Ǵ��� dto�� ����ִ� num�� null�̸� ���۷�
	// null�� �ƴϸ� ��۷� insert�� �Ұ��̴�
	public void insertBoard(BoardDto dto) {
		String num = dto.getNum();
		int regroup = dto.getRegroup();
		int relevel = dto.getRelevel();
		int restep = dto.getRestep();
		String sql = "insert into board (writer,subject,content,pass,regroup,relevel,restep,writeday) values "
				+ "(?,?,?,?,?,?,?,now())";
		if(num==null) {
			// ������ �ǹ��Ѵ�
			regroup = this.getMaxNum()+1;
			relevel = 0;
			restep = 0;
		}else {
			// ����� �ǹ��Ѵ�
			// ���� �׷��� restep�� ���޹��� ������ ū��� ������ 1����
			this.updateRestep(regroup, restep);
			// �׸��� ���޹��� level,step�� 1�����Ѵ�
			relevel+=1;
			restep+=1;
		}
		Connection conn = null;
		PreparedStatement pstmt = null;
		conn = db.getGangsaConnection();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getWriter());
			pstmt.setString(2, dto.getSubject());
			pstmt.setString(3, dto.getContent());
			pstmt.setString(4, dto.getPass());
			pstmt.setInt(5, regroup);
			pstmt.setInt(6, relevel);
			pstmt.setInt(7, restep);
			
			pstmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.dbClose(conn, pstmt);
		}
	}
	
	// ���뺸��� ��ȸ�� 1������ �ؾ��ϹǷ�
	public void updateReadcount(String num) {
		String sql = "update board set readcount = readcount + 1 where num=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		conn = db.getGangsaConnection();
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
	
	// ���뺸��
	public BoardDto getData(String num) {
		BoardDto dto = null;
		String sql = "select * from board where num=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		conn = db.getGangsaConnection();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, num);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				dto = new BoardDto();
				dto.setNum(rs.getString("num"));
				dto.setWriter(rs.getString("writer"));
				dto.setSubject(rs.getString("subject"));
				dto.setContent(rs.getString("content"));
				dto.setPass(rs.getString("pass"));
				dto.setRegroup(rs.getInt("regroup"));
				dto.setRelevel(rs.getInt("relevel"));
				dto.setRestep(rs.getInt("restep"));
				dto.setReadcount(rs.getInt("readcount"));
				dto.setWriteday(rs.getTimestamp("writeday"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.dbClose(conn, pstmt, rs);
		}
		return dto;
	}
	
	// ���-����¡ó��
	public List<BoardDto> getList(int start, int perpage){
		String sql = "select * from board order by regroup desc, restep asc limit ?,?";
		List<BoardDto> list = new ArrayList<BoardDto>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		conn = db.getGangsaConnection();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, start);
			pstmt.setInt(2, perpage);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				BoardDto dto = new BoardDto();
				dto.setNum(rs.getString("num"));
				dto.setWriter(rs.getString("writer"));
				dto.setSubject(rs.getString("subject"));
				dto.setContent(rs.getString("content"));
				dto.setPass(rs.getString("pass"));
				dto.setRegroup(rs.getInt("regroup"));
				dto.setRelevel(rs.getInt("relevel"));
				dto.setRestep(rs.getInt("restep"));
				dto.setReadcount(rs.getInt("readcount"));
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
	
	// ��ü ���� ���ϱ�
	public int getTotalCount() {
		int total = 0;
		String sql = "select count(*) from board ";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		conn = db.getGangsaConnection();
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				total = rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.dbClose(conn, pstmt, rs);
		}
		return total;
	}
	
	// ����� ������� true��ȯ
	public boolean isEqualPass(String num, String pass) {
		boolean flag=false;
		String sql = "select count(*) from board where num=? and pass=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		conn = db.getGangsaConnection();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, num);
			pstmt.setString(2, pass);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				if(rs.getInt(1) == 1) {
					flag = true;
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.dbClose(conn, pstmt);
		}
		return flag;
	}
	
	// ����
	public void updateBoard(BoardDto dto) {
		String sql = "update board set writer=?, subject=?, content=? where num=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		conn = db.getGangsaConnection();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getWriter());
			pstmt.setString(2, dto.getSubject());
			pstmt.setString(3, dto.getContent());
			pstmt.setString(4, dto.getNum());
			
			pstmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.dbClose(conn, pstmt);
		}
	}
	
	// ����
	public void deleteBoard(String num) {
		String sql = "delete from board where num=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		conn = db.getGangsaConnection();
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
	
	public boolean isGroupStep(int regroup) {
		boolean flag = false;
		String sql = "select * from board where regroup=? and restep=0";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		conn = db.getGangsaConnection();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, regroup);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				flag=true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.dbClose(conn, pstmt);
		}
		return flag;
	}
	
	public List<BoardDto> getNewList(){
		List<BoardDto> list = new ArrayList<BoardDto>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from board where restep=0 order by "
				+ "regroup desc limit 0,4";
		conn = db.getGangsaConnection();
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				BoardDto dto = new BoardDto();
				dto.setNum(rs.getString("num"));
				dto.setWriter(rs.getString("writer"));
				dto.setSubject(rs.getString("subject"));
				dto.setContent(rs.getString("content"));
				dto.setRegroup(rs.getInt("regroup"));
				dto.setRelevel(rs.getInt("relevel"));
				dto.setRestep(rs.getInt("restep"));
				dto.setReadcount(rs.getInt("readcount"));
				dto.setWriteday(rs.getTimestamp("writeday"));
				
				list.add(dto);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.dbClose(conn, pstmt);
		}
		return list;
	}
}





























