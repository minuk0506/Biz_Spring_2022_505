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
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<title>Insert title here</title>
</head>
<body>
	<!-- 
	관광지(위,경도 있음)
	향토문화유적(위,경도 있음)
	
	박물관(위,경도 있음)
	미술관(위,경도 있음)
	체육시설(위,경도 없음)
	
	축제
	공연행사정보
	도시철도 공연행사정보
	----관광지----
	코드			id
	관광지명		tourDestNm
	주소			addrRoad
	위도			lat
	경도			lng
	공공편익시설	publicConvFcltInfo
	운동, 오락시설	sportsEnterFcltInfo
	수용인원수		capacity
	주차가능수		availParkingCnt
	관광지소개		tourDestIntro
	전화번호		mngAgcTel
	관리기관		mngAgcNm
	데이터 기준일	syncTime
	
	----향토문화유적----
	코드					id	20	필	1	코드
	향토문화유적명			localCultHeritNm
	향토문화유적지정번호	localCultHeritCode
	향토문화유적구분		classifiLocalCultHeri
	향토문화유적종류		localCultHeritTypeNm
	소재지 도로명주소		addrRoad
	소재지 지번주소			addrJibun
	위치 좌표 위도			lat	50
	위치 좌표 경도			lng	50
	조성시대				eraCreation
	이미지 정보				photo
	향토문화유적 소개		localCultHeritIntro
	관리기관전화번호		mngAgcTel
	관리기관				mngAgcNm
	데이터기준일자			syncTime
	
	----박물관, 미술관----
	코드					id
	시설명					msmArtGlrNm
	박물관미술관구분		operationRuleNm
	소재지 도로명주소		addrRoad
	소재지 지번주소			addrJibun
	위치 좌표 위도			lat
	위치 좌표 경도			lng
	운영기관전화번호		operationAgcTel
	운영기관				operationAgcNm
	운영기관 홈페이지		homePage
	편의시설 정보			convFcltInfo
	평일 관람 시작시각		weekdayBeginTime
	평일 관람 종료시각		weekdayEndTime
	공휴일 운영 시작시각	holidayBeginTime
	공휴일 운영 종료시각	holidayEndTime
	휴관정보				closeInfo
	어른관람료				adultAdmsFee
	청소년관람료			youthAdmsFee
	어린이관람료			childAdmsFee
	관람료기타정보			admsFeeOtherInfo
	박물관미술관 소개		msmArtGlrIntro
	교통안내 정보			trafficInfo
	관리기관전화번호		mngAgcTel
	관리기관				mngAgcNm
	데이터기준일자			syncTime
	
	----체육시설----
	
	순번			num
	경기장구분		stdm_ty
	시도			sido	
	시군구			sigungu_nm
	시설명			faclt_nm
	관람석_좌석수	audtrm_seat_aceptnc_psn	
	
	----축제----
	id					코드
	festivalNm			축제명
	festivalVenue		개최장소
	festivalBeginDate	축제 시작일자
	festivalEndDate		축제 종료일자
	festivalInfo		축제 내용
	manageAgcNm			주관기관
	auspiceAgcNm		주최기관
	sponsorAgcNm		후원기관
	tel					전화번호
	homePage			홈페이지주소
	relatedInfo			관련정보
	addrRoad			소재지 도로명주소
	addrJibun			소재지 지번주소
	lat					위치 좌표 위도
	lng					위치 좌표 경도
	syncTime			데이터기준일자
	
	----공연행사정보----
	id				코드
	eventNm			행사명
	eventVenue		장소
	eventInfo		행사내용
	eventBeginDate	행사 시작일자
	eventEndDate	행사 종료일자
	eventBeginTime	행사 시작시각
	eventEndTime	행사 종료시각
	payYn			요금정보
	manageAgcNm		주관기관
	auspiceAgcNm	주최기관
	tel				전화번호
	sponsorAgcNm	후원기관
	seatCount		객석수
	price			관람요금
	enterAge		입장연령
	discountInfo	할인정보
	notice			유의사항
	homePage		홈페이지주소
	rsrvtInfo		예매정보
	parkingLotAvail	주차장보유여부
	addrRoad		소재지 도로명 주소
	addrJibun		소재지 지번 주소
	lat				위치 좌표 위도
	lng				위치 좌표 경도
	syncTime		데이터기준일자
	
	----도시철도 공연행사정보----
	excur_date		행사일자
	excur_date		행사시간
	subject			행사명	 
	station_area	장소(역명)	 
	cal_user		전시자/공연자
	-->

</body>
</html>