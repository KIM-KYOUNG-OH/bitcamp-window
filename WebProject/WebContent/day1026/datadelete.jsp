<%@page import="ajax.mem.db.MemoDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//db선언
	MemoDao dao = new MemoDao();
	//num 읽기
	String num = request.getParameter("num");
	//메서드 호출
	dao.memoDelete(num);
%>
