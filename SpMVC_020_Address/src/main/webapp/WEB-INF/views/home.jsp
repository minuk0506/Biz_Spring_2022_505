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
<link rel="stylesheet" href="${rootPath}/resources/css/css.css?000022">
<title>Insert title here</title>
</head>

<body>
<div class="body">
	<div class="container">
		<header class="head">
			<h1 class="title">주소록</h1>
		</header>
		<section class="sect">
		<div class="insertAddr">
			<form method="POST">
				<input name="a_seq" type="hidden"
					value='<c:out value="${ADDR.a_seq}" default="0"/>'> <input
					name="a_name" placeholder="이름" value="${ADDR.a_name}"> <input
					name="a_tel" placeholder="전화번호" value="${ADDR.a_tel}"> <input
					name="a_address" placeholder="주소" value="${ADDR.a_address}">
				<button>저장</button>
			</form>
		</div>
		<div class="selectAddr">
				<c:forEach items="${DATAS}" var="DATA">
				<table>
					<tr>
						<td><a href="${rootPath}/detail?seq=${DATA.a_seq}">${DATA.a_name}</a></td>
						<td>${DATA.a_tel}</td>
						<td>${DATA.a_address}</td>
					</tr>
			</table>
				</c:forEach>
		</div>
				<%@include file="/WEB-INF/views/pagination.jsp" %>
		</section>
		<footer class="foot">
		<address>CopyRight &copy; minuk</address>
		</footer>
	</div>
	</div>
</body>
</html>