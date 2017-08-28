<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file = "guest_header.jsp"%>
<html>
<body>
<h1 align = "center">MyPage</h1>
<table class = "myPageTable">
	<colgroup>
		<col width = "33%">
		<col width = "33%">
		<col width = "33%">
	</colgroup>
<tr>
<th colspan = "3" align = "center"><h3 align = "center">회원정보 관리</h3></th>
</tr>
<tr>
<td align = "center"><a class = "href" href ="infoModify.do?cnt=0">회원정보 변경</a></td><td align = "center"><a class = "href" href = "infoExit.do?cnt=0">회원탈퇴</a></td><td align = "center"><a class = "href" href = "boardList.do">게시판</a></td>
</tr>
</table>
<br>
<br>
<section>
	<fieldset id = "fieldset">
	
		<legend>${sessionScope.memId}님 반갑습니다.</legend>
			<br>
			<h3 align = "center">주문내역</h3>
			<br>
			
			<table class = "orderTable">
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
			<form action = "" method = "post" id = "">
			<input type = "hidden" name = "salesNum" value = "${dto.salesNum}">
			<input type = "hidden" name = "count" value = "${dto.salesCount}">
			<input type = "hidden" name = "isbn" value = "${dto.isbn}">
			<table class = "orderTable">
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
			<!-- <tr>
				<td align = "center">판매번호</td>
				<td align = "center">isbn</td>
				<th align = "center">제목</th>
				<td align = "center">가격</td>
				<td align = "center">수량</td>
				<td align = "center">구매일</td>
				<td colspan = "2"  align = "center">상태</td>
			</tr> -->
			<tr>
				<td align = "center">${dto.salesNum}</td>
				<td align = "center">${dto.isbn}</td>
				<td align = "center"><b>${dto.title}</b></td>
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
						<input type = "button" class = "guestCancle" value = "취소신청">
					</c:if>
					<c:if test = "${dto.state == 1}">
						<input type = "button" class = "guestOrder" value = "환불신청">
					</c:if>
					</td>
				
			</tr>
			</table>
			</form>
			</c:forEach>
			
			<!-- <h3>주문 /배송 안내</h3>
			<table>
				<tr>
					<td>1.주문접수</td><td>2.결제완료</td><td>3.상품준비중</td><td>4.배송중</td><td>5.배송완료</td>
				</tr>
				<tr>
					<td>결제전상태입니다. 10일이내 미입금시 주문 자동 취소됩니다.</td><td>결제가 완료되어 주문처리가 진행됩니다.</td><td>주문한 상품을 준비중에 있습니다.</td><td>포장된 상품을 배송하고 있습니다.</td><td>주문하신 상품이 고객님께 전달된 상태입니다.</td>
				</tr>
			</table> -->
	</fieldset>
</section>
<br>
<br>
<br>
<br>


</body>
<%@ include file = "guest_footer.jsp"%>
</html>