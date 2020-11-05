<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<%
	// 현재 도메인에 저장되어있는 모든 쿠키 가져오기
	Cookie []cookies = request.getCookies();
	boolean isLogin = false; // 쿠키가 존재하면 true
	// 저장된 쿠키가 하나도 없다면 null
	if(cookies!=null){
		for(Cookie cook: cookies){
			// 쿠키 이름 얻기
			String cookieName=cook.getName();
			// 쿠키에 저장된 값 얻기
			String cookieValue = cook.getValue();
			System.out.println(cookieName + "," +cookieValue);
			//loginok라는 쿠키가 있고 값이 success가 들어있다면 성공적으로 로그인했다는 뜻
			//생성안된 상태에서 널값일 경우 오류가 나기 때문에 널 조건도 추가
			if(cookieName.equals("loginok") && cookieValue!=null
				&& cookieValue.equals("success")){
					isLogin = true;
				}
		}
	}
%>
<body>
<%
	if(isLogin){%>
		<jsp:include page="cookielogout.jsp"/>
	<%}else{%>
		<jsp:include page="cookielogin.jsp"/>
	<%}
%>
<hr align="left" width="500" size="5" color="gray">
<h1>오늘의 주요 기사</h1>
<jsp:include page="paper.jsp"/>
</body>
</html>



















