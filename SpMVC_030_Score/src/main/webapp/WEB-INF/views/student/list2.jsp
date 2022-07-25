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
	<form>
		<table>
			<tr>
			<td>학번</td>
			<td>이름</td>
			<td>학과</td>
			<td>학년</td>
			<td>전화</td>
			<td>주소</td>
			</tr>
			<c:forEach items="${DATA}" var="DATA">
				<tr>
					<td>${DATA.st_num}</td>
					<td>${DATA.st_name}</td>
					<td>${DATA.st_dept}</td>
					<td>${DATA.st_grade}</td>
					<td>${DATA.st_tel}</td>
					<td>${DATA.st_addr}</td>
				</tr>
			</c:forEach>
		</table>
	</form>
</body>
</html>