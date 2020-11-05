<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table style="width: 100%">
	<tr height="150" align="center">
		<td colspan="2" style="font-size: 2em;" bgcolor="pink">
			<jsp:include page="top.jsp"/>
		</td>
	</tr>
	<tr height="800">
		<td width="25%" bgcolor="yellow">
			<jsp:include page="menu.jsp"/>
		</td>
		<td rowspan="2" bgcolor="cyan">
			<jsp:include page="main.jsp"/>
		</td>
	</tr>
	<tr height="100">
		<td style="color: rd; background-color:#ffffaa">
			<jsp:include page="info.jsp"/>
		</td>
	</tr>
</table>
</body>
</html>