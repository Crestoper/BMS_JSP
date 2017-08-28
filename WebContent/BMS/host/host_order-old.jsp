<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<body>
<%@ include file = "host_header.jsp"%>
<h2 align = "center">주문상태</h2>
<p align = "right">
<select  id = "orderSize" name = "pageSize">
	<option value = "">페이지 사이즈를 선택하시오.</option>
	<option value = "5">5개씩 보기</option>
	<option value = "10">10개씩 보기</option>
	<option value = "15">15개씩 보기</option>
	<option value = "20">20개씩 보기</option>
	<option value = "25">25개씩 보기</option>
	<option value = "30">30개씩 보기</option>
</select>
</p>
<bn>


<p align = "right">결산액</td><td><fmt:formatNumber value="${closing}" type="number"/></p>
<bn>
<table class = "table">
			<colgroup>
				<col width = "10%">
				<col width = "10%">
				<col width = "25%">
				<col width = "15%">
				<col width = "10%">
				<col width = "15%">
				<col width = "10%">
				<col width = "5%">
			</colgroup>
			<tr>
				<td align = "center">판매번호</td>
				<td align = "center">isbn</td>
				<th align = "center">제목</th>
				<td align = "center">가격</td>
				<td align = "center">수량</td>
				<td align = "center">구매일</td>
				<td colspan = "2"  align = "center">상태</td>
			</tr>
			<tr>
			<td align = "center">
				
				</td>
				<td align = "center">
					<select  id = "orderSize" name = "isbn" onchange = "selectSearch(this);">
						<option value = "">검색 조건</option>
						<c:forEach var = "search" items = "${searchList}">
							<option value = "${search.isbn}">${search.isbn}</option>
						</c:forEach>
						<option value = "0">모두보기</option>
					</select>
				</td>
				<th align = "center">
					<select  id = "orderSize" name = "title" onchange = "selectSearch(this);">
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
					<%-- <select  id = "orderSize" name = "salesDay" onchange = "selectSearch(this);" >
						<option value = "">검색 조건</option>
						<c:forEach var = "search" items = "${searchList21}">
							<option value = "${search.salesDay}">${search.salesDay}</option>
						</c:forEach>
						<option value = "0">모두보기</option>
					</select> --%>
				</td>
				<td colspan = "2"  align = "center">
					<select  id = "orderSize" name = "state" onchange = "selectSearch(this);">
						<option value = "">검색 조건</option>
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
<c:forEach var = "dto" items = "${dtolist}">
<form action = "hostOrderAgree.do" method = "post" id = "hostOrderAgreeform">
	<input type = "hidden" name = "salesNum" value = "${dto.salesNum}">
	<input type = "hidden" name = "count" value = "${dto.salesCount}">
	<input type = "hidden" name = "isbn" value = "${dto.isbn}">
	<table class = "table">
	<colgroup>
				<col width = "8%">
				<col width = "8%">
				<col width = "10%">
				<col width = "25%">
				<col width = "10%">
				<col width = "10%">
				<col width = "15%">
				<col width = "15%">
			</colgroup>
		<!-- <tr>
			<td align = "center">판매번호</td>
			<td align = "center">구매자id</td>
			<td align = "center">isbn</td>
			<td align = "center">제목</td>
			<td align = "center">가격</td>
			<td align = "center">수량</td>
			<td align = "center">구매일</td>
			<td align = "center">상태</td>
		</tr> -->
		<tr>			
			<td align = "center">${dto.salesNum}</td>
			<td align = "center">${dto.guestId}</td>
			<td align = "center">${dto.isbn}</td>
			<td align = "center">${dto.title}</td>
			<td align = "center"><fmt:formatNumber value="${dto.price}" type="number"/>원</td>
			<td align = "center"><fmt:formatNumber value="${dto.salesCount}" type="number"/>권</td>
			<td align = "center">${dto.salesDay}</td>
			<td align = "center">
				<c:if test = "${dto.state == 0}"> 
						구매승인대기
				</c:if>
				<c:if test = "${dto.state == 1}"> 
					구매승인완료
				</c:if>
				<c:if test = "${dto.state == 2}"> 
					환불대기
				</c:if>
				<c:if test = "${dto.state == 3}"> 
					환불완료
				</c:if>
				<c:if test = "${dto.state == 4}"> 
					취소완료
				</c:if>
			</td>
			<td>
				<c:if test = "${dto.state == 0}">
					<input type = "hidden" value = "1" name = "cnt">
					<input type = "button" class = "hostOrderAgree" value = "승인">
				</c:if>
				<c:if test = "${dto.state == 2}">
					<input type = "hidden" value = "2" name = "cnt">
					<input type = "button" class = "hostOrderDisAgree" value = "승인">
				</c:if>
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
						<a href = "hostOrderList.do">[◁◁]</a>
						<a href = "hostOrderList.do?pageNum=${startPage - pageBlock}">[◁]</a>
					</c:if>
					
					<c:forEach var = "i" begin = "${startPage}" end = "${endPage}">
					<c:if test = "${i == currentPage}">
						<span><b>[${i}]</b></span>
					</c:if>
					<c:if test = "${i != currentPage}">
						<a href = "hostOrderList.do?pageNum=${i}">[${i}]</a>
					</c:if>
					</c:forEach>
				
					<!-- 다음, 끝 블럭 -->
					<c:if test = "${pageCount > endPage}">
						<a href = "hostOrderList.do?pageNum=${startPage + pageBlock}">[▷]</a>
						<a href = "hostOrderList.do?pageNum=${pageCount}">[▷▷]</a>
					</c:if>
				</c:if>
			</th>
		</tr>
	</table>
	
 
</body>
</html>