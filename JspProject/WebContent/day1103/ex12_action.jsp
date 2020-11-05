<%@page import="java.util.Enumeration"%>
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
	request.setCharacterEncoding("utf-8");
	Enumeration<String> en = request.getParameterNames();
	int scoresum=0;
	String writer = "";
	while(en.hasMoreElements()){
		String name = en.nextElement();
		if(name.equals("name")){
			writer=request.getParameter(name);
		}else{
			int score=Integer.parseInt(request.getParameter(name));
			if(score == 0){
				out.print(name+" 문제: 오답<br>");
			}else{
				out.print(name+" 문제: 정답<br>");
			}
			scoresum += score;
		}
	}
%>
<h1>오라클 시험 결과</h1>
	한가인님은 총 100점중 <%=scoresum %>점입니다
</body>
</html>