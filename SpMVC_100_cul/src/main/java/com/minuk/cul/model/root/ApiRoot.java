package com.minuk.cul.model.root;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.ToString;

@ToString
public class ApiRoot {

	@JsonProperty("getStdm")
	public GetStdm getStdm;
	
	@JsonProperty("getTour")
	public GetTour getTour;
}
