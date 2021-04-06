<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/style.css">
</head>
<body>
	${member}
	<h2>회원 정보</h2>
	<table border="1">
		<tr>
			<td colspan="2">회원정보</td>
		</tr>
		<tr>
			<td>아이디 </td>
			<td>${member.id }</td>
		</tr>
		<tr>
			<td>이름 </td>
			<td>${member.name }</td>
		</tr>
		<tr>
			<td>나이 </td>
			<td>${member.age }</td>
		</tr>
		<tr>
			<td>성별 </td>
			<td>${member.gender }</td>
		</tr>
		<tr>
			<td>이메일 </td>
			<td>${member.email }</td>
		</tr>
		<tr>
			<td colspan="2"><a href="memberList">리스트 돌아가자</a></td>
		</tr>
	</table>

</body>
</html>