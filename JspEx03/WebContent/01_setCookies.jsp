<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	Cookie c = new Cookie("id", "hyunho");
	
	c.setMaxAge(365*24*60*60);
	
	response.addCookie(c);
	
	response.addCookie(new Cookie("pwd", "test1234"));
	response.addCookie(new Cookie("age", "28"));
	
	
	%>
	<h3>쿠키 설정</h3>
</body>
</html>