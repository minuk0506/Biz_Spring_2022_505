package com.minuk.cul.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.ToString;

@ToString
public class TourRoot {

	@JsonProperty("getTourKr")
	public GetTourKr getTourKr;
	
}
