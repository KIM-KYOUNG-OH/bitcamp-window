<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	String key = request.getParameter("key");
	if(key==null){
		// 검색폼
		%>
		<form action="postsearch.jsp" method="get">
			<b>검색할 동을 입력해주세요</b><br><br>
			<img alt="" src="../image/s10.JPG" width="130" align="left" hspace="20">
			<input type="text" name="dong" required="required"
			 autofocus="autofocus" size="8">
			 <br><br>
			 <input type="hidden" name="key" value="result">
			 <button type="submit" style="width: 100px;">검색하기</button>
		</form>
	<%}else{
		// 결과테이블
		String dong = request.getParameter("dong");
		%>
		<div class="result"><%=dong %>에 대한 결과 나올곳</div>
		<button type="button" style="width: 100px;"
		onclick="location.href='postsearch.jsp'">다시검색</button>
	<%}
%>
</body>
</html>