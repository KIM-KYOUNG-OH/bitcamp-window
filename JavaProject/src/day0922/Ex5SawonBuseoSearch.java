package day0922;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Ex5SawonBuseoSearch {
	public Ex5SawonBuseoSearch() {
		// TODO Auto-generated constructor stub
		//오라클 드라이버 클래스 실행
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");			
		} catch (ClassNotFoundException e) {
			System.out.println("오라클 드라이버가 없어요:"+e.getMessage());
		}
	}
	
	public void buseoSelect()
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("검색할 부서명을 입력하세요");
		String buseo=sc.nextLine();
		//일단 sql문을 완성해봅시다
		String sql="select name,to_char(pay,'L9,999,999') pay,to_char(paytax,'L9,999,999') paytax"
				+ " from sawon where buseo='"+buseo+"'";
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
			System.out.println(buseo+" 의 명단 출력");
			while(rs.next())
			{
				String name=rs.getString("name");
				String pay=rs.getString("pay");
				String paytax=rs.getString("paytax");
				
				//인원수 증가
				count++;
				System.out.println(name+"\t"+pay+"\t"+paytax);
			}
			if(count==0)
				System.out.println(buseo+" 부서에는 인원이 없습니다");
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
		Ex5SawonBuseoSearch ex=new Ex5SawonBuseoSearch();
		ex.buseoSelect();
	}

}








