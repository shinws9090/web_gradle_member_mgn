<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="../css/style.css">
</head>
<body>
	<h2>회원 정보</h2>
	<form name="updateform" action="memberUpdate" method="get">
	<table>
		<tr>
			<td colspan="2">회원정보</td>
		</tr>
		<tr>
			<td>아이디 </td>
			<td><input type="hidden" name="id" value="${member.id }">${member.id }</td>
		</tr>
		<tr>
			<td>이름 </td>
			<td><input type="text" name="name" value="${member.name }"></td>
		</tr>
		<tr>
			<td>나이 </td>
			<td><input type="text" name="age" value="${member.age }"></td>
		</tr>
		<tr>
			<td>성별 </td>
			<td> <input type="radio" name="gender" value="남" required id="gender" checked>남자
			<input type="radio" name="gender" value="여" required id="gender">여자 </td>
		</tr>
		<tr>
			<td>이메일 </td>
			<td><input type="text" name="email" value="${member.email }"></td>
		</tr>
		<tr>
			<td colspan="2"><a href="memberList">리스트 돌아가자</a> <a href="javascript:updateform.submit()">저장</a></td>
		</tr>
	</table>
	</form>

</body>
</html>