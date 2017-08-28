<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<%@ include file = "guest_header.jsp"%>
<body>
<h1>Cart</h1>
<c:if test = "${dtolist != null}">

<form action = "cartBuy.do" method = "post">
<table class = "bookTable">
<c:set var = "num" value = "0" />
<c:forEach var = "dto" items = "${dtolist}">
	<input type = "hidden" value = "${dto.isbn}" name = "isbn${num}">
	<input type = "hidden" value = "${dto.price}" name = "price${num}">
	<input type = "hidden" value = "${dto.title}" name = "title${num}">
	<colgroup>
		<col width = "20%">
		<col width = "25%">
		<col width = "13%">
		<col width = "10%">
		<col width = "14%">
		<col width = "13%">
		<col width = "10%">
	</colgroup>
	<tr align = "center">
	<td></td><td>제목</td><td>작가</td><td>출판사</td><td>가격</td><td>재고</td><td>수량</td>
	</tr>
	<tr align = "center">
		<td><img src ="./Images/imagebyin/${dto.isbn}.jpg"></td>
		<td><a href = "bookpage.do?num=${dto.isbn}" class = "href">${dto.title}</a></td>
		<td>${dto.author}</td>
		<td>${dto.publisher}</td>
		<td><fmt:formatNumber value="${dto.price}" type="number"/>원</td>
		<td><fmt:formatNumber value="${dto.count}" type="number"/>권</td>
		<td align = "center" colspan = "1">
		<input type = "number" value = "${dto.cartCount}" name = "count${num}" min = "0" max = "${dto.count}">
		<input type = "button" value = "삭제" onclick = "window.location = 'cart.do?cnt=1&pop=${num}&isbn=${dto.isbn}'">
		</td>
		
	</tr>
		<c:set var = "total" value = "${dto.cartCount * dto.price + total}" />
		<c:set var = "num" value = "${num +1}" />
		<input type = "hidden" value = "${num}" name = "num">
</c:forEach>
<tr>
<br>
<td colspan = "6" align = "right"><h2>총구매액 : <fmt:formatNumber value="${total}" type="number"/>원</h2></td>
</tr>
<tr>
<td colspan = "7" align = "center">
	<br>
	<input type = "submit" value = "구매">
	<input type = "button" value = "돌아가기" onclick = "home.do">
</td>
</tr>
</table>
<input type = "hidden" name = "number" value = "${num}">
</form>
</c:if>
<%@ include file = "guest_footer.jsp" %>
</body>
</html>