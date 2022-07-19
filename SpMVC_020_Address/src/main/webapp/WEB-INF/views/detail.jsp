<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set value="${pageContext.request.contextPath}" var="rootPath"/>

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
	<div class="info">
		<div><h1>seq : </h1><h2>${DATA.a_seq}</h2></div>
		<div><h1>이름 : </h1><h2>${DATA.a_name}</h2></div>
		<div><h1>전화번호 : </h1><h2>${DATA.a_tel}</h2></div>
		<div><h1>주소 : </h1><h2>${DATA.a_address}</h2></div>		
	</div>
	<div class="btn">
		<a href="${rootPath}/update?seq=${DATA.a_seq}">수정하기</a>
		<a href="${rootPath}/delete?seq=${DATA.a_seq}">삭제하기</a>
		<a href="${rootPath}/">처음으로</a>
	</div>
	</div>
	</div>
</body>
</html>