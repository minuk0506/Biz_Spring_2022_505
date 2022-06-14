package com.schoolverse.app.model;


import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class HomeVO {

	private String space;
	private String subject;
	private String age;
	private String cost;
	private String search;
}
