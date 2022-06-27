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
	<h1>메모추가</h1>
	<form:form modelAttribute="memoVO" enctype="multipart/form-data">
		<form:input path="m_author" placeholder="작성자" />
		<form:input path="m_date" value="${memo.m_date}" hidden="hidden" />
		<form:input path="m_time" value="${memo.m_time}" hidden="hidden" />
		<form:textarea path="m_memo" placeholder="내용" />
		<input type="file" name="file" multiple="multiple"
			accept="images/*" />
		<button>저장</button>
	</form:form>
</body>
</html>