<%@page import="org.json.simple.JSONObject"%>
<%@page import="ajax.sawon.db.SawonDto"%>
<%@page import="ajax.sawon.db.SawonDao"%>
<%@ page language="java" contentType="text/json; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	String num = request.getParameter("num");

	SawonDao dao = new SawonDao();
	
	SawonDto dto = dao.getData(num);
	
	JSONObject ob = new JSONObject();
	ob.put("num", dto.getNum());
	ob.put("name", dto.getName());
	ob.put("driver", dto.getDriver());
	ob.put("gender", dto.getGender());
	ob.put("address", dto.getAddress());
	ob.put("birthday", dto.getBirthday());
%>
<%=ob.toString()%> 