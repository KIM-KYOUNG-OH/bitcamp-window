package test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import oracle.db.OracleConnect;

public class Ex3PersonInsert {

	OracleConnect connect;
	
	public Ex3PersonInsert() {
		connect = OracleConnect.getInstance();
	}
	
	public void personInsert() {
		Scanner sc = new Scanner(System.in);
		String name, blood;
		int java, spring;
		double height;
		System.out.println("이름입력: ");
		name = sc.nextLine();
		System.out.println("혈액형 입력: (소문자)");
		blood = sc.nextLine();
		System.out.println("자바 점수 입력 : ");
		java = sc.nextInt();
		System.out.println("스프링 점수 입력 : ");
		spring = sc.nextInt();
		System.out.println("키 입력 : ");
		height = sc.nextDouble();
		
		String sql = "insert into person2 values (seq_person.nextval,?,?,?,?,?,sysdate)";
		Connection conn = null;
		PreparedStatement pstmt = null;
		conn = connect.getConnection();
		try {
			pstmt = conn.prepareStatement(sql);
			// 바인딩
			pstmt.setString(1, name);
			pstmt.setString(2, blood);
			pstmt.setInt(3, java);
			pstmt.setInt(4, spring);
			pstmt.setDouble(5, height);
			pstmt.execute();
			System.out.println(sql);
		} catch (SQLException e) {
			System.out.println("sql문 오류:"+e.getMessage());
			e.printStackTrace();
		} finally {
			connect.dbClose(pstmt, conn);
		}
		
	}
	
	
	public static void main(String[] args) {
		Ex3PersonInsert ex = new Ex3PersonInsert();
		ex.personInsert();
	}
}
