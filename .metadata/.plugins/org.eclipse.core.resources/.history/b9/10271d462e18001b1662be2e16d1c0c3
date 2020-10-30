<%@page import="ajax.sawon.db.SawonDto"%>
<%@page import="ajax.sawon.db.SawonDao"%>
<%@ page language="java" contentType="text/json; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	request.setCharacterEncoding("UTF-8");
	String name = request.getParameter("name");
	String driver = request.getParameter("driver");
	String gender = request.getParameter("gender");
	String address = request.getParameter("address");
	String birthday = request.getParameter("birthday");

	SawonDto dto = new SawonDto();
	dto.setName(name);
	dto.setDriver(driver);
	dto.setGender(gender);
	dto.setAddress(address);
	dto.setBirthday(birthday);
	
	SawonDao dao = new SawonDao();
	dao.insertSawon(dto);
%>