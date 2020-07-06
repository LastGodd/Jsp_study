<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
</head>
<body>
	<div>
		<form action="/join" method="post">
			<div><input type="text" name="cid" placeholder="아이디"></div>
			<div><input type="password" name="cpw" placeholder="비밀번호"></div>
			<div><input type="password" name="recpw" placeholder="비밀번호 확인"></div>
			<div><input type="text" name="nm" placeholder="이름"></div>
			<div><input type="submit" value="회원가입"></div>
		</form>
	</div>
</body>
</html>