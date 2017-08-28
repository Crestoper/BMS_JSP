<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ include file ="../assest/setting_host.jsp" %>
<c:forEach var = "dto" items = "${dtolist}">

<form action = "hostOrderAgree.do" method = "post" id = "hostOrderAgreeform">
	<input type = "hidden" id = "salesNum" value = "${dto.salesNum}">
	<input type = "hidden" id = "count" value = "${dto.salesCount}">
	<input type = "hidden" id = "isbn" value = "${dto.isbn}">
	<input type = "hidden" value = "${value}" name = "value" id = "value">
	<input type = "hidden" value = "${pageSize}" name = "orderSize" id = "orderSize">
	<input type = "hidden" value = "${pageNum}" name = "pageNum" id = "pageNum">
	<input type = "hidden" value = "${startPage - pageBlock}" id = "[◁]">
	<input type = "hidden" value = "${startPage + pageBlock}" id = "[▷]">
	<input type = "hidden" value = "${pageCount}" id = "[▷▷]">
	
	
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
					<input type = "hidden" value = "1" id = "agreeCnt">
					<input type = "button" class = "hostOrderAgree" value = "승인">
				</c:if>
				<c:if test = "${dto.state == 2}">
					<input type = "hidden" value = "2" id = "agreeCnt">
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
						<input type = "button" value = "[◁◁]" class = "pageMove">
						<input type = "button" class = "pageMove" value = "[◁]">
					</c:if>
					
					<c:forEach var = "i" begin = "${startPage}" end = "${endPage}">
						<input type = "button" class = "pageMove" value = "${i}">
					</c:forEach>
				
					<!-- 다음, 끝 블럭 -->
					<c:if test = "${pageCount > endPage}">
						<input type = "button" class = "pageMove" value = "[▷]">
						<input type = "button" class = "pageMove" value = "[▷▷]">
					</c:if>
				</c:if>
			</th>
		</tr>
	</table>