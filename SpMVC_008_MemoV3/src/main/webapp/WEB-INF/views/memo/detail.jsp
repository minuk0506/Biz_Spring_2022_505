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
	<div class="detail-writeData">
		<div>작성자 : ${MEMO.m_author}</div>
		<div>작성일자 : ${MEMO.m_date}</div>
		<div>작성시각 : ${MEMO.m_time}</div>
	</div>
	<div class="detail-memoData">
	<fieldset>
			<legend>메모</legend>
			<div class="memoData">${MEMO.m_memo}</div>
		</fieldset>
		<fieldset>
		<legend>이미지</legend>
		<div>
			<img src="${rootPath}/upload/${MEMO.m_up_image}"
				alt="${MEMO.m_image}" width="100px">
		</div>
				</fieldset>
	</div>
	<div class="detail-div-button">
		<a href="${rootPath}/memo/${MEMO.m_seq}/update">수정</a> <a
			href="${rootPath}/memo/${MEMO.m_seq}/delete">삭제</a> <a
			href="${rootPath}/">홈으로</a>
	</div>
</body>
</html>