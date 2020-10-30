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
		//����Ŭ ����̹� Ŭ���� ����
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");			
		} catch (ClassNotFoundException e) {
			System.out.println("����Ŭ ����̹��� �����:"+e.getMessage());
		}
	}
	
	public void nameSelect()
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("�˻��� �̸��� �Է��ϼ���");
		String name=sc.nextLine();
		//�ϴ� sql���� �ϼ��غ��ô�
		String sql="select name,pay,paytax,ipsaday from sawon where name like '%"+name+"%'";
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
			System.out.println(name+" �˻� ���");
			while(rs.next())
			{
				String name1=rs.getString("name");
				int pay=rs.getInt("pay");
				int paytax=rs.getInt("paytax");
				Date ipsaday=rs.getDate("ipsaday");
				//�ο��� ����
				count++;
				
				//���� ���� ���
				NumberFormat nf=NumberFormat.getCurrencyInstance();
				
				System.out.println(name1+"\t"+nf.format(pay)+"\t"+nf.format(paytax)+"\t"+ipsaday);
			}
			if(count==0)
				System.out.println("�̸��� \""+name+"\" �� ������ ����� �����ϴ�");
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
		Ex6SawonNameSearch ex=new Ex6SawonNameSearch();
		ex.nameSelect();
	}

}








