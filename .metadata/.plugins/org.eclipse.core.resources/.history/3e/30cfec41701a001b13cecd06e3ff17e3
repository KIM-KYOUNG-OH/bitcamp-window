<%@page import="org.json.simple.JSONObject"%>
<%@page import="ajax.note.db.NoteDto"%>
<%@page import="ajax.note.db.NoteDao"%>
<%@ page language="java" contentType="text/jsp; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	int num = Integer.parseInt(request.getParameter("num"));
	
	NoteDao dao = new NoteDao();

	NoteDto dto = dao.getData(num);
	
	JSONObject jo = new JSONObject();
	
	jo.put("num", dto.getNum());
	jo.put("title",	dto.getTitle());
	jo.put("description", dto.getDescription());
	jo.put("commention", dto.getCommention());
	jo.put("image", dto.getImage());
	jo.put("dueDate", dto.getDueDate());
%>
<%=jo.toString()%>