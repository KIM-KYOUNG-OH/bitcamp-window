<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<%
	String id = request.getParameter("id");

%>
<body>
<div class='alert alert-info' style="width: 250px;height: 120px; text-align: center;
vertical-align: mid; padding-top=20px;" border: 5px solid gray;">
<form action="member/deletepassaction.jsp" mehtod="post">
	<input type="hidden" name='id' value='<%=id%>'>
	<b>가입시 입력한 비밀번호를 넣어주세요</b><br><br>
	<input type="password" name="pass" style="width: 100px;" required="required" autofocus="autofocus">
	<button type="submit" class="btn btn-danger">회원탈퇴</button>
</form>
</div>
</body>
</html>