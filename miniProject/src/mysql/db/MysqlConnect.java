package mysql.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MysqlConnect {
	String driver = "com.mysql.jdbc.Driver";
	String gangsa_url="jdbc:mysql://192.168.0.4:3306/java0901";
	String my_url="jdbc:mysql://localhost:3306/java0901";
	String gangsa_id="bit301";
	String my_id="java";
	String gangsa_pass="1234";
	String my_pass="1234";
	
	public MysqlConnect() {
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			System.out.println("Mysql 드라이버 오류" + e.getMessage());
		}
	}
	
	//본인 pc의 mysql 연결
	public Connection getMyConnection() {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(my_url, my_id, my_pass);
		} catch (SQLException e) {
			System.out.println("내 컴의 mysql 연결 실패: " +e.getMessage());
		}
		return conn;
	}
	
	// 강사 pc의 mysql 연결
	public Connection getGangsaConnection() {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(gangsa_url, gangsa_id, gangsa_pass);
		} catch (SQLException e) {
			System.out.println("강사 컴의 mysql 연결 실패: " +e.getMessage());
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
			if(conn!=null)rs.close();
			if(pstmt!=null) pstmt.close();
			if(conn!=null) conn.close();
			} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
