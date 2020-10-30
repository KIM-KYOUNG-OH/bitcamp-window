package day0923;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import oracle.db.OracleConnect;

public class PersonDao {
	OracleConnect db;
	public PersonDao() {
		// TODO Auto-generated constructor stub
		db=OracleConnect.getInstance();
	}
	
	//��ü ����Ÿ �����ϴ� �޼���
	public List<PersonDto> getAllPersons()
	{
		List<PersonDto> list=new ArrayList<PersonDto>();
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String sql="select * from person2 order by num asc";
		//db ����
		conn=db.getConnection();
		try {
			pstmt=conn.prepareStatement(sql);
			//����
			rs=pstmt.executeQuery();
			while(rs.next())
			{
				//�̶� dto ������ �ݵ�� while�� �ȿ��� �ؾ��Ѵ�
				PersonDto dto=new PersonDto();
				//db���� ����Ÿ ��������
				int num=rs.getInt("num");
				int java=rs.getInt("java");
				int spring=rs.getInt("spring");
				String name=rs.getString("name");
				String blood=rs.getString("blood");
				double height=rs.getDouble("height");
				Date birthday=rs.getDate("birthday");
				
				//dto �� �ֱ�
				dto.setNum(num);
				dto.setName(name);
				dto.setBirthday(birthday);
				dto.setJava(java);
				dto.setSpring(spring);
				dto.setBlood(blood);
				dto.setHeight(height);
				
				//list �� dto�߰�				
				list.add(dto);
			}
		} catch (SQLException e) {
			System.out.println("select ����:"+e.getMessage());
		}finally {
			db.dbClose(rs, pstmt, conn);
		}
		
		return list;
	}
	
	//����Ÿ�� dto �� �޾� db�� insert �ϴ� �޼���
	public void personInsert(PersonDto dto)
	{
		Connection conn=null;
		PreparedStatement pstmt=null;
		String sql="insert into person2 values (seq_person.nextval,?,?,?,?,?,?)";
		System.out.println(dto.getBirthday().toString());
		conn=db.getConnection();
		try {
			pstmt=conn.prepareStatement(sql);
			//���ε�
			pstmt.setString(1, dto.getName());
			pstmt.setString(2, dto.getBlood());
			pstmt.setInt(3, dto.getJava());
			pstmt.setInt(4, dto.getSpring());
			pstmt.setDouble(5, dto.getHeight());
			
			//util.Date �� String ���� ��ȯ
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
			pstmt.setString(6,sdf.format(dto.getBirthday()) );
			
			//����
			pstmt.execute();
		} catch (SQLException e) {
			System.out.println("sql insert ����:"+e.getMessage());
		}finally {
			db.dbClose(pstmt, conn);
		}
	}
	
	//�̸��� �Ķ���ͷ� �ް� ������ ���ڵ��� ������ ��ȯ
	public int personDelete(String name)
	{
		int n=0;
		Connection conn=null;
		PreparedStatement pstmt=null;
		String sql="delete from person2 where name=?";
		//db����
		conn=db.getConnection();
		try {
			pstmt=conn.prepareStatement(sql);
			//���ε�
			pstmt.setString(1, name);
			//����
			n=pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("sql delete ����:"+e.getMessage());
		}finally {
			db.dbClose(pstmt, conn);
		}
		return n;
	}
	
	//������ ������ ���ڵ� ���� ��ȯ
	public int personUpdate(PersonDto dto)
	{
		int n=0;
		Connection conn=null;
		PreparedStatement pstmt=null;
		String sql="update person2 set name=?,blood=?,java=?,spring=? where num=?";
		conn=db.getConnection();
		try {
			pstmt=conn.prepareStatement(sql);
			//���ε�
			pstmt.setString(1, dto.getName());
			pstmt.setString(2, dto.getBlood());
			pstmt.setInt(3, dto.getJava());
			pstmt.setInt(4, dto.getSpring());
			pstmt.setInt(5, dto.getNum());
			//����
			n=pstmt.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println("sql update ����:"+e.getMessage());
		}finally {
			db.dbClose(pstmt, conn);
		}
		
		return n;
	}
	
	//������ �˻�
	public List<PersonDto> getBloodSearch(String blood)
	{
		List<PersonDto> list=new ArrayList<PersonDto>();
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String sql="select * from person2 where blood=? order by name asc";
		
		//db ����
		conn=db.getConnection();
		try {
			pstmt=conn.prepareStatement(sql);
			//���ε�
			pstmt.setString(1, blood.toLowerCase());
			//����
			rs=pstmt.executeQuery();
			while(rs.next())
			{
				PersonDto dto=new PersonDto();
				dto.setName(rs.getString("name"));
				dto.setJava(rs.getInt("java"));
				dto.setSpring(rs.getInt("spring"));
				dto.setHeight(rs.getDouble("height"));
				dto.setBirthday(rs.getDate("birthday"));
				//�߰�
				dto.setNum(rs.getInt("num"));
				dto.setBlood(rs.getString("blood"));
				//list �� �߰�
				list.add(dto);
			}
			
		} catch (SQLException e) {
			System.out.println("sql search ����:"+e.getMessage());
		}finally {
			db.dbClose(rs, pstmt, conn);
		}
		return list;
	}
}























