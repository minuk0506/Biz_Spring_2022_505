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
<h1>메모추가</h1>
	<div>
		<form method="POST" enctype="multipart/form-data">
			<input name="m_upauthor" placeholder="작성자"/>
			<input name="m_update" type="date" value="${memo.m_date}" hidden="hidden"/>
			<input name="m_uptime" type="time" value="${memo.m_time}" hidden="hidden"/>
			<textarea name="m_upmemo" placeholder="내용"></textarea>
			<input type="file" name="m_upimage" multiple="multiple" accept="images/*" />
			<button>저장</button>
		</form>
	</div>
</body>
</html>