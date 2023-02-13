package com.project.pet.security;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum MyRole {
	
	USER("USER"),
	ADMIN("ADMIN");
	
	private final String roles;
	//member entity의 메서드에서 사용 할 것
	//MyUserDetails 에서도 map에 사용됨
	//final을 붙으면 USER(roles) 해주어야함

}
