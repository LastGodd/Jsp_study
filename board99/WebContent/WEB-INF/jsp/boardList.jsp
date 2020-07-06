<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Writing</title>
</head>
<body>
	<div>
		<table>
			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>작성자</th>
				<th>작성일</th>
			</tr>
			<c:forEach var="item" items="${data}">
				<tr>
					<td>${item.i_board}</td>
					<td>${item.title}</td>
					<td>${item.userNm}</td>
					<td>${item.r_dt}</td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>