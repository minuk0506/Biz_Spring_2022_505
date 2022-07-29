<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set value="${pageContext.request.contextPath}" var="rootPath" />
	<h1>여기는 Admin Page</h1>
	<form>
		<table>
		<thead>
			<tr>
				<th>아이디</th>
				<th>Email</th>
				<th>실명</th>
				<th>닉네임</th>
				<th>전화번호</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${USERLIST}" var="DATA">
			<tr>
				<td><a href="${rootPath}/admin/update?username=${DATA.username}">${DATA.username}</a></td>
				<!-- <td>${DATA.username}</td> -->
				<td>${DATA.email}</td>
				<td>${DATA.realname}</td>
				<td>${DATA.nickname}</td>
				<td>${DATA.tel}</td>
			</tr>
			</c:forEach>
			</tbody>
		</table>
	</form>