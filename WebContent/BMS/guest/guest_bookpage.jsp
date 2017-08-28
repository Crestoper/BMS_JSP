<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<%@ include file = "guest_header.jsp" %>
<body onload = focus(2)>
<h1>bookPage</h1>
<c:forEach var = "dto" items = "${dtolist}">

<form action = "buyPage.do" name = "buypage" method = "post">
<input type = "hidden" value = "${dto.price}" name = "price">
<input type = "hidden" value = "${dto.isbn}" name = "isbn">
<input type = "hidden" value = "${dto.title}" name = "title">

<table class = "bookTable">
	<colgroup>
		<col width = "20%">
		<col width = "35%">
		<col width = "13%">
		<col width = "10%">
		<col width = "14%">
		<col width = "13%">
	</colgroup>
	<tr align = "center">
	<td></td><td>제목</td><td>작가</td><td>출판사</td><td>가격</td><td>재고</td>
	</tr>
	<tr align = "center">
		<td><img src ="./Images/imagebyin/${dto.isbn}.jpg"></td>
		<td><a href = "bookpage.do?num=${dto.isbn}" class = "href">${dto.title}</a></td>
		<td>${dto.author}</td>
		<td>${dto.publisher}</td>
		<td><fmt:formatNumber value="${dto.price}" type="number"/>원</td>
		<td><fmt:formatNumber value="${dto.count}" type="number"/>권</td>
	</tr>
	<tr>
		<td   align = "right" colspan = "5">구매수량</td>
		<td  align = "center" colspan = "1">
		<input type = "number" name = "count" min = "0" max = "${dto.count}"></td>
		
	</tr>
	<tr>
		<td align = "center" colspan = "6">
		<br>
			<input type = "submit" value = "바로구매" id = "buy">
			<input type = "button" value = "장바구니 담기" onclick = "gocart('${dto.isbn}')">
		</td>
	</tr>
</table>
</form>
</c:forEach>	
<br>		
<%@ include file = "guest_footer.jsp" %>
</body>
</html>