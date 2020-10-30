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
		System.out.println("�̸��Է�: ");
		name = sc.nextLine();
		System.out.println("������ �Է�: (�ҹ���)");
		blood = sc.nextLine();
		System.out.println("�ڹ� ���� �Է� : ");
		java = sc.nextInt();
		System.out.println("������ ���� �Է� : ");
		spring = sc.nextInt();
		System.out.println("Ű �Է� : ");
		height = sc.nextDouble();
		
		String sql = "insert into person2 values (seq_person.nextval,?,?,?,?,?,sysdate)";
		Connection conn = null;
		PreparedStatement pstmt = null;
		conn = connect.getConnection();
		try {
			pstmt = conn.prepareStatement(sql);
			// ���ε�
			pstmt.setString(1, name);
			pstmt.setString(2, blood);
			pstmt.setInt(3, java);
			pstmt.setInt(4, spring);
			pstmt.setDouble(5, height);
			pstmt.execute();
			System.out.println(sql);
		} catch (SQLException e) {
			System.out.println("sql�� ����:"+e.getMessage());
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
