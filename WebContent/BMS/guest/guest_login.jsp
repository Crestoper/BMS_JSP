<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<body onload = "focus(1)">
<jsp:include page="./guest_header.jsp" />

<script type = "text/javascript">
switch(${sessionScope.msg}){
case 320 : alert("ID를 잘못입력하셨습니다."); request.getSession().setAttribute("msg", "0"); break;
case 350 : alert("PW를 잘못입력하셨습니다."); request.getSession().setAttribute("msg", "0"); break;
} 
</script>
<br>
<br>



<form action = "loginPro.do" method = "post" name = "inputform">
	<table class = loginTable>
		<tr>
		<th align = "center"> 아이디</th>
		<td>
			<input type = "text" name = "id" maxlength = "10">
		</td>
	</tr>
	<tr>
		<th align = "center">비밀번호</th>
		<td>
			<input type = "password" name = "pw" maxlength = "20">
		</td>
	</tr>
	<tr>
		<td align = "center" colspan = "2">
			
			<input type = "submit" value = "확인">
			<input type = "button" value = "취소" onclick = "home.do">
		</td>
	</tr>
	</table>
</form>
<br>
<br>
<jsp:include page="./guest_footer.jsp" />
</body>
</html>