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
<script>
	const rootPath = "${rootPath}"
</script>
<script src="${rootPath}/static/button.js?20220701009"></script>
<script src="${rootPath}/static/memo.js?20220627006"></script>
<link rel="stylesheet" href="${rootPath}/static/css.css?20220701128" />
<link rel="stylesheet"
	href="//cdn.jsdelivr.net/npm/xeicon@2.3.3/xeicon.min.css">
</head>

<body>
	<c:choose>
		<c:when test="${LAYOUT eq 'LOGIN'}">
			<img class="pin" src="${rootPath}/static/pushpin.png">
			<img class="pin2" src="${rootPath}/static/pushpin.png">
			<div class="container slide">
				<%@ include file="/WEB-INF/views/user/login.jsp"%>
			</div>
		</c:when>
		<c:when test="${LAYOUT eq 'DETAIL'}">
			<img class="pin" src="${rootPath}/static/pushpin.png">
			<img class="pin2" src="${rootPath}/static/pushpin.png">
			<div class="detail-container slide">
				<%@ include file="/WEB-INF/views/memo/detail.jsp"%>
			</div>
		</c:when>
		<c:when test="${LAYOUT eq 'INPUT'}">
			<img class="pin" src="${rootPath}/static/pushpin.png">
			<img class="pin2" src="${rootPath}/static/pushpin.png">
			<div class="container slide">
				<%@ include file="/WEB-INF/views/memo/input.jsp"%>
			</div>
		</c:when>
		<c:when test="${LAYOUT eq 'UPDATE'}">
			<img class="pin" src="${rootPath}/static/pushpin.png">
			<img class="pin2" src="${rootPath}/static/pushpin.png">
			<div class="container slide">
				<%@ include file="/WEB-INF/views/memo/input.jsp"%>
			</div>
		</c:when>
		
		<c:otherwise>
			<img class="pin" src="${rootPath}/static/pushpin.png">
			<img class="pin2" src="${rootPath}/static/pushpin.png">
			<div class="container slide">
				<fieldset> 
					<legend class="home-legend">${USERNAME}??? ??????</legend>
					<div class="home-table">
						<table class="memo">
							<tr>
								<th>SEQ</th>
								<th>????????????</th>
								<th>????????????</th>
								<th>??????</th>
							</tr>
							<c:if test="${empty MEMOS}">
								<tr>
									<td colspan="4">????????? ????????????</td>
								</tr>
							</c:if>
							<c:forEach items="${MEMOS}" var="MEMO" varStatus="INDEX">
								<tr data-seq="${MEMO.m_seq}">
									<td>${INDEX.count}</td>
									<td>${MEMO.m_date}</td>
									<td>${MEMO.m_time}</td>
									<td>${MEMO.m_memo}</td>
								</tr>
							</c:forEach>
						</table>
					</div>
				</fieldset>
				<div class="btn-memo">
					<div>
						<i class="xi-plus-circle-o"></i> <a href="${rootPath}/memo/insert">??????????????????</a>
					</div>
					<div>
						<c:if test="${empty USERNAME}">
							<i class="xi-log-in"></i>
							<a href="${rootPath}/user/login">???????????????</a>
						</c:if>
						<c:if test="${not empty USERNAME }">
							<i class="xi-log-out"></i>
							<a href="${rootPath}/user/logout">??????????????????</a>
						</c:if>
					</div>
				</div>
			</div>
		</c:otherwise>
	</c:choose>
</body>
</html>