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
public class ImagesVO {

	private long i_aca_code;
	private String i_OriginalName;
	private String i_imageName;
	
}
