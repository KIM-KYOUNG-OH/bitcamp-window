<%@page import="ajax.mem.db.MemoDao"%>
<%@page import="ajax.mem.db.MemoDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// post 방식으로 보냈으므로 한글 엔코딩
	request.setCharacterEncoding("UTF-8");
	// 보낸 데이터 읽기
	String nick = request.getParameter("nick");
	String content = request.getParameter("content");
	String avata = request.getParameter("avata");
	
	// dto로 묶기
	MemoDto dto = new MemoDto();
	dto.setNickname(nick);
	dto.setContent(content);
	dto.setAvata(avata);
	
	// db선언
	MemoDao dao = new MemoDao();
	// 추가 메소드 호출
	dao.memoInsert(dto);
%>