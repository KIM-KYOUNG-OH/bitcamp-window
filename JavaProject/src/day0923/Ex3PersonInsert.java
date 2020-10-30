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
		
		String sql="insert into person2 values (seq_person.nextval,?,?,?,?,?,?)";
		//? 에 값을 넣어주는것을 바인딩이라하는데 ?는 앞에부터 1번..
		Connection conn=null;
		PreparedStatement pstmt=null;
		
		conn=connect.getConnection();
		try {
			pstmt=conn.prepareStatement(sql);//sql 문을 이때 검사
			//? 갯수만큼 바인딩후 실행
			pstmt.setString(1, name);
			pstmt.setString(2, blood);
			pstmt.setInt(3, java);
			pstmt.setInt(4, spring);
			pstmt.setDouble(5, height);
			pstmt.setString(6, "2018-12-22");
			//실행
			pstmt.execute();//**sql이 안들어간다
			System.out.println("데이타 추가 성공!!!");
		} catch (SQLException e) {
			System.out.println("sql문 오류:"+e.getMessage());
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







