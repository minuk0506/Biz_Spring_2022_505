package com.schoolverse.app.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AcademyVO {
	private long aca_code;
	private String aca_name;
	private String aca_subject;
	private String aca_addr;
	private String aca_info;
	private String aca_img;
	private long aca_teacher;
	private String aca_region;
	private String aca_age;
}
