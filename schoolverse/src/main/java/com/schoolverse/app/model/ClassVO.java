package com.schoolverse.app.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class ClassVO {
	private String class_code;
	private String aca_code;
	private String class_name;
	private String class_subject;
	private String class_fee;
	private String sche_code;
}
