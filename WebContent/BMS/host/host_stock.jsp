<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<body>
<%@ include file = "host_header.jsp"%>
<h1 align = "center">재고관리</h1>
<p align = "right">
<select  id = "pageSize" name = "pageSize">
	<option value = "">페이지 사이즈를 선택하시오.</option>
	<option value = "5">5개씩 보기</option>
	<option value = "10">10개씩 보기</option>
	<option value = "15">15개씩 보기</option>
	<option value = "20">20개씩 보기</option>
	<option value = "25">25개씩 보기</option>
	<option value = "30">30개씩 보기</option>
</select>
</p>
<br>
<br>
<br>



<div class = "table"> 

<form method = "post" action = "imgUpLoad.do"  enctype="multipart/form-data"> 
<input type = "file" name = "img">
<input type = "submit" value = "등록" id = "hostStockAddImg">
</form>
<p align = "center">
<form method = "post" name = "hostStockAddForm" action = "hostStockAdd.do">
<input type = "text" name = "isbn" placeholder = "isbn을 입력하시오.">
<input type = "text" name = "title" placeholder = "title 입력하시오.">
<input type = "text" name = "author" placeholder = "author 입력하시오.">
<input type = "text" name = "publisher" placeholder = "publisher 입력하시오.">
<input type = "text" name = "price" placeholder = "price 입력하시오.">
<input type = "text" name = "count" placeholder = "count 입력하시오.">
<input type = "button" id = "hostStockAdd" value = "등록">
</form>
</p>
</div>

<br>
<br>
<br>
<c:forEach var = "dto" items = "${dtolist}">
<form action = "hostStockModify.do" method = "post" id = "hostStockModifyForm">
<table class = "table">
<tr>
<td><img class = "bImg" src ="./Images/imagebyin/${dto.isbn}.jpg"></td>
<td>
	<input type = "hidden" name = "exIsbn" value = "${dto.isbn}">
	<input type = "text" name = "isbn" value = "${dto.isbn}" placeholder = "isbn">
</td>
<td><input type = "text" name = "title" value = "${dto.title}" placeholder = "제목"></td>
<td><input type = "text" name = "author" value = "${dto.author}" placeholder = "작가"></td>
<td><input type = "text" name = "publisher" value = "${dto.publisher}" placeholder = "출판사"></td>
<td><input type = "text" name = "price" value = "${dto.price}" placeholder = "가격"></td>
<td><input type = "text" name = "count" value = "${dto.count}" placeholder = "수량"></td>

<td>
<input type = "button" class = "hostStockModify" value = "수정">
<input type = "button" class = "hostStockDelete" value = "삭제">
</td>
</tr>
</table>
</form>
</c:forEach>	

	<table style = "width : 1000px" align = "center">
		<tr>
			<th align = "center">
				<c:if test = "${cnt > 0}">
					<c:if test = "${startPage > pageBlock}">
						<a href = "hostStock.do">[◁◁]</a>
						<a href = "hostStock.do?pageNum=${startPage - pageBlock}">[◁]</a>
					</c:if>
					
					<c:forEach var = "i" begin = "${startPage}" end = "${endPage}">
					<c:if test = "${i == currentPage}">
						<span><b>[${i}]</b></span>
					</c:if>
					<c:if test = "${i != currentPage}">
						<a href = "hostStock.do?pageNum=${i}">[${i}]</a>
					</c:if>
					</c:forEach>
				
					<!-- 다음, 끝 블럭 -->
					<c:if test = "${pageCount > endPage}">
						<a href = "hostStock.do?pageNum=${startPage + pageBlock}">[▷]</a>
						<a href = "hostStock.do?pageNum=${pageCount}">[▷▷]</a>
					</c:if>
				</c:if>
			</th>
		</tr>
	</table>

<form action = "hostBookSearch.do" method = "post" id = "searchBook">
<p  align = "center">	
					<input id = "search" type = "text" name = "search" placeholder = " 찾으시는 책의 제목을 입력하세요." >
					<input id = "searchButton" type = "submit" value = "검색">
					</p>
</form>

</body>
</html>