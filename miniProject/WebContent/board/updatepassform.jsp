<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	form.frm{
		width: 300px;
		border: 1px solid gray;
		text-align: center;
	}
	
</style>
</head>
<%
	request.setCharacterEncoding("utf-8");

	String num = request.getParameter("num");
	String pageNum = request.getParameter("pageNum");
%>
<body>
<div class="form-group">
	<form action="board/updatepassaction.jsp" method="post" class="frm">
		<input type="hidden" name="num" value="<%=num%>">
		<input type="hidden" name="pageNum" value="<%=pageNum%>">
		<h4>비밀번호를 입력하세요</h4>
		<input type="password" name="pass" class="pass form-control"
		required="required" autofocus="autofocus"><br>
		<button type="submit" class="btn btn-primary">확인</button>
		<button type="button" class="btn btn-warning" onclick="history.back()">뒤로가기</button>
	</form>
</div>
</body>
</html>