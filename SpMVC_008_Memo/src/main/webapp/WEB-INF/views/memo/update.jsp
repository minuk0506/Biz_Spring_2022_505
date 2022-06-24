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
	<h1>수정</h1>
	<form method="POST" enctype="multipart/form-data">
			<input name="m_upauthor" value="${memo.m_author}" />
			<input name="m_update" value="${memo.m_date}" hidden="hidden"/>
			<input name="m_uptime" value="${memo.m_time}" hidden="hidden" />
			<textarea name="m_upmemo" value="${memo.m_memo}"></textarea>
			<img src="c:/file/upload/${memo.m_image}" />
		<button>저장</button>
	</form>
</body>
</html>