<%@page import="ajax.mem.db.MemoDao"%>
<%@page import="ajax.mem.db.MemoDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// post방식이므로 한글 엔코딩 추가
	request.setCharacterEncoding("utf-8");
	String num = request.getParameter("num");
	String avata = request.getParameter("avata");
	String content = request.getParameter("content");
	String nickname = request.getParameter("nickname");
	
	// dto에 넣기
	MemoDto dto = new MemoDto();
	dto.setNum(num);
	dto.setAvata(avata);
	dto.setNickname(nickname);
	dto.setContent(content);
	
	MemoDao dao = new MemoDao();
	dao.memoUpdate(dto);
%>