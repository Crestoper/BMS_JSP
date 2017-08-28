<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<body onload = 'focus(1);'>

<%@ include file = "guest_header.jsp"%>

<script type = "text/javascript">
switch(${sessionScope.msg}){
case 900 : alert("ID중복 사용불가합니다."); <c:set var = "msg" value = "0" scope = "session" /> break;
case 950 : alert("ID 사용가능합니다."); <c:set var = "msg" value = "0" scope = "session" /> break;
}
</script>
&ensp;&ensp;&ensp;<h2>회원가입 페이지</h2>
<form action ="joinusPro.do" method = "post" name = "inputform" onsubmit = "return check();">
<c:if test = "(${sessionScope.msg != null})">
	<input type = "hidden" name = "msg" value = "${sessionScope.msg}">
</c:if>

<table id = "table">
	<colgroup>
		<col width = "40%">
		<col width = "60%">
	</colgroup>
	<tr>
		<th align = "right">아이디</th>
		<td align = "left">
		<c:if test = "${id == null }">
			&ensp;<input type = "text" id = "id" name = "id" maxlength = "10">
		</c:if>
		<c:if test = "${id != null }">
			&ensp;<input type = "text" id = "id" name = "id" maxlength = "10" value = "${id}">
		</c:if>
			<input type = "button" value = "중복확인" onclick = "idCheck();">
			
		</td>
	</tr>
	<tr>
		<th align = "right">비밀번호</th>
		<td align = "left">&ensp;<input type = "password" name = "pw" maxlength = "20"></td>
	</tr>
	<tr>
		<th align = "right">비밀번호 확인</th>
		<td align = "left">&ensp;<input type = "password" name = "pwR" maxlength = "20"></td>
	</tr>
	<tr>
		<th align = "right">이름</th>
		<td align = "left">&ensp;<input type = "text" name = "gName" maxlength = "10"></td>
	</tr>
	<tr>
		<th align = "right">생년월일</th>
		<td align = "left">&ensp;<input type = "date" name = "gBirth"></td>
	</tr>
	<tr>
		<script src="//ajax.googleapis.com/ajax/libs/jquery/1/jquery.min.js"></script>
		<script src="//d1p7wdleee1q2z.cloudfront.net/post/search.min.js"></script>
		<script> $(function() { $("#post").postcodifyPopUp(); }); </script>
		<th align = "right">도로명주소<br>상세주소</th>
		<td align = "left"> &ensp;<input type="text" name="addr1" class="postcodify_address" value="" />
							&ensp;<input type = "button" id = "post" value = "검색"><br />
							&ensp;<input type="text" name="addr2" class="postcodify_details" value="" /><br />
		</td>
	</tr>
	<tr>
		<th align = "right">Email</th>
		<td align = "left">&ensp;<input type = "email" name = "gEmail" maxlength = "20"></td>
	</tr>
	<tr>
		<td align = "center" colspan = "2">
			<input type = "submit" value = "확인">
			<input type = "button" value = "취소" onclick = "window.history.back()">
		</td>
	</tr>
</table>
</form>
<br>
<br>

<%@ include file = "guest_footer.jsp" %>
</body>
</html>