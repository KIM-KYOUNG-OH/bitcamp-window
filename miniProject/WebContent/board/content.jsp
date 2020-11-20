<%@page import="java.text.SimpleDateFormat"%>
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
	// 목록에서 제목을 누를 경우에만 어떤 값을 보낼것임
	// 목록으로부터 왔을때만 조회수를 증가하기 위한 값
	// 목록으로부터 올때 말고는 null값이 넘어온다
	String key = request.getParameter("key");
	
	BoardDao dao = new BoardDao();
	// 목록에서 넘어온 경우에는 조회수 1증가
	if(key!=null){
		dao.updateReadcount(num);
	}
	// dto 얻기
	BoardDto dto = dao.getData(num);
	// 날짜 출력에 대한 포맷
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
%>
<body>
<div class="boardcontent">
	<table class="table table-bordered" style="width: 700px;">
		<caption><b>내용 확인</b></caption>
		<tr>
			<td>
				<pre style="font-size: 1.5em; font-weight: bold; border: none; white-space:pre-wrap;
				word-wrap: break-word; width: 650px;"><%=dto.getSubject()%></pre>
				<b><%=dto.getWriter() %></b><span style="float: right;color: gray;font-size: 0.8em;"><%=sdf.format(dto.getWriteday()) %></span>
			</td>
		</tr>
		<tr style="height: 180px;">
			<td style="vertical-align: top;" align="left">
				<pre style="background-color: white; border: none; white-space:pre-wrap;
				word-wrap: break-word; width: 650px;"><%=dto.getContent()%></pre>
			</td>
		</tr>
		<tr>
			<td>
				조회 <%=dto.getReadcount() %>
				<br>
				<!-- 버튼들 -->
				<div style="float: right;">
					<button type="button" class="btn btn-primary btn-sm" 
					onclick="location.href='index.jsp?main=board/writeform.jsp'"
					style="width: 80px;">새글</button>
					
					<button type="button" class="btn btn-primary btn-sm" 
					onclick="location.href='index.jsp?main=board/boardlist.jsp?pageNum=<%=pageNum %>'"
					style="width: 80px;">목록</button>
					
					<button type="button" class="btn btn-primary btn-sm" 
					onclick="location.href='index.jsp?main=board/writeform.jsp?pageNum=<%=pageNum %>&num=<%=num %>&regroup=<%=dto.getRegroup() %>&relevel=<%=dto.getRelevel() %>&restep=<%=dto.getRestep() %>'"
					style="width: 80px;">답글</button>
					
					<button type="button" class="btn btn-primary btn-sm" 
					onclick="location.href='index.jsp?main=board/updatepassform.jsp?num=<%=num %>&pageNum=<%=pageNum %>'"
					style="width: 80px;"><span class="glyphicon glyphicon-edit"></span>수정</button>
					
					<button type="button" class="btn btn-primary btn-sm" 
					onclick="location.href='index.jsp?main=board/deletepassform.jsp?num=<%=num %>&pageNum=<%=pageNum %>'"
					style="width: 80px;"><span class="glyphicon glyphicon-edit"></span>삭제</button>
				</div>
			</td>
		</tr>
	</table>
</div>
</body>
</html>