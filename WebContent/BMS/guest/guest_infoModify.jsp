<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<%@ include file = "guest_header.jsp" %>
<body onload = focus(2)>
<h2 align = "center">회원정보 변경</h2>
<form action ="infoModify.do" method = "post" name = "inputform" onsubmit = "return pwcheck();">
<!-- 중복체크 여부 input 0 안함 / 1 함 -->
<input type = "hidden" value = "2" name = "cnt">
<table id = "table">
<colgroup>
		<col width = "50%">
		<col width = "50%">
	</colgroup>
<c:forEach var = "dto" items = "${dtos}">
	<tr>
		<th align = "right">아이디&ensp;</th>
		<td align = "left">
			${sessionScope.memId}
		</td>
	</tr>
	<tr>
		<th align = "right">비밀번호&ensp;</th>
		<td align = "left"><input type = "password" name = "pw" maxlength = "20" value = "${dto.guestPw}"></td>
	</tr>
	<tr>
		<th align = "right">비밀번호 확인&ensp;</th>
		<td align = "left"><input type = "password" name = "pwR" maxlength = "20" value = "${dto.guestPw}" ></td>
	</tr>
	<tr>
		<th align = "right">이름&ensp;</th>
		<td align = "left">${dto.guestName}</td>
	</tr>
	<tr>
		<th align = "right">생년월일&ensp;</th>
		<td align = "left">${dto.guestBirth}</td>
	</tr>
	<tr>
		<script src="//ajax.googleapis.com/ajax/libs/jquery/1/jquery.min.js"></script>
		<script src="//d1p7wdleee1q2z.cloudfront.net/post/search.min.js"></script>
		<script> $(function() { $("#post").postcodifyPopUp(); }); </script>
		
		<c:set var = "gaddr" value = "${func:split(dto.guestAddr,'@')}" />
		
		<th align = "right">도로명주소<br>상세주소</th>
		<td align = "left"> &ensp;<input type="text" name="addr1" class="postcodify_address" value="${gaddr[0]}" />
							&ensp;<input type = "button" id = "post" value = "검색"><br />
							&ensp;<input type="text" name="addr2" class="postcodify_details" value="${gaddr[1]}" /><br />
		</td>
	<tr>
		<th align = "right">Email&ensp;</th>
		<td align = "left"><input type = "email" name = "gEmail" maxlength = "20" value = "${dto.guestEmail}"></td>
	</tr>
	<tr>
		<td colspan = "2" align = "center">
			<input type = "submit" value = "확인">
			<input type = "button" value = "취소" onclick = "window.location = 'home.do'">
		</td>
	</tr>
</c:forEach>
</table>
</form>

</body>
<%@ include file = "guest_footer.jsp" %>
</html>