<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set value="${pageContext.request.contextPath}" var="rootPath"/>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>schoolversee</title>
    <link rel="stylesheet" href="static/css/schedule.css?12fffsddsfsdf2ss313" />
       <link rel="icon" type="image/x-icon" href="/static/img/favicon.ico">
    <script type="text/javascript" src="https://openapi.map.naver.com/openapi/v3/maps.js?ncpClientId=nanq2sq1z7"></script>
  </head>

  <body>
    <div class="wrapper">
      <div class="table">
        <table>
        <thead>
          <tr>
            <th class="top-left"></th>
            <th>09:00</th>
            <th>10:00</th>
            <th>11:00</th>
            <th>12:00</th>
            <th>13:00</th>
            <th>14:00</th>
            <th>15:00</th>
            <th>16:00</th>
            <th>17:00</th>
            <th class="bottom-left">18:00</th>
          </tr>
          </thead>
          <tbody>
          <tr data-day="mon">
            <th>월</th>
            <td data-date="09:00"></td>
            <td data-date="10:00"></td>
            <td data-date="11:00"></td>
            <td data-date="12:00"></td>
            <td data-date="13:00"></td>
            <td data-date="14:00"></td>
            <td data-date="15:00"></td>
            <td data-date="16:00"></td>
            <td data-date="17:00"></td>
            <td data-date="18:00"></td>
          </tr>
          <tr data-day="tue">
            <th>화</th>
            <td data-date="09:00"></td>
            <td data-date="10:00"></td>
            <td data-date="11:00"></td>
            <td data-date="12:00"></td>
            <td data-date="13:00"></td>
            <td data-date="14:00"></td>
            <td data-date="15:00"></td>
            <td data-date="16:00"></td>
            <td data-date="17:00"></td>
            <td data-date="18:00"></td>
          </tr>
          <tr data-day="wed">
            <th>수</th>
            <td data-date="09:00"></td>
            <td data-date="10:00"></td>
            <td data-date="11:00"></td>
            <td data-date="12:00"></td>
            <td data-date="13:00"></td>
            <td data-date="14:00"></td>
            <td data-date="15:00"></td>
            <td data-date="16:00"></td>
            <td data-date="17:00"></td>
            <td data-date="18:00"></td>
          </tr>
          <tr data-day="thu">
            <th>목</th>
            <td data-date="09:00"></td>
            <td data-date="10:00"></td>
            <td data-date="11:00"></td>
            <td data-date="12:00"></td>
            <td data-date="13:00"></td>
            <td data-date="14:00"></td>
            <td data-date="15:00"></td>
            <td data-date="16:00"></td>
            <td data-date="17:00"></td>
            <td data-date="18:00"></td>
          </tr>
          <tr data-day="fri">
            <th>금</th>
            <td data-date="09:00"></td>
            <td data-date="10:00"></td>
            <td data-date="11:00"></td>
            <td data-date="12:00"></td>
            <td data-date="13:00"></td>
            <td data-date="14:00"></td>
            <td data-date="15:00"></td>
            <td data-date="16:00"></td>
            <td data-date="17:00"></td>
            <td data-date="18:00"></td>
          </tr>
          <tr data-day="sat">
            <th>토</th>
            <td data-date="09:00"></td>
            <td data-date="10:00"></td>
            <td data-date="11:00"></td>
            <td data-date="12:00"></td>
            <td data-date="13:00"></td>
            <td data-date="14:00"></td>
            <td data-date="15:00"></td>
            <td data-date="16:00"></td>
            <td data-date="17:00"></td>
            <td data-date="18:00"></td>
          </tr>
          <tr data-day="sun">
            <th class="top-right">일</th>
            <td data-date="09:00"></td>
            <td data-date="10:00"></td>
            <td data-date="11:00"></td>
            <td data-date="12:00"></td>
            <td data-date="13:00"></td>
            <td data-date="14:00"></td>
            <td data-date="15:00"></td>
            <td data-date="16:00"></td>
            <td data-date="17:00"></td>
            <td  class="bottom-right" data-date="18:00"></td>
          </tr>
          </tbody>
        </table>
      <div class="basket">
      <c:forEach items="${CLASS}" var="CLASS" varStatus="status">
      <c:set var="SCHE" value="${SCHE}"/>
          <div class="classes"
            data-schedule="${SCHE[status.index]}" data-class_code="${CLASS.class_code}">
            ${CLASS.class_name}
          </div>
       </c:forEach>
    </div>
       <div class="sub">-</div>
</div>
      <div id="map"></div>
    </div>
      <button class="toPay" onclick="location.href = '/pay' ">
        결제하기
      </button>
      <button class="toSearch" onclick="location.href = document.referrer;">
        돌아가기
      </button>
      <h1 class="notice">마우스 클릭으로 거리를 확인하세요</h1>
  <script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=2e1d9784e6d6ac580791dd4e2c958267&libraries=services"></script>
  </body>
  <script src="static/js/schedule.js?1232fffssdfdfssfsdddfdddf2ss34"></script>
  <script src="static/js/schedule_map.js?1232dsdfdfssfdfsddddf2fsssss34"></script>
</html>
