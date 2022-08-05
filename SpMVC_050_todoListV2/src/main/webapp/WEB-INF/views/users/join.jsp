<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set value="${pageContext.request.contextPath}" var="rootPath"/>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />

<title>Insert title here</title>
</head>

<body>
	<h1>join</h1>
	<form:form>
		<input name="username" placeholder="아이디">
		<input name="password" type="password" placeholder="비밀번호">
		<input name="re_password" type="password" placeholder="비밀번호">
		<input name="email" placeholder="이메일">
		<input name="realname" placeholder="이름">
		<input name="nickname" placeholder="닉네임">
		<div><button>저장</button></div>
	</form:form>
</body>
</html>