package day0922;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

public class Ex8SelectPerson {
	public Ex8SelectPerson() {
		// TODO Auto-generated constructor stub
		//����Ŭ ����̹� Ŭ���� ����
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");			
		} catch (ClassNotFoundException e) {
			System.out.println("����Ŭ ����̹��� �����:"+e.getMessage());
		}
	}

	public void writePerson()
	{
		Connection conn=null;
		Statement stmt=null;
		ResultSet rs=null;
		String url="jdbc:oracle:thin:@localhost:1521:orcl";
		String sql="select * from person2";
		System.out.println("��ȣ\t�̸�\t������\tŰ\t�������\t�ڹ�\t������\t����\t���");
		System.out.println("-------------------------------------------------------------------");
		
		try {
			conn=DriverManager.getConnection(url, "angel", "a1234");
			stmt=conn.createStatement();
			rs=stmt.executeQuery(sql);
			while(rs.next())
			{
				String num=rs.getString("num");
				String name=rs.getString("name");
				String blood=rs.getString("blood");
				int java=rs.getInt("java");
				int spring=rs.getInt("spring");
				double height=rs.getDouble("height");
				Date birthday=rs.getDate("birthday");
				int tot=java+spring;
				double avg=tot/2.0;
				System.out.println(num+"\t"+name+"\t"+blood.toUpperCase()+"��\t"+
						height+"\t"+birthday+"\t"+java+"\t"+spring+"\t"+tot+"\t"+avg);				
			}
			System.out.println();
			sql="select round(avg(java),1) avgjava,round(avg(spring),1) avgspring from person2";
			rs=stmt.executeQuery(sql);
			if(rs.next())
			{
				double avgjava=rs.getDouble("avgjava");
				double avgspring=rs.getDouble("avgspring");
				System.out.println("�ڹ������� ��ü ���:"+avgjava);
				System.out.println("������������ ��ü ���:"+avgspring);	
			}					
			
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
		Ex8SelectPerson ex=new Ex8SelectPerson();
		ex.writePerson();
	}

}












