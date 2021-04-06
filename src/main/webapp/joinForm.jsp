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
	<form name="joinform" action="joinprocess" method="get">
		<fieldset>
			<legend>회원가입 페이지</legend>
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
					<label for="name">이름</label>
					<input type="text" name="name" size="20" required id="name">
				</li>
				<li>
					<label for="age">나이</label>
					<input type="text" name="age" size="20" required id="age">
				</li>
				<li>
					<label for="gender">성별</label>
					<input type="radio" name="gender" value="남" required id="gender">남자
					<input type="radio" name="gender" value="여" required id="gender">여자
				</li>
				<li>
					<label for="email">이메일</label>
					<input type="text" name="email" size="20" required id="email">
				</li>
				<li>
				<a href="javascript:joinform.submit()">회원가입</a>
				<a href="javascript:joinform.reset()">취소</a>
					
				</li>
			</ul>
		</fieldset>

	</form>
</body>
</html>