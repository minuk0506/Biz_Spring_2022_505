package com.minuk.cul.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TourVO {
	//관광지(위,경도 있음)
	private String totalPage;				//전체 페이지 수
	private String pageNo;					//페이지 번호
	private String resultCode;				//결과코드
	private String totalCount;				//데이터 총 개수
	private String numOfRows;				//한 페이지 결과 수
	private String resultMsg;				//결과메세지
	private String id;						//코드
	private String tourDestNm;				//관광지명
	private String operationRuleNm;			//관광지 구분
	private String addrRoad;				//소재지 도로명주소
	private String addrJibun;				//소재지 지번주소
	private String lat;						//위치 좌표 위도
	private String lng;						//위치 좌표 경도
	private String area;					//면적
	private String publicConvFcltInfo;		//공공편익시설 정보
	private String accomInfo;				//숙박시설 정보
	private String sportsEnterFcltInfo;		//운동 및 오락시설 정보
	private String recreationalCultFcltInfo;//휴양 및 문화시설 정보
	private String hospitalityFcltInfo;		//접객시설 정보
	private String supportFcltInfo;			//지원시설 정보
	private String dsgnDate;				//지정일자
	private String capacity;				//수용인원수
	private String availParkingCnt;			//주차가능수
	private String tourDestIntro;			//관광지소개
	private String mngAgcTel;				//관리기관전화번호
	private String mngAgcNm;				//관리기관
	private String syncTime;				//데이터기준일자

}
