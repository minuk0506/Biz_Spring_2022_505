<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set value="${pageContext.request.contextPath}" var="rootPath" />

<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />

<title>Insert title here</title>
</head>

<body>
<h1>자세히보기</h1>
	<form>
		<table>
			<tr>
				<td>${memo.m_author}</td>
				<td>${memo.m_date}</td>
				<td>${memo.m_time}</td>
				<td>${memo.m_memo}</td>
				<td>${memo.m_image}</td>
			</tr>
		</table>
		<a href="${rootPath}/memo/${memo.m_seq}/update">수정</a>
		<a href="${rootPath}/memo/${memo.m_seq}/delete">삭제</a>
	</form>
</body>
</html>