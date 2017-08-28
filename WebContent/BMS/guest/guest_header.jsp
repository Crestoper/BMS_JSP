<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file = "../assest/setting_guest.jsp" %>
<html>
<body>
	<div id = "sec"></div>
	<table>
			<tr>
				<td id = "homefirstcattd">
					<img id = "logo" src = "../BMS/Images/catlogo/CATLOGO_WHITE.png" onclick = "window.location = 'home.do'"><br>
					<span>The Ong's Book Store</span>
					<ul id = "nav">
						<!-- 로그인 안된 경우 로그인 페이지 / 로그인 된 경우 id님 -->
					<c:if test = "${sessionScope.memId != null}">
							<li>${memId}님</li>
					</c:if>
					<c:if test = "${sessionScope.memId == null}">
						<li><a class = "aTag" href = "login.do">LogIn</a></li>
					</c:if>
					
					<!-- 로그인 안된 경우 회원가입 페이지 / 로그인 된 경우 로그아웃 -->
					<c:if test = "${sessionScope.memId == null}">
						<li><a class = "aTag" href = "joinus.do">JoinUs</a></li>
						<li> <pre>                             </pre></li>
						<li>                                                      </li>
					</c:if>
					<c:if test = "${sessionScope.memId != null}">
						<li><li><a class = "aTag" href = "logout.do">Logout</a></li></li>
						<li><a class = "aTag" href = "cart.do">Cart</a></li>
						<li><a class = "aTag" href = "mypage.do">MyPage</a></li>
					</c:if>
					</ul>
					<label for ="toggle"><img id = "menuclick" src = "../BMS/Images/ClickHere/click2.png"></label>
				</td>
			</tr>
	</table>
</body>
</html>