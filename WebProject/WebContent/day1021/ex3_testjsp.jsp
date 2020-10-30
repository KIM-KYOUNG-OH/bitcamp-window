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
String []colors = {"red","green","blue","orange","pink"};
	
%>
</body>
<table border='1'>
	<tr>
		<th width='100'>번호</th>
		<th width='100'>색상</th>
	</tr>
	<%
	for(int i=0; i<colors.length; i++){
	%>
	<tr>
		<td align='center'><%=i+1 %></td>
		<td align='center' bgcolor='<%=colors[i] %>'><%=colors[i] %></td>
	</tr>
	<%	
	}
	%>
</table>
</html>