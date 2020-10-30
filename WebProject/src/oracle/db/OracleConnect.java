package oracle.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class OracleConnect {
	//�ٸ� Ŭ���������� new �� �����Ҽ� ����
	private OracleConnect()
	{
		//����Ŭ ����̹� Ŭ���� ����
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");			
		} catch (ClassNotFoundException e) {
			System.out.println("����Ŭ ����̹��� �����:"+e.getMessage());
		}
	}
	
	public static OracleConnect getInstance()
	{
		return new OracleConnect();
	}
	
	//db �����ؼ� ������ ���ؼ� ��ȯ�ϴ� �޼���
	public Connection getConnection()
	{
		Connection conn=null;
		String url="jdbc:oracle:thin:@localhost:1521:orcl";
		try {
			conn=DriverManager.getConnection(url, "angel", "a1234");
		} catch (SQLException e) {
			System.out.println("����Ŭ ���� ���� ����:"+e.getMessage());
		}
		
		return conn;
	}
	
	//�� 4���� dbClose �� ����
	public void dbClose(ResultSet rs,Statement stmt,Connection conn)
	{
		try {
			if(rs!=null) rs.close();
			if(stmt!=null) stmt.close();
			if(conn!=null) conn.close();
		}catch(SQLException e) {}
	}
	
	public void dbClose(Statement stmt,Connection conn)
	{
		try {			
			if(stmt!=null) stmt.close();
			if(conn!=null) conn.close();
		}catch(SQLException e) {}
	}
	
	public void dbClose(ResultSet rs,PreparedStatement pstmt,Connection conn)
	{
		try {
			if(rs!=null) rs.close();
			if(pstmt!=null) pstmt.close();
			if(conn!=null) conn.close();
		}catch(SQLException e) {}
	}
	
	public void dbClose(PreparedStatement pstmt,Connection conn)
	{
		try {
			if(pstmt!=null) pstmt.close();
			if(conn!=null) conn.close();
		}catch(SQLException e) {}
	}
}

















