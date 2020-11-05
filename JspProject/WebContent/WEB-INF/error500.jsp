<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<img alt="" src="../image2/01.png">
<h1>서버 오류입니다</h1>
<h1>에러명 : <%=exception.getClass().getName()%></h1>
<h2 style="color: red;">에러메세지: <%=exception.getMessage()%></h2>
</body>
</html>