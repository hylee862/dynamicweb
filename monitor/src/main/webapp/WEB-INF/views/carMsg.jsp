<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.7.2/css/all.css">
<script
src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js"></script>
<script
src="https://openapi.map.naver.com/openapi/v3/maps.js?ncpClientId=3ie9gmbxhc"></script>
</head>
<body>
<script type="text/javascript">
$(function(){
	if(!window.WebSocket){
		alert('웹 소켓을 지원하지 않는 브라우저 입니다.');
		return;
	}
	
	var mapOptions = {
			center: new naver.maps.LatLng(37.3595704, 127.1052133),
			zoom: 10 // 1(최소)~14(최대), 기본 : 11
	};
	
	var map = new naver.maps.Map('map', mapOptions);
	var carMarker = new naver.maps.Marker({
		map:map,
		position: new naver.maps.LatLng(37.3595704, 127.1052133)
	})
	
	// 소켓 생성
	var socket = new WebSocket("ws://localhost:8080/start/car");
	socket.onopen = function(){
		console.log('접속 성공');
		// JSON 문자열로 변환
		msg = JSON.stringify({
			msgType: 'POSITION_SUB',
			target: 1
		})
		socket.send(msg);
	}
	
	socket.close = function(){
		console.log('접속 해제');
	}
	
	socket.onmessage = function(msg){
		console.log('데이터 수신: ', msg.data);
		// 수신 메시지를 JS 객체로 저장
		carMsg = JSON.parse(msg.data)
		if(carMsg.msgType == 'POSITION'){
			position = new naver.maps.LatLng(carMsg.lat, carMsg.lng)
			map.setCenter(position)
			carMarker.setPosition(position)
		}
	}
	
	socket.onerror = function(err){
		console.log('에러', err);
	}
	
	$('#send-btn').click(function(){
		var msg = $('#send-message').val();
		socket.send(msg);
	})
})
</script>
<div id="map" style="width:100%; height:400px;"></div>
<h1>웹 소켓 테스트</h1>

<div>
	전송 메시지:
	<input type="text" id="send-message">
	<button type="button" id="send-btn">전송</button>
</div>
<div>
	수신 메시지: <span id="recv-message"></span>
</div>
</body>
</html>