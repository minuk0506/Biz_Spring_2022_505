<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set value="${pageContext.request.contextPath}" var="rootPath" />

<script src="${rootPath}/static/js/detail.js?ver=2022-06-03-009"></script>

<h1>도서정보 리스트 보여주기</h1>

<a href="${rootPath}/books/insert">도서 정보 추가</a>
<table>
	<tr>
		<th>No.</th>
		<th>ISBN</th>
		<th>도서명</th>
		<th>출판사</th>
		<th>저자</th>
		<th>출판일자</th>
	</tr>
	<c:forEach items="${LIST}" var="book">
		<tr data-title="${book.title}" class="book">
			<td>1</td>
			<td>${book.isbn}</td>
			<td >${book.title}</td>
			<td>${book.publisher}</td>
			<td>${book.author}</td>
			<td>${book.pubdate}</td>
		</tr>
	</c:forEach>
</table>