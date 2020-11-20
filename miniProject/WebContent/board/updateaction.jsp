<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- useBean으로 dao,dto 선언후 모든 데이터 읽기 -->
<%
	request.setCharacterEncoding("utf-8");
%>
<jsp:useBean id="dao" class="data.dao.BoardDao"/>
<jsp:useBean id="dto" class="data.dto.BoardDto"/>
<jsp:setProperty property="*" name="dto"/>
<%
	// 제목은 html태그 안되게 하기(<>를 특수기호로 변경)
	String subject=dto.getSubject().replace("<","&lt;").replace(">","&gt;");
	dto.setSubject(subject);
	
	// update
	dao.updateBoard(dto);
	
	// 페이지 번호
	String pageNum = request.getParameter("pageNum");
	// content로 이동
	String go = "../index.jsp?main=board/content.jsp?num="+dto.getNum()+"&pageNum="+pageNum;
	response.sendRedirect(go);
%>