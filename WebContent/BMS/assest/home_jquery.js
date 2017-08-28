$(function(){
			/* 배경화면 고양이 사진 8장 랜덤 지정  위한 그림 지정*/
			var images = ['1.jpg', '2.jpg', '3.jpg', '4.jpg', '5.jpg', '6.jpg', '7.jpg', '8.jpg'];
			/* 배경화면 고양이 사진 8장 랜덤 지정 위한 랜덤번호  */
			var randomnumber=Math.floor(Math.random()*8);
			/* 배경화면 고양이 사진 8장 랜덤 지정  */
			$('#homefirstcattd').css('background', 'url(./Images/BackGroundcat/' + images[randomnumber] + ')');
			/* 배경화면 반복 안함 */
			$('#homefirstcattd').css('background-repeat', 'no-repeat');
			
			$('body').css('margin', '0');
			$('body').css('padding', '0');
			/* 전체 화면 크기 지정 */
			$('table').css('width', '100%');
			/* $('table').css('height', '400%'); */
			
			/* 메인 화면 크기 설정 */
			$("#homefirstcattd").css('width', '100%');
			$("#homefirstcattd").css('height', '100vh');
			$("#homefirstcattd").css('padding-top', '0%');
			
			/* 메인 화면 텍스트 설정 */
			/* 폰트 설정 */
			$('#homefirstcattd').css('font-family', 'Noto Serif');
			$("#homefirstcattd").css('text-align', 'center');
			$('#homefirstcattd').css('font-size', '500%');
			$("#homefirstcattd").css('valign', 'top');
			$("#homefirstcattd").css('color', 'white');
			$("#homefirstcattd").css('text-shadow', '2px 2px 8px rgba(0,0,0,0.7)');
			/* Welcome to 만 따로 설정 */
			$('#homefirstcattd span').css('font-style', 'italic');
			$('#homefirstcattd span').css('margin-top', '0%');
			/* 메인페이지 상단 로고 설정 */
			$("#logo").css('width', '8%');
			$("#logo").css('margin-bottom', '-1%');
			$("#logo").css('margin-left', '-4%');
			
			$("#top").css('margin-bottom', '5%');
			
			/* 메뉴 손가락 설정 */
			$("#menuclick").css('width', '5%');
			/* $(".topMenu > img").css('float', 'left'); */
			$("#menuclick").css('position', 'absolute');
			$("#menuclick").css('left', '3%');
			$("#menuclick").css('top', '3%');
			/* 메뉴 위치 설정 */
			$("#nav").css('position', 'absolute');
			$("#nav").css('left', '1%');
			$("#nav").css('top', '1%');
			$("#nav >li").css('padding-right', '1%');
			$("#nav >li").css('display', 'inline');
			/* 메뉴 속성 설정 */
			$("#nav").css('list-style', '5%');
			$("#nav").css('font-size', '40%');
			$("#nav").css('width', '40%');
			
			/* a태그 글자 밑줄 색깔 변경 */
			$('.aTag').css('text-decoration', 'none');
			$('.aTag').css('color', 'white');
			
			/* 손가락 클릭 시 메뉴 보였다 사라졌다*/
			$("#nav").css('display', 'none');
			$("#menuclick").click(function(){
				$("#nav").toggle();
			});
			
			/* 검색창 설정 */
			$("#search").css('border', '3px #333333 solid');
			$("#search").css('height', '4%');
			$("#search").css('width', '43.8%');
			/* 검색창 위치 설정 */
			$("#search").css('position', 'absolute');
			$("#search").css('top', '75%');
			$("#search").css('left', '28%');
			$("#searchButton").css('position', 'absolute');
			$("#searchButton").css('top', '75.4%');
			$("#searchButton").css('left', '68.8%');
			
			/* Ong's select td 외부크기 지정 */
			$(".ongsselect").css('width', '100%');
			/* $(".ongsselect").css('height', '80%'); */
			$(".ongsselect").css('margin', '0 auto');
			$(".ongsselect").css('padding-top', '5%');
			
			/* Ong's select 텍스트 설정 */
			$(".ongsselect").css('font-family', 'Noto Sans');
			$(".ongsselect").css('text-align', 'center');
			$('.ongsselect').css('font-size', '200%');
			$(".ongsselect").css('color', '#333333');
			/* Ong's select 만 따로 설정*/
			$('.ongsselect p').css('font-size', '200%');
			$('.ongsselect p').css('margin-bottom', '0.7%');
			
			/* Ong's select 그림 크기 설정 */
			$(".ongsselect>img").css('width', '10%');
			$(".ongsselect>img").css('margin-left', '5%');
			
			
			
			$("footer").css('text-align', 'center');
			/* footer 배경화면 */
			$('footer').css('background', 'url(./Images/BackGroundcat/' + images[randomnumber] + ')');
			
			/* footer 반복 안함 */
			$('footer').css('background-repeat', 'no-repeat');
			$("footer > img").css('width', '5%');
			$('footer').css('font-family', 'Noto Serif');
			$("footer").css('text-align', 'center');
			$('footer').css('font-size', '300%');
			$("footer").css('valign', 'middle');
			$("footer").css('color', 'white');
			$("footer").css('text-shadow', '2px 2px 8px rgba(0,0,0,0.7)');
			$("footer").css('padding', '2%');
});