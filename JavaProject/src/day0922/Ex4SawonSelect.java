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
		//����Ŭ ����̹� Ŭ���� ����
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//System.out.println("����Ŭ ����̹� Ŭ���� ����");
		} catch (ClassNotFoundException e) {
			System.out.println("����Ŭ ����̹��� �����:"+e.getMessage());
		}
	}
	
	//����ϴ� �޼���
	public void writeSawon()
	{
		Connection conn=null;
		Statement stmt=null;
		ResultSet rs=null;
		
		String url="jdbc:oracle:thin:@localhost:1521:orcl";//express ���� ��ġ�� ����� orcl�ƴϰ� xe
		try {
			conn=DriverManager.getConnection(url, "angel", "a1234");
			stmt=conn.createStatement();
			rs=stmt.executeQuery("select * from sawon order by name asc");
			System.out.println("***����ȣ�� �̿��ؼ� ����Ÿ ��������***");
			while(rs.next())
			{
				String num=rs.getString(1);
				String name=rs.getString(2);
				String buseo=rs.getString(3);
				int pay=rs.getInt(4);
				int paytax=rs.getInt(5);
				Date ipsaday=rs.getDate(6);//java.util ��Ű���� Date �Դϴ�
				String jumin=rs.getString(7);
				
				//�ڹ�Ŭ������ �̿��ؼ� ���ھտ� ȭ����� ���̰� 3�ڸ����� �ĸ����
				NumberFormat nf=NumberFormat.getCurrencyInstance();
				
				//System.out.println(num+"\t"+name+"\t"+buseo+"\t"+pay+"\t"+paytax+"\t"+ipsaday+"\t"+jumin);
				System.out.println(num+"\t"+name+"\t"+buseo+"\t"+nf.format(pay)+"\t"
				    +nf.format(paytax)+"\t"+ipsaday+"\t"+jumin);
			}
		} catch (SQLException e) {
			System.out.println("�����߻�:"+e.getMessage());
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











