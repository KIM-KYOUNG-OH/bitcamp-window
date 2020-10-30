package day0922;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//ORA-28040: ��ġ�ϴ� ���� �������� ����-�� �������� ojdbc ���� ����
//ojdbc14.jar �������� ������� ojdbc6.jar �� �����ؼ� �߰����ּ���
public class Ex3OracleConnect {
	public Ex3OracleConnect() {
		// TODO Auto-generated constructor stub
		//����Ŭ ����̹� Ŭ���� ����
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("����Ŭ ����̹� Ŭ���� ����");
		} catch (ClassNotFoundException e) {
			System.out.println("����Ŭ ����̹��� �����:"+e.getMessage());
		}
	}
	
	//sawon ���̺��� ��ü ���� ��������
	public void countSawon()
	{
		//����Ŭ ������ ����
		Connection conn=null;
		Statement stmt=null;
		ResultSet rs=null;
		
		String url="jdbc:oracle:thin:@localhost:1521:orcl";//express ���� ��ġ�� ����� orcl�ƴϰ� xe
		try {
			conn=DriverManager.getConnection(url, "angel", "a1234");
			System.out.println("����Ŭ ���� ���� ����");
			//statement ����
			stmt=conn.createStatement();
			//sql �� ����
			//select �� ����Ÿ�� ���� �ϹǷ� executeQuery �� sql���� �����Ѵ�
			rs=stmt.executeQuery("select count(*) cnt from sawon");
			//rs.next �� ���� ����Ÿ�� �̵��� �ϸ鼭 true��ȯ,������� false ��ȯ
			if(rs.next())
			{
				//����Ÿ�� �����ö��� ���ε�����ȣ�� �������ų� �÷������� �����´�
				int cnt=rs.getInt(1);//�ε��� 1����
				System.out.println("sawon ���̺� �� ����:"+cnt);
				cnt=rs.getInt("cnt");//���̸����� ��������
				System.out.println("sawon ���̺� �� ����:"+cnt);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.out.println("����Ŭ ���� ���� ����:"+e.getMessage());
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
		Ex3OracleConnect ex=new Ex3OracleConnect();//������ ȣ��
		ex.countSawon();
	}

}











