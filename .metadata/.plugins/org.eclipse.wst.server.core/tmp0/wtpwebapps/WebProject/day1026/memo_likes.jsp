<?xml version="1.0" encoding="UTF-8"?>
<%@page import="ajax.mem.db.MemoDao"%>
<%@ page language="java" contentType="text/xml; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	// num 읽기
	String num = request.getParameter("num");
	// dao 선언
	MemoDao dao = new MemoDao();	
	// likes 업데이트
	dao.memoUpdateLikes(num);
	// 현재 likes 값 얻기
	int likes = dao.getData(num).getLikes();
%>
<likes><%=likes %></likes>
