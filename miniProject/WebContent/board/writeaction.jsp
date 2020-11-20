<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- useBean으로 dao,dto선언후 모든 데이터 읽기 -->
<%
	request.setCharacterEncoding("utf-8");
%>
<jsp:useBean id="dao" class="data.dao.BoardDao"/>
<jsp:useBean id="dto" class="data.dto.BoardDto"/>
<jsp:setProperty property="*" name="dto"/>
<%
	// 제목은 html 태그 안되게 하기 (<>를 특수기호로 변경)
	String subject = dto.getSubject().replace("<","&lt;").replace(">","&gt;");
	dto.setSubject(subject);
	// insert
	dao.insertBoard(dto);
	// insert된 num값 얻기
	int num = dao.getMaxNum();	
	// 페이지번호 읽기
	String pageNum = request.getParameter("pageNum");
	if(pageNum==null){
		pageNum="1";
	}
	// content로 이동
	String go="../index.jsp?main=board/content.jsp?num="+num+"&pageNum="+pageNum;
	response.sendRedirect(go);
%>