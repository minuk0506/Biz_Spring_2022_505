package com.minuk.cul.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.ToString;

@ToString
public class GetTourKr {
	
	@JsonProperty("header")
	public Header header;
	
	@JsonProperty("item")
	public List<TourVO> item;
	
	@ToString
	public class Header{
		public String code;
		public String message;
		
	}
	
	
}
