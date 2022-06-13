<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set value="${pageContext.request.contextPath}" var="rootPath" />
<!DOCTYPE html>
<html lang="ko">

<head>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>academy-info</title>

</head>
<link rel="stylesheet" href="${rootPath }/resources/css/reset.css" />
<link rel="stylesheet"
	href="${rootPath }/resources/css/search.css?ver=22-06-13-001" />
<link rel="stylesheet"
	href="${rootPath }/resources/css/basket.css?ver=22-06-13-001">
<link rel="stylesheet"
	href="//cdn.jsdelivr.net/npm/xeicon@2.3.3/xeicon.min.css">
<script type="text/javascript"
	src="//dapi.kakao.com/v2/maps/sdk.js?appkey=40dea0e310add7b952e4c081dd860973&libraries=services,clusterer,drawing"></script>
<link rel="stylesheet"
	href="${rootPath }/resources/css/kakao.css?ver=22-06-13-004">
<body>
	<div class="map_wrap">
		<div id="map"></div>
	</div>
	<aside class="aside">
		<div>
			<div id="nav">
				<div id="menu_wrap" class="bg_white">
					<div class="option">
						<div>
							<form onsubmit="searchPlaces(); return false;" method="POST">
								키워드 : <input type="text" value="광주" id="keyword" size="15">
								<button type="submit">검색하기</button>
							</form>
						</div>
					</div>
				</div>
				<form>
					<div class="search-bar">

						<!-- 검색창 <select name="지역">
							<option value="">지역</option>
							<option value="광산구">광산구</option>
							<option value="남구">남구</option>
							<option value="동구">동구</option>
							<option value="북구">북구</option>
							<option value="서구">서구</option>
						</select> <input type="text" placeholder="과목" /> <select name="나이">
							<option value="7세 이하">7세 이하</option>
							<option value="8세 ~ 10세">8세 ~ 10세</option>
							<option value="11세 ~ 13세">11세 ~ 13세</option>
							<option value="14세 ~ 16세">14세 ~ 16세</option>
							<option value="17세 ~ 19세">17세 ~ 19세</option>
							<option value="20세 이상">20세 이상</option>
						</select> <select name="수강료">
							<option value="100,000원 이하">100,000원 이하</option>
							<option value="100,000원 ~ 300,000원">100,000원 ~ 300,000원
							</option>
							<option value="300,000원 ~ 600,000원">300,000원 ~ 600,000원
							</option>
							<option value="600,000원 ~ 1,000,000원">600,000원 ~
								1,000,000원</option>
							<option value="1,000,000원 이상">1,000,000원 이상</option>
						</select>

						<button onclick="location.href = './academy-info.html'">
							<i class="xi-search xi-2x"></i>
						</button> -->
					</div>
				</form>

			</div>

			<div id="edu_list">
				<ul id="placesList"></ul>
				<div id="pagination"></div>
				<!-- <div>
					<table>
						<tr>
							<th>yy영어학원</th>
						</tr>
						<tr>
							<th>zz영어학원</th>
						</tr>
						<tr>
							<th>xx수학학원</th>
						</tr>
						<tr>
							<th>oo피아노학원</th>
						</tr>
						<tr>
							<th>kk태권도</th>
						</tr>
						<tr>
							<th>yy영어학원</th>
						</tr>
						<tr>
							<th>zz영어학원</th>
						</tr>
						<tr>
							<th>xx수학학원</th>
						</tr>
						<tr>
							<th>oo피아노학원</th>
						</tr>
						<tr>
							<th>kk태권도</th>
						</tr>
						<tr>
							<th>yy영어학원</th>
						</tr>
						<tr>
							<th>zz영어학원</th>
						</tr>
						<tr>
							<th>xx수학학원</th>
						</tr>
						<tr>
							<th>oo피아노학원</th>
						</tr>
						<tr>
							<th>kk태권도</th>
						</tr>
					</table>
				</div> -->
			</div>
		</div>
		<button class="aside_btn">
			<i class="xi-angle-left xi-2x"></i> <i style="display: none"
				class="xi-angle-right xi-2x"></i>
		</button>
		<button class="toSchedule" onclick="location.href = '/api/schedule' ">스케줄로</button>
	</aside>

	<!-- ////////////////////////////////////// -->
	<section class="section">
		<div class="put-in">
			<div class="put-in-btn">
				<i class="xi-angle-right xi-2x"></i>
			</div>
			<div class="content">
				<div class="img"></div>
				<div class="info">
					<div>
						<h1>yy영어학원</h1>
						<i id="add_btn" class="xi-plus xi-3x"></i>
					</div>
					<h2>수강료 : 300,000원</h2>
					<p>yy영어학원은 교육 수준의 향상과 교육의 본질적 가치에 가장 큰 의의를 두고, 해외 명문대 진학을 위한
						최고의 교육 서비스를 제공하는 학원입니다.</p>
				</div>
				<div class="teacher">
					<h2>선생님소개</h2>
					<div class="teacher-info">
						<img src="${rootPath }/resources/img/teacher1.jpg" />
						<div>
							<h3>주혜연 선생님</h3>
							<p>귀에 쏙 꽂히는 영어강의 No.1!!</p>
						</div>
					</div>
					<div class="teacher-info">
						<img src="${rootPath }/resources/img/teacher2.png" />
						<div>
							<h3>김보라 선생님</h3>
							<p>차근차근 기초부터 쌓아가는 탄탄영어의 탑!!</p>
						</div>
					</div>
				</div>
				<div class="others">
					<h2>시간표</h2>
					<p>월요일 9:00 - 12:00</p>
					<p>수요일 9:00 - 12:00</p>
					<p>금요일 9:00 - 12:00</p>
				</div>
			</div>
		</div>
	</section>
	<!-- 장바구니 시작 -->
	<div class="basket-button">
		<i class="xi-cart-o xi-2x"></i> <span class="count"></span>
	</div>
	<div class="wrapper">
		<div class="toggle_button">
			<i class="xi-angle-right xi-2x"></i>
		</div>
		<div class="sub-wrapper">
			<div class="classes"
				data-schedule="mon_13:00,mon_14:00,mon_15:00,mon_16:00,wed_13:00,wed_14:00,wed_15:00,wed_16:00,fri_13:00,fri_14:00,fri_15:00,fri_16:00"
				data-expense="300000">
				<div class="content-section">
					<h1 class="title">yy영어학원</h1>
					<hr>
					</h2>
					<h2 class="fee">300,000원/월</h2>
				</div>
				<div class="sub">-</div>
			</div>

			<div class="classes"
				data-schedule="tue_13:00,tue_14:00,tue_15:00,tue_16:00,fri_13:00,fri_14:00,fri_15:00,fri_16:00"
				data-expense="200000">
				<div class="content-section">
					<h1 class="title">zz영어학원</h1>
					<hr>
					</h2>
					<h2 class="fee">200,000원/월</h2>
				</div>
				<div class="sub">-</div>
			</div>
			<div class="classes"
				data-schedule="mon_09:00,mon_10:00,mon_11:00,wed_09:00,wed_10:00,wed_11:00,fri_09:00,fri_10:00,fri_11:00"
				data-expense="300000">
				<div class="content-section">
					<h1 class="title">xx수학학원</h1>
					<hr>
					</h2>
					<h2 class="fee">300,000원/월</h2>
				</div>
				<div class="sub">-</div>
			</div>
			<div class="classes"
				data-schedule="mon_10:00,mon_11:00,mon_12:00,mon_13:00,tue_10:00,tue_11:00,tue_12:00,tue_13:00"
				data-expense="200000">
				<div class="content-section">
					<h1 class="title">oo피아노학원</h1>
					<hr>
					</h2>
					<h2 class="fee">200,000원/월</h2>
				</div>
				<div class="sub">-</div>
			</div>
			<div class="classes"
				data-schedule="mon_18:00,wed_18:00,fri_18:00,sat_18:00"
				data-expense="180000">
				<div class="content-section">
					<h1 class="title">kk태권도</h1>
					<hr>
					<h2 class="fee">180,000원/월</h2>
				</div>
				<div class="sub">-</div>
			</div>
		</div>
		<!--sub_wrapper end -->

		<h1 class="sum"></h1>
	</div>
	<!-- wrapper end -->



</body>

<script src="${rootPath }/resources/js/basket.js"></script>
<script src="${rootPath }/resources/js/search.js"></script>
<script src="${rootPath }/resources/js/kakao.js?ver=22-06-13-008"></script>

</html>