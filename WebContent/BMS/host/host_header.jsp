<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file = "../assest/setting_host.jsp" %>
<html>
<body>
	<div id = "sec"></div>
	<table>
			<tr>
				<td id = "homefirstcattd">
					<img id = "logo" src = "../BMS/Images/catlogo/CATLOGO_WHITE.png" onclick = "window.location = 'host.do'"><br>
					<span>The Ong's Book Store</span>
					<ul id = "nav">
						<!-- <li>Host</li> -->
						<li><a class = "aTag" href = "hostStock.do">재고관리</a></li>
						<li><a class = "aTag" href = "hostOrderList.do">주문관리</a></li>
						<li><a class = "aTag" href = "boardList.do">게시판관리</a></li>
						<li><a class = "aTag" href = "settlement.do">결산</a></li>
					</ul>
					<label for ="toggle"><img id = "menuclick" src = "../BMS/Images/ClickHere/click2.png"></label>
				</td>
			</tr>
	</table>
</body>
</html>