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
public class SubwayEventVO {
	// 지하철 행사 정보
	private String rbsIdx;		//	프로그램ID
	private String doctype;	//	문서형식
	private String listcount;	//	목록개수
	private String month;		//	행사월
	private String eventtype;	//	행사종류
}
