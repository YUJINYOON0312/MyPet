package com.project.pet.security;

import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

import com.project.pet.entity.MemberEntity;

import lombok.Getter;

@Getter
public class MyUserDetails extends User{
	
	private String email;
	private String name;
	private String nickName;

	//빨간줄 Add클릭으로 생성
	public MyUserDetails(String username, String password, Collection<? extends GrantedAuthority> authorities) {
		super(username, password, authorities);
	}

	// 뭐하는 애인지 자세하게 설명을 등록하자
	public MyUserDetails(MemberEntity ent) {
		this(ent.getEmail(), ent.getPass(), ent.getMyRoles()
				.stream()
				.map(myRole -> new SimpleGrantedAuthority(myRole.getRoles()))
				.collect(Collectors.toSet()));
		
		this.email=ent.getEmail();
		this.name=ent.getName();
		this.nickName=ent.getNickName();
	}


}
