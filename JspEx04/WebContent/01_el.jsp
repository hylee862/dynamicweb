<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
var temp = 'test';
var str = `temp 변수 값 : /${temp}`;
console.log(str);
</script>
</head>
<body>
 <!--  -->
 ${"Hello"} <br>
 <%= "Hello" %> <br>
 <% out.println("Hello"); %> <br> <!-- 표현식(Expression) -->
 ${10} <br>
 ${5.6} <br>
 ${true } <br>
 ${null } <br>
 <br>
 /${"성윤정"} <br>
 ${empty input } /
 ${not empty input } /
 ${!empty input } /
</body>
</html>