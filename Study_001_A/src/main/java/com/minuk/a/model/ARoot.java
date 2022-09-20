package com.minuk.a.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.ToString;

@ToString
public class ARoot {
	@JsonProperty("MsmArtGlrBaseInfo")
	public List<AVO> MsmArtGlrBaseInfo;
	
	@JsonProperty("header")
	public Header header;
	
	public class Header{
		public String totalPage;
		public String pageNo;
		public String resultCode;
		public String totalCount;
		public String numOfRows;
		public String resultMsg;
	}
}
