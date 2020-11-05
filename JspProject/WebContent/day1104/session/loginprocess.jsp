<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String amho = request.getParameter("amho");
	// 암호가 맞으면 세션 생성
	if(amho.equals("angel")){
		// 세션 저장
		session.setAttribute("loginok", "success");
		// 유지시간(기본이 30분)
		session.setMaxInactiveInterval(60*60*24); //24시간 지정
		// 메인 페이지로 이동
		response.sendRedirect("sessionmain.jsp");
	}else{%>
		<script>
			alert("암호가 맞지 않습니다");
			history.back();
		</script>		
	<%}
%>