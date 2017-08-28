$(function(){
			/* 배경화면 고양이 사진 8장 랜덤 지정  위한 그림 지정*/
			var images = ['1.jpg', '2.jpg', '3.jpg', '4.jpg', '5.jpg', '6.jpg', '7.jpg', '8.jpg'];
			/* 배경화면 고양이 사진 8장 랜덤 지정 위한 랜덤번호  */
			var randomnumber=Math.floor(Math.random()*8);
			/* 배경화면 고양이 사진 8장 랜덤 지정  */
			$('#homefirstcattd').css('background', 'url(../BMS/Images/BackGroundcat/' + images[randomnumber] + ')');
			/* 배경화면 반복 안함 */
			$('#homefirstcattd').css('background-repeat', 'no-repeat');
			
			$('body').css('margin', '0');
			$('body').css('padding', '0');
			/* 전체 화면 크기 지정 */
			$('table').css('width', '100%');
			
			
			/* 메인 화면 크기 설정 */
			$("#homefirstcattd").css('height', '10%');
			$("#homefirstcattd").css('padding-top', '2%');
			$("#homefirstcattd").css('padding-bottom', '1%');
			
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
			$('#homefirstcattd span').css('font-size', '100%');
			
			/* 메인페이지 상단 로고 설정 */
			$("#logo").css('width', '6%');
			$("#logo").css('margin-bottom', '-1%');
			$("#logo").css('margin-left', '0%');
			
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
			$("#nav").css('list-style', 'none');
			$("#nav").css('font-size', '40%');
			$("#nav").css('width', '40%');
			$("#nav").css('align', 'left');
			
			/* a태그 글자 밑줄 색깔 변경 */
			$('.aTag').css('text-decoration', 'none');
			$('.aTag').css('color', 'white');
			
			/* 손가락 클릭 시 메뉴 보였다 사라졌다*/
			$("#nav").css('display', 'none');
			$("#menuclick").click(function(){
				$("#nav").toggle();
			});
			
			$('#sec').css('margin', '0');
			$('#sec').css('padding', '0');
			$('#sec').css('display', 'inline');
			
			/* footer 설정 */
			$("footer").css('text-align', 'center');
			/* footer 배경화면 */
			$('footer').css('background', 'url(../BMS/Images/BackGroundcat/' + images[randomnumber] + ')');
			
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

			//책 목록 / 상세페이지  등 책 관련 table
			$('.bookTable').css('width', '80%');
			$('.bookTable').css('padding', '1%');
			
			$('.bookTable').css('margin', 'auto');
			$('.bookTable').css('border', '1px dotted black');
			$('.bookTable').css('border-radius', '2px');
			
			$('.bookTable>tr').css('border', '1%');
			$('.bookTable>tr').css('margin', '1%');
			
			$('.bookTable>tr>td').css('border', '1%');
			$('.bookTable>tr>td').css('margin', '1%');
			$('.href').css('text-decoration', 'none');
			$('.href').css('color', '#3333333');
			$('.href:visited').css('color', '#3333333');
			$('.href:active').css('color', '#3333333');

			//login table
			$('.loginTable').css('width', '20%');
			$('.loginTable').css('padding', '1%');
			$('.loginTable').css('margin', 'auto');
			$('.loginTable').css('border', '1px dotted black');
			$('.loginTable').css('border-radius', '2px');
			$('.loginTable>tr').css('border', '1%');
			$('.loginTable>tr').css('margin', '1%');
			$('.loginTable>tr>td').css('border', '1%');
			$('.loginTable>tr>td').css('margin', '1%');
			
			//myPageTable
			$('.myPageTable').css('width', '60%');
			$('.myPageTable').css('padding', '1%');
			$('.myPageTable').css('margin', 'auto');
			$('.myPageTable').css('border', '1px dotted black');
			$('.myPageTable').css('border-radius', '2px');
			$('.myPageTable>tr').css('border', '1%');
			$('.myPageTable>tr').css('margin', '1%');
			$('.myPageTable>tr>td').css('border', '1%');
			$('.myPageTable>tr>td').css('margin', '1%');
			
			//orderTable
			$('.orderTable').css('width', '90%');
			$('.orderTable').css('padding', '1%');
			$('.orderTable').css('margin', 'auto');
			$('.orderTable').css('border', '1px dotted black');
			$('.orderTable').css('border-radius', '2px');
			$('.orderTable>tr').css('border', '1%');
			$('.orderTable>tr').css('margin', '1%');
			$('.orderTable>tr>td').css('border', '1%');
			$('.orderTable>tr>td').css('margin', '1%');
			
			$('#fieldset').css('width','80%');
			$('#fieldset').css('margin','auto');
			
			
			//join us
			$('#table').css('width', '40%');
			$('#table').css('padding', '1%');
			$('#table').css('margin', 'auto');
			$('#table').css('border', '1px dotted black');
			$('#table').css('border-radius', '2px');
			$('#table').css('align', 'center');
			$('#table>tr').css('border', '1%');
			$('#table>tr').css('margin', '1%');
			$('#table>tr').css('align', 'center');
			$('#table>tr>td').css('border', '1%');
			$('#table>tr>td').css('margin', '1%');
			$('#table>tr>td').css('align', 'center');
			
			
			//게시판 설정 boardTable
			$('.boardTable').css('width', '70%');
			$('.boardTable').css('padding', '1%');
			$('.boardTable').css('margin', 'auto');
			$('.boardTable').css('border', '2px solid black');
			$('.boardTable').css('border-radius', '2px');
			$('.boardTable>tr').css('border', '1%');
			$('.boardTable>tr').css('margin', '1%');
			$('.boardTable>tr').css('border', '1px dotted black');
			$('.boardTable>tr>td').css('border', '1%');
			$('.boardTable>tr>td').css('margin', '1%');
			$('.boardTable>tr>td').css('border', '1px dotted black');
			
			//
			$("#searchSize").change(function(){
				var pageSize = $("#searchSize option:selected").val();
				window.location.href = "searchBook.do?pageSize="+pageSize;
			});
			
			
			//환불/취소신청
			$('.guestOrder').click(function(){
				var result = confirm("신청하시겠습니까?");
				
				if(result){
					var form = $(this).parents("form");
					console.log($(this));
					console.log(form);
					var togo = $('#sec');
					
					  $.ajax({ 					
					       data: 	form.serialize(),		
					       type: 	'post',	 			
					       url: 	"guestOrder.do",	 	
					       success: function(response) { 		
					          alert("신청 완료");
					          window.location.reload(true);
					    	 /* togo.html(response);*/ 			
					       }
					  });
				}
			});
			
			$('.guestCancle').click(function(){
				var result = confirm("신청하시겠습니까?");
				
				if(result){
					var form = $(this).parents("form");
					console.log($(this));
					console.log(form);
					var togo = $('#sec');
					
					  $.ajax({ 					
					       data: 	form.serialize(),		
					       type: 	'post',	 			
					       url: 	"guestCancle.do",	 	
					       success: function(response) { 		
					          alert("취소 완료");
					          window.location.reload(true);
					    	 /* togo.html(response);*/ 			
					       }
					  });
				}
			});
			/*$('#check').click(function(){
				var form = $(this).parents("form");
				
				console.log($(this));
				console.log(form);
				
				var togo = $('#sec');
				
				$.ajax({ 					
				       data: 	form.serialize(),		
				       type: 	'post',	 			
				       url: 	"idCheck.do",	 	
				       success: function(response) { 		
				    	togo.html(response);			
				       }
				});
			});*/
			
			
			
			
			/* searchBook-------------------------------------------------------------------------------------- */
						
	});
