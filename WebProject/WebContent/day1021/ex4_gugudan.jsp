<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">

<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>
<h1>전체구구단</h1>
<table class="table table-bordered" style='width: 1000px; text-align: center;'>
	<thead style='background-color: orange;'>
		<tr>
		<%
		for(int i=2; i<10; i++){
		%>
			<th style='text-align: center;'><b><%=i %>단</b></th>
		<%
		}
		%>
		</tr>
	</thead>
	<tbody>
		<%
		for(int i=1; i<10; i++){
			%>
			<tr>
			<%
			for(int j=2; j<10; j++){
			%>
				<td><%=j%>X<%=i%>=<%=i*j%></td>
			<%
			}%>
			</tr>
		<%
		}
		%>
	</tbody>
</table>
</body>
</html>