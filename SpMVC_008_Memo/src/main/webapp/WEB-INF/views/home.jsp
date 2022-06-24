<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
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
<h1>홈</h1>
<h1>메모리스트</h1>
	<form>
		<table>
			<tr>
				<td>작성자</td>
				<td>작성일자</td>
				<td>작성시각</td>
				<td>메모내용</td>
				<td>이미지파일</td>
			</tr>
			<c:forEach items="${memoList}" var="memoList">
				<tr>
					<td><a href="${rootPath}/memo/detail/${memoList.m_seq}">${memoList.m_author}</a></td>
					<td><a href="${rootPath}/memo/detail/${memoList.m_seq}">${memoList.m_date}</a></td>
					<td><a href="${rootPath}/memo/detail/${memoList.m_seq}">${memoList.m_time}</a></td>
					<td><a href="${rootPath}/memo/detail/${memoList.m_seq}">${memoList.m_memo}</a></td>
					<td><a href="${rootPath}/memo/detail/${memoList.m_seq}"><img src="c:/file/upload/${memoList.m_image}"/></a></td>
				</tr>
			</c:forEach>
		</table>
		<a href="${rootPath}/memo/insert">메모추가</a>
	</form>
</body>
</html>