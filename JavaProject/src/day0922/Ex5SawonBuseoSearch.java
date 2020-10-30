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
		//����Ŭ ����̹� Ŭ���� ����
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");			
		} catch (ClassNotFoundException e) {
			System.out.println("����Ŭ ����̹��� �����:"+e.getMessage());
		}
	}
	
	public void buseoSelect()
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("�˻��� �μ����� �Է��ϼ���");
		String buseo=sc.nextLine();
		//�ϴ� sql���� �ϼ��غ��ô�
		String sql="select name,to_char(pay,'L9,999,999') pay,to_char(paytax,'L9,999,999') paytax"
				+ " from sawon where buseo='"+buseo+"'";
		System.out.println(sql);
		
		//�ʿ��� ������ ����
		Connection conn=null;
		Statement stmt=null;
		ResultSet rs=null;
		int count=0;//�� �ο���
		String url="jdbc:oracle:thin:@localhost:1521:orcl";
		
		try {
			conn=DriverManager.getConnection(url, "angel", "a1234");
			stmt=conn.createStatement();
			rs=stmt.executeQuery(sql);
			System.out.println(buseo+" �� ��� ���");
			while(rs.next())
			{
				String name=rs.getString("name");
				String pay=rs.getString("pay");
				String paytax=rs.getString("paytax");
				
				//�ο��� ����
				count++;
				System.out.println(name+"\t"+pay+"\t"+paytax);
			}
			if(count==0)
				System.out.println(buseo+" �μ����� �ο��� �����ϴ�");
			else
				System.out.println("�� "+count+"��");
			
		} catch (SQLException e) {
			System.out.println("����:"+e.getMessage());
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








