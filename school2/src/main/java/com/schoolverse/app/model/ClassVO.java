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
public class ClassVO {
	private long class_code;
	private long aca_code;
	private String class_name;
	private String class_subject;
	private String class_fee;
	private long sche_code;
	private long class_teacher;
}
