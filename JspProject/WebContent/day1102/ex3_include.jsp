<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>formtag1.html</h2>
<jsp:include page="formtag1.html"/>
<hr>
<h2>ex1_test.jsp</h2>
<jsp:include page="ex1_test.jsp"/>
<hr>
<h2>ex2_include.jsp</h2>
<jsp:include page="ex2_include.jsp"/>
<hr>
<h2>네이트 페이지 포함시키기</h2>
<embed src="http://www.nate.com" style="width:800px; height: 300px;">
<h2>네이트 페이지 포함시키기</h2>
<iframe src="ex1_test.jsp" style="width:800px; height: 300px;"></iframe>
</body>
</html>