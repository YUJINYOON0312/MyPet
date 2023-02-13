package com.project.pet.entity;

import org.springframework.security.crypto.password.PasswordEncoder;

import lombok.Setter;

@Setter
public class MemberRegDTO {
	
	private String email;
	private String pass;
	private String nickName;
	private String name;
	
	public MemberEntity ent(PasswordEncoder pe) {
		return MemberEntity.builder().email(email).pass(pe.encode(pass)).name(name).nickName(nickName).build();
	}

}
