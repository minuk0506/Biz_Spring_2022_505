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
    <title>My Page</title>
    <link rel="stylesheet" href="${rootPath }/resources/css/schedule.css" />
    <script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=40dea0e310add7b952e4c081dd860973&libraries=services,clusterer,drawing"></script>
  </head>
  <script src="${rootPath }/resources/js/kakaomap.js?ver=22-06-08-009"></script>
  <body>
    <div class="wrapper">
      <div class="table">
        <table>
          <tr>
            <th></th>
            <th>09:00</th>
            <th>10:00</th>
            <th>11:00</th>
            <th>12:00</th>
            <th>13:00</th>
            <th>14:00</th>
            <th>15:00</th>
            <th>16:00</th>
            <th>17:00</th>
            <th>18:00</th>
          </tr>
          <tr data-day="mon">
            <th>mon</th>
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
            <th>tue</th>
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
            <th>wed</th>
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
            <th>thu</th>
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
            <th>fri</th>
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
            <th>sat</th>
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
            <th>sun</th>
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
        </table>

        <div class="basket">
          <div
            class="classes"
            data-schedule="mon_09:00,mon_10:00,mon_11:00,wed_09:00,wed_10:00,wed_11:00,fri_09:00,fri_10:00,fri_11:00"
          >
            xx수학학원
          </div>
          <div
            class="classes"
            data-schedule="tue_13:00,tue_14:00,tue_15:00,tue_16:00,fri_13:00,fri_14:00,fri_15:00,fri_16:00"
          >
            zz영어학원
          </div>
          <div
            class="classes"
            data-schedule="mon_13:00,mon_14:00,mon_15:00,mon_16:00,wed_13:00,wed_14:00,wed_15:00,wed_16:00,fri_13:00,fri_14:00,fri_15:00,fri_16:00"
          >
            yy영어학원
          </div>
          <div
            class="classes"
            data-schedule="mon_10:00,mon_11:00,mon_12:00,mon_13:00,tue_10:00,tue_11:00,tue_12:00,tue_13:00"
          >
            oo피아노학원
          </div>
          <div
            class="classes"
            data-schedule="mon_18:00,wed_18:00,fri_18:00,sat_18:00"
          >
            kk태권도
          </div>
        </div>
        <div class="sub">-</div>
      </div>
      <div id="map"></div>

      <button class="toPay" onclick="location.href = '/api/pay' ">
        결제하기
      </button>
      <button class="toSearch" onclick="location.href = '/api/search' ">
        돌아가기
      </button>
    </div>
  </body>

  <script src="${rootPath }/resources/js/schedule.js"></script>
</html>
