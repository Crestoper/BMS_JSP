<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<body>
<%@ include file = "/BMS/guest/guest_header.jsp"%>
<h2><center>글쓰기</center></h2>
	
	<form action = "boardWrite.do" method = "post" name = "writeform"">
		<input type = "hidden" name = "num" value = "${num}">
		<input type = "hidden" name = "ref" value = "${ref}">
		<input type = "hidden" name = "ref_level" value = "${ref_level}">
		<input type = "hidden" name = "ref_step" value = "${ref_step}">
		<input type = "hidden" name = "cnt" value = "3">
		<table align = "center" class = "boardTable">
			<tr>
				<th align = "center">작성자</th>
				<td align = "center"><input class = "input" type = "text" name = "writer" maxlength = "20" 
				<c:if test = "${sessionScope.memId != null }" >
				value = "${sessionScope.memId}"
				</c:if>
				>
				</td>
			</tr>
			<tr>
				<th align = "center">비밀번호</th>
				<td align = "center"><input class = "input" type = "password" name = "passwd" maxlength = "10"></td>
			</tr>
			<tr>
				<th align = "center">제목</th>
				<td align = "center"><input class = "input" type = "text" name = "subject" maxlength = "50" style = "width : 270px"></td>
			</tr>
			<tr>
				<th align = "center">내용</th>
				<td align = "center"><textarea class = "input" name = "content" cols = "38" rows = "10" style = "width : 270px"></textarea></td>
			</tr>
			<tr>
			<td colspan = "2" align = "center">
			<input class = "inputButton" type = "submit" value = "확인">
			<input class = "inputButton" type = "reset" value = "취소">
			<input class = "inputButton" type = "button" value = "목록" onclick = "window.location = 'boardList.do'">
		</table>
	</form>
	<br>
	<br>
	<br>
<%@ include file = "/BMS/guest/guest_footer.jsp"%>
</body>
</html>