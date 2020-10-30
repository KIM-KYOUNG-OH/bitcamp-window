package test;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import oracle.db.OracleConnect;

public class Ex2PersonInsert {
	OracleConnect connect;

	public Ex2PersonInsert() {
		connect = OracleConnect.getInstance();
	}
	
	public void personInsert() {
		Scanner sc = new Scanner(System.in);
		String name, blood;
		int java, spring;
		double height;
		System.out.println("이름입력: ");
		name = sc.nextLine();
		System.out.println("혈액형 입력:");
		blood = sc.nextLine();
		System.out.println("자바 점수 입력 : ");
		java = sc.nextInt();
		System.out.println("스프링 점수 입력 : ");
		spring = sc.nextInt();
		System.out.println("키 입력 : ");
		height = sc.nextDouble();
		
		String sql = "insert into person2 values(seq_person.nextval, '"+name+"','"
				+blood+"',"+java+","+spring+","+height+",sysdate)";
		System.out.println(sql);
		Connection conn = null;
		Statement stmt = null;
		conn = connect.getConnection();
		try {
			stmt = conn.createStatement();
			stmt.execute(sql);
			System.out.println("데이터 추가 성공!!");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connect.dbClose(stmt, conn);
		}
		
	}
	
	public static void main(String[] args) {
		Ex2PersonInsert ex = new Ex2PersonInsert();
		ex.personInsert();
	}
}

























