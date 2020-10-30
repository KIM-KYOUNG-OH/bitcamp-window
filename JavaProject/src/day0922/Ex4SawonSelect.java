package day0922;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.NumberFormat;
import java.util.Date;

public class Ex4SawonSelect {
	public Ex4SawonSelect() {
		// TODO Auto-generated constructor stub
		//오라클 드라이버 클래스 실행
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//System.out.println("오라클 드라이버 클래스 성공");
		} catch (ClassNotFoundException e) {
			System.out.println("오라클 드라이버가 없어요:"+e.getMessage());
		}
	}
	
	//출력하는 메서드
	public void writeSawon()
	{
		Connection conn=null;
		Statement stmt=null;
		ResultSet rs=null;
		
		String url="jdbc:oracle:thin:@localhost:1521:orcl";//express 버전 설치한 사람은 orcl아니고 xe
		try {
			conn=DriverManager.getConnection(url, "angel", "a1234");
			stmt=conn.createStatement();
			rs=stmt.executeQuery("select * from sawon order by name asc");
			System.out.println("***열번호를 이용해서 데이타 가져오기***");
			while(rs.next())
			{
				String num=rs.getString(1);
				String name=rs.getString(2);
				String buseo=rs.getString(3);
				int pay=rs.getInt(4);
				int paytax=rs.getInt(5);
				Date ipsaday=rs.getDate(6);//java.util 패키지의 Date 입니다
				String jumin=rs.getString(7);
				
				//자바클래스를 이용해서 숫자앞에 화폐단위 붙이고 3자리마다 컴마찍기
				NumberFormat nf=NumberFormat.getCurrencyInstance();
				
				//System.out.println(num+"\t"+name+"\t"+buseo+"\t"+pay+"\t"+paytax+"\t"+ipsaday+"\t"+jumin);
				System.out.println(num+"\t"+name+"\t"+buseo+"\t"+nf.format(pay)+"\t"
				    +nf.format(paytax)+"\t"+ipsaday+"\t"+jumin);
			}
		} catch (SQLException e) {
			System.out.println("오류발생:"+e.getMessage());
		}finally {
			try {
				if(rs!=null) rs.close();
				if(stmt!=null) stmt.close();
				if(conn!=null) conn.close();
			}catch(SQLException e) {}
		}		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ex4SawonSelect ex=new Ex4SawonSelect();
		ex.writeSawon();
	}

}











