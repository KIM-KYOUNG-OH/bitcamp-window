<%@page import="ajax.note.db.NoteDao"%>
<%@page import="ajax.note.db.NoteDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
	String title = request.getParameter("title");
	String description = request.getParameter("description");
	String image = request.getParameter("image");
	String dueDate = request.getParameter("dueDate");
	
	NoteDto dto = new NoteDto();
	
	dto.setTitle(title);
	dto.setDescription(description);
	dto.setImage(image);
	dto.setDueDate(dueDate);
	
	NoteDao dao = new NoteDao();
	dao.addData(dto);
%>