package com.minuk.cul.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.ToString;

@ToString
public class TourRoot {

	@JsonProperty("TourDestBaseInfo")
	public List<TourVO> TourDestBaseInfo;
	
}
