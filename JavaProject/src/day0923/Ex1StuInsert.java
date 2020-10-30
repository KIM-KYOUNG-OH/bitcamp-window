package day0923;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import oracle.db.OracleConnect;

public class Ex1StuInsert {
	OracleConnect connect;
	public Ex1StuInsert() {
		// TODO Auto-generated constructor stub
		connect=OracleConnect.getInstance();
	}

	//����Ÿ �Է��ؼ� ���̺� stu �� �߰��ϴ� �޼���
	public void dataInsert()
	{
		Scanner sc=new Scanner(System.in);
		String name;
		int age;
		String sql;
		System.out.println("�̸��Է�");
		name=sc.nextLine();
		System.out.println("�����Է�");
		age=sc.nextInt();
		sql="insert into stu values (seq1.nextval,'"+name+"',"+age+")";
		System.out.println(sql);
		
		Connection conn=null;
		Statement stmt=null;
		
		//db ����
		conn=connect.getConnection();
		try {
			stmt=conn.createStatement();
			//����
			//execute :��ȯŸ�� boolean
			//executeUpdate ��ȯŸ�� int
			//stmt.execute(sql);
			int n=stmt.executeUpdate(sql);
			System.out.println("n="+n);//������ ���ڵ��� ����
			System.out.println("����Ÿ �߰� ����!!");
		} catch (SQLException e) {
			System.out.println("sql ����:"+e.getMessage());
		}finally {
			connect.dbClose(stmt, conn);
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ex1StuInsert ex=new Ex1StuInsert();
		ex.dataInsert();
	}

}







