<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원목록</title>
<link rel="stylesheet" href="../css/style.css">
</head>
<body>
	<c:choose>
	<c:when test="${member.id eq 'admin' }">
	<h2>회원회원목록</h2>
	<table border="1">
		<tr>
			<td colspan="3">회원목록</td>
		</tr>
		<tr>
			<td colspan="3"><a href="logoutProcess">로그아웃</a><br></td>
		</tr>
		<c:forEach var="m" items="${members}">
			<tr>
				<td><a href="memberinfo?id=${m.id}">${m.id}</a></td>
				<td><a href="memberinfo?id=${m.id}">${m.name}</a></td>
				<td><a href="memberRemove?id=${m.id}">삭제</a> 
				<a href="memberModify?id=${m.id}">수정</a></td>
			</tr>
		</c:forEach>
		<tr>
			<td colspan="2"><a href="joinForm.jsp">회원추가</a> </td>
			<td><a href="admin/main.jsp">메인으로</a> </td>
		</tr>
	</table>
	</c:when>
	<c:otherwise>
	<h2>로그아웃 했잔슴</h2>
	</c:otherwise>
	</c:choose>

</body>
</html>