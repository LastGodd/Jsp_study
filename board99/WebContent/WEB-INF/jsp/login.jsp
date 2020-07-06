<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Writing</title>
<link rel="stylesheet" href="/css/common.css">
</head>
<body>
	<div id="container">
		<form id="frm" action="/login" method="post">
			<div><input type="text" name="cid" placeholder="아이디"></div>
			<div><input type="password" name="cpw" placeholder="비밀번호"></div>
			<div><input type="submit" value="로그인"></div>
			<div><input type="reset" value="새로고침"></div>
			<div><a href="/join">회원가입</a></div>
		</form>
	</div>
</body>
</html>