<%@page import="data.dao.MemberDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%--
세션에 저장
아이디 myid: 로그인한 아이디를 저장
아이디저장 체크박스 상태 : 

--%>
<%
	request.setCharacterEncoding("utf-8");
	// id, pass, saveid 읽기
	String id = request.getParameter("id");
	String pass = request.getParameter("pass");
	String saveid = request.getParameter("saveid"); //null이면 체크 안한 상태를 나타낸다
	%>
	<script>
		console.log(saveid);
	</script>
	<%
	// dao 선언
	MemberDao dao = new MemberDao();
	// loginProcess 호출
	// 아이디가 DB명단에 없을경우 1반환
	// 아이디는 있는데 비번은 안맞을때 2반환
	// 아이디와 비번 모두 맞을때 3반환
	int c = dao.loginProcess(id, pass);
	// 위의 결과 3인 경우에만 세션에 위의 설명대로 저장 및 삭제후 index로 이동
	// 나머지 경우는 적적한 경고창과 함께 이전 페이지로 이동하기
	if(c==1){
		%>
		<script>
			alert("아이디가 존재하지 않습니다\n먼저 회원가입을 해주세요");
			history.back();
		</script>
		<%
	}else if(c==2){
		%>
		<script>
			alert("비밀번호가 맞지 않습니다");
			history.back();
		</script>
		<%
	}else{
		session.setAttribute("myid", id);
		if(saveid!=null){
			session.setAttribute("saveid", "yes");
		}else{
			session.removeAttribute("saveid");
		}
		session.setAttribute("loginok", "success");
		// 세션 유지시간 지정
		session.setMaxInactiveInterval(60*60*24);
		response.sendRedirect("../index.jsp");
	}
%>


