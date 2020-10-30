package day0922;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.NumberFormat;
import java.util.Date;
import java.util.Scanner;

public class Ex7BuseoAnalysis {
	public Ex7BuseoAnalysis() {
		// TODO Auto-generated constructor stub
		//오라클 드라이버 클래스 실행
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");			
		} catch (ClassNotFoundException e) {
			System.out.println("오라클 드라이버가 없어요:"+e.getMessage());
		}
	}
	
	public void buseoAnalysis()
	{
		String sql="select buseo,count(buseo) count,to_char(avg(pay),'L9,999,999') avg "
				+ "from sawon group by buseo order by buseo asc";
		//필요한 변수들 선언
		Connection conn=null;
		Statement stmt=null;
		ResultSet rs=null;
		String url="jdbc:oracle:thin:@localhost:1521:orcl";
		
		try {
			conn=DriverManager.getConnection(url, "angel", "a1234");
			stmt=conn.createStatement();
			rs=stmt.executeQuery(sql);
			System.out.println("부서명\t인원수\t\t평균급여");
			System.out.println("-------------------------------------");
			while(rs.next())
			{
				String buseo=rs.getString("buseo");
				int count=rs.getInt("count");
				String avg=rs.getString("avg");
				System.out.println(buseo+"\t"+count+"명\t"+avg);
			}	
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
		Ex7BuseoAnalysis ex=new Ex7BuseoAnalysis();
		ex.buseoAnalysis();
	}

}








