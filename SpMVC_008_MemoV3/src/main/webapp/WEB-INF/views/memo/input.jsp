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
	<form class="input-form" method="POST" enctype="multipart/form-data">
		<input name="m_seq" type="hidden"
			value='<c:out value="${MEMO.m_seq}" default= "0"/>'>
			<input
			class="input-form-memo" name="m_memo" placeholder="메모를 입력"
			value="${MEMO.m_memo}">
			<div class="insert-file">
			<label class="input-button" for="input-file">파일선택</label>
			<input id="input-file" name="file" type="file"
			accept="image/*">
			<div class="upload-name"></div>
			</div>
		<button><i class="xi-pen"></i>메모기록</button>
	</form>
</body>
</html>