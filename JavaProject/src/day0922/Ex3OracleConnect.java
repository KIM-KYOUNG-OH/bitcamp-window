package day0922;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//ORA-28040: 일치하는 인증 프로토콜 없음-이 오류나면 ojdbc 버전 변경
//ojdbc14.jar 오류나는 사람들은 ojdbc6.jar 로 변경해서 추가해주세요
public class Ex3OracleConnect {
	public Ex3OracleConnect() {
		// TODO Auto-generated constructor stub
		//오라클 드라이버 클래스 실행
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("오라클 드라이버 클래스 성공");
		} catch (ClassNotFoundException e) {
			System.out.println("오라클 드라이버가 없어요:"+e.getMessage());
		}
	}
	
	//sawon 테이블의 전체 갯수 가져오기
	public void countSawon()
	{
		//오라클 서버에 연결
		Connection conn=null;
		Statement stmt=null;
		ResultSet rs=null;
		
		String url="jdbc:oracle:thin:@localhost:1521:orcl";//express 버전 설치한 사람은 orcl아니고 xe
		try {
			conn=DriverManager.getConnection(url, "angel", "a1234");
			System.out.println("오라클 서버 연결 성공");
			//statement 생성
			stmt=conn.createStatement();
			//sql 문 실행
			//select 는 데이타를 얻어야 하므로 executeQuery 로 sql문을 실행한다
			rs=stmt.executeQuery("select count(*) cnt from sawon");
			//rs.next 는 다음 데이타로 이동을 하면서 true반환,없을경우 false 반환
			if(rs.next())
			{
				//데이타를 가져올때는 열인덱스번호로 가져오거나 컬럼명으로 가져온다
				int cnt=rs.getInt(1);//인덱스 1번열
				System.out.println("sawon 테이블 총 갯수:"+cnt);
				cnt=rs.getInt("cnt");//열이름으로 가져오기
				System.out.println("sawon 테이블 총 갯수:"+cnt);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.out.println("오라클 서버 연결 실패:"+e.getMessage());
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
		Ex3OracleConnect ex=new Ex3OracleConnect();//생성자 호출
		ex.countSawon();
	}

}











