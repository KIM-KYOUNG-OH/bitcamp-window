<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
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
	// 서버에 올라간 프로젝트의 실제 경로 구하기(save)
	ServletContext context = getServletContext();
	String realFolder = context.getRealPath("/save");
	System.out.println(realFolder);
	
	// 업로드할 파일의 크기
	int uploadSize = 1024*1024*2; //2MB
	
	MultipartRequest multi = null;
	
	try{
		multi = new MultipartRequest(request, realFolder, uploadSize,
				"utf-8", new DefaultFileRenamePolicy());
		// 모든 데이터는 multi로 읽어야만 한다
		// request로 읽을 경우 못 읽어옴
		String writer = multi.getParameter("writer");
		String subject = multi.getParameter("subject");
		String uploadName = multi.getFilesystemName("photo");
		String originalName = multi.getOriginalFileName("photo");
		%>
		<h2>
		작성자 : <%=writer %><br>
		제 목 : <%=subject %><br>
		원래이미지명 : <%=originalName %><br>
		업로드된이미지명 : <%=uploadName %><br>
		</h2>
		<h1>이미지 확인하기</h1>
		<img alt="" src="../save/<%=uploadName%>" style="max-width: 300px;">
	<%}catch(Exception e){
		System.out.println("업로드 오류:" + e.getMessage());
		out.print("업로드 오류:" + e.getMessage()); //브라우저에 출력
	}
%>
</body>
</html>