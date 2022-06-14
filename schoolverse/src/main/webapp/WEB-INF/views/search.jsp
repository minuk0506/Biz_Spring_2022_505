<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set value="${pageContext.request.contextPath}" var="rootPath"/>
<!DOCTYPE html>
<html lang="ko">

<head>
  <meta charset="UTF-8" />
  <meta http-equiv="X-UA-Compatible" content="IE=edge" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0" />
  <title>schoolverse</title>
     <link rel="icon" type="image/x-icon" href="/static/img/favicon.ico">
  <!-- <script type="text/javascript" src="https://openapi.map.naver.com/openapi/v3/maps.js?ncpClientId=nanq2sq1z7"></script> -->
</head>
<link rel="stylesheet" href="static/css/reset.css?123412sss21234" />
<link rel="stylesheet" href="static/css/search.css?123s22s2s123e34" />
<link rel="stylesheet" href="static/css/basket.css?12112ss123234">
<link rel="stylesheet" href="//cdn.jsdelivr.net/npm/xeicon@2.3.3/xeicon.min.css">

<body>
  <aside class="aside">
    <div>
      <div id="nav">
        <form>
          <div class="search-bar">
            <input id="keyword"/>
            <button onclick="location.href = '/search'">
              <i class="xi-search xi-2x"></i>
            </button>
          </div>
        </form>
      </div>

      <div id="edu_list">
        <div>
          <table class="academy">
		<c:forEach items="${ACA}" var="ACA">
            <tr >
              <th data-aca_code = "${ACA.aca_code}">${ACA.aca_name}</th>
            </tr>
		</c:forEach>
          </table>
        </div>
      </div>
    </div>
    <button class="aside_btn">
      <i class="xi-angle-left xi-2x"></i>
      <i style="display:none" class="xi-angle-right xi-2x"></i>
    </button>

    <button class="toHome" onclick="location.href = '/' ">홈으로</button>
    <button class="toSchedule" onclick="location.href = '/schedule' ">스케줄로</button>

  </aside>

  <!-- ///////////////////////////////////////////////////////////////////////// -->

  <div id="map" style="width:100vw; height:100vh;"></div>
  
  <!-- ///////////////////////////////////////////////////////////////////////// -->
  
    <!-- 장바구니 시작 -->
  <div class="basket-button"><i class="xi-cart-o xi-2x"></i>
    <span class="count"></span>
  </div>
  
  <div class="wrapper">
    <div class="toggle_button">
      <i class="xi-angle-right xi-2x"></i>
    </div>
    <div class="sub-wrapper">
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
    <!--sub_wrapper end -->
    <h1 class="sum"></h1>
  </div>
  <!-- wrapper end -->
  
  <!-- ///////////////////////////////////////////////////////////////////////// -->
  
  <section class="section">
    <div class="put-in">
      <div class="put-in-btn">
        <i class="xi-angle-right xi-2x"></i>
      </div>
      <div class="content">
        <div class="img"></div>
      <div class="info">
        
          <div>
            <h1 class="aca_name"></h1>
          </div>
          
          <p class="aca_info">
          </p>
          
        </div>
        <div class="teacher">
        
          <h2>선생님소개</h2>
          
          <div class="teacher-info">
            <img src="static/img/teacher1.jpg" />
            <div>
              <h3>주혜연 선생님</h3>
              <p>귀에 쏙 꽂히는 영어강의 No.1!!</p>
            </div>
          </div>
          
          <div class="teacher-info">
            <img src="static/img/teacher2.png" />
            <div>
              <h3>김보라 선생님</h3>
              <p>차근차근 기초부터 쌓아가는 탄탄영어의 탑!!</p>
            </div>
          </div>
        </div>
        
        <div class="others"></div>
      </div>
    </div>
  </section>
  
</body>
<script src="static/js/search.js?1231s2ssss2fdss3223"></script>
<script src="static/js/basket.js?1231s2dssss2ss23323"></script>
<!-- <script src="static/js/map_search.js?1212ssss2ss233123"></script> -->
<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=40dea0e310add7b952e4c081dd860973&libraries=services,clusterer,drawing"></script>
<script src="/static/js/kakao.js?ver=22-06-14-016"></script>
</html>