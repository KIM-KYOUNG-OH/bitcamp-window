<%@page import="data.dao.ShopAnswerDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
	String idx=request.getParameter("idx"); // 수정할 글번호
	String acontent = request.getParameter("acontent"); // 샵주인의 메세지
	ShopAnswerDao dao = new ShopAnswerDao();
	dao.updateShopAnswer(idx, acontent);
%>