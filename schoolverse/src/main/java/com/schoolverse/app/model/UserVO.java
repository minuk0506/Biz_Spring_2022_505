package com.schoolverse.app.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class UserVO {
	private String username;
	private String password;
	private String email;
	private String name;
	private String nickname;
	private String role;
	private long aca_code;
}
