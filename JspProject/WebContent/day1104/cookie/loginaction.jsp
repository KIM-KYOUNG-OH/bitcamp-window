<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//입력한 암호 읽기
	String amho = request.getParameter("amho");
	//암호 비교해서 맞으면 쿠키저장
	Cookie cookie = null;
	if(amho.equals("1234")){
		cookie = new Cookie("loginok","success");
		// 유지 시간 - 테스트라 아주 짧게
		cookie.setMaxAge(10); // 10초후 제거
		cookie.setPath("/"); // root / 에 저장하기
		// 브라우저에 쿠키 추가
		response.addCookie(cookie);
		// 메인 페이지에 이동
		response.sendRedirect("cookiemain.jsp");
	}else{%>
		<script>
			alert("암호가 맞지 않습니다");
			history.back();
		</script>
	<%}
%>


















