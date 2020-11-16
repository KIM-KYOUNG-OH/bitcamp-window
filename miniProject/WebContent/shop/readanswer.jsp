<%@page import="com.sun.xml.internal.bind.v2.runtime.Location"%>
<%@page import="data.dto.ShopAnswerDto"%>
<%@page import="data.dao.ShopAnswerDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
	
	String shopnum = request.getParameter("shopnum");
	String myid = request.getParameter("myid");
	String content = request.getParameter("content");
	
	ShopAnswerDto dto = new ShopAnswerDto();
	dto.setShopnum(shopnum);
	dto.setMyid(myid);
	dto.setContent(content);
	
	ShopAnswerDao dao = new ShopAnswerDao();
	dao.insertAnswer(dto);

%>