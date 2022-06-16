package com.schoolverse.app.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@Builder
public class BasketVO {
	private long c_code;
	private String u_id;
}
