<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%request.setCharacterEncoding("UTF-8"); %>
</head>
<body>
<h1>ex3 빈 파일인데 이 글자들이 보일까요?</h1>
<jsp:forward page="ex4_forward.jsp">
	<jsp:param value="오늘도 화이팅" name="msg"/>
</jsp:forward>
</body>
</html>