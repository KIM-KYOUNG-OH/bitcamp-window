<?xml version="1.0" encoding="UTF-8"?>
<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.Timestamp"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="oracle.db.OracleConnect"%>
<%@ page language="java" contentType="text/xml; charset=UTF-8"
    pageEncoding="UTF-8"%>
<list>
<% 
OracleConnect db = null;
Connection conn = null;
PreparedStatement pstmt = null;
ResultSet rs = null;
String sql = "select * from ajaxboard";
db = OracleConnect.getInstance();

conn = db.getConnection();
try{
	pstmt=conn.prepareStatement(sql);
	//실행
	rs=pstmt.executeQuery();
	// 데이터 가져오기
	while(rs.next()){
		int num = rs.getInt("num");
		String writer = rs.getString("writer");
		String subject = rs.getString("subject");
		String content = rs.getString("content");
		String photo = rs.getString("photo");
		Timestamp writeday = rs.getTimestamp("writeday");
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		%>
		<board num="<%=num %>" writer="<%=writer %>">
			<subject><%=subject%></subject>
			<content><%=content %></content>
			<photo><%=photo %></photo>
			<writeday><%=df.format(writeday) %></writeday>
		</board>
	<%}
	}catch(SQLException e){
		System.out.println("출력 오류 : "+e.getMessage());
	}
%>
</list>
