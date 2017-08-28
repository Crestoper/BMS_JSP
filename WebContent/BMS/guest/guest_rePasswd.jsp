<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<%@ include file = "guest_header.jsp" %>
<body>

<script type = "text/javascript">
switch(${sessionScope.msg}){
case 350 : alert("PW를 잘못입력하셨습니다."); request.getSession().setAttribute("msg", "0"); break;
} 
</script>

<h3 align = "center">비밀번호 입력</h1>
<c:if test = "${cnt == 0}">
<form name = "inputform" action = "infoExit.do" method = "post">
<p align = "center">
<input type = "hidden" value = "1" name = "cnt">
<input type = "password" name = "pw">&ensp;<input type = "submit" value = "확인">
</p>
</form>
</c:if>

<c:if test = "${cnt == 3}">
<form name = "inputform" action = "infoModify.do" method = "post">
<p align = "center">
<input type = "hidden" value = "1" name = "cnt">
<input type = "password" name = "pw">&ensp;<input type = "submit" value = "확인">
</p>
</form>
</c:if>


</body>
<%@ include file = "guest_footer.jsp" %>
</html>