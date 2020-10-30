package test;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import oracle.db.OracleConnect;

public class Ex1StuInsert {

	OracleConnect connect;
	
	public Ex1StuInsert() {
		connect = OracleConnect.getInstance();
	}
	
	// 데이터 입력해서 테이블 stu에 추가하는 메서드
	public void dataInsert() {
		Scanner sc = new Scanner(System.in);
		String name;
		int age;
		String sql;
		System.out.println("이름입력");
		name = sc.nextLine();
		System.out.println("나이입력");
		age=sc.nextInt();
		sql = "insert into stu values (seq1.nextval,'"+name+"',"+age+")";
		System.out.println(sql);
		
		Connection conn = null;
		Statement stmt = null;
		
		conn = connect.getConnection();
		try {
			stmt = conn.createStatement();
			int n = stmt.executeUpdate(sql);
			System.out.println("n="+n);
			System.out.println("데이터 추가 성공!!");
		} catch (SQLException e) {
			System.out.println("sql 오류 :" + e.getMessage());
		} finally {
			connect.dbClose(stmt, conn);
		}
	}
	public static void main(String[] args) {
		Ex1StuInsert ex = new Ex1StuInsert();
		ex.dataInsert();
	}
}































