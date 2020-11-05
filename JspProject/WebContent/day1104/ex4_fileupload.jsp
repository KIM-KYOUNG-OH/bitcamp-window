<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>서버에 이미지 업로드하기</h1>
<form action="ex4_uploadaction.jsp" method="post"
enctype="multipart/form-data">
	작성자 : <input type="text" name="writer"><br>
	제목 : <input type="text" name="subject"><br>
	이미지 : <input type="file" name="photo"><br>
	<button type="submit">서버에 업로드하기</button>
</form>
</body>
</html>