
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<%
	String msg = request.getParameter("msg");
%>
<body>
<h2>여기는 ex4번 파일입니다</h2>
<img alt="" src="../image2/ani12.gif">
<h2><%=msg %></h2>
</body>
</html>