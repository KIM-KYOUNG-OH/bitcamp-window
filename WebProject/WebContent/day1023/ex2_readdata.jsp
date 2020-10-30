<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	String name = request.getParameter("name");
	String age = request.getParameter("age");
	String addr = request.getParameter("addr");
	//이클립스 콘솔때 출력하기
	System.out.println("이름="+name);
	System.out.println("나이="+age);
	System.out.println("주소="+addr);
%>