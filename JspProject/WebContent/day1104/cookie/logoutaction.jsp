<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// 현재 도메인에 저장되어있는 모든 쿠키 가져오기
	Cookie []cookies = request.getCookies();
	boolean isLogin = false; // 쿠키가 존재하면 true
	// 저장된 쿠키가 하나도 없다면 null
	if(cookies!=null){
		for(Cookie cook: cookies){
			// 쿠키 이름 얻기
			String cookieName=cook.getName();
			if(cookieName.equals("loginok")){
				// 쿠키 제거작업
				cook.setMaxAge(0);
				cook.setPath("/");
				response.addCookie(cook);
			}
		}
	}
	// 메인 페이지로 이동
	response.sendRedirect("cookiemain.jsp");
%>
