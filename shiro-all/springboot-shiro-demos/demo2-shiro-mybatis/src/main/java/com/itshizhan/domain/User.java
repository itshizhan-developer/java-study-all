package com.itshizhan.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class User {
	private Integer id;
	private String name;
	private String password;
	private String perms;
}
