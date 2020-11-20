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

	String num = request.getParameter("num");
	String pageNum = request.getParameter("pageNum");
	//System.out.println(pageNum);
	String pass = request.getParameter("pass");
	
	BoardDao dao = new BoardDao();
	boolean flag = dao.isEqualPass(num, pass);
%>
<body>
<%
	if(flag){
		dao.deleteBoard(num);
		response.sendRedirect("../index.jsp?main=board/boardlist.jsp?&pageNum="+pageNum);
	}else{
		%>
		<script type="text/javascript">
			alert("비밀번호가 틀립니다");
			history.back();
		</script>
		<%
	}
%>

</body>
</html>