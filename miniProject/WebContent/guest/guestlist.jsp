<%@page import="data.dao.GuestDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="guestform.jsp"/>
<hr width:"1000" align="left" style="height: 10px; background-color: pink;"> 
<%
	GuestDao dao = new GuestDao();
	int count = dao.getTotalCount();
%>
<b>총<%=count %>개의 데이터가 있습니다</b>
</body>
</html>