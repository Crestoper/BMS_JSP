<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<h1 align = "center">판매량</h1>
   <h1 align = "center">판매내역</h1>
   <table class = "table">
    	<tr>
	    	<th>
	    		Isbn
	    	</th>
	    	<th>
	    		제목
	    	</th>
	    	<th>
	    		구매자Id
	    	</th>
	    	<th>
	    		가격
	    	</th>
	    	<th>
	    		수량
	    	</th>
	    	<th>
	    		구매액
	    	</th>
    	</tr>
		<c:forEach var = "dto" items = "${dtolist}" >
		<tr>
	    	<th>
	    		${dto.isbn}
	    	</th>
	    	<th>
	    		${dto.title}
	    		
	    	</th>
	    	<th>
	    		${dto.guestId}
	    	</th>
	    	<th>
	    	<fmt:formatNumber value="${dto.price}" type="number"/>원
	    	</th>
	    	<th>
	    	<fmt:formatNumber value="${dto.salesCount}" type="number"/>권
	    	</th>
	    	<th>
	    	<fmt:formatNumber value="${dto.price * dto.salesCount}" type="number"/>원
	    	</th>
    	</tr>
    	</c:forEach>
    </table>
    
