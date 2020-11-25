package data.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import data.dto.MemberDto;
import data.dto.MemberDto2;
import data.dto.ZipcodeDto;
import oracle.db.DbConnect;

public class MemberDao {
	DbConnect db = new DbConnect();
	
	// 아이디가 있으면 true반환, 없으면 false반환
	public boolean isIdSearch(String id){
		boolean find = false;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from member where id=?";
		
		conn = db.getGangsaConnection();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				find = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.dbClose(conn, pstmt, rs);
		}
		return find;
	}
	
	// 동에 해당하는 주소 반환하는 메서드
	public List<ZipcodeDto> getSearchDong(String dong){
		List<ZipcodeDto> list = new Vector<ZipcodeDto>();
		String sql = "select zipcode,sido,gugun,dong,nvl(ri,' ') ri,"
				+"nvl(bunji,' ') bunji from zipcode where dong like ?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		conn = db.getGangsaConnection();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%"+dong+"%");
			rs=pstmt.executeQuery();
			while(rs.next()) {
				ZipcodeDto dto = new ZipcodeDto();
				dto.setZipcode(rs.getString("zipcode"));
				dto.setSido(rs.getString("sido"));
				dto.setGugun(rs.getString("gugun"));
				dto.setDong(rs.getString("dong"));
				dto.setRi(rs.getString("ri"));
				dto.setBunji(rs.getString("bunji"));
				
				list.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.dbClose(conn, pstmt, rs);
		}
		return list;
	}
	
	// insert
	public void insertMember(MemberDto dto) {
		String sql = "insert into member values (seq_mini.nextval,"
				+"?,?,?,?,?,?,?,sysdate)";
		Connection conn = null;
		PreparedStatement pstmt = null;
		conn = db.getGangsaConnection();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getId());
			pstmt.setString(2, dto.getPass());
			pstmt.setString(3, dto.getName());
			pstmt.setString(4, dto.getAddress());
			pstmt.setString(5, dto.getAddrdetail());
			pstmt.setString(6, dto.getEmail1()+"@"+dto.getEmail2());
			pstmt.setString(7, dto.getHp1()+"-"+dto.getHp2()+"-"+dto.getHp3());
			
			pstmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.dbClose(conn, pstmt);
		}
	}
	
	// 전체 회원 목록
	public List<MemberDto2> getAllMembers(){
		List<MemberDto2> list = new Vector<MemberDto2>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from member order by id asc";
		conn = db.getGangsaConnection();
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				MemberDto2 dto = new MemberDto2();
				dto.setNum(rs.getString("num"));
				dto.setId(rs.getString("id"));
				dto.setName(rs.getString("name"));
				dto.setAddress(rs.getString("address"));
				dto.setAddrdetail(rs.getString("addrdetail"));
				dto.setEmail(rs.getString("email"));
				dto.setHp(rs.getString("hp"));
				dto.setGaipday(rs.getTimestamp("gaipday"));
				
				list.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.dbClose(conn, pstmt, rs);
		}
		
		return list;
	}
	
	// num에 해당하는 dto반환
	public MemberDto getData(String num) {
		MemberDto dto = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from member where num=?";
		conn = db.getGangsaConnection();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, num);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				dto = new MemberDto();
				dto.setNum(rs.getString("num"));
				dto.setId(rs.getString("id"));
				dto.setPass(rs.getString("pass"));
				dto.setName(rs.getString("name"));
				String []hp = rs.getString("hp").split("-");
				dto.setHp1(hp[0]);
				dto.setHp2(hp[1]);
				dto.setHp3(hp[2]);
				String []email = rs.getString("email").split("@");
				dto.setEmail1(email[0]);
				dto.setEmail2(email[1]);
				dto.setAddress(rs.getString("address"));
				dto.setAddrdetail(rs.getString("addrdetail"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.dbClose(conn, pstmt, rs);
		}
		
		return dto;
	}
	
	// 수정-이름,핸드폰,이메일,주소만 수정
	public void updateMember(MemberDto dto) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "update member set id=?, name=?, pass=?, address=?, addrdetail=?, email=?, hp=? where num=?";
		conn = db.getGangsaConnection();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getId());
			pstmt.setString(2, dto.getName());
			pstmt.setString(3, dto.getPass());
			pstmt.setString(4, dto.getAddress());
			pstmt.setString(5, dto.getAddrdetail());
			String email = dto.getEmail1() +"@"+dto.getEmail2();
			pstmt.setString(6, email);
			String hp = dto.getHp1() +"-"+ dto.getHp2() +"-"+ dto.getHp3();
			pstmt.setString(7, hp);
			pstmt.setString(8, dto.getNum());
			
			pstmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.dbClose(conn, pstmt);
		}
	}
	
	// 아이디에 해당하는 비번이 맞으면 true반환, 틀리면 false반환
	public boolean isIdPassCheck(String id, String pass){
		boolean find = false;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from member where id=? and pass=?";
		
		conn = db.getGangsaConnection();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pass);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				find = true;
			}else {
				find = false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.dbClose(conn, pstmt, rs);
		}
		return find;
	}
	
	// 삭제하는 메서드
	public void deleteMember(String id) {
		String sql = "delete from member where id=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		conn = db.getGangsaConnection();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			
			pstmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}	finally {
			db.dbClose(conn, pstmt);
		}
	}
	
	// 로그인시 필요한 메서드
	public int loginProcess(String id, String pass) {
		int ans = 0;
		if(this.isIdSearch(id)) {
			// 아이디가 존재하는 경우
			// 비번이 맞는지 체크하기
			if(this.isIdPassCheck(id, pass)) {
				// 비번이 맞을경우
				ans=3;
			}else {
				// 비번이 틀린경우
				ans=2;
			}
		}else {
			// 이이디가 아예 존재하지 않는 경우
			ans = 1;
		}
		return ans;
	}
	
	public String getName(String id) {
		String name="";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select name from member where id=?";
		conn = db.getGangsaConnection();
		try {
			pstmt= conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				name = rs.getString("name");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.dbClose(conn, pstmt, rs);
		}
		
		return name;
	}
	
	public String getNum(String id) {
		String num="";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select num from member where id=?";
		conn = db.getGangsaConnection();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				num=rs.getString("num");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.dbClose(conn, pstmt, rs);
		}
		return num;
	}
}



























