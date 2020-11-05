<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>name으로 읽기</h1>
<form action="ex11_action.jsp" method="post">
	<b>이름:</b>
	<input type="text" name="name" size="10"><br>
	<b>핸드폰:</b>
	<input type="text" name="hp" size="15"><br>
	<b>주소:</b>
	<input type="text" name="addr" size="20"><br>
	<!-- hidden -->
	<input type="text" name="code" value="A101">
	<button type="submit">서버에 전송하기</button>
</form>
</body>
</html>