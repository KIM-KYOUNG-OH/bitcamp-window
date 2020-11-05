<%@page import="java.util.Vector"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	//request에 데이터 저장하기
	request.setAttribute("message", "안녕하세요");
	List<String> list = new Vector();
	list.add("red");
	list.add("green");
	list.add("pink");
	list.add("orange");
	list.add("gray");
	
	request.setAttribute("colors", list);
%>
<jsp:forward page="ex6_forward.jsp"/>
</body>
</html>