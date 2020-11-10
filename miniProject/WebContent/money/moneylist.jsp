<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	table.table{
		width: 800px;
		margin-left: auto;
  		margin-right: auto;
  		text-align: center;
	}
	
	table tr th{
		background-color: #0099FF;
		text-align: center;
	}
	
	.container {
		display: flex;
		justify-content: center;
		align-items: center;
	}

</style>
</head>
<body>
	<table class="table table-bordered">
		<tr>
			<th>번호</th><th>상품명</th><th>가격</th><th>출납일</th><th>수정</th>
		</tr>
	</table>
	<hr>
	<div class="container">
		<button type="button" class="btn-primary" onclick="location.href='money/moneyform.jsp'">데이터 추가</button>
	</div>
</body>
</html>