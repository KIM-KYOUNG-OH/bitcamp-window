package oracle.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DbConnect {
	String driver="oracle.jdbc.OracleDriver";
	String gangsa_url="jdbc:oracle:thin:@192.168.0.10:1521:xe";
	String my_url="jdbc:oracle:thin:@localhost:1521:orcl";
	String gangsa_id="angel";
	String my_id="angel";
	String gangsa_pass="a1234";
	String my_pass="a1234";

	public DbConnect() {
		try {
			// 1. JDBC 드라이버 로딩
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			System.out.println("오라클 드라이버 실패:" + e.getMessage());
		}
	}

	// 강사pc 오라클 연결
	public Connection getGangsaConnection() {
		Connection conn = null;
		try {
			// 2. 데이터베이스 커넥션 생성
			conn = DriverManager.getConnection(gangsa_url, gangsa_id, gangsa_pass);
		} catch (SQLException e) {
			System.out.println("강사 pc 오라클 연결 실패:" +e.getMessage());
		}
		return conn;
	}

	// 내pc 오라클 연결
	public Connection getMyConnection() {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(my_url, my_id, my_pass);
		} catch (SQLException e) {
			System.out.println("내 pc 오라클 연결 실패:" +e.getMessage());
		}
		return conn;
	}
	
	public void dbClose(Connection conn, Statement stmt) {
		try {
			if(stmt!=null) stmt.close();
			if(conn!=null) conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void dbClose(Connection conn, PreparedStatement pstmt) {
		try {
			if(pstmt!=null) pstmt.close();
			if(conn!=null) conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void dbClose(Connection conn, Statement stmt, ResultSet rs) {
		try {
			if(rs!=null)rs.close();
			if(stmt!=null) stmt.close();
			if(conn!=null) conn.close();
			} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void dbClose(Connection conn, PreparedStatement pstmt, ResultSet rs) {
		try {
			if(rs!=null)rs.close();
			if(pstmt!=null) pstmt.close();
			if(conn!=null) conn.close();
			} catch (Exception e) {
			e.printStackTrace();
		}
	}
}


























