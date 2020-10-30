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
		System.out.println("�̸��Է�: ");
		name = sc.nextLine();
		System.out.println("������ �Է�:");
		blood = sc.nextLine();
		System.out.println("�ڹ� ���� �Է� : ");
		java = sc.nextInt();
		System.out.println("������ ���� �Է� : ");
		spring = sc.nextInt();
		System.out.println("Ű �Է� : ");
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
			System.out.println("������ �߰� ����!!");
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

























