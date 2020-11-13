<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// 한글 엔코딩
	request.setCharacterEncoding("utf-8");
	// pageNum 읽기
	String pageNum = request.getParameter("pageNum");
%>
<!-- useBean dto,dao 선언 -->
<jsp:useBean id="dao" class="data.dao.AnswerDao"/>
<jsp:useBean id="dto" class="data.dto.AnswerDto"/>
<!-- dto 에 데이터 일어서 넣기 : setProperty -->
<jsp:setProperty property="*" name="dto"/>
<% 
	// insert 메서드
	dao.insertAnswer(dto);
	// guestlist에 보던페이지로 이동
	response.sendRedirect("../index.jsp?main=guest/guestlist.jsp?pageNum="+pageNum);
%>