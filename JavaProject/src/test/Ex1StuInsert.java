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
	
	// ������ �Է��ؼ� ���̺� stu�� �߰��ϴ� �޼���
	public void dataInsert() {
		Scanner sc = new Scanner(System.in);
		String name;
		int age;
		String sql;
		System.out.println("�̸��Է�");
		name = sc.nextLine();
		System.out.println("�����Է�");
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
			System.out.println("������ �߰� ����!!");
		} catch (SQLException e) {
			System.out.println("sql ���� :" + e.getMessage());
		} finally {
			connect.dbClose(stmt, conn);
		}
	}
	public static void main(String[] args) {
		Ex1StuInsert ex = new Ex1StuInsert();
		ex.dataInsert();
	}
}































