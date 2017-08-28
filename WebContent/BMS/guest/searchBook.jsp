<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<body>
<%@ include file = "guest_header.jsp" %>
<h1>검색결과</h1>

<!-- <select  id = "searchSize" name = "pageSize">
	<option value = "">페이지 사이즈를 선택하시오.</option>
	<option value = "5">5개씩 보기</option>
	<option value = "10">10개씩 보기</option>
	<option value = "15">15개씩 보기</option>
	<option value = "20">20개씩 보기</option>
	<option value = "25">25개씩 보기</option>
	<option value = "30">30개씩 보기</option>
</select> -->
<br>
<br>
<br>
<br>
<form action = "searchBook.do" method = "post">
<c:forEach var = "dto" items = "${dtolist}">
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
	<tr  align = "center">
		<td><img src ="./Images/imagebyin/${dto.isbn}.jpg"></td>
		<td><a href = "bookpage.do?num=${dto.isbn}" class = "href">${dto.title}</a></td>
		<td>${dto.author}</td>
		<td>${dto.publisher}</td>
		<td><fmt:formatNumber value="${dto.price}" type="number"/>원</td>
		<td><fmt:formatNumber value="${dto.count}" type="number"/>권</td>
	</tr>
</table>
<br>
</c:forEach>	
</form>
<%-- <table style = "width : 1000px" align = "center">
		<tr>
			<th align = "center">
				<c:if test = "${cnt > 0}">
					<c:if test = "${startPage > pageBlock}">
						<a href = "searchBook.do">[◁◁]</a>
						<a href = "searchBook.do?pageNum=${startPage - pageBlock}">[◁]</a>
					</c:if>
					
					<c:forEach var = "i" begin = "${startPage}" end = "${endPage}">
					<c:if test = "${i == currentPage}">
						<span><b>[${i}]</b></span>
					</c:if>
					<c:if test = "${i != currentPage}">
						<a href = "searchBook.do?pageNum=${i}">[${i}]</a>
					</c:if>
					</c:forEach>
				
					<!-- 다음, 끝 블럭 -->
					<c:if test = "${pageCount > endPage}">
						<a href = "searchBook.do?pageNum=${startPage + pageBlock}">[▷]</a>
						<a href = "searchBook.do?pageNum=${pageCount}">[▷▷]</a>
					</c:if>
				</c:if>
			</th>
		</tr>
	</table> --%>	
<%@ include file = "guest_footer.jsp" %>
</body>
</html>