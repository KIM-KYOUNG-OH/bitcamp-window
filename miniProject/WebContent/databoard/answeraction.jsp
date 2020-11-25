<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
%>
<jsp:useBean id="dao" class="data.dao.DataBoardDao"/>
<jsp:useBean id="dto" class="data.dto.DataAnswerDto"/>
<jsp:setProperty property="*" name="dto"/>
<%
	// 페이지번호
	String pageNum = request.getParameter("pageNum");
	// 댓글 추가
	dao.insertAnswer(dto);
	// 내용보기로 이동하는데 댓글부분으로 이동
	String go = "../index.jsp?main=databoard/content.jsp?num="+dto.getNum()
		+"&pageNum="+pageNum+ "#insertAnswer";
	response.sendRedirect(go);
%>