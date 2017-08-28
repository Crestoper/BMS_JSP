<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<body>
<%@ include file = "/BMS/guest/guest_header.jsp"%>

<h2><center>상세 페이지</center></h2>
	<c:forEach var = "dto" items = "${dtolist}">
	<table align = "center" class = "boardTable">
		<tr>
			<th style = "width : 150px"  align = "center">글번호</th>
			<td style = "width : 150px" align = "center">${number}</td>
			<th style = "width : 150px"  align = "center">조회수</th>
			<td style = "width : 150px" align = "center">${dto.readCnt}</td>
		</tr>
		<tr>
			<th style = "width : 150px"  align = "center">작성자</th>
			<td style = "width : 150px"  align = "center">${dto.writer}</td>
			<th style = "width : 150px"  align = "center">작성일</th>
			<td style = "width : 150px"  align = "center"><fmt:formatDate type = "both" pattern = "yyyy-MM-dd HH:mm" value = "${dto.reg_date}" /></td>
		</tr>
		<tr>
			<th style = "width : 150px"  align = "center">글제목</th>
			<td colspan = "3" align = "center">${dto.subject}</td>
		</tr>
		<tr>
			<th style = "width : 150px"  align = "center">글내용</th>
			<td colspan = "3">${dto.content}</td>
		</tr>
		<tr>
			<td colspan = "4"  align = "center">
				<input class = "Button" type = "button" value = "글수정" onclick = "window.location = 'boardModify.do?num=${dto.num}&pageNum=${pageNum}&cnt=0&writer=${dto.writer}'">
				<input class = "Button" type = "button" value = "글삭제" onclick = "window.location = 'boardDelete.do?writer=${dto.writer}&num=${dto.num}&pageNum=${pageNum}&cnt=0'">
				<input class = "Button" type = "button" value = "답글쓰기" onclick = "window.location = 'boardWrite.do?num=${dto.num}&ref=${dto.ref}&ref_level=${dto.ref_level}&&ref_step=${dto.ref_step}&cnt=0'">
				<input class = "Button" type = "button" value = "목록보기" onclick = "window.location = 'boardList.do?pageNum=${pageNum}'">
			</td>
		</tr>
	</table>
	</c:forEach>
	<br>
	<br>
	<br>
<%@ include file = "/BMS/guest/guest_footer.jsp"%>
</body>
</html>