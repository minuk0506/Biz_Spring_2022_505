package com.schoolverse.app.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TeacherVO {
	private long teacher_id;
	private String teacher_name;
	private String teacher_info;
	private long aca_teacher;
}
