<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file = "host_header.jsp" %>
<html>
<body>
<form >
<br>
<table class = "table" id = "ta">
	<tr>
		<th><input type = "button" value = "전체보기" id = "viewAll"></th	>
	</tr>
	<tr>
		<th colspan = "3">
			검색조건
		</th>
	</tr>
	<tr>
		<th>
			<input type = "date" id = "startDate" name = "startDate">
			<input type = "date" id = "endDate" name = "endDate">
			<input type = "button" value = "확인" id = "dateClick">
			<br><br>
		</th>
	</tr>
	<tr>
		<th>
			<select name = "title" id = "selectTitle">
				<option value = "0">TITLE 전체보기</option>
				<c:forEach var = "dto" items = "${searchList}" >
				<option value = "${dto.title}">${dto.title}</option>
				</c:forEach>
			</select>

			<select name = "guestId" id = "selectGuestId">
				<option value = "0">guestId 전체보기</option>
				<c:forEach var = "dto" items = "${guestIdList}">
				<option value = "${dto.guestId}">${dto.guestId}</option>
				</c:forEach>
			</select>
			<br><br>
		</th>
	</tr>
	<tr>
		<th>년별
			<c:forEach var = "year" begin = "${year.startYear}" end = "${year.endYear}">
				<input type = "button" value = "${year}년" name = "clickYear">
			</c:forEach>
			<br><br>
		</th>
	</tr>
	<tr>
		<th>월별
			<c:forEach var = "month" begin = "1" end = "12">
				<input type ="button" value = "${month}월" name = "clickMonth">
			</c:forEach>
		</th>
	</tr>
</table>
</form>
<div id = "settlement"></div>

<!-- 판매량 -->
<div id="settlementStock"></div>

<!-- 그래프 -->    
<div id="container" style="width:100%; height:400px;"></div>
</body>
</html>