<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>세션에 들어있는 아이디와 핸드폰 출력하기</h1>
<%
	String id = (String)session.getAttribute("id");
	String hp = (String)session.getAttribute("hp");
%>
ID : <%=id %><br>
Handphone : <%=hp %>
</body>
</html>