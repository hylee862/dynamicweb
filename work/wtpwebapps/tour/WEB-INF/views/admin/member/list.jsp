<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib tagdir="/WEB-INF/tags/util" prefix="iot" %>

<div class="container">
	<h2 class="my-5">
		<i class="fas fa-list"></i> 회원 현황
	</h2>
	<table class="table table-striped table-hover">
		<tr>
			<th>아이디</th>
			<th>이름</th>
			<th>이메일</th>
			<th>전화번호</th>
			<th>주소</th>
			<th>등록일</th>
			<th>수정일</th>
		</tr>
		<c:forEach var="member" items="${pi.list}">
			<tr>
				<td>${member.userId}</td>
				<td>${member.name}</td>
				<td>${member.email}</td>
				<td>${member.phone}</td>
				<td>${member.address}</td>
				<td><fmt:formatDate value="${member.regDate}"
						pattern="yyyy-MM-dd" /></td>
				<td><fmt:formatDate value="${member.updateDate}"
						pattern="yyyy-MM-dd" /></td>
				<td></td>
			</tr>
		</c:forEach>
	</table>
	<iot:pagination pageInfo="${pi}" />
	<!-- 페이지네이션 -->
</div>