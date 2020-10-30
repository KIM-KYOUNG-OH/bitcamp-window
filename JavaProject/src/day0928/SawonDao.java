package day0928;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import oracle.db.OracleConnect;

public class SawonDao {
	OracleConnect db=OracleConnect.getInstance();

	//��¿� �ʿ��� �޼���
	//����: col :������ �÷���,search:�˻��ܾ�
	//col ���� 'all','name','buseo' �� ���޵ǵ��� ������
	public List<SawonDto> getSearchList(String col,String search)
	{
		List<SawonDto> list=new ArrayList<SawonDto>();
		String sql="";
		if(col.equals("all"))
			sql="select * from sawon order by num asc";
		else if(col.equals("name"))
			sql="select * from sawon where name like '%"+search+"%' order by num asc";
		else
			sql="select * from sawon where buseo like '%"+search+"%' order by num asc";

		Connection conn=db.getConnection();
		Statement stmt=null;
		ResultSet rs=null;
		try {
			stmt=conn.createStatement();
			rs=stmt.executeQuery(sql);
			String []ddi= {"������","��","��","����","��","��","ȣ����","�䳢","��","��","��","��"};
			while(rs.next())
			{
				SawonDto dto=new SawonDto();
				dto.setNum(rs.getString("num"));
				dto.setName(rs.getString("name"));
				dto.setBuseo(rs.getString("buseo"));
				dto.setPay(rs.getInt("pay"));
				dto.setPaytax(rs.getInt("paytax"));				
				String jumin=rs.getString("juminno");
				dto.setJuminno(jumin);				
				String ipsaday=rs.getString("ipsaday").substring(0,10);//0~9���� ����
				dto.setIpsaday(ipsaday);

				//�¾ �⵵ ���ϱ�
				//�ֹι�ȣ�� �� ���ڸ� ����
				int y=Integer.parseInt(jumin.substring(0,2));//�� ���ڸ� ���ϱ�
				//System.out.println(y);
				char g=jumin.charAt(7);//�ֹι�ȣ ���ڸ��� ù����
				if(g=='1'||g=='2'||g=='5'||g=='6')
					y+=1900;
				else
					y+=2000;
				//System.out.println(y);
				//�챸�ϱ�
				dto.setDdi(ddi[y%12]);
				//�������ϱ�
				String gender="";
				if(g=='1' || g=='3' ||g=='5')
					gender="����";
				else
					gender="����";
				dto.setGender(gender);

				//list �� �߰�
				list.add(dto);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.dbClose(rs, stmt, conn);
		}

		return list;
	}

	//���ڰ� ������� ��ü ����Ÿ ��½�Ű�� ���� �޼���
	public List<SawonDto> getSearchList()
	{
		return getSearchList("all", "");
	}

	//INSERT
	public void sawonInsert(SawonDto dto)
	{
		String sql="insert into sawon values (seq_sawon.nextval,?,?,?,?,?,?)";
		Connection conn=null;
		PreparedStatement pstmt=null;
		conn=db.getConnection();
		try {
			pstmt=conn.prepareStatement(sql);
			//���ε�
			pstmt.setString(1, dto.getName());
			pstmt.setString(2, dto.getBuseo());
			pstmt.setInt(3, dto.getPay());
			pstmt.setInt(4, dto.getPaytax());
			pstmt.setString(5, dto.getIpsaday());
			pstmt.setString(6, dto.getJuminno());

			//����
			pstmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.dbClose(pstmt, conn);
		}

	}

	//update
	public void sawonUpdate(SawonDto dto)
	{
		String sql="update sawon set name=?,juminno=?,pay=?,paytax=?,ipsaday=?,buseo=? where num=?";
		Connection conn=null;
		PreparedStatement pstmt=null;
		conn=db.getConnection();
		try {
			pstmt=conn.prepareStatement(sql);
			//���ε�
			pstmt.setString(1, dto.getName());
			pstmt.setString(2, dto.getJuminno());
			pstmt.setInt(3, dto.getPay());
			pstmt.setInt(4, dto.getPaytax());
			pstmt.setString(5, dto.getIpsaday());
			pstmt.setString(6, dto.getBuseo());
			pstmt.setString(7, dto.getNum());

			//����
			pstmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.dbClose(pstmt, conn);
		}

	}

	//delete
	public void sawonDelete(String num)
	{
		String sql="delete from sawon where num=?";
		Connection conn=null;
		PreparedStatement pstmt=null;
		conn=db.getConnection();
		try {
			pstmt=conn.prepareStatement(sql);
			//���ε�
			pstmt.setString(1, num);
			
			//����
			pstmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.dbClose(pstmt, conn);
		}

	}
}





















