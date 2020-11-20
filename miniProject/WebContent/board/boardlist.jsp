<%@page import="java.text.SimpleDateFormat"%>
<%@page import="data.dto.BoardDto"%>
<%@page import="java.util.List"%>
<%@page import="data.dao.BoardDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- 10초마다 자동 새로고침 -->
<meta http-equiv="Refresh" content="10;url=index.jsp?main=board/boardlist.jsp">
<title>Insert title here</title>
</head>
<%
	// dao 선언
	BoardDao db = new BoardDao();
	// 총 갯수 구하기
	int totalCount = db.getTotalCount();
	int perPage = 10; // 한페이지당 보여질 글의 갯수
	int perBlock = 5; // 한 블럭당 출력할 페이지의 갯수
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
	
	// mysql은 첫글이 0번(오라클은 1번)
	start = (currentPage-1)*perPage;
	
	// 각페이지에서 출력할 시작번호
	// 총 50개일 경우 1페이지는 50
	//	2페이지는 40 뭔소리징
	int no=totalCount-(currentPage-1)*perPage;
	// mysql에서 해당 페이지에 필요한 목록 가져오기
	List<BoardDto> list = db.getList(start, perPage);
%>
<body>
<div class="write">
	<a href="index.jsp?main=board/writeform.jsp">
		<img alt="" src="image/btn13.gif" title="새글쓰기">
	</a>
</div>
<div class="board">
	<table class="table table-bordered" style="width: 800px;">
		<caption><b>총 <%=totalCount %> 개의 글이 있습니다</b></caption>
			<tr bgcolor="#e6e6fa">
				<th style="width: 50px;">번호</th>
				<th style="width: 350px;">제목</th>
				<th style="width: 100px;">작성자</th>
				<th style="width: 100px;">작성일</th>
				<th>조회</th>
			</tr>
			<%
				if(totalCount==0){
					%>
					<tr height="40">
						<td colspan="5" align="center">
							<b>등록된 게시물이 없습니다</b>
						</td>
					</tr>
					<%
				}else{
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
					for(BoardDto dto:list){
						%>
						<tr align="center">
							<td><%=no-- %></td>
							<td align="left"><span style="text-overflow:ellipsis;overflow: hidden;
							white-space: nowrap;display: inline-block;max-width: 330px;">
								<!-- 제목 -->
								<!-- 답글일 경우 공백 - 1레벨당 3칸 -->
							<%
								for(int i=1;i<=dto.getRelevel(); i++){
									%>
									&nbsp;&nbsp;&nbsp;
									<%
								}
							%>
							<!-- 답글일경우 답글 이미지 출력 -->
							<%
								if(dto.getRelevel()>0){
									%>
									<img alt="" src="image/r.png">
									<%
								}
								// 원글이 없을경우
								boolean flag = db.isGroupStep(dto.getRegroup());
								if(dto.getRestep()>0){
									if(!flag){
										%>
										<span style="color: red;">[원글이 없는 답글]</span>
										<%
									}
								}
							%>
								<a href="index.jsp?main=board/content.jsp?num=<%=dto.getNum()%>&pageNum=<%=currentPage%>&key=a">
								<%=dto.getSubject() %></a>
							</span></td>
							<td><%=dto.getWriter() %></td>
							<td><%=sdf.format(dto.getWriteday()) %></td>
							<td><%=dto.getReadcount() %></td>
						</tr>
						<%
					}
				}
			%>
	</table>
	<%
	if(totalCount>0){
	%>
		<!-- 페이징처리 -->
		<div style="width: 600px; text-align: center; font-size: 17px;">
			<ul class="pagination">
				<%
			
			// 이전
			if(startPage>1){
			%>
				<li><a href="index.jsp?main=board/boardlist.jsp?pageNum=<%=startPage-1 %>">
					&lt;이전</a></li>
			<%
			}
			for(int i=startPage; i<=endPage; i++){
				String url = "index.jsp?main=board/boardlist.jsp?pageNum="+i;
				if(i==currentPage){
					%>
				<li><a href="<%=url%>" style="color: red; cursor: pointer"> <%=i %></a></li>&nbsp;
				<%
				}else{
					%>
				<li><a href="<%=url%>" style="color: black; cursor: pointer"> <%=i %></a></li>&nbsp;
				<%
				}
			}
			
			//다음
			if(endPage<totalPage){
			%>
				<li><a href="index.jsp?main=board/boardlist.jsp?pageNum=<%=endPage+1 %>">
					다음&gt;</a></li>
				<%
			}
		%>
			</ul>
		</div>
	<%
	}
	%>
</div>
</body>
</html>




















