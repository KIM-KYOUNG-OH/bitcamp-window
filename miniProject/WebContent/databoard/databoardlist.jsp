<%@page import="data.dao.MemberDao"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="data.dto.DataBoardDto"%>
<%@page import="java.util.List"%>
<%@page import="data.dao.DataBoardDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="Refresh" content="10;url=index.jsp?main=databoard/databoardlist.jsp">
<title>Insert title here</title>
<script type="text/javascript">
$(function(){
	$("#btndatasearch").click(function(){
		var search = $("#search").val();
		var word = $("#word").val();
		$.ajax({
			type:"get",
			dataType:"html",
			url:"databoard/savesession.jsp",
			data:{"search":search,"word":word},
			success:function(data){
				// 전체 새로고침
				//console.log(search, word);
				location.href="index.jsp?main=databoard/databoardlist.jsp";
			}
		});
	});
	
	$("#search").change(function(){
		$("#word").val("");
	});
});
</script>
</head>
<%
	// dao 선언
	DataBoardDao dao = new DataBoardDao();
	// 세션으로부터 key, value 가져오기
	String key = (String)session.getAttribute("key");
	String value = (String)session.getAttribute("value");
	// 게시글 갯수 구하기
	int totalCount = dao.getTotalCount(key,value);
	int perPage = 10; // 한페이지당 보여질 글의 갯수
	int perBlock = 10; // 한 블럭당 출력할 페이지의 갯수
	int totalPage; // 총 페이지의 갯수
	int startPage; // 각 블럭당 시작 페이지 번호
	int endPage; // 각 블럭당 끝 페이지 번호
	int start; // 각 블럭당 불러올 글의 시작번호
	int end; // 각 블럭당 불러올 글의 끝 번호
	int currentPage; // 현재 보여질 페이지 번호
	
	// 현재 페이지 번호 구하기
	String pageNum = request.getParameter("pageNum");
	if(pageNum==null){
		currentPage = 1; // 페이지 번호가 없을 경우 무조건 1페이지로 간다
	}else{
		currentPage=Integer.parseInt(pageNum);
	}
	
	// 총 페이지 구하기(예: 총 글수가 9이고 한페이지당 2개씩 볼경우 5페이지,
	// 나머지가 있을 경우에는 1페이지 더 추가)
	totalPage = totalCount/perPage + (totalCount%perPage>0?1:0);
	// 시작페이지와 끝페이지 구하기
	// 예: 한페이지당 3개만 볼경우 현재 페이지가 2라면 sp:1, ep:3
	startPage = (currentPage-1)/perBlock*perBlock+1;
	endPage = startPage+perBlock-1;
	// 마지막 블럭은 endPage를 totalPage로 해놔야 한다
	if(endPage>totalPage){
		endPage = totalPage;
	}
	
	// 각 페이지에서 불러올 글번호 구하기
	// 예: 1페이지: 1~2, 2페이지: 3~4....
	start = (currentPage-1)*perPage+1;
	end = start+perPage-1;
	// 마지막 글번호는 총 글수와 같은 번호라야 한다
	if(end>totalCount){
		end = totalCount;
	}
	
	// 출력할 목록 가져오기
	List<DataBoardDto> list = dao.getSearchList(key, value, start, end);
	// 각 페이지의 시작번호 계산
	int no=totalCount-(currentPage-1)*perPage;
%>
<body>
<button type="button" class="btn btn-info" style="width: 120px;"
onclick="location.href='index.jsp?main=databoard/databoardform.jsp'">자료추가</button>
<table class="table table-bordered" style="width: 900px; margin-top: 30px;">
	<caption><b>총 <%=totalCount %>개의 자료가 있습니다</b></caption>
	<tr bgcolor="#ddd">
		<th style="width: 60px;">번호</th>
		<th style="width: 400px;">제목</th>
		<th style="width: 130px;">작성자</th>
		<th style="width: 130px;">작성일</th>
		<th style="width: 60px;">조회</th>
	</tr>
	<%
	if(totalCount==0){
		%>
		<tr height="50">
			<td colspan="5" align="center">
				<b>등록된 글이 없습니다</b>
			</td>
		</tr>
		<%
	}else{
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		MemberDao mdao = new MemberDao();
		for(DataBoardDto dto: list){
			boolean isPhoto = dto.isFileInPicture();
			boolean isGeneral = dto.isFileInGeneral();
			// 아이디에 해당하는 이름 얻기
			String name = mdao.getName(dto.getMyid());
		%>
			<tr align="center">
				<td><%=no-- %></td>
				<td align="left"> <!-- 제목 -->
					<a href="index.jsp?main=databoard/content.jsp?num=<%=dto.getNum()%>&pageNum=<%=currentPage%>&key=a">
						<%=dto.getSubject() %>
						<%
						if(!dto.getFiles().equals("no")){
							if(dto.isFileInPicture()){
								%>
								<span class="glyphicon glyphicon-picture" style="font-size: 0.8em;
								 color: gray;"></span>
								<%
							}
							if(dto.isFileInGeneral()){
								%>
								<span class="glyphicon glyphicon-paperclip" style="font-size:0.8em;
								 color: gray;"></span>
								<%
							}
						}
						%>
					</a>
					<!-- 댓글 갯수 출력하기 -->
					<%
					if(dto.getAnswerCount()>0){
						%>
						<span style="color: red;">
							[<a style="color: red;" href="index.jsp?main=databoard/content.jsp?num=<%=dto.getNum()%>&pageNum=<%=pageNum%>#dataanswerlist">
							<%=dto.getAnswerCount() %></a>]
						</span>
						<%
					}
					%>
				</td>
				<td><%=name %></td>
				<td><%=sdf.format(dto.getWriteday())%></td>
				<td><%=dto.getReadcount() %></td>
			</tr>
		<%
		}
	}
	%>
</table>
<!-- 페이징처리 -->
<div class="paging" style="text-align: center;">
	<%
	// 이전
	if(startPage>1){
	%>
		<a href="index.jsp?main=databoard/databoardlist.jsp?pageNum=<%=startPage-1 %>">
			&lt;이전</a>
		<%
	}
	for(int i=startPage; i<=endPage; i++){
		String url = "index.jsp?main=databoard/databoardlist.jsp?pageNum="+i;
		if(i==currentPage){
			%>
		<a href="<%=url%>" style="color: red; cursor: pointer"> <%=i %></a>&nbsp;
		<%
		}else{
			%>
		<a href="<%=url%>" style="color: black; cursor: pointer"> <%=i %></a>&nbsp;
		<%
		}
	}
	
	//다음
	if(endPage<totalPage){
	%>
		<a href="index.jsp?main=databoard/databoardlist.jsp?pageNum=<%=endPage+1 %>">
			다음&gt;</a>
		<%
	}
	%>
</div>
<form action="#" class="form-inline">
	<div style="width: 800px; text-align: center;">
		<div class="form-group">
		<%
			String search=(String)session.getAttribute("key");
			String word = (String)session.getAttribute("value");
			if(search==null){
				search="all";
			}
			if(word==null){
				word="";
			}
		%>
			<select id="search" name="search" style="width: 100px;"
			class="form-control">
				<option value="all" <%=search.equals("all")?"selected":"" %>>전체</option>
				<option value="myid" <%=search.equals("myid")?"selected":"" %>>아이디</option>
				<option value="subject" <%=search.equals("subject")?"selected":"" %>>제목</option>
				<option value="content" <%=search.equals("content")?"selected":"" %>>내용</option>
			</select>
			<input type="text" class="form-control" style="width: 150px;"
				name="word" id="word" placeholder="검색단어입력하기" value="<%=word%>">
				
			<!-- 검색버튼 -->
			<button type="button" class="btn btn-default btn-sm"
			id="btndatasearch">
			<span class="glyphicon glyphicon-search"></span>
			검색</button>
		</div>
	</div>
</form>
</body>
</html>


























