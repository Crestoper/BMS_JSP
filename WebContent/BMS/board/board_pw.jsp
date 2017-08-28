<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<body>
<%@ include file = "/BMS/guest/guest_header.jsp"%>
<h2 align = "center">비밀번호 입력</h2>
<c:if test = "${cnt == 3}">
<form name = "inputform" action = "boardModify.do" method = "post">
<input type = "hidden" value = "${num}" name = "num">
<input type = "hidden" value = "1" name = "cnt">
<input type = "hidden" value = "${pageNum}" name = "pageNum">
<input type = "hidden" value = "${writer}" name = "writer">

<p align = "center">
<input type = "password" name = "pw" placeholder = "비밀번호를 입력하시오."><input type = "submit" value = "확인">
</p>
</form>
</c:if>

<c:if test = "${cnt == 4}">
<form name = "inputform" action = "boardDelete.do" method = "post">
<input type = "hidden" value = "${num}" name = "num">
<input type = "hidden" value = "1" name = "cnt">
<input type = "hidden" value = "${pageNum}" name = "pageNum">
<input type = "hidden" value = "${writer}" name = "writer">
<p align = "center">
<input type = "password" name = "pw" placeholder = "비밀번호를 입력하시오."><input type = "submit" value = "확인">
</p>
</form>
</c:if>

<%@ include file = "/BMS/guest/guest_footer.jsp"%>
</body>
</html>