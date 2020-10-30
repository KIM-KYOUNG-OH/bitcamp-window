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
	
	//전체 데이타 리턴하는 메서드
	public List<PersonDto> getAllPersons()
	{
		List<PersonDto> list=new ArrayList<PersonDto>();
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String sql="select * from person2 order by num asc";
		//db 연결
		conn=db.getConnection();
		try {
			pstmt=conn.prepareStatement(sql);
			//실행
			rs=pstmt.executeQuery();
			while(rs.next())
			{
				//이때 dto 선언은 반드시 while문 안에서 해야한다
				PersonDto dto=new PersonDto();
				//db에서 데이타 가져오기
				int num=rs.getInt("num");
				int java=rs.getInt("java");
				int spring=rs.getInt("spring");
				String name=rs.getString("name");
				String blood=rs.getString("blood");
				double height=rs.getDouble("height");
				Date birthday=rs.getDate("birthday");
				
				//dto 에 넣기
				dto.setNum(num);
				dto.setName(name);
				dto.setBirthday(birthday);
				dto.setJava(java);
				dto.setSpring(spring);
				dto.setBlood(blood);
				dto.setHeight(height);
				
				//list 에 dto추가				
				list.add(dto);
			}
		} catch (SQLException e) {
			System.out.println("select 오류:"+e.getMessage());
		}finally {
			db.dbClose(rs, pstmt, conn);
		}
		
		return list;
	}
	
	//데이타를 dto 로 받아 db에 insert 하는 메서드
	public void personInsert(PersonDto dto)
	{
		Connection conn=null;
		PreparedStatement pstmt=null;
		String sql="insert into person2 values (seq_person.nextval,?,?,?,?,?,?)";
		System.out.println(dto.getBirthday().toString());
		conn=db.getConnection();
		try {
			pstmt=conn.prepareStatement(sql);
			//바인딩
			pstmt.setString(1, dto.getName());
			pstmt.setString(2, dto.getBlood());
			pstmt.setInt(3, dto.getJava());
			pstmt.setInt(4, dto.getSpring());
			pstmt.setDouble(5, dto.getHeight());
			
			//util.Date 를 String 으로 변환
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
			pstmt.setString(6,sdf.format(dto.getBirthday()) );
			
			//실행
			pstmt.execute();
		} catch (SQLException e) {
			System.out.println("sql insert 오류:"+e.getMessage());
		}finally {
			db.dbClose(pstmt, conn);
		}
	}
	
	//이름을 파라미터로 받고 성공한 레코드의 갯수를 반환
	public int personDelete(String name)
	{
		int n=0;
		Connection conn=null;
		PreparedStatement pstmt=null;
		String sql="delete from person2 where name=?";
		//db연결
		conn=db.getConnection();
		try {
			pstmt=conn.prepareStatement(sql);
			//바인딩
			pstmt.setString(1, name);
			//실행
			n=pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("sql delete 오류:"+e.getMessage());
		}finally {
			db.dbClose(pstmt, conn);
		}
		return n;
	}
	
	//수정후 성공한 레코드 갯수 반환
	public int personUpdate(PersonDto dto)
	{
		int n=0;
		Connection conn=null;
		PreparedStatement pstmt=null;
		String sql="update person2 set name=?,blood=?,java=?,spring=? where num=?";
		conn=db.getConnection();
		try {
			pstmt=conn.prepareStatement(sql);
			//바인딩
			pstmt.setString(1, dto.getName());
			pstmt.setString(2, dto.getBlood());
			pstmt.setInt(3, dto.getJava());
			pstmt.setInt(4, dto.getSpring());
			pstmt.setInt(5, dto.getNum());
			//실행
			n=pstmt.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println("sql update 오류:"+e.getMessage());
		}finally {
			db.dbClose(pstmt, conn);
		}
		
		return n;
	}
	
	//혈액형 검색
	public List<PersonDto> getBloodSearch(String blood)
	{
		List<PersonDto> list=new ArrayList<PersonDto>();
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String sql="select * from person2 where blood=? order by name asc";
		
		//db 연결
		conn=db.getConnection();
		try {
			pstmt=conn.prepareStatement(sql);
			//바인딩
			pstmt.setString(1, blood.toLowerCase());
			//실행
			rs=pstmt.executeQuery();
			while(rs.next())
			{
				PersonDto dto=new PersonDto();
				dto.setName(rs.getString("name"));
				dto.setJava(rs.getInt("java"));
				dto.setSpring(rs.getInt("spring"));
				dto.setHeight(rs.getDouble("height"));
				dto.setBirthday(rs.getDate("birthday"));
				//추가
				dto.setNum(rs.getInt("num"));
				dto.setBlood(rs.getString("blood"));
				//list 에 추가
				list.add(dto);
			}
			
		} catch (SQLException e) {
			System.out.println("sql search 오류:"+e.getMessage());
		}finally {
			db.dbClose(rs, pstmt, conn);
		}
		return list;
	}
}























