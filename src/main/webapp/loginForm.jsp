<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원의 정보 입력 폼</title>

<link rel="stylesheet" href="css/style.css">
</head>
<body>
	<h2>회원</h2>
	<form name="loginform" action="loginprocess" method="post">
		<fieldset>
			<legend>로그인 페이지</legend>
			<ul>
				<li>
					<label for="id">아이디</label>
					<input type="text" name="id" size="20" id="id">
				</li>
			
				<li>
					<label for="pass">비밀번호</label>
					<input type="password" name="pass" size="20" required id="pass">
				</li>
				<li>
				<a href="javascript:loginform.submit()">로그인</a>
				<a href="joinForm.jsp">회원가입</a>
					
				</li>
			</ul>
		</fieldset>

	</form>
</body>
</html>