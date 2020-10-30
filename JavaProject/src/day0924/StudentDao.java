package day0924;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import oracle.db.OracleConnect;

public class StudentDao {
	OracleConnect db=OracleConnect.getInstance();

	//insert
	public void studentInsert(StudentDto dto)
	{
		Connection conn=null;
		PreparedStatement pstmt=null;
		String sql="insert into student values (seq_stu.nextval,?,?,?,?,?,sysdate)";
		//db����
		conn=db.getConnection();
		try {
			pstmt=conn.prepareStatement(sql);
			//���ε� 5��
			pstmt.setString(1, dto.getName());
			pstmt.setString(2, dto.getPhoto());
			pstmt.setString(3, dto.getHp());
			pstmt.setString(4, dto.getAddr());
			pstmt.setInt(5, dto.getBirthyear());

			//����
			pstmt.execute();
		} catch (SQLException e) {
			System.out.println("insert ����:"+e.getMessage());
		}finally {
			db.dbClose(pstmt, conn);
		}
	}

	//��ü ����Ÿ�� ������ �޼���
	public List<StudentDto> getAllDatas()
	{
		List<StudentDto> list=new ArrayList<StudentDto>();
		Connection conn=null;
		Statement stmt=null;
		ResultSet rs=null;
		String sql="select * from student order by name asc";

		conn=db.getConnection();
		try {
			stmt=conn.createStatement();
			rs=stmt.executeQuery(sql);
			while(rs.next())
			{
				StudentDto dto=new StudentDto();
				dto.setNum(rs.getString("num"));
				dto.setName(rs.getString("name"));
				dto.setAddr(rs.getString("addr"));
				dto.setHp(rs.getString("hp"));
				dto.setPhoto(rs.getString("photo"));
				dto.setBirthyear(rs.getInt("birthyear"));
				dto.setWriteday(rs.getTimestamp("writeday"));

				//list �� �߰�
				list.add(dto);
			}
		} catch (SQLException e) {
			System.out.println("select ����:"+e.getMessage());
		}finally {
			db.dbClose(rs, stmt, conn);
		}
		return list;
	}

	//�̸��� ���ڷ� �޾Ƽ� �����ϴ� �޼���
	public void studentDelete(String name)
	{
		Connection conn=null;
		PreparedStatement pstmt=null;
		String sql="delete from student where name=?";

		conn=db.getConnection();
		try {
			pstmt=conn.prepareStatement(sql);
			//���ε�
			pstmt.setString(1, name);
			//����
			pstmt.execute();
		} catch (SQLException e) {
			System.out.println("delete ����:"+e.getMessage());
		}finally {
			db.dbClose(pstmt, conn);
		}
	}

	//���� �޼���
	public void studentUpdate(StudentDto dto)
	{
		//������ num
		//��¥ ���� ��� ����
		Connection conn=null;
		PreparedStatement pstmt=null;
		String sql="update student set name=?,hp=?,addr=?,photo=?,birthyear=? where num=?";

		conn=db.getConnection();
		try {
			pstmt=conn.prepareStatement(sql);
			//���ε�
			pstmt.setString(1, dto.getName());
			pstmt.setString(2, dto.getHp());
			pstmt.setString(3, dto.getAddr());
			pstmt.setString(4, dto.getPhoto());
			pstmt.setInt(5, dto.getBirthyear());
			pstmt.setString(6, dto.getNum());			
			
			//����
			pstmt.execute();
		} catch (SQLException e) {
			System.out.println("delete ����:"+e.getMessage());
			e.printStackTrace();
		}finally {
			db.dbClose(pstmt, conn);
		}
	}
}






















