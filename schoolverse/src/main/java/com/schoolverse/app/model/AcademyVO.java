package com.schoolverse.app.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class AcademyVO {
	private String aca_code;
	private String aca_name;
	private String aca_subject;
	private String aca_addr;
	private String aca_info;
	private Byte aca_img;
}
