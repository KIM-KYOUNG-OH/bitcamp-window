<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>입력값 세션에 저장하기</h1>
<form action="../savesession" method='post'>
	아이디: <input type='text' name='id'><br>
	핸드폰: <input type='text' name='hp'><br>
	<button type="submit">서블릿에서 세션에 저장하기</button>
</form>
</body>
</html>