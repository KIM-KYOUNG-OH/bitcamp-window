<%@page import="data.dto.BoardDto"%>
<%@page import="data.dao.BoardDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<%
	String num = request.getParameter("num");
	String pageNum = request.getParameter("pageNum");

	BoardDao dao = new BoardDao();
	BoardDto dto = dao.getData(num);
%>
<body>
<div class="boardform">
<form action="board/updateaction.jsp" method="post">
	<!-- hidden -->
	<input type="hidden" name="num" value="<%=num %>">
	<input type="hidden" name="pageNum" value="<%=pageNum %>">
	<table class="table table-bordered" style="width: 500px;">
		<caption><b>게시글 수정</b></caption>
		<tr>
			<th style="width: 100px;" bgcolor="#e6e6fa">작성자</th>
			<td>
				<input type="text" name="writer" style="width: 150px;"
				class="form-control" required="required" value="<%=dto.getWriter()%>">
			</td>
		</tr>
		<tr>
			<th style="width: 130px;" bgcolor="#e6e6fa">제 목</th>
			<td>
				<input type="text" name="subject"
				class="form-control" required="required" value="<%=dto.getSubject()%>">
			</td>
		</tr>
		<tr>
			<td colspan="2">
				<textarea style="width: 400px; height: 200px;"
				name="content" required="required"
				class="form-control"><%=dto.getContent()%></textarea>
			</td>
		</tr>
		<tr>
			<td colspan="2" align="center">
				<button type="submit" class="btn btn-success btn-lg">
				게시글 수정</button>
			</td>
		</tr>
	</table>
</form>
</div>
</body>
</html>