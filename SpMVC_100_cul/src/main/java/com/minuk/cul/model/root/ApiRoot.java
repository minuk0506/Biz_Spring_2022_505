package com.minuk.cul.model.root;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.ToString;

@ToString
public class ApiRoot {

	
	@JsonProperty("getTour")
	public GetTour getTour;
}
