<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set value="${pageContext.request.contextPath}" var="rootPath"/>

<form method="POST">
		<input name="st_name" placeholder="이름" value="${STUDENT.st_name}">
		<input name="st_dept" placeholder="학과" value="${STUDENT.st_dept}">
		<input name="st_grade" placeholder="학년" value="${STUDENT.st_grade}">
		<input name="st_tel" placeholder="전화" value="${STUDENT.st_tel}">
		<input name="st_addr" placeholder="주소" value="${STUDENT.st_addr}">
		<button>수정</button>		
	</form>