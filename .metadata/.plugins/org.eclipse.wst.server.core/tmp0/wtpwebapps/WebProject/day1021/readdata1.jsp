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
	// get 방식
	// 폼에서 보낸 data 읽기
	String name=request.getParameter("name");
	String gender = request.getParameter("gender");
%>
<h2>서버에서 보낸 데이터 읽기</h2>
<h3>이름 : <%= name %></h3>
<h3>성별 : <%= gender %></h3>

</body>
</html>