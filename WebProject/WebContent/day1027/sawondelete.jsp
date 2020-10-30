<%@page import="ajax.sawon.db.SawonDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// num 읽기
	String num = request.getParameter("num");
	// dao 선언
	SawonDao dao = new SawonDao();
	// 삭제 메서드 호출
	dao.deleteSawon(num);
%>
