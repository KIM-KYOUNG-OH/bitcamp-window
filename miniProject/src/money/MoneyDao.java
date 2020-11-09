package money;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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
}
