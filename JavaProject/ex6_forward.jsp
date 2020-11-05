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
<%
	//request에 저장된 데이터 꺼내기
	String message = (String)request.getAttribute("message");
	List<String> list = (Vector<String>)request.getAttribute("colors");
%>
<body>
<h2>Ex5 번 예제의 데이터 출력하기</h2>
<h3><%=message %></h3>
<%
	for(String color: list){
	%>
		<h4 style="color: <%=color%>"><%=color %></h4>	
		
	<%}
%>
</body>
</html>