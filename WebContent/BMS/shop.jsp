<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src = "./assest/jquery-1.11.3.js"></script>
<script type = "text/javascript">
		
	$(function(){
		/* 배경화면 고양이 사진 8장 랜덤 지정  */
			var images = ['1.jpg', '2.jpg', '3.jpg', '4.jpg', '5.jpg', '6.jpg', '7.jpg', '8.jpg'];
			/* 배경화면 고양이 사진 8장 랜덤 지정 위한 랜덤번호  */
			var randomnumber=Math.floor(Math.random()*8);
			/* 배경화면 고양이 사진 8장 랜덤 지정  */
			$('body').css('background', 'url(./Images/BackGroundcat/' + images[randomnumber] + ')');
			/* 배경화면 반복 안함 */
			$('body').css('background-repeat', 'no-repeat');
	});			
		/* 손가락 그림 클릭시 에니메이션 실행 */
		function here_click(id){	
			/* 각각의 개채들 변수에 넣어 줌 */
			var ani = document.getElementById('welcome');
			var cat = document.getElementById('catfoot'); 
			var cat2 = document.getElementById('catfoot2');
			var cat3 = document.getElementById('catfoot3');
			var cat4 = document.getElementById('catfoot4');
			var cataudio = document.getElementById('catsound');
			var click = document.getElementById('click');
			/* var tEnd = 'transitionend webkitTransitionEnd oTransitionEnd otransitionend'; */
			/* var audio = document.getElementById('sound'); */
			
			/* 고양이 소리 플레이 */
			cataudio.play();
			
			/* 웰컴 그림 커짐 */
			ani.classList.toggle('end');
			
			/* 손가락 그림 사라짐 */
			click.classList.toggle('clickend')
			/* $function($("#click").fadeOut(1);); */
			/* audio.play(); */
			
			/* 발자국 그림들 생김 */
			cat.classList.toggle('catend');
			cat2.classList.toggle('catend2');
			cat3.classList.toggle('catend3');
			cat4.classList.toggle('catend4'); 
			
			
			/* var maxnum=15;
			var random=Math.floor(Math.random()*maxnum)+1; */
			
			/* window.open( '../Images/thanks/thanks1.jpg', '../Images/cat/catmove' + random + '.gif', height = 1, weight = 1, left = 0, top = 0); */
		
		
			
			/* cataudio.addEventListener(cataudio.play(), ani.classList.toggle('end'), true );
			ani.addEventListener(ani.classList.toggle('end'), cat.classList.toggle('catbegin'), true );
			cat.addEventListener(cat.classList.toggle('catend'), cat2.classList.toggle('catbegin2'), true );
			cat2.addEventListener(cat2.classList.toggle('catend2'), cat3.classList.toggle('catbegin3'), true );
			cat3.addEventListener(cat3.classList.toggle('catend3'), cat4.classList.toggle('catend4'), true );  */
			
			/* 클릭 5초 후 home으로 이동 */
			setTimeout(function () {
				window.location.href = "home.do";
			}, 5000);
			
			
			/* cat4.addEventListener(cat4.classList.toggle('catend4'),, true ); */
			/* window.location.href = "home.html" */
			
			
		}
	
			/* cat4.addEventListener('webkitTransitionEnd', alert('2'), true );
			cat4.addEventListener('TransitionEnd', alert('function(){document.write ("<img src='../Images/cat/catmove1.gif"})'), true ); */
			/* here_click2(1000); */
			
			/* function wait(time){	
				var then, now;
				then = new Date().getTime();
				now = then;
				while((now-then)<time){ 
		    		now = new Date().getTime();
				}
			} */
			/* window.location.href = "home.html";  */
		
	</script>
<style>
	/* 손가락 모양 그림 기본 위치 */
	#click{
		left :45%;
		top : 45%;
		position: absolute;
	}
	/* 웰컴 그림 기본 위치  */
	#welcome{
		position: absolute;
		left : 47%;
		top : 47%;
		width : 1%;
		height : auto;
		tranform : scale(0);
	}
	
	/* 웰컴 그림 준비단계 */
	.begin{
		tranform : scale(0);
		transition : 4s;
	}
	/* 웰컴  그림 에니메이션 후 단계 */
	.end{
		transform : scale(60);
		transition : 4s;
	}
	
	/* 발자국 그림 위치 */
	#catfoot{
		position: absolute;
		left : 66%;
		top : 30%;
	}
	
	/* 발자국 그림2 위치 */
	#catfoot2{
		position: absolute;
		left : 16%;
		top : 5%;
	}
	
	/* 발자국 그림3 위치 */
	#catfoot3{
		position: absolute;
		left : 6%;
		top : 15%;
	}
	
	/* 발자국 그림4 위치 */
	#catfoot4{
		position: absolute;
		left : 56%;
		top : 15%;
	}
	
	/* 발자국 그림 에니메이션 준비단계 */
	.catbegin{
		opacity : 0;
		transition-duration : 3s;
		transition-direction: reserve;
	}
	
	/* 발자국 그림 에니메이션 마지막 단계 */
	.catend{
		opacity : 100;
		transition-duration : 3s;
		transition-direction: reserve;
	}
	
	/* 발자국 그림2 에니메이션 준비단계 */
	.catbegin2{
		opacity : 0;
		transition-delay : 1s;
		transition-duration : 3s;
		transition-direction: nomal;
	}
	
	/* 발자국 그림2 에니메이션 마지막 단계 */
	.catend2{
		opacity : 100;
		transition-delay : 1s;
		transition-duration : 3s;
		transition-direction: nomal;
	}
	
	/* 발자국 그림3 에니메이션 준비단계 */
	.catbegin3{
		opacity : 0;
		transition-delay : 1.5s;
		transition-duration : 3s;
		transition-direction: nomal;
	}
	
	/* 발자국 그림3 에니메이션 마지막 단계 */
	.catend3{
		opacity : 100;
		transition-delay : 1.5s;
		transition-duration : 3s;
		transition-direction: nomal;
	}
	
	/* 발자국 그림4 에니메이션 준비단계 */
	.catbegin4{
		opacity : 0;
		transition-delay : 2s;
		transition-duration : 3s;
		transition-direction: nomal;
	}
	
	/* 발자국 그림4 에니메이션 마지막 단계 */
	.catend4{
		opacity : 100;
		transition-delay : 2s;
		transition-duration : 3s;
		transition-direction: nomal;
	}
	
	/* 손가락 그림 마지막 단계 - 없어짐 */
	.clickend{
		opacity : 0;
		transition-duration : 1s;
	}
	
	body{
		width : 100%;
		height :100vh%;
	}
	
</style>

</head>
<body>
<!-- 고양이 소리 지정 -->
		<audio id = "catsound"><source src = "./Images/catfoot/yaong.mp3" type = "audio/mpeg"></audio>
  		<!-- <audio id = "sound"><source src = "./Images/pop/popsound.mp3" type = "audio/mpeg"></audio> -->

		<!-- 에니메이션에 쓰일 그림들 지정 -->
		<table>
		<tr>
		<td>
		<input type="image" id = "click" src = "./Images/ClickHere/click2.png" width = "100" height = "100" onclick="here_click(${request.sessionScope.memId});">		
		<img id="catfoot" src = "./Images/catfoot/catfoot.png" onclick="here_click(${request.sessionScope.memId});" class = "catbegin">
		<img id="catfoot2" src = "./Images/catfoot/catfoot1.png" onclick="here_click(${request.sessionScope.memId});" class = "catbegin">
		<img id="catfoot3" src = "./Images/catfoot/catfoot12.png" onclick="here_click(${request.sessionScope.memId});" class = "catbegin">
		<img id="catfoot4" src = "./Images/catfoot/catfoot13.png" onclick="here_click(${request.sessionScope.memId});" class = "catbegin">
    	<img class = 'begin' src = "./Images/welcome/welcome4.png" id = "welcome" >
    	</td>
    	</tr>
    	</table>
</body>
</html>
