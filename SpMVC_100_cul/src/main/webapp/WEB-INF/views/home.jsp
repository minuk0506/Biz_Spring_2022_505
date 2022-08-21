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

<title>Insert title here</title>
</head>

<body>
<h1>홈</h1>
<c:forEach items="${TOURS}" var="TOUR">
	<p>관광지 : ${TOUR.tourDestNm}<p>
</c:forEach>
<c:forEach items="${RUINS}" var="RUIN">
	<p>유적 : ${RUIN.localCultHeritNm}<p>
</c:forEach>
<c:forEach items="${MSMARTGLRS}" var="MSMARTGLR">
	<p>박물관, 미술관 : ${MSMARTGLR.msmArtGlrNm}<p>
</c:forEach>
<c:forEach items="${FESTIVALS}" var="FESTIVAL">
	<p>축제 : ${FESTIVAL.festivalNm}<p>
</c:forEach>
<c:forEach items="${EVENTS}" var="EVENT">
	<p>행사 : ${EVENT.eventNm}<p>
</c:forEach>
</body>
</html>