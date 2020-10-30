package day0923;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import oracle.db.OracleConnect;

public class Ex2PersonInsert {
	OracleConnect connect;
	public Ex2PersonInsert() {
		// TODO Auto-generated constructor stub
		connect=OracleConnect.getInstance();
	}
	
	public void personInsert()
	{
		Scanner sc=new Scanner(System.in);
		String name,blood;
		int java,spring;
		double height;
		System.out.println("이름입력");
		name=sc.nextLine();
		System.out.println("혈액형 입력(소문자로)");
		blood=sc.nextLine();
		System.out.println("자바점수입력");
		java=sc.nextInt();
		System.out.println("스프링점수입력");
		spring=sc.nextInt();
		System.out.println("키 입력");
		height=sc.nextDouble();
		
		String sql="insert into person2 values (seq_person.nextval,'"+name+"','"+blood+"',"+java+","
				+spring+","+height+",sysdate)";
		System.out.println(sql);
		
		Connection conn=null;
		Statement stmt=null;
		conn=connect.getConnection();
		try {
			stmt=conn.createStatement();
			//sql문 실행
			stmt.execute(sql);
			System.out.println("데이타 추가 성공!!");
		} catch (SQLException e) {
			System.out.println("sql 오류:"+e.getMessage());
		}finally {
			connect.dbClose(stmt, conn);
		}
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ex2PersonInsert ex=new Ex2PersonInsert();
		ex.personInsert();
	}

}







