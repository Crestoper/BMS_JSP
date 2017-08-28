<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<body>
<%@ include file = "/BMS/guest/guest_header.jsp"%>
<h2><center>게시판</center></h2>
	<table style ="width : 1000px" align = "center" class = "boardTable">

		<tr>
			<th colspan = "6" align = "right" style = "height : 25px">
				글목록(글갯수 : ${cnt}) &nbsp;&nbsp;&nbsp; <a href = "boardWrite.do?cnt=0">글쓰기</a>
			</th>
		</tr>
		<tr>
			<th style = "width : 5%">글번호</th>
			<th style = "width : 35%">글제목</th>
			<th style = "width : 10%">작성자</th>
			<th style = "width : 15%">작성일</th>
			<th style = "width : 5%">조회수</th>
		</tr>
		<!-- 게시글이 있는 경우 -->
		<c:if test = "${cnt > 0}">
		<c:forEach var = "dto" items = "${dtolist}">	
			<tr>
				<td align = "center">${number}</td>
				<c:set var = "number" value = "${number - 1 }" />
				<td align = "center">
					<c:if test = "${dto.ref_level > 0 }">
						<c:forEach begin = "1" end = "${dto.ref_level}">
							<img src = "./Images/board/level.gif" border = "0" width = "20" height = "15">
						</c:forEach>
					</c:if>
					<c:if test = "${dto.ref_step > 0 }">
						<img src = "./Images/board/re.gif" border = "0" width = "20" height = "15">
					</c:if>
						<a href = "boardContent.do?num=${dto.num}&pageNum=${pageNum}&number=${number+1}">${dto.subject}</a>
					<c:if test = "${dto.readCnt > 10}">
						<img src = "./Images/board/hot.gif" border = "0" width = "20" height = "15">
					</c:if>
				</td>
				<td align = "center">${dto.writer}</td>
				<td align = "center"><fmt:formatDate type = "both" pattern = "yyyy-MM-dd HH:mm" value = "${dto.reg_date}" /></td>
				<td align = "center">${dto.readCnt}</td>
			</tr>
		</c:forEach>	
		</c:if>
		
		<!-- 게시글이 없는 경우 -->
		<c:if test = "${cnt == 0}">
			<tr>
				<td colspan = "6" align = "center">게시글이 없습니다. 글을 작성하시오.</td>
			</tr>
		</c:if>
	</table>
	<form action = "searchBoard.do" method = "post">
			<p align = "center">
					<input id = "search" type = "text" name = "search" placeholder = " 찾으시는 글의 제목을 입력하세요." >
					<input id = "searchButton" type = "submit" value = "검색">
			</p>
				</form>
	<table style = "width : 1000px" align = "center">
		<tr>
			<th align = "center">
				<c:if test = "${cnt > 0}">
					<c:if test = "${startPage > pageBlock}">
						<a href = "boardList.do">[◁◁]</a>
						<a href = "boardList.do?pageNum=${startPage - pageBlock}">[◁]</a>
					</c:if>
					
					<c:forEach var = "i" begin = "${startPage}" end = "${endPage}">
					<c:if test = "${i == currentPage}">
						<span><b>[${i}]</b></span>
					</c:if>
					<c:if test = "${i != currentPage}">
						<a href = "boardList.do?pageNum=${i}">[${i}]</a>
					</c:if>
					</c:forEach>
				
					<!-- 다음, 끝 블럭 -->
					<c:if test = "${pageCount > endPage}">
						<a href = "boardList.do?pageNum=${startPage + pageBlock}">[▷]</a>
						<a href = "boardList.do?pageNum=${pageCount}">[▷▷]</a>
					</c:if>
				</c:if>
			</th>
		</tr>
	</table>
	<br>
	<br>
	<br>
<%@ include file = "/BMS/guest/guest_footer.jsp"%>
</body>
</html>