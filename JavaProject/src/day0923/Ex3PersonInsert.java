package day0923;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import oracle.db.OracleConnect;

public class Ex3PersonInsert {
	OracleConnect connect;
	public Ex3PersonInsert() {
		// TODO Auto-generated constructor stub
		connect=OracleConnect.getInstance();
	}
	
	public void personInsert()
	{
		Scanner sc=new Scanner(System.in);
		String name,blood;
		int java,spring;
		double height;
		System.out.println("�̸��Է�");
		name=sc.nextLine();
		System.out.println("������ �Է�(�ҹ��ڷ�)");
		blood=sc.nextLine();
		System.out.println("�ڹ������Է�");
		java=sc.nextInt();
		System.out.println("�����������Է�");
		spring=sc.nextInt();
		System.out.println("Ű �Է�");
		height=sc.nextDouble();
		
		String sql="insert into person2 values (seq_person.nextval,?,?,?,?,?,?)";
		//? �� ���� �־��ִ°��� ���ε��̶��ϴµ� ?�� �տ����� 1��..
		Connection conn=null;
		PreparedStatement pstmt=null;
		
		conn=connect.getConnection();
		try {
			pstmt=conn.prepareStatement(sql);//sql ���� �̶� �˻�
			//? ������ŭ ���ε��� ����
			pstmt.setString(1, name);
			pstmt.setString(2, blood);
			pstmt.setInt(3, java);
			pstmt.setInt(4, spring);
			pstmt.setDouble(5, height);
			pstmt.setString(6, "2018-12-22");
			//����
			pstmt.execute();//**sql�� �ȵ���
			System.out.println("����Ÿ �߰� ����!!!");
		} catch (SQLException e) {
			System.out.println("sql�� ����:"+e.getMessage());
		}finally {
			connect.dbClose(pstmt, conn);
		}
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ex3PersonInsert ex=new Ex3PersonInsert();
		ex.personInsert();
	}

}







