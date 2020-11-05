<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>hello.jsp include 하기</h1>
<%
	request.setCharacterEncoding("UTF-8");
%>
<jsp:include page="hello.jsp">
	<jsp:param value="Happy Day" name="msg1"/>
	<jsp:param value="오늘은 jsp 공부하기" name="msg2"/>
	<jsp:param value="../image/16.JPG" name="myimg"/>
</jsp:include>
<img alt="" src="../image2/03.png">
</body>
</html>