<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<body>
<%@ include file = "host_header.jsp"%>
<h2 align = "center">주문상태</h2>
<p align = "right">
<select  id = "orderSize" name = "pageSize">
	<option value = "0">페이지 사이즈를 선택하시오.</option>
	<option value = "5">5개씩 보기</option>
	<option value = "10">10개씩 보기</option>
	<option value = "15">15개씩 보기</option>
	<option value = "20">20개씩 보기</option>
	<option value = "25">25개씩 보기</option>
	<option value = "30">30개씩 보기</option>
</select>
</p>

<table class = "table">
			<colgroup>
				<col width = "5%">
				<col width = "10%">
				<col width = "10%">
				<col width = "25%">
				<col width = "15%">
				<col width = "10%">
				<col width = "10%">
				<col width = "10%">
				<col width = "5%">
			</colgroup>
			<tr>
				<td align = "center">판매번호</td>
				<td align = "center">구매자ID</td>
				<td align = "center">isbn</td>
				<th align = "center">제목</th>
				<td align = "center">가격</td>
				<td align = "center">수량</td>
				<td align = "center">구매일</td>
				<td colspan = "2"  align = "center">상태</td>
			</tr>
			<tr>
			<td align = "center">
				<input type = "button" value = "전체보기" id = "allView">
				</td>
			<td align = "center">
			<select  id = "guestId" name = "guestId" >
						<option value = "0">검색 조건</option>
						<c:forEach var = "search" items = "${guestIdList}">
							<option value = "${search.guestId}">${search.guestId}</option>
						</c:forEach>
						<option value = "0">모두보기</option>
					</select>
			</td>
				<td align = "center">
					<select  id = "isbn" name = "isbn" >
						<option value = "">검색 조건</option>
						<c:forEach var = "search" items = "${searchList}">
							<option value = "${search.isbn}">${search.isbn}</option>
						</c:forEach>
						<option value = "0">모두보기</option>
					</select>
				</td>
				<th align = "center">
					<select  id = "title" name = "title">
						<option value = "">검색 조건</option>
						<c:forEach var = "search" items = "${searchList}">
							<option value = "${search.title}">${search.title}</option>
						</c:forEach>
						<option value = "0">모두보기</option>
					</select>
				</th>
				<td align = "center">

				</td>
				<td align = "center">
					
				</td>
				<td align = "center">
				</td>
				<td colspan = "2"  align = "center">
					<select  id = "state" name = "state">
						<option value = "99">검색 조건</option>
						<c:forEach var = "search" items = "${searchList22}">
							<option value = "${search.state}">
								<c:if test = "${search.state == 0}"> 
									구매승인대기
								</c:if>
								<c:if test = "${search.state == 1}"> 
									구매승인완료
								</c:if>
								<c:if test = "${search.state == 2}"> 
									환불대기
								</c:if>
								<c:if test = "${search.state == 3}"> 
									환불완료
								</c:if>
								<c:if test = "${search.state == 4}"> 
									취소완료
								</c:if>
							</option>
						</c:forEach>
						<option value = "0">모두보기</option>
					</select>
				</td>
			</tr>
			</table>	
			<br>

<nav id = "result"> </nav>
	
 
</body>
</html>