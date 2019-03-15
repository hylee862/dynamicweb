<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<%
String error = (String)request.getAttribute("error");
if(error==null) error = "";
String reason = (String)request.getAttribute("reason");
if(reason==null) reason= "";
String target = (String)request.getAttribute("target");
if(target==null) target= "";

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="login" method="post">
		<input type="hidden" name="target" value="${target}">
		<label for="userid"> 아이디: </label>
		<input type="text" name="id" id="userid" value="${param.id}"><br>
		<label for="userpwd"> 암 &nbsp; 호 : </label>
		<input type="password" name="pwd" id="userpwd"><br>
		<input type="submit" value="로그인">
	</form>
	<div>
		<a href="join">회원가입</a>
	</div>
	<div class="error">${error}</div>
	<div class="reason">${reason}></div>
	
	전에 입력한 값 <br>
	ID: ${param.id }, ${param["id"]}<br>
	비밀번호: ${param.pwd}, ${param["pwd"]}<br>
	EL 식 <hr>
	== 연산자 사용 결과: ${param.id=="pinksung"}<br>
	
</body>
</html>