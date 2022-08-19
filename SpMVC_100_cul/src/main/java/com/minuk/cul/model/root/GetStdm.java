package com.minuk.cul.model.root;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.minuk.cul.model.StdmVO;

import lombok.ToString;

@ToString
public class GetStdm {

	@JsonProperty("header")
	public Header header;
	
	@JsonProperty("items")
	public List<StdmVO> items;
	
	@ToString
	public class Header {
		public String resultCode;
		public String resultMsg;
	}
	
}
