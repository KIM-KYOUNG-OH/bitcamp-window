package money;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import oracle.db.DbConnect;

public class MoneyDao {
	DbConnect db = new DbConnect();
	
	// insert
	public void addData(MoneyDto dto) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "insert into daymoney values (seq_mini.nextval,?,?,?)";
		conn = db.getMyConnection();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getPummok());
			pstmt.setInt(2, dto.getPrice());
			pstmt.setString(3,dto.getDay());
			
			pstmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.dbClose(conn, pstmt);
		}
	}
	
	// select
	public List<MoneyDto> showDatas() {
		List<MoneyDto> list = new ArrayList<MoneyDto>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from daymoney order by num asc";
		conn = db.getMyConnection();
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				MoneyDto dto = new MoneyDto();
				dto.setNum(Integer.parseInt(rs.getString("num")));
				dto.setPummok(rs.getString("pummok"));
				dto.setPrice(Integer.parseInt(rs.getString("price")));
				dto.setDay(rs.getString("day"));
				
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
	
	public MoneyDto getData(int num) {
		MoneyDto dto = new MoneyDto();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from daymoney where num=?";
		conn = db.getMyConnection();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				dto.setNum(Integer.parseInt(rs.getString("num")));
				dto.setPummok(rs.getString("pummok"));
				dto.setPrice(Integer.parseInt(rs.getString("price")));
				dto.setDay(rs.getString("day"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.dbClose(conn, pstmt, rs);
		}
		return dto;
	}
	
	public void updateData(MoneyDto dto) {
		String sql = "update daymoney set pummok=?,price=?,day=? where num=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		conn = db.getMyConnection();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getPummok());
			pstmt.setInt(2, dto.getPrice());
			pstmt.setString(3,dto.getDay());
			pstmt.setInt(4, dto.getNum());
			
			pstmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.dbClose(conn, pstmt);
		}
	}
	
	// delete
	public void deleteData(int num) {
		String sql = "delete from daymoney where num=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		conn = db.getMyConnection();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			
			pstmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.dbClose(conn, pstmt);
		}
	}
}
