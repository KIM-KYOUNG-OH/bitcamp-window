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
	int []jungdap = {1,2,3,4};
	int []jumsoo = {5,5,20,70};
	int []dap = new int[4];
	String writer = "";
%>
<%
	// 한글 엔코딩
	request.setCharacterEncoding("utf-8");
	// 전체 폼의 이름 얻기
	Enumeration<String> en = request.getParameterNames();
	int i = 0;
	while(en.hasMoreElements()){
		// name 얻기
		String name = en.nextElement();
		if(name.equals("name")){
			writer = request.getParameter(name);
		}else{
			dap[i] = Integer.parseInt(request.getParameter(name));
			i++;
		}
	}
%>
<h1>오라클 시험 결과 확인</h1>
<h3>내가 선택한 답은?</h3>
<%
	int scoresum = 0;
	for(int n=0; n<dap.length;n++){
		if(jungdap[n]==dap[n]){
			scoresum += jumsoo[n];
		%>
			<%=n+1 %>번 문제 : 내가 선택한 답은
			<%=dap[n] %>(정답:<%=jungdap[n] %>)
			<b style="color: red;">
			<%=jungdap[n] == dap[n]?"점수"+jumsoo[n]+"점 획득":"" %></b><br>
		<%}
	}
%>
<h1><%=writer %>님은 총 100점중
<b style="color: red;"><%=scoresum %>점</b> 입니다
</h1>
</body>
</html>





























