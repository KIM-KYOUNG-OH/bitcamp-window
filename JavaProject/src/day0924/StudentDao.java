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
		//db연결
		conn=db.getConnection();
		try {
			pstmt=conn.prepareStatement(sql);
			//바인딩 5개
			pstmt.setString(1, dto.getName());
			pstmt.setString(2, dto.getPhoto());
			pstmt.setString(3, dto.getHp());
			pstmt.setString(4, dto.getAddr());
			pstmt.setInt(5, dto.getBirthyear());

			//실행
			pstmt.execute();
		} catch (SQLException e) {
			System.out.println("insert 오류:"+e.getMessage());
		}finally {
			db.dbClose(pstmt, conn);
		}
	}

	//전체 데이타를 보내는 메서드
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

				//list 에 추가
				list.add(dto);
			}
		} catch (SQLException e) {
			System.out.println("select 오류:"+e.getMessage());
		}finally {
			db.dbClose(rs, stmt, conn);
		}
		return list;
	}

	//이름을 인자로 받아서 삭제하는 메서드
	public void studentDelete(String name)
	{
		Connection conn=null;
		PreparedStatement pstmt=null;
		String sql="delete from student where name=?";

		conn=db.getConnection();
		try {
			pstmt=conn.prepareStatement(sql);
			//바인딩
			pstmt.setString(1, name);
			//실행
			pstmt.execute();
		} catch (SQLException e) {
			System.out.println("delete 오류:"+e.getMessage());
		}finally {
			db.dbClose(pstmt, conn);
		}
	}

	//수정 메서드
	public void studentUpdate(StudentDto dto)
	{
		//조건은 num
		//날짜 빼고 모두 수정
		Connection conn=null;
		PreparedStatement pstmt=null;
		String sql="update student set name=?,hp=?,addr=?,photo=?,birthyear=? where num=?";

		conn=db.getConnection();
		try {
			pstmt=conn.prepareStatement(sql);
			//바인딩
			pstmt.setString(1, dto.getName());
			pstmt.setString(2, dto.getHp());
			pstmt.setString(3, dto.getAddr());
			pstmt.setString(4, dto.getPhoto());
			pstmt.setInt(5, dto.getBirthyear());
			pstmt.setString(6, dto.getNum());			
			
			//실행
			pstmt.execute();
		} catch (SQLException e) {
			System.out.println("delete 오류:"+e.getMessage());
			e.printStackTrace();
		}finally {
			db.dbClose(pstmt, conn);
		}
	}
}






















