package day0922;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.NumberFormat;
import java.util.Date;
import java.util.Scanner;

public class Ex6SawonNameSearch {
	public Ex6SawonNameSearch() {
		// TODO Auto-generated constructor stub
		//오라클 드라이버 클래스 실행
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");			
		} catch (ClassNotFoundException e) {
			System.out.println("오라클 드라이버가 없어요:"+e.getMessage());
		}
	}
	
	public void nameSelect()
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("검색할 이름을 입력하세요");
		String name=sc.nextLine();
		//일단 sql문을 완성해봅시다
		String sql="select name,pay,paytax,ipsaday from sawon where name like '%"+name+"%'";
		System.out.println(sql);
		
		//필요한 변수들 선언
		Connection conn=null;
		Statement stmt=null;
		ResultSet rs=null;
		int count=0;//총 인원수
		String url="jdbc:oracle:thin:@localhost:1521:orcl";
		
		try {
			conn=DriverManager.getConnection(url, "angel", "a1234");
			stmt=conn.createStatement();
			rs=stmt.executeQuery(sql);
			System.out.println(name+" 검색 결과");
			while(rs.next())
			{
				String name1=rs.getString("name");
				int pay=rs.getInt("pay");
				int paytax=rs.getInt("paytax");
				Date ipsaday=rs.getDate("ipsaday");
				//인원수 증가
				count++;
				
				//숫자 포멧 양식
				NumberFormat nf=NumberFormat.getCurrencyInstance();
				
				System.out.println(name1+"\t"+nf.format(pay)+"\t"+nf.format(paytax)+"\t"+ipsaday);
			}
			if(count==0)
				System.out.println("이름에 \""+name+"\" 를 포함한 사람은 없습니다");
			else
				System.out.println("총 "+count+"명");
			
		} catch (SQLException e) {
			System.out.println("오류:"+e.getMessage());
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
		Ex6SawonNameSearch ex=new Ex6SawonNameSearch();
		ex.nameSelect();
	}

}








