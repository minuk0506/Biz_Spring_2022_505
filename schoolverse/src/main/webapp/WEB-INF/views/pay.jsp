<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set value="${pageContext.request.contextPath}" var="rootPath"/>
<!DOCTYPE html>
<html lang="ko">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>schoolverse</title>
    <link rel="stylesheet" href="static/css/pay.css?1111ssfffdf1ss111">
    <link rel="stylesheet" href="//cdn.jsdelivr.net/npm/xeicon@2.3.3/xeicon.min.css">
       <link rel="icon" type="image/x-icon" href="/static/img/favicon.ico">
</head>

<body>
    <aside class="pay_aside">
        <div id="edu_list">
<c:forEach items="${CLASS }" var="CLASS">
      <div class="classes" data-aca_code = "${CLASS.aca_code}" data-class_code = "${CLASS.class_code}" data-expense = "${CLASS.class_fee }">
        <div class="content-section">
          <h1 class="title">${CLASS.class_name }</h1>
          <hr>
          <h2 class="fee">${CLASS.class_fee.replaceAll("\\B(?=(\\d{3})+(?!\\d))", ",")}원/월</h2>
        </div>
        <div class="sub">-</div>
      </div>
</c:forEach>
        </div>
        <button class="backToSchedule" onclick="window.history.back()">돌아가기</button>
    </aside>
    <div class="payment_wrapper">
        <div id="box">
            <div>
                <h1>총액 : 470,000원/월</h1>
            </div>
            <button onclick="location.href = '/thanks'" class="pay-button">결제하기</button>
        </div>
    </div>
</body>
<script src="static/js/pay.js?12saaasdddsssdsfsdsdf1ss32"></script>

</html>