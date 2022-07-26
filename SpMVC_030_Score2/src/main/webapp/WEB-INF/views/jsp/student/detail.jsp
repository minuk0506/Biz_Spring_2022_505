<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set value="${pageContext.request.contextPath}" var="rootPath" />

<div class="student detail_body">
	<div>학번 :</div>
	<div>${STUDENT.st_num}</div>
</div>

<div class="student detail_body">
	<div>이름 :</div>
	<div>${STUDENT.st_name}</div>
</div>

<div class="student detail_body">
	<div>학과 :</div>
	<div>${STUDENT.st_dept}</div>
</div>

<div class="student detail_body">
	<div>학년 :</div>
	<div>${STUDENT.st_grade}</div>
</div>

<div class="student detail_body">
	<div>전화 :</div>
	<div>${STUDENT.st_tel}</div>
</div>

<div class="student detail_body">
	<div>주소 :</div>
	<div>${STUDENT.st_addr}</div>
</div>

<div>
	<c:forEach items="${STUDENT.scoreList}" var="SCORE">
		<div>${SCORE.sb_name}(${SCORE.sc_sbcode} : ${SCORE.sc_score})</div>

	</c:forEach>
</div>
<div>
	<a
		href="http://localhost:8080/score/student/update">수정</a>
	<a href="http://localhost:8080/score/student">리스트로</a>
</div>