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
	request.setCharacterEncoding("utf-8");
	// 답글일 경우 읽어야할 값들 처리하기
	String num = request.getParameter("num");
	// 새글일 경우 null, 답글일경우 원글의 num이 넘어온다
	String regroup="",relevel="",restep="",pageNum="",subject="";
	//db 선언
	BoardDao db = new BoardDao();
	
	if(num!=null){ // 답글인경우
		regroup = request.getParameter("regroup");
		relevel = request.getParameter("relevel");
		restep = request.getParameter("restep");
		pageNum = request.getParameter("pageNum");
		// 답글일경우 제목부분에 원들의 제목 출력하기
		subject = "[답글]"+db.getData(num).getSubject();
	}
%>
<body>
<div class="boardform">
	<form action="board/writeaction.jsp" method="post">
	<!-- hidden -->
	<%
		if(num!=null){
			%>
			<input type="hidden" name="num" value="<%=num%>">
			<input type="hidden" name="regroup" value="<%=regroup%>">
			<input type="hidden" name="relevel" value="<%=relevel%>">
			<input type="hidden" name="restep" value="<%=restep%>">
			<input type="hidden" name="pageNum" value="<%=pageNum%>">
			<%
		}
	%>
		<table class="table table-bordered" style="width: 500px;">
			<caption><b><%=num==null?"새글등록":"답글등록"%></b></caption>
			<tr>
				<th style="width: 100px;" bgcolor="#e6e6fa">작성자</th>
				<td>
					<input type="text" name="writer" style="width: 150px;"
					class="form-control" required="required">
				</td>
			</tr>
			<tr>
				<th style="width: 130px;" bgcolor="#e6e6fa">제 목</th>
				<td>
					<input type="text" name="subject"
					class="form-control" required="required" value="<%=subject%>">
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<textarea style="width: 400px; height: 200px;"
					name="content" required="required"
					class="form-control"></textarea>
				</td>
			</tr>
			<tr>
				<th style="width: 130px;" bgcolor="#e6e6fa">비밀번호</th>
				<td>
					<input type="password" name="pass"
					style="width: 120px;"
					class="form-control" required="required">
				</td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<button type="submit" class="btn btn-success btn-lg">
					게시글 등록</button>
				</td>
			</tr>
		</table>
	</form>
</div>
</body>
</html>