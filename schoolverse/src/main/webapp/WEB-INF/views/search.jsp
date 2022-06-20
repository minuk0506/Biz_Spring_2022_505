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
  <script type="text/javascript" src="https://openapi.map.naver.com/openapi/v3/maps.js?ncpClientId=nanq2sq1z7"></script>
</head>
<link rel="stylesheet" href="static/css/reset.css?123d41sf2f21234" />
<link rel="stylesheet" href="static/css/search.css?123fsddfffs123e34" />
<link rel="stylesheet" href="static/css/basket.css?121sfdfd123234">
<link rel="stylesheet" href="//cdn.jsdelivr.net/npm/xeicon@2.3.3/xeicon.min.css">

<body>
  <aside class="aside">
    <div>
      <div id="nav">
      
        <form>
<div class="search-bar">
      <!--검색창-->
      <div class="search-detail">
        <select class="select-main" name="aca_region">
          <option value="">지역</option>
          <option value="광산구">광산구</option>
          <option value="남구">남구</option>
          <option value="동구">동구</option>
          <option value="북구">북구</option>
          <option value="서구">서구</option>
        </select>
      </div>
      <div class="search-wall"></div>
      <div class="search-detail">
        <select class="select-main" name="aca_subject">
        <option value="">과목</option>
          <option value="입시">입시</option>
          <option value="영어">영어</option>
          <option value="예체능">예체능</option>
          <option value="기타">기타</option>
        </select>
      </div>
      <div class="search-wall"></div>
      <div class="search-detail">
        <select class="select-main" name="aca_age">
        <option value="">나이</option>
          <option value="학생">학생</option>
          <option value="성인">성인</option>
        </select>
      </div>
      <div class="search-wall"></div>
      <button class="search-button" onclick="location.href = '/search' ">
        <i class="xi-search xi-2x"></i>
      </button>
    </div>
        </form>
        
      </div>

      <div id="edu_list">
        <div>
          <table class="academy">
		<c:forEach items="${SEARCH}" var="SEARCH">
            <tr >
              <th data-aca_code = "${SEARCH.aca_code}">${SEARCH.aca_name}</th>
            </tr >
		</c:forEach>
            <c:if test="${ERROR == 'EMPTY'}">
            <tr >
              <th style="color:red;font-weight:bold;">검색 결과가 없습니다.</th>
            </tr >
            </c:if>
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
<c:forEach items="${CLASSES}" var="CLASS">
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

          </div>
        </div>
        
        <div class="others"></div>
      </div>
    </div>
  </section>
  <script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=2e1d9784e6d6ac580791dd4e2c958267&libraries=services"></script>
</body>
<script src="static/js/search.js?12hhffddsdffdfssf3fsss22116"></script>
<script src="static/js/basket.js?1231ffssdffdf12s23323"></script>
<script src="static/js/map.js?1212ssfssdf1dfdff123"></script>
</html>