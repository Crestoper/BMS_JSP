//에러메시지
var id_msg = "아이디를 입력하시오.";
var pw_msg = "비밀번호를 입력하시오.";
var pwR_msg = "비밀번호를 잘못 입력하셨습니다.";
var gName_msg = "이름을 입력하시오.";
var gBirth_msg = "생일을 입력하시오.";
var gAddr_msg = "주소를 입력하시오.";
var gEmail_msg = "이메일을 입력하시오.";

var insert_err = "입력시 에러가 발생하였습니다. \n다시 시도해주세요.";

//환영메시지
var join = "가입 완료. 환영합니다.";

//form onload시 focus method
function focus(name){
	if(name == 1){
		document.inputform.id.focus();
	}else if(name == 2){
		document.inputform.count.focus();
	}
}

//메시지 method
function msg(msg){
	alert(msg);
}

//유효성 검사 method
function check(){
	

	var pw = /^(?=.*[a-zA-Z])(?=.*[!@#$%^*+=-])(?=.*[0-9]).{8,16}$/;
	var name = /^[가-힣]{2,4}|[a-zA-Z]{2,10}\s[a-zA-Z]{2,10}$/;
	
	if(!document.inputform.id.value){
		alert(id_msg);
		document.inputform.id.focus();
		return false;
	}else if(!document.inputform.pw.value){
		alert(pw_msg);
		document.inputform.pw.focus();
		return false;
	}else if(!pw.test(document.inputform.pw.value)){
		alert("영문 / 숫자 특수문자 8 - 16자 입력 가능합니다.");
		document.inputform.pw.focus();
		return false;
	}else if(document.inputform.pwR.value != document.inputform.pw.value){
		alert(pwR_msg);
		document.inputform.pwR.focus();
		return false;
	}else if(!document.inputform.gName.value){
		alert(gName_msg);
		document.inputform.gName.focus();
		return false;
	}else if(!name.test(document.inputform.gName.value)){
		alert("한글 2 - 4자 영문 2 - 10자 입력 가능합니다.");
		document.inputform.gName.focus();
		return false;
	}else if(!document.inputform.gAddr.value){
		alert(gAddr_msg);
		document.inputform.gAddr.focus();
		return false;
	}
}

//아이디 중복 확인
function idCheck(){
	var id = /^[A-Za-z0-9]{4,12}$/;
	if(!document.inputform.id.value){
		alert(id_msg);
		document.inputform.id.focus();
		return false;
	
	}else if(!id.test(document.inputform.id.value)){
		alert("영문 / 숫자 4 - 12자 입력 가능합니다.");
		document.inputform.id.focus();
		return false;
	}else{
		var id = document.inputform.id.value;
		window.location = "idCheck.do?id="+id;
	}
}

//아이디 중복 확인 중 중복되지 않은 경우 창 닫고 value값에 아이디 넣어줌


function logIn(){
	if(!document.inputform.id.value){
		alert(id_msg);
		document.inputform.id.focus();
		return false;
	}
}

function gobuy(num){
	var count = document.inputform.count.value;
	window.location = "buyPage.do?num="+num+"&count="+count;
	
	return false;
}

function gocart(num){
	var count = document.buypage.count.value;
	window.location = "cartPut.do?num="+num+"&count="+count;
	
	return false;
}

function reset(){
	window.location.reload(true);
}

function selectSearch(here){
	var value = here.value;
	var name = here.name;
	if(value == 0){
		window.location = "mypage.do?cnt=0";
		return false;
	}
	if(value != null && name != null){
		window.location = "mypage.do?cnt=99&name="+name+"&value="+value;
		return false;
	}
	
}

function pwcheck(){

	var pw = /^(?=.*[a-zA-Z])(?=.*[!@#$%^*+=-])(?=.*[0-9]{8,16})$/;
	
	if(!document.inputform.pw.value){
		alert(pw_msg);
		document.inputform.pw.focus();
		return false;
	}else if(!pw.test(document.inputform.id.value)){
		alert("영문 / 숫자 특수문자 8 - 16자 입력 가능합니다.");
		return false;
	}else if(document.inputform.pwR.value != document.inputform.pw.value){
		alert(pwR_msg);
		document.inputform.pwR.focus();
		return false;
	}
}


