<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="ko">

<head>
  <meta charset="UTF-8" />
  <meta http-equiv="X-UA-Compatible" content="IE=edge" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0" />
  <link rel="stylesheet" href="static/css/home.css?12dd11ssdd2s43" />
  <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css" />
  <link rel="stylesheet" href="//cdn.jsdelivr.net/npm/xeicon@2.3.3/xeicon.min.css" />
   <link rel="icon" type="image/x-icon" href="/static/img/favicon.ico">
  <title>schoolverse</title>
</head>

<body>
    <nav>

    <div class="logo">
    	<img src="/static/svg/logo.svg" alt="logo"/>
      <h1>스쿨버스</h1>
    </div>
          <c:if test="${empty USER }">
          <ul>
          	<li><a href="/user/login">로그인</a></li>
          	<li><a href="/user/join">회원가입</a></li>
          </ul>
          </c:if>
          <c:if test="${USER.role == 'GUEST' }">
          <ul>
          	<li><a href="/schedule">스케줄로</a></li>
          	<li><a href="/pay">결제하기</a></li>
          	<li><a href="/user/logout">로그아웃</a></li>
          </ul>
          </c:if>
          <c:if test="${USER.role == 'ADMIN' }">
                    <ul>
            <li><a href="/user/logout">학원등록하기</a></li>
          	<li><a href="/user/logout">로그아웃</a></li>
          	          </ul>
          </c:if>

    </nav>

  <!--헤더 끝-->
  <section class="section">
    <!--주 내용-->
    <div class="search-bar">
      <!--검색창-->
      <div class="search-detail">
        <select class="select-main" name="지역">
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
        <select class="select-main" name="과목">
        <option value="">과목</option>
          <option value="국어">국어</option>
          <option value="영어">영어</option>
          <option value="수학">수학</option>
          <option value="과학">과학</option>
          <option value="예체능">예체능</option>
          <option value="기타">기타</option>
        </select>
      </div>
      <div class="search-wall"></div>
      <div class="search-detail">
        <select class="select-main" name="나이">
        <option value="">나이</option>
          <option value="7세 이하">7세 이하</option>
          <option value="8세 ~ 10세">8세 ~ 10세</option>
          <option value="11세 ~ 13세">11세 ~ 13세</option>
          <option value="14세 ~ 16세">14세 ~ 16세</option>
          <option value="17세 ~ 19세">17세 ~ 19세</option>
          <option value="20세 이상">20세 이상</option>
        </select>
      </div>
      <div class="search-wall"></div>
      <div class="search-detail">
        <select class="select-main" name="수강료">
        <option value="">수강료</option>
          <option value="100,000원 이하">100,000원 이하</option>
          <option value="100,000원 ~ 300,000원">
            100,000원 ~ 300,000원
          </option>
          <option value="300,000원 ~ 600,000원">
            300,000원 ~ 600,000원
          </option>
          <option value="600,000원 ~ 1,000,000원">
            600,000원 ~ 1,000,000원
          </option>
          <option value="1,000,000원 이상">1,000,000원 이상</option>
        </select>
      </div>
      <div class="search-wall"></div>
            <div class="search-detail">
      <input class="select-main" type="text" placeholder="학원명을 입력해주세요"/>
      </div>
      <div class="search-wall"></div>
      <button class="search-button" onclick="location.href = '/search' ">
        <i class="xi-search xi-2x"></i>
      </button>
    </div>

<div id="artboard"></div>

  </section>
  <!--주 내용 끝-->
</body>
<script src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/js/all.min.js"></script>
<script src="/static/js/sketch.js?12dd3sssasss223"></script>
<script src="/static/js/p5.min.js"></script>

</html>