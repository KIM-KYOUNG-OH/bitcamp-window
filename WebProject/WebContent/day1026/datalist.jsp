<?xml version="1.0" encoding="UTF-8"?>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="ajax.mem.db.MemoDto"%>
<%@page import="ajax.mem.db.MemoDao"%>
<%@page import="java.util.Vector"%>
<%@ page language="java" contentType="text/xml; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	MemoDao dao = new MemoDao();
	Vector<MemoDto> list = dao.getAllDatas();
%>
<list>
<%
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
	for(MemoDto dto: list){
	%>
		<board num="<%=dto.getNum()%>" likes="<%=dto.getLikes()%>">
			<nickname><%=dto.getNickname() %></nickname>
			<content><%=dto.getContent() %></content>
			<avata><%=dto.getAvata() %></avata>
			<writeday><%=sdf.format(dto.getWriteday()) %></writeday>
		</board>
	<%}
%>
</list>